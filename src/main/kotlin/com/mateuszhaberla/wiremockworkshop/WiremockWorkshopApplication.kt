package com.mateuszhaberla.wiremockworkshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WiremockWorkshopApplication

fun main(args: Array<String>) {
    runApplication<WiremockWorkshopApplication>(*args)
}
