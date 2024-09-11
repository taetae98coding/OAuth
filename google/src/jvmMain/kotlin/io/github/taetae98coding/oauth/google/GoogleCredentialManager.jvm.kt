package io.github.taetae98coding.oauth.google

public actual class GoogleCredentialManager {
    public actual suspend fun signIn(
        filterByAuthorizedAccounts: Boolean,
        autoSelectEnabled: Boolean,
    ): GoogleCredential? {
        TODO("Not yet implemented")
    }
}
