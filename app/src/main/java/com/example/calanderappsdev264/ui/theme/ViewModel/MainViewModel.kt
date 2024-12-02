package com.example.calanderappsdev264.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    // State to track the current screen
    private val _currentScreen = mutableStateOf("home")
    val currentScreen: State<String> = _currentScreen


    private val _checkedOff = MutableStateFlow(false)
    val checkedOff: StateFlow<Boolean> = _checkedOff

    // Toggle function to update checkedOff
    fun checkedOffToggle(isChecked: Boolean) {
        _checkedOff.value = isChecked
    }

    // Function to update the current screen
    fun navigateToSettings() {
        _currentScreen.value = "settings"
    }

    fun navigateToHome() {
        _currentScreen.value = "home"
    }
}
