package com.heb.dnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.heb.dnote.note.Note
import com.heb.dnote.note.NoteRepository

class AddNoteActivity : AppCompatActivity() {

    private val contentView: EditText by lazy {
        findViewById<EditText>(R.id.note_content)
    }

    private val saveButton: View by lazy {
        findViewById<View>(R.id.save_note_button)
    }

    private val viewModel: AddNoteViewModel by lazy {
        val appContainer = (this.application as DNoteApplication).applicationContainer
        ViewModelProvider(this, AddNoteViewModelFactory(appContainer.noteRepository))
            .get(AddNoteViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        saveButton.setOnClickListener {
            val content = contentView.text.toString()
            if (content.isNotEmpty()) {
                viewModel.save(content, 1)
            }
        }
    }
}
