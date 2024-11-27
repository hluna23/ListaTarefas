package com.example.listatarefas.ui.feature.addedit

import android.os.Parcel
import android.os.Parcelable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listatarefas.data.TodoRepository
import com.example.listatarefas.ui.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AddEditViewModel(
    private val repository: TodoRepository,

    ): ViewModel() {

        var title by mutableStateOf("")
            private set

        var description by mutableStateOf<String?>(null)
            private set
        private val _uiEvent = Channel<UiEvent>()
        val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: AddEditEvent) {
            when (event) {
                is AddEditEvent.TitleChanged -> {
                    title = event.title
                }

                is AddEditEvent.DescriptionChanged -> {
                    description = event.description
                }
                AddEditEvent.Save -> {
                    saveTodo()
                }

            }

            }

    private fun saveTodo() {
        viewModelScope.launch {
            if (title.isBlank()) {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(
                        message = "Title cannot be empty"
                    )
                )
                return@launch
            }

                repository.insert(title, description)
                _uiEvent.send(UiEvent.NavigateBack)
            }

        }

    }
