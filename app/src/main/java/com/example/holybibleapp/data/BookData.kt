package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.data.net.BookServerModel
import com.example.holybibleapp.domain.BookDomain
import java.lang.Exception

sealed class BookData : Abstract.Object<BookDomain, BooksDataToDomainMapper>() {
    class Success(private val books: List<BookServerModel>) : BookData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain = mapper.map(books)
    }

    class Fail(private val e: Exception) : BookData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain = mapper.map(e)
    }
}