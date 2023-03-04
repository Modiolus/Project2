package com.bank.exchange.repositori;


import com.bank.exchange.entity.CurrencyEnum;
import com.bank.exchange.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    List<Rate> findAllByCurrency(CurrencyEnum currency);
}
