package com.bank.exchange.controller;

import com.bank.exchange.dto.WalletDto;
import com.bank.exchange.dto.WalletUpdateDto;
import com.bank.exchange.entity.Wallet;
import com.bank.exchange.mapper.MapperConfig;
import com.bank.exchange.repositori.WalletRepository;
import com.bank.exchange.service.ExchangeService;
import com.bank.exchange.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/exchange")
@RequiredArgsConstructor
@Slf4j
public class ExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping
    public List<WalletDto> exchange(@RequestBody WalletUpdateDto wallet)  {

exchangeService.exchange(wallet);
        return null;
    }
}
