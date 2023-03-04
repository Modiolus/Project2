package com.bank.exchange.controller;

import com.bank.exchange.dto.UserDto;
import com.bank.exchange.dto.WalletDto;
import com.bank.exchange.dto.WalletUpdateDto;
import com.bank.exchange.entity.User;
import com.bank.exchange.entity.Wallet;
import com.bank.exchange.exceptions.UserNotFoundException;
import com.bank.exchange.mapper.MapperConfig;
import com.bank.exchange.repositori.UserRepository;
import com.bank.exchange.repositori.WalletRepository;
import com.bank.exchange.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/wallet")
@RequiredArgsConstructor
@Slf4j
public class WalletController {

    private final UserService userService;
    private final WalletRepository walletRepository;
    private final MapperConfig mapperConfig;

    @PostMapping
    public WalletDto updateWallet(@RequestBody WalletUpdateDto wallet)  {
        if (userService.isUserNotExist(wallet.getPhone())){
            throw new RuntimeException("Unsupported operation. User is not register in system.");
        }

        Wallet wal = walletRepository.findAllByCurrencyAndUser_Phone(wallet.getCurrency(), wallet.getPhone());

        wal.setAmmount(wal.getAmmount().add(wallet.getAmmount()))
                .setLastModify(new Timestamp(System.currentTimeMillis()));

        wal = walletRepository.save(wal);

        return mapperConfig.map(wal, WalletDto.class);
    }

    @GetMapping
    List<WalletDto> getWalletsByUserPhone(@RequestParam String phone){
        return mapperConfig.mapAsList(walletRepository.findAllByUser_Phone(phone), WalletDto.class);
    }

}
