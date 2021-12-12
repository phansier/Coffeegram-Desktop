package ru.beryukhov.compose


import ru.beryukhov.compose.data.CoffeeType
import ru.beryukhov.compose.pages.withEmpty
import ru.beryukhov.compose.data.Americano
import ru.beryukhov.compose.data.Cappuccino
import ru.beryukhov.compose.data.CommonCoffee
import ru.beryukhov.compose.data.Latte
import kotlin.test.Test
import kotlin.test.assertEquals

class EmptyTest {
    @Test
    fun withEmptyTest() {
        val map = mapOf<CoffeeType, Int>(
            Cappuccino to 2,
            Latte to 3
        )
        val actual = map.withEmpty()
        val expected = listOf(
            Latte to 3,
            Cappuccino to 2,
            Americano to 0,
            CommonCoffee to 0
        )
        assertEquals(expected, actual)
    }
}