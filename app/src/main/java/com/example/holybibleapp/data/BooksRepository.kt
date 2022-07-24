package com.example.holybibleapp.data

import java.lang.Exception

interface BooksRepository {

    suspend fun fetchBook(): BookData

    class Base(private val booksCacheDataSource: BooksCloudDataSource) : BooksRepository {
        override suspend fun fetchBook(): BookData =
             try {
                BookData.Success(booksCacheDataSource.fetchBooks())
            } catch (e: Exception) {
                BookData.Fail(e)
            }
        }

    }