package com.devrel.android.fitactions.recommendation

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devrel.android.fitactions.R
import com.example.myapplication.Channel
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
                val string = URL("http://192.168.20.141:1337/channels/recommend/1").readText()
                val string2 = URL("http://192.168.20.141:1337/channels/recommend/high/1").readText()


                val result = Gson().fromJson<List<Channel>>(
                    string,
                    type
                )

                val result2 = Gson().fromJson<List<Channel>>(
                    string2,
                    type
                )

                GlobalScope.launch(Dispatchers.Main) {
                    recyclerview.addItemDecoration(
                        DividerItemDecoration(
                            recyclerview.context,
                            DividerItemDecoration.VERTICAL
                        )
                    )

                    recyclerview.addItemDecoration(
                        DividerItemDecoration(
                            recyclerview.context,
                            DividerItemDecoration.HORIZONTAL
                        )
                    )


                    recyclerview2.addItemDecoration(
                        DividerItemDecoration(
                            recyclerview2.context,
                            DividerItemDecoration.VERTICAL
                        )
                    )

                    recyclerview2.addItemDecoration(
                        DividerItemDecoration(
                            recyclerview2.context,
                            DividerItemDecoration.HORIZONTAL
                        )
                    )


                    recyclerview.adapter = ChannelAdapter(result)
                    recyclerview2.adapter = ChannelAdapter(result2)

                    progress_bar.visibility = View.GONE
                    container1.visibility = View.VISIBLE
                    container2.visibility = View.VISIBLE


                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}
