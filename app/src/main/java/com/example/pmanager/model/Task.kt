package com.example.pmanager.model

import android.accounts.AuthenticatorDescription
import android.icu.text.CaseMap.Title
import com.google.android.material.progressindicator.BaseProgressIndicator

data class Task(
    val title:String?=null,
    val description:String?=null,
):java.io.Serializable
