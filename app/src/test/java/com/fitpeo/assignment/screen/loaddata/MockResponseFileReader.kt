package com.fitpeo.assignment.screen.loaddata

import java.io.InputStreamReader
import java.lang.StringBuilder

object MockResponseFileReader {
    fun readFileResponse(path:String) :String {
        val inputStream = MockResponseFileReader::class.java.getResourceAsStream(path)
        val builder=StringBuilder()
        val reader=InputStreamReader(inputStream,"UTF-8")
        reader.readLines().forEach{
            builder.append(it)
        }
        return builder.toString()
    }
}