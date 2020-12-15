package com.mateuszhaberla.wiremockworkshop.workshopclient.models

data class Person (
    private val id: Long,
    private val name: String,
    private val lastName: String,
    private val nationality: Nationality
)