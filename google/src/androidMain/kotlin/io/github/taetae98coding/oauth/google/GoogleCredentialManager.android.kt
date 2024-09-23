package io.github.taetae98coding.oauth.google

import android.content.Context
import androidx.credentials.CreateCredentialRequest
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialCancellationException
import androidx.credentials.exceptions.GetCredentialProviderConfigurationException
import androidx.credentials.exceptions.NoCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import io.github.taetae98coding.oauth.google.exception.NoGoogleAccountException

public actual class GoogleCredentialManager(
    private val context: Context
) {
    public actual suspend fun signIn(
        filterByAuthorizedAccounts: Boolean,
        autoSelectEnabled: Boolean,
    ): GoogleCredential? {
        return try {
            val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(filterByAuthorizedAccounts)
                .setAutoSelectEnabled(autoSelectEnabled)
                .setServerClientId(requireNotNull(serverClientId) { "GoogleCredentialManager not initialized." })
                .build()

            val request: GetCredentialRequest = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            execute(request)
        } catch (exception: GetCredentialCancellationException) {
            null
        } catch (exception: NoCredentialException) {
            throw NoGoogleAccountException(cause = exception)
        }
    }

    private suspend fun execute(request: GetCredentialRequest): GoogleCredential {
        val response = CredentialManager.create(context).getCredential(context, request)
        val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(response.credential.data)

        return GoogleCredential(
            idToken = googleIdTokenCredential.idToken,
            accessToken = null,
        )
    }

    public companion object {
        private var serverClientId: String? = null

        public fun init(serverClientId: String) {
            this.serverClientId = serverClientId
        }
    }
}
