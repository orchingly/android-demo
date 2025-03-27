package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.handler.HandlerMainActivity

open class BaseActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpBack()
    }

    private fun setUpBack() {
        findViewById<Button>(R.id.handler_demo)?.setOnClickListener {
            val intent = Intent(this, HandlerMainActivity::class.java)
            startActivity(intent)
        }
    }
}