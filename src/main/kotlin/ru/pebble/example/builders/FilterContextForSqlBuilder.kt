package ru.pebble.example.builders

import org.springframework.stereotype.Component
import ru.pebble.example.constants.SQL_CONDITION
import ru.pebble.example.constants.SQL_CONTEXT_FILTER_NAME

@Component
open class FilterContextForSqlBuilder {
    open fun filterContextBuild(): Map<String, Any> {
        val filterContext = mutableMapOf<String, Any>()
        filterContext[SQL_CONTEXT_FILTER_NAME] = SQL_CONDITION
        return filterContext
    }
}