package com.heb.dnote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.heb.dnote.note.Note
import com.heb.dnote.note.NoteRepository

class AddNoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddNoteViewModel(repository) as T
    }
}

class AddNoteViewModel(private val noteRepository: NoteRepository): ViewModel() {

    val note: MutableLiveData<Note> = MutableLiveData()

    fun save(content: String, bookId: Int) {
        noteRepository.saveNote(content, bookId)
    }
}