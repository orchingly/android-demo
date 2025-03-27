package com.example.demo.handler

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast
import java.lang.ref.WeakReference

class ThreadHandler(looper: Looper, private val sContext: Context): Handler(looper) {
    companion object {
        const val TAG = "ThreadHandler"
        const val MSG_MAIN_MSG = 0x01
        const val MSG_MAIN_MSG_CANCEL = 0x02
        const val MSG_THREAD_CLICK = 0x03
    }

    private val mContext = if (sContext is HandlerMainActivity) WeakReference (sContext) else WeakReference(null)

    override fun handleMessage(msg: Message) {
        when (msg.what) {
            MSG_MAIN_MSG -> mContext.get()?.showMsg(msg.obj as String)
            MSG_MAIN_MSG_CANCEL -> mContext.get()?.showMsg("")
            MSG_THREAD_CLICK -> Toast.makeText(sContext, msg.obj?.toString(), Toast.LENGTH_SHORT).show()
        }
    }

}