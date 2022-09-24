package com.kleinreveche.playground.features.notes.ui.notes

import com.kleinreveche.playground.features.notes.domain.model.Note
import com.kleinreveche.playground.features.notes.domain.util.NoteOrder
import com.kleinreveche.playground.features.notes.domain.util.OrderType

data class NotesState (
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)