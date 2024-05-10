package com.example.thenotesapp.viewmodel

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.thenotesapp.model.Note
import com.example.thenotesapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application, private val noteRepository: NoteRepository): AndroidViewModel(app) {

    fun addNote(note: Note) =
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    fun deleteNote(note: ContactsContract.CommonDataKinds.Note) =
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    fun updateNote(note: ContactsContract.CommonDataKinds.Note) =
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }

    fun getAllNotes() = noteRepository.getAllNotes()

    fun searchNote(query: String?) =
        noteRepository.searchNote(query)
}