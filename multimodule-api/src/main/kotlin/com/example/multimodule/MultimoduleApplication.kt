package com.example.multimodule

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultimoduleApplication {
}

fun main(args: Array<String>) {
    runApplication<MultimoduleApplication>(*args)
}