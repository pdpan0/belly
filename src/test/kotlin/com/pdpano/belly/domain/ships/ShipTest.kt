package com.pdpano.belly.domain.ships

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ShipTest {
    @Test
    fun `should create ship instance`() {
        assertDoesNotThrow {
            Ship(
                idShip = 1,
                name = "Thousand Sunny",
                description = "Thousand Sunny é o segundo navio dos Chapéu de Palha, e atualmente seu principal meio de transporte após a destruição do Going Merry.",
                createdBy = "lucas.martins"
            )
        }
    }
    @Test
    fun `should throw error description exceeded number of characters allowed`() {
        assertThrows(IllegalArgumentException::class.java) {
            Ship(
                idShip = 1,
                name = "Thousand Sunny",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam congue venenatis lorem. Cras sagittis nulla ut felis luctus, eu molestie odio congue. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Morbi dignissim lectus ac consequat gravida. In sollicitudin augue ac purus varius dapibus. Vivamus interdum, lectus et luctus feugiat, nunc mi pulvinar nisi, ac feugiat mi ipsum ut metus. Duis bibendum ullamcorper nibh sit amet mattis. Aenean luctus quis dui pharetra porta. Pellentesque aliquet, ipsum vel egestas tincidunt, arcu dolor feugiat purus, et condimentum nisl sem sed risus.",
                createdBy = "lucas.martins"
            )
        }
    }
}