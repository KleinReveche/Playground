package com.kleinreveche.playground.features.notes.presentation.notes

import com.kleinreveche.playground.features.notes.domain.model.Note
import com.kleinreveche.playground.features.notes.domain.util.NoteOrder

sealed class NotesEvent {
    data class OrderNote(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
