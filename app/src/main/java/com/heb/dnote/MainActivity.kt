package com.heb.dnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.heb.dnote.note.Note
import com.heb.dnote.note.NoteRepository

class MainActivity : AppCompatActivity() {

    private val viewModel: ListNoteViewModel by lazy {
        ViewModelProvider(this, ListNoteViewModelFactory(NoteRepository()))
            .get(ListNoteViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val noteItemsObserver = Observer<List<Note>> {
            Log.d("MainActivity", "got ${it.size} notes")
        }

        viewModel.noteItems.observe(this, noteItemsObserver)
    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
    }
}
