package com.example.demo.handler

import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R
import com.example.demo.handler.ThreadHandler.Companion.MSG_MAIN_MSG
import com.example.demo.handler.ThreadHandler.Companion.MSG_MAIN_MSG_CANCEL
import com.example.demo.handler.ThreadHandler.Companion.MSG_THREAD_CLICK

class HandlerMainActivity : AppCompatActivity() {

    private val mHandler by lazy {
        ThreadHandler(mainLooper, this)
    }

    private val mThread = HandlerThread(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_main)
        Thread(mThread).start()
    }

    override fun onStart() {
        super.onStart()
        initMainClick()
        initThreadClick()
    }

    private fun initThreadClick() {
        findViewById<Button>(R.id.button3)?.apply {
            setOnClickListener {
                val msg = Message.obtain()
                msg.what = MSG_THREAD_CLICK
                msg.obj = "Sub thread click"
                mThread.getHandler().sendMessage(msg)
            }
        }
    }

    private fun initMainClick() {
        findViewById<Button>(R.id.button)?.apply {
            setOnClickListener {
                val msg = Message.obtain().apply {
                    what = MSG_MAIN_MSG
                    obj = "Click on main thread"
                }
                mHandler.sendMessage(msg)
                mHandler.sendEmptyMessageDelayed(MSG_MAIN_MSG_CANCEL, 3000)
//                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun showMsg(msg: String) {
        findViewById<TextView>(R.id.msg_show)?.apply {
            text = msg
        }
    }
}
