package com.example.multimodule.redis.dto

data class CurrentPrice(
    val symbol: String,
    val price: Double
) {
    constructor() : this("", 0.0)
}