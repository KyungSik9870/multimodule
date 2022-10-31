package com.example.multimodule.endpoint

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StockController {

    @GetMapping("/api/stock")
    fun getStock() {
        // TODO -> 외부 URL (주식 받아오는)
//        webclient.get()
//        .body .... -> parse ExceptionHandling
//        .service.save()
        // TODO : 외부에서 발생한 Error 는 여기서 처리 -> ErrorResponse / throw
    }
}