package io.github.taetae98coding.oauth.google.exception

public class NoGoogleAccountException(
    override val message: String? = null,
    override val cause: Throwable? = null
) : RuntimeException(message, cause)