package io.github.taetae98coding.oauth.sample.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.taetae98coding.oauth.google.compose.rememberGoogleCredentialManager
import kotlinx.coroutines.launch

@Composable
fun SampleScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        val coroutineScope = rememberCoroutineScope()
        val googleCredentialManager = rememberGoogleCredentialManager()

        var result by rememberSaveable { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        ) {
            BasicText(text = result)
        }
        LoginButton(
            text = { BasicText(text = "Google Login") },
            onClick = {
                coroutineScope.launch {
                    result = try {
                        googleCredentialManager.signIn().toString()
                    } catch (throwable: Throwable) {
                        throwable.printStackTrace()
                        throwable.toString()
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )
    }
}

@Composable
private fun LoginButton(
    text: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        text()
    }
}
