package io.github.taetae98coding.oauth.google

import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.suspendCancellableCoroutine
import platform.UIKit.UIViewController

@OptIn(ExperimentalForeignApi::class)
public actual class GoogleCredentialManager(
    private val uiViewController: UIViewController
) {
    public actual suspend fun signIn(
        filterByAuthorizedAccounts: Boolean,
        autoSelectEnabled: Boolean
    ): GoogleCredential? {
        return suspendCancellableCoroutine { continuation ->
            GIDSignIn.sharedInstance.signInWithPresentingViewController(
                presentingViewController = uiViewController,
                completion = { signInResult, error ->
                    val result = runCatching {
                        if (signInResult != null) {
                            GoogleCredential(
                                idToken = requireNotNull(signInResult.user.idToken?.tokenString),
                                accessToken = signInResult.user.accessToken.tokenString,
                            )
                        } else if (error != null) {
                            if (error.code == -5L) {
                                null
                            } else {
                                throw RuntimeException()
                            }
                        } else {
                            throw IllegalStateException()
                        }
                    }

                    continuation.resumeWith(result)
                }
            )
        }
    }
}
