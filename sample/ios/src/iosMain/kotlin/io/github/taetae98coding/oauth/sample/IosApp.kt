package io.github.taetae98coding.oauth.sample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import io.github.taetae98coding.oauth.sample.common.SampleScreen
import platform.UIKit.UIViewController

fun compose(): UIViewController {
    return ComposeUIViewController {
        SampleScreen(modifier = Modifier.fillMaxSize())
    }
}
