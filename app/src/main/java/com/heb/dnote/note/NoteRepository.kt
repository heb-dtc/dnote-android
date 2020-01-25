package com.heb.dnote.note

import com.heb.dnote.book.Book

class NoteRepository {

    private val mockBook = Book(1, "mockbook")
    private val mockContent = "Morbi accumsan eu lorem non lacinia. " +
            "Curabitur mattis, sapien et tincidunt ultricies, sapien nisi " +
            "pellentesque mauris, non varius urna ligula quis nulla. Donec " +
            "ullamcorper fringilla nunc, non varius massa rhoncus sit amet. "


    fun getNotes() : List<Note> {
        return listOf(getMockNote(1), getMockNote(2), getMockNote(3), getMockNote(4),
            getMockNote(5), getMockNote(6), getMockNote(7), getMockNote(8))
    }

    private fun getMockNote(id: Int): Note {
        return Note(id, mockBook, mockContent)
    }
}