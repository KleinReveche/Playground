package com.kleinreveche.playground.features.notes.domain.use_case

import com.kleinreveche.playground.features.notes.domain.model.Note
import com.kleinreveche.playground.features.notes.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }

}