package com.mateuszhaberla.wiremockworkshop.workshopclient.models

import java.math.BigDecimal

data class Car(
    private val id : Long,
    private val mark: String,
    private val model: String,
    private val price: BigDecimal,
    private val type: Type
)
