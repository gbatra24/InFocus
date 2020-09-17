package com.android.dummyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.discover.InFocus

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var infocus = InFocus()
        infocus.launch(this)
    }
}
