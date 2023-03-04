package com.bank.exchange.dto;

import com.bank.exchange.entity.CurrencyEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class WalletDto {
    Long id;
    CurrencyEnum currency;
    BigDecimal ammount;
}
