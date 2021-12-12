package ru.beryukhov.compose.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.beryukhov.coffeegram.data.CoffeeType

@Composable
expect fun Image(coffeeType: CoffeeType, modifier: Modifier = Modifier)