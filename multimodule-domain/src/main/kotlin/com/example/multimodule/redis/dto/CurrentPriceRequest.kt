package com.example.multimodule.redis.dto

data class CurrentPriceRequest(
    val exchange: String = "KB",
    val market: String = "KRW",
    val symbol: String
)