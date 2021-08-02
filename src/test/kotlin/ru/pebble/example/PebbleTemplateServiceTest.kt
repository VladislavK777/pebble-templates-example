package ru.pebble.example

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert.isTrue
import ru.pebble.example.builders.FilterContextForSqlBuilder
import ru.pebble.example.services.PebbleTemplateService

@EnableAutoConfiguration
@SpringBootTest(classes = [PebbleTemplateService::class, FilterContextForSqlBuilder::class])
class PebbleTemplateServiceTest {
    @Autowired
    private lateinit var pebbleTemplateService: PebbleTemplateService

    @Test
    fun testSqlTemplate() {
        isTrue("select f.*\nfrom foo f\nwhere f.count = 10" == pebbleTemplateService.prepareSqlTemplate(), "")
    }

    @Test
    fun testSqlTemplateFromString() {
        isTrue("select f.id\nfrom foo f\nwhere f.count = 10" == pebbleTemplateService.prepareSqlTemplateFromString(), "")
    }
}
