package com.jayden.shared.db

import com.jayden.cache.Hello
import com.jayden.cache.MyAppDb
import com.jayden.shared.DatabaseDriverFactory

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = MyAppDb(databaseDriverFactory.createDriver())
    private val dbQuery = database.myAppDbQueries


    fun insert(it: String) {
        dbQuery.insertHello(title = it)
    }

    fun getData(): List<Hello> {
        return dbQuery.selectAll().executeAsList()
    }
}