package ru.pebble.example

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import ru.pebble.example.builders.FilterContextForSqlBuilder
import ru.pebble.example.services.PebbleTemplateService

@EnableAutoConfiguration
@SpringBootTest(classes = [PebbleTemplateService::class, FilterContextForSqlBuilder::class])
class PebbleTemplateServiceTest {
    @Autowired
    private lateinit var pebbleTemplateService: PebbleTemplateService

    @Test
    fun testSqlTemplate() {
        println(pebbleTemplateService.prepareSqlTemplate())
    }

    @Test
    fun testSqlTemplateFromString() {
        println(pebbleTemplateService.prepareSqlTemplateFromString())
    }
}
