package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.data.net.BookServerModel
import com.example.holybibleapp.domain.BookDomain
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException

interface BooksDataToDomainMapper : Abstract.Mapper {

    fun map(booksList: List<BookServerModel>): BookDomain

    fun map(e: Exception): BookDomain

    class Base : BooksDataToDomainMapper {
        override fun map(booksList: List<BookServerModel>): BookDomain {
            //todo
            return BookDomain.Success()
        }

        override fun map(e: Exception): BookDomain {
            val errorType = when (e) {
                is UnknownHostException -> 0
                is HttpException -> 1
                else -> 2
            }
            return BookDomain.Fail(errorType)
        }
    }
}
