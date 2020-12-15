package com.mateuszhaberla.wiremockworkshop.workshopclient

import com.mateuszhaberla.wiremockworkshop.workshopclient.models.Car
import com.mateuszhaberla.wiremockworkshop.workshopclient.models.Person
import com.mateuszhaberla.wiremockworkshop.workshopclient.models.Type
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient(name = "workshop")
@RequestMapping(value = ["workshop"])
interface WiremockWorkshopClient {
    companion object {
        private const val PERSON = "person"
        private const val PERSON_ID = "personId"
        private const val CAR = "car"
        private const val CAR_ID = "carId"
        private const val TYPE = "type"

        private const val PERSON_CAR = "$PERSON/{$PERSON_ID}/$CAR/{$CAR_ID}"
        private const val ALL_CARS = "cars"
        private const val PERSON_ALL_CARS = "$PERSON/{$PERSON_ID}/$ALL_CARS"
    }

    @GetMapping("V1/$PERSON_CAR")
    fun getCar(
        @PathVariable(PERSON_ID) personId: Long,
        @PathVariable(CAR_ID) carId: Long
    ) : List<Car>

    @GetMapping("V1/$PERSON_ALL_CARS")
    fun getPersonAllCars(
        @PathVariable(PERSON_ID) personId: Long,
    ) : List<Car>

    @GetMapping("V1/$PERSON_ALL_CARS")
    fun getAllCarsWithExactType(
        @PathVariable(PERSON_ID) personId: Long,
        @RequestParam(TYPE, required = true) type: Type
    ) : List<Car>

    @GetMapping("V1/$ALL_CARS")
    fun getAllCars() : List<Car>

    @PostMapping("V1/$CAR")
    fun addCar(@RequestBody car: Car)

    @PostMapping("V1/$PERSON")
    fun addPerson(@RequestBody person: Person)
}