package com.example.listatarefas.ui.feature.list

interface ListEvent {
    data class Delete(val id: Long): ListEvent
    data class CompleteChanged(val id: Long, val isCompleted: Boolean) : ListEvent
    data class AddEdit(val id: Long?) : ListEvent
}