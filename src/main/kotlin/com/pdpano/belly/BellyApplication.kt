package com.pdpano.belly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BellyApplication

fun main(args: Array<String>) {
	runApplication<BellyApplication>(*args)
}
