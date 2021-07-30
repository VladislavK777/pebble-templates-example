package ru.pebble.example.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PebbleTemplateExampleApplication

fun main(args: Array<String>) {
    runApplication<PebbleTemplateExampleApplication>(*args)
}
