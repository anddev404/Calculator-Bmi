package com.anddev404.calculatorbmi.data.local

import com.anddev404.calculatorbmi.data.model.HeightUnit
import com.anddev404.calculatorbmi.data.model.WeightUnit

interface LocalDataSource {

    /**
     *  LocalDataSource to interfejs określający, jakie dane należy zapisać i odczytać
     *  w celu ułatwienia korzystania z aplikacji. Dzięki temu, gdy użytkownik ponownie otwiera aplikację,
     *  nie musi ponownie wybierać odpowiedniej jednostki wagi ani wzrostu,
     *  ponieważ dane te zostały już zapamiętane. Dodatkowo zapisywany jest wzrost użytkownika,
     *  który z reguły się nie zmienia.
     */

    suspend fun getHeightInKg(): Int
    suspend fun saveHeightInKg(height: Int): Boolean

    suspend fun getHeightUnit(): HeightUnit
    suspend fun saveHeightUnit(heightUnit: HeightUnit): Boolean

    suspend fun getWeightUnit(): WeightUnit
    suspend fun saveWeightUnit(weightUnit: WeightUnit): Boolean
}