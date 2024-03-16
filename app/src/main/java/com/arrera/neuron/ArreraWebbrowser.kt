package com.arrera.neuron

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity

class ArreraWebbrowser(private val cont : Context) {

    fun open(url:String)
    {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(cont,intent,null)

    }

}