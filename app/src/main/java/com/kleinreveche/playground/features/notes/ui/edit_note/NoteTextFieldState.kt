package com.kleinreveche.playground.features.notes.ui.edit_note

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)