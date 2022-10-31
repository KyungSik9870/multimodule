package com.example.multimodule.endpoint

import com.example.multimodule.service.StockResponse
import com.example.multimodule.service.StockResponses
import com.example.multimodule.service.StockService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class StockController(
    private val stockService: StockService
) {
    @GetMapping("api/stock/{symbol}")
    fun getStock(@PathVariable symbol: String): ResponseEntity<StockResponse> {
        return ResponseEntity.ok(
            stockService.findStock(symbol)
        )
    }

    @GetMapping("api/stock/{market}")
    fun getStocks(@PathVariable market: String): ResponseEntity<StockResponses> {
        return ResponseEntity.ok(
            stockService.findStocks(market)
        )
    }
}