package com.example.multimodule.service

import com.example.multimodule.model.Stock
import com.example.multimodule.redis.dto.CurrentPrice
import com.example.multimodule.redis.dto.CurrentPriceRequest
import org.springframework.stereotype.Service

@Service
class StockCurrentPriceService(
    private val currentPriceRedisService: CurrentPriceRedisService
) {
    fun findCurrentPrice(stock: Stock): CurrentPrice {
        return currentPriceRedisService.findCurrentPrice(
            CurrentPriceRequest("KB", "KRW", stock.symbol)
        )
    }

    fun findCurrentPriceWithAll(stocks: List<Stock>): List<StockWithCurrentPrice> {
        return stocks.map {
            StockWithCurrentPrice.of(
                it,
                currentPriceRedisService.findCurrentPrice(CurrentPriceRequest(symbol = it.symbol))
            )
        }
    }
}