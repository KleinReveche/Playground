package com.kleinreveche.playground.features.notes.presentation.util

sealed class NotesScreen(val route: String) {
    object NotesNotesScreen: NotesScreen("notes_screen")
    object AddEditNoteNotesScreen: NotesScreen("add_edit_note_screen")
}