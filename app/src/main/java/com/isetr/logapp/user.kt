package com.isetr.logapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
open class User(
    val username: String,
    val password: String,
    //var email: String="admin@isetr.tn",
    //var phoneNumber: String="22111111"
) : Parcelable

