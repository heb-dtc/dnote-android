package com.heb.dnote.note

import com.heb.dnote.book.Book

data class Note(val id: Int, val book: Book, val content: String)