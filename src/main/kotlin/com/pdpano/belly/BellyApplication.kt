package com.pdpano.belly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.ClassPathXmlApplicationContext

@SpringBootApplication
class BellyApplication

fun main(args: Array<String>) {
	runApplication<BellyApplication>(*args)

	val appContext = ClassPathXmlApplicationContext("classpath:context.xml")

}
