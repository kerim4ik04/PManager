package com.example.pmanager.model

import android.accounts.AuthenticatorDescription
import android.icu.text.CaseMap.Title
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.material.progressindicator.BaseProgressIndicator
@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int?= null,
    val title:String?=null,
    val description:String?=null,
    val isSuccess: Boolean = false,
):java.io.Serializable
