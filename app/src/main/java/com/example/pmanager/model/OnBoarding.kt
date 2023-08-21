package com.example.pmanager.model

import android.accounts.AuthenticatorDescription
import android.icu.text.CaseMap.Title
import android.media.Image

data class OnBoarding(
    val image: String? = null,
    val title: String? = null,
    val description: String? = null
)
