package com.heb.dnote

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heb.dnote.note.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter(private val notes: List<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.bindNote(notes[position])
    }

    class NoteHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        private var note: Note? = null

        fun bindNote(note: Note) {
            this.note = note
            view.book_name.text = note.book.title
            view.note_content.text = note.content

            view.setOnClickListener {
                it.context.startActivity(Intent(it.context, ViewNoteActivity::class.java).putExtra(
                    EXTRA_NOTE_ID, note.id))
            }
        }
    }
}