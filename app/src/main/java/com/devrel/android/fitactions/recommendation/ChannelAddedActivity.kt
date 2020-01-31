package com.devrel.android.fitactions.recommendation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devrel.android.fitactions.R
import kotlinx.android.synthetic.main.activity_channel_added.*

class ChannelAddedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channel_added)
        check.postDelayed({
            check.check()
        }, 500)
    }
}
