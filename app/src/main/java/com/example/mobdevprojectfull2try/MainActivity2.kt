package com.example.mobdevprojectfull2try

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        handler = Handler()
        handler!!.postDelayed({
            val intent = Intent(
                this@MainActivity2,
                MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }, 3000)
    }
}