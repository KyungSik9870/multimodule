package com.example.multimodule.repository

import com.example.multimodule.model.Stock
import org.springframework.data.repository.CrudRepository

interface StockRepository : CrudRepository<Stock, Long> {
    fun findBySymbol(symbol: String): Stock
    fun findAllByMarket(market: String): List<Stock>
}