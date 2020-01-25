package com.heb.dnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val viewModel: ListNoteViewModel by lazy {
        ViewModelProvider(this, ListNoteViewModelFactory(NoteRepository()))
            .get(ListNoteViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

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
