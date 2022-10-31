package com.example.multimodule.service

import com.example.multimodule.model.Stock
import com.example.multimodule.redis.dto.CurrentPrice

class StockResponse(
    val symbol: String,
    val currentPrice: Double,
) {
    companion object {
        fun of(currentPrice: CurrentPrice): StockResponse {
            return StockResponse(
                symbol = currentPrice.symbol,
                currentPrice = currentPrice.price
            )
        }
    }
}

class StockResponses(
    val stocks: List<StockWithCurrentPrice>
) {
    companion object {
        fun of(stocks: List<StockWithCurrentPrice>): StockResponses {
            return StockResponses(stocks.sorted())
        }
    }
}

data class StockWithCurrentPrice(
    val exchange: String,
    val market: String,
    val currentPrice: Double,
    val openPrice: Double,
    val fluctuationRate: Double = (openPrice- currentPrice) / 100
): Comparable<StockWithCurrentPrice> {
    companion object {
        fun of (stock: Stock, currentPrice: CurrentPrice): StockWithCurrentPrice {
            return StockWithCurrentPrice(
                exchange = stock.exchange,
                market = stock.market,
                currentPrice = currentPrice.price,
                openPrice = stock.openPrice
            )
        }
    }

    override fun compareTo(other: StockWithCurrentPrice): Int {
        return (other.currentPrice - currentPrice).toInt()
    }
}