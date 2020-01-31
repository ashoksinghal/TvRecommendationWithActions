package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devrel.android.fitactions.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val type = object : TypeToken<ArrayList<Channel>>() {}.type


        GlobalScope.launch(Dispatchers.IO) {
            try {
                val string = URL("http://10.178.23.94:1337/channels/recommend/1").readText()
                val result = Gson().fromJson<List<Channel>>(
                    string,
                    type
                )
                GlobalScope.launch(Dispatchers.Main) {
                    recyclerview.adapter = ChannelAdapter(result)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}
