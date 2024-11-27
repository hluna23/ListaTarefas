package com.example.listatarefas.domain

data class Todo(
    val id: Long,
    val title: String,
    val description: String?,
    val isCompleted: Boolean,
)

// falso objetos

val todo1 = Todo(
    id = 1,
    title = "todo 1",
    description = "description for todo 1",
    isCompleted = false,
)

val todo2 = Todo(
    id = 2,
    title = "todo 2",
    description = "description for todo 2",
    isCompleted = false,
    )

val todo3 = Todo(
    id = 3,
    title = "todo 3",
    description = "description for todo 3",
    isCompleted = false,
)