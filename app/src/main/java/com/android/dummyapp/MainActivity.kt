package com.android.dummyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.infocus.data.ItemUpdates
import com.android.infocus.ui.InFocus

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var infocus = InFocus.newInstance(
            ItemUpdates("Nice Icons", "Completely customize colors, texts and icons.", ItemUpdates.NO_IMAGE_RES_ID),
            ItemUpdates("Such Easy", "Setting this up only takes 2 lines of code, impressive you say?", ItemUpdates.NO_IMAGE_RES_ID),
            ItemUpdates("Very Sleep", "It helps you get more sleep by writing less code.", ItemUpdates.NO_IMAGE_RES_ID),
            ItemUpdates("Text Only", "No icons? Just go with plain text.", ItemUpdates.NO_IMAGE_RES_ID)
        )
        infocus.launch(this)

    }
}
