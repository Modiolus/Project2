package com.bank.exchange.repositori;

import com.bank.exchange.entity.CurrencyEnum;
import com.bank.exchange.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findAllByUser_Phone(String phone);

    Wallet findAllByCurrencyAndUser_Phone(CurrencyEnum currency, String phone);
}
