package com.heb.dnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.heb.dnote.note.Note
import com.heb.dnote.note.NoteRepository

const val EXTRA_NOTE_ID = "com.heb.dnote.NOTE_ID"
const val NO_NOTE_ID = -1

class ViewNoteActivity : AppCompatActivity() {

    private val bookTitleView: TextView by lazy {
        findViewById<TextView>(R.id.book_name)
    }

    private val noteContentView: TextView by lazy {
        findViewById<TextView>(R.id.note_content)
    }

    private val noteViewModel: NoteViewModel by lazy {
        val appContainer = (this.application as DNoteApplication).applicationContainer
        ViewModelProvider(this, NoteViewModelFactory(appContainer.noteRepository))
            .get(NoteViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_note)

        val noteId = intent.getIntExtra(EXTRA_NOTE_ID, NO_NOTE_ID)

        val noteObserver = Observer<Note> {
            Log.d("ViewNoteActivity", "got $it")
            bookTitleView.text = it.book.title
            noteContentView.text = it.content
        }
        noteViewModel.note.observe(this, noteObserver)

        noteViewModel.load(noteId)
    }
}
