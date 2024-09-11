package io.github.taetae98coding.oauth.google.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import io.github.taetae98coding.oauth.google.GoogleCredentialManager

@Composable
public actual fun rememberGoogleCredentialManager(): GoogleCredentialManager {
    return remember { GoogleCredentialManager() }
}
