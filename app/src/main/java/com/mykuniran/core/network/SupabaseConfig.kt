package com.mykuniran.core.network

import com.mykuniran.BuildConfig

object SupabaseConfig {
    const val LIVE_SUPABASE_URL = "https://bxjehrnneedmpvenzdzx.supabase.co"
    const val LIVE_ANON_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImJ4amVocm5uZWVkbXB2ZW56ZHp4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3OTA3NDk4MTQsImV4cCI6MjEwNjMyNTgxNH0.9K8eoKkajfAh5hLFEQvt_5ven8AF9Rh5L6thF0xH84g"
    const val LIVE_PUBLISHABLE_KEY = "sb_publishable_Szva0PFMm3tC207ZI7yDXA_hTep-Oy7"
    const val LIVE_GOOGLE_WEB_CLIENT_ID = "479527077405-env78bgrmqtf1aoaob61i9osdlei64q6.apps.googleusercontent.com"
    const val LIVE_GOOGLE_ANDROID_CLIENT_ID = "479527077405-3qsqu93pjtjs5hbqr87521tvn7jt25to.apps.googleusercontent.com"

    val baseUrl: String
        get() {
            val url = runCatching { BuildConfig.SUPABASE_URL }.getOrNull()
            val effectiveUrl = if (!url.isNullOrBlank() && !url.contains("your-project-ref")) url else LIVE_SUPABASE_URL
            return if (effectiveUrl.endsWith("/")) effectiveUrl else "$effectiveUrl/"
        }

    val anonKey: String
        get() {
            val key = runCatching { BuildConfig.SUPABASE_ANON_KEY }.getOrNull()
            return if (!key.isNullOrBlank() && !key.contains("placeholder")) key else LIVE_ANON_KEY
        }

    val publishableKey: String
        get() {
            val key = runCatching { BuildConfig.SUPABASE_PUBLISHABLE_KEY }.getOrNull()
            return if (!key.isNullOrBlank() && !key.contains("placeholder")) key else LIVE_PUBLISHABLE_KEY
        }

    val googleWebClientId: String
        get() {
            val id = runCatching { BuildConfig.GOOGLE_WEB_CLIENT_ID }.getOrNull()
            return if (!id.isNullOrBlank() && !id.contains("placeholder")) id else LIVE_GOOGLE_WEB_CLIENT_ID
        }

    val googleAndroidClientId: String
        get() {
            val id = runCatching { BuildConfig.GOOGLE_ANDROID_CLIENT_ID }.getOrNull()
            return if (!id.isNullOrBlank() && !id.contains("placeholder")) id else LIVE_GOOGLE_ANDROID_CLIENT_ID
        }

    val appLinkHost: String
        get() {
            val host = runCatching { BuildConfig.APP_LINK_HOST }.getOrNull()
            return if (!host.isNullOrBlank()) host else "mykuniran.app"
        }
}
