package com.example.projectcatering

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MySingleton private constructor(context: Context) {
    private val requestQueue: RequestQueue = Volley.newRequestQueue(context.applicationContext)

    fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue.add(req)
    }

    companion object {
        @Volatile
        private var INSTANCE: MySingleton? = null

        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MySingleton(context).also { INSTANCE = it }
            }
    }
}
