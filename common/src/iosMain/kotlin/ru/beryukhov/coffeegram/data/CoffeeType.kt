package ru.beryukhov.coffeegram.data


actual abstract class CoffeeType constructor(
    actual val name: String,
)

actual object Cappuccino : CoffeeType("Cappuccino")
actual object Latte : CoffeeType("Latte")
actual object Americano : CoffeeType("Americano")
actual object CommonCoffee : CoffeeType("CommonCoffee")