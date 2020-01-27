package com.heb.dnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heb.dnote.note.Note
import com.heb.dnote.note.NoteRepository

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view)
    }

    private val addNewNoteButton: View by lazy {
        findViewById<View>(R.id.add_new_note_button)
    }
    
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val viewModel: ListNoteViewModel by lazy {
        ViewModelProvider(this, ListNoteViewModelFactory(NoteRepository()))
            .get(ListNoteViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.bottom_navigation_bar))

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        addNewNoteButton.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }

        val noteItemsObserver = Observer<List<Note>> {
            Log.d("MainActivity", "got ${it.size} notes")
            recyclerView.adapter = NoteAdapter(it)
        }

        viewModel.noteItems.observe(this, noteItemsObserver)
    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
    }
}
