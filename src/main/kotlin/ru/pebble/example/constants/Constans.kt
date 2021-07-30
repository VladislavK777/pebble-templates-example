package ru.pebble.example.constants

const val SQL_TEMPLATE_FILE_NAME = "sql_example"
const val SQL_CONTEXT_FILTER_NAME = "filter"
const val SQL_CONDITION = "f.count = 10"
const val SQL_TEMPLATE_STRING_FORMAT = "select f.id\nfrom foo f\nwhere {{ filter }}"