package com.example.multimodule.service

import com.example.multimodule.redis.dto.CurrentPrice
import com.example.multimodule.redis.dto.CurrentPriceRequest
import com.example.multimodule.redis.repository.CurrentPriceRedisRepository
import org.springframework.stereotype.Service

@Service
class CurrentPriceRedisService(
    private val currentPriceRedisRepository: CurrentPriceRedisRepository
) {
    fun findCurrentPrice(req: CurrentPriceRequest): CurrentPrice {
        return currentPriceRedisRepository.get(req.exchange, req.market, req.symbol)
    }
}