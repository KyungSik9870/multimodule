package com.example.multimodule.service

import org.springframework.stereotype.Service

@Service
class StockService(
    private val stockDomainService: StockDomainService,
    private val stockCurrentPriceService: StockCurrentPriceService
) {
    fun findStock(symbol: String): StockResponse {
        return stockDomainService.findStock(symbol)
            .let { stockCurrentPriceService.findCurrentPrice(it) }
            .let { StockResponse.of(it) }
    }


    fun findStocks(market: String): StockResponses {
        return stockDomainService.findAllStocks(market)
            .let { stockCurrentPriceService.findCurrentPriceWithAll(it!!) }
            .let { StockResponses.of(it) }
    }

}