package com.heb.dnote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.heb.dnote.note.Note
import com.heb.dnote.note.NoteRepository

class ListNoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListNoteViewModel(repository) as T
    }
}

class ListNoteViewModel(private val noteRepository: NoteRepository): ViewModel() {

    val noteItems: MutableLiveData<List<Note>> = MutableLiveData()

    fun load() {
        noteItems.value = noteRepository.getNotes()
    }
}