package com.anddev404.calculatorbmi.data.model

/**
 * Klasa enum reprezentująca dostępne jednostki wagi w aplikacji.
 * Na podstawie tej klasy wyświetlany jest odpowiedni fragment do wprowadzania danych
 * oraz informacje takie jak waga idealna, prawidłowa, niedowaga oraz nadwaga są wyświetlane w
 * odpowiednim formacie. Ta klasa jest również wykorzystywana przy konwersji danych (wagi użytkownika).
 */

enum class WeightUnit(val id: Int) {

    KG(1),
    LB(2),
    ST_LB(3)
}