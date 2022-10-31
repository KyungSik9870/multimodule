package com.example.multimodule.service

import com.example.multimodule.model.Stock
import com.example.multimodule.repository.StockRepository
import org.springframework.stereotype.Service

@Service
class StockDomainService(
    private val stockRepository: StockRepository
) {
    fun findStock(symbol: String): Stock {
        return stockRepository.findBySymbol(symbol)
    }

    fun findAllStocks(market: String): List<Stock>? {
        return stockRepository.findAllByMarket(market)
    }
}