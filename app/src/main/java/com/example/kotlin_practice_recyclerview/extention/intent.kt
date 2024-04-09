package com.example.kotlin_practice_recyclerview.extention

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf


inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

inline fun <reified T : Any> Context.launchActivity(vararg pair: Pair<String, Any?>){
    val intent = newIntent<T>(this)
    intent.putExtras(bundleOf(*pair))
    startActivity(intent)
}


inline fun <reified T : Any> Activity.extraNotNull(key : String, default : T? = null) = lazy{
    val value = intent?.extras?.getLong(key)
}