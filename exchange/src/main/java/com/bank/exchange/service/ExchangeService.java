package com.bank.exchange.service;

import com.bank.exchange.dto.WalletDto;
import com.bank.exchange.dto.WalletUpdateDto;
import com.bank.exchange.entity.CurrencyEnum;
import com.bank.exchange.entity.Rate;
import com.bank.exchange.entity.Wallet;
import com.bank.exchange.mapper.MapperConfig;
import com.bank.exchange.repositori.RateRepository;
import com.bank.exchange.repositori.WalletRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeService {

    private final RateRepository rateRepository;
    private final UserService userService;
    private final WalletRepository walletRepository;
    private final MapperConfig mapperConfig;

    @Scheduled(cron = "0 * * * * *")
    public void getRates() throws JsonProcessingException {
        log.error("start cron job");
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        log.error(response.getBody());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(response.getBody());

        actualObj.forEach(c -> {
            if (!c.get("ccy").asText().equals("BTC") && !c.get("ccy").asText().equals("RUR")) {
                Rate rate = new Rate()
                        .setBuy(BigDecimal.valueOf(Double.parseDouble(c.get("buy").asText())))
                        .setSale(BigDecimal.valueOf(Double.parseDouble(c.get("sale").asText())))
                        .setReceive(new Timestamp(System.currentTimeMillis()))
                        .setCurrency(CurrencyEnum.valueOf(c.get("ccy").asText()));
                rateRepository.save(rate);
            }
        });
        log.error("finish cron job");
    }

    public List<WalletDto> exchange(WalletUpdateDto upd){
        if (userService.isUserNotExist(upd.getPhone())){
            throw new RuntimeException("Unsupported operation. User is not register in system.");
        }

        List<Wallet> wallets = walletRepository.findAllByUser_Phone(upd.getPhone());

        Wallet wUSD = null;
        Wallet wUAH = null;

        for (Wallet w : wallets){
            if (w.getCurrency().equals(CurrencyEnum.UAH)){
                wUAH = w;
            } else {
                wUSD = w;
            }
        }

        List<Rate> allByCurrency = rateRepository.findAllByCurrency(upd.getCurrency());

        BigDecimal rate = allByCurrency.get(allByCurrency.size() - 1).getBuy();

        if (upd.getCurrency().equals(CurrencyEnum.USD)){
            BigDecimal uahAmmount = rate.multiply(upd.getAmmount());

            wUSD.setAmmount(wUSD.getAmmount().add(upd.getAmmount()));
            wUAH.setAmmount(wUAH.getAmmount().subtract(uahAmmount));
        }

        walletRepository.save(wUSD);
        walletRepository.save(wUAH);

        return mapperConfig.mapAsList(walletRepository.findAllByUser_Phone(upd.getPhone()), WalletDto.class);
    }
}
