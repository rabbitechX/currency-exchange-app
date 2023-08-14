package com.example.currencyexchange;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyDataRepository extends JpaRepository<CurrencyData, Long> {
}

