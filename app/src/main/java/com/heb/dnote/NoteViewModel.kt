package com.heb.dnote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.heb.dnote.note.Note
import com.heb.dnote.note.NoteRepository

class NoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(repository) as T
    }
}

class NoteViewModel(private val noteRepository: NoteRepository): ViewModel() {

    val note: MutableLiveData<Note> = MutableLiveData()

    fun load(noteId: Int) {
        note.value = noteRepository.getNote(noteId)
    }
}