package com.stanroy.jetdex.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController

data class KeyboardManager(
    private val keyboardController: SoftwareKeyboardController?,
    private val focusManager: FocusManager
) {
    fun hideKeyboard() {
        keyboardController?.hide()
        focusManager.clearFocus()
    }
}

@Composable
fun rememberKeyboardManager(): KeyboardManager {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    return remember(keyboardController, focusManager) {
        KeyboardManager(keyboardController, focusManager)
    }
}