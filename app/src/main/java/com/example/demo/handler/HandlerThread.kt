package com.example.demo.handler

import android.content.Context
import android.os.Handler
import android.os.Looper

class HandlerThread(private val context: Context): Runnable{
    private lateinit var mHandler: Handler

    fun getHandler() = mHandler

    override fun run() {
        Looper.prepare()
        mHandler = ThreadHandler(Looper.myLooper()!!, context)
        Looper.loop()
    }
}