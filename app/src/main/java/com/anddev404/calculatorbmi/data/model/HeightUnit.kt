package com.anddev404.calculatorbmi.data.model

/**
 * Klasa enum reprezentująca dostępne jednostki wzrostu w aplikacji.
 * Na podstawie tej klasy wyświetlany jest odpowiedni fragment do wprowadzania danych.
 * Ta klasa jest również wykorzystywana przy konwersji danych (wzrostu użytkownika).
 */
enum class HeightUnit(val id: Int) {

    CM(1),
    FT_IN(2),
    IN(3)
}