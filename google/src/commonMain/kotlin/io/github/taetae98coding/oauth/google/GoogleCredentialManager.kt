package io.github.taetae98coding.oauth.google

public expect class GoogleCredentialManager {
    public suspend fun signIn(
        filterByAuthorizedAccounts: Boolean = false,
        autoSelectEnabled: Boolean = false,
    ): GoogleCredential?
}
