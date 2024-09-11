package io.github.taetae98coding.oauth.google.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import io.github.taetae98coding.oauth.google.GoogleCredentialManager

@Composable
public actual fun rememberGoogleCredentialManager(): GoogleCredentialManager {
    val context = LocalContext.current

    return remember(context) { GoogleCredentialManager(context) }
}