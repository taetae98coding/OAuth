package io.github.taetae98coding.oauth.google.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.interop.LocalUIViewController
import io.github.taetae98coding.oauth.google.GoogleCredentialManager

@Composable
public actual fun rememberGoogleCredentialManager(): GoogleCredentialManager {
    val uiViewController = LocalUIViewController.current

    return remember(uiViewController) { GoogleCredentialManager(uiViewController) }
}
