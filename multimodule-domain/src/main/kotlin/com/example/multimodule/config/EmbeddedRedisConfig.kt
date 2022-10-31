package com.example.multimodule.config

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct
import redis.embedded.RedisServer
import javax.annotation.PreDestroy

@Configuration
class EmbeddedRedisConfig(
    @Value("\${spring.redis.port}")
    val redisPort: Int
) {
    private val logger = LoggerFactory.getLogger(EmbeddedRedisConfig::class.java)
    lateinit var redisServer: RedisServer

    @PostConstruct
    fun startRedisServer() {
        redisServer = RedisServer(redisPort)
        try {
            redisServer.start()
        } catch (e: Exception) {
            logger.error("Embedded redis error")
        }
    }

    @PreDestroy
    fun stopRedisServer() {
        redisServer.stop()
    }
}