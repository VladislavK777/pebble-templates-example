package ru.pebble.example.services

import com.mitchellbosecke.pebble.PebbleEngine
import com.mitchellbosecke.pebble.PebbleEngine.Builder
import com.mitchellbosecke.pebble.loader.StringLoader
import org.springframework.stereotype.Service
import ru.pebble.example.builders.FilterContextForSqlBuilder
import ru.pebble.example.constants.SQL_TEMPLATE_FILE_NAME
import ru.pebble.example.constants.SQL_TEMPLATE_STRING_FORMAT
import java.io.StringWriter
import java.io.Writer

@Service
open class PebbleTemplateService(
    private var pebbleEngine: PebbleEngine,
    private val filterContextForSqlBuilder: FilterContextForSqlBuilder
) {
    open fun prepareSqlTemplate(): String {
        val sqlTemplate = pebbleEngine.getTemplate(SQL_TEMPLATE_FILE_NAME)
        val filterContext = filterContextForSqlBuilder.filterContextBuild()
        val writer: Writer = StringWriter()
        sqlTemplate.evaluate(writer, filterContext)
        return writer.toString() // or JDBC call
    }

    open fun prepareSqlTemplateFromString(): String {
        pebbleEngine = Builder().loader(StringLoader()).build()
        val sqlTemplate = pebbleEngine.getTemplate(SQL_TEMPLATE_STRING_FORMAT)
        val filterContext = filterContextForSqlBuilder.filterContextBuild()
        val writer: Writer = StringWriter()
        sqlTemplate.evaluate(writer, filterContext)
        return writer.toString() // or JDBC call
    }
}