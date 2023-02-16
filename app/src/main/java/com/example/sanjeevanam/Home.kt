package com.example.sanjeevanam

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager

import java.util.*


class Home : Fragment() {

    var currentPage = 0
    var timer: Timer? = null
    val DELAY_MS: Long = 500 //delay in milliseconds before task is to be executed
    val PERIOD_MS: Long = 3000


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment

        var view : View = inflater.inflate(R.layout.fragment_home, container, false)
        var imgs : List<Int> = listOf<Int>(R.drawable.sanjeevanam03,R.drawable._nd_slide,R.drawable.red_cross,R.drawable.nguy_n_hi_p_ufwc2cmbaai_unsplash)
        var adapter = context?.let { Adapter(imgs , it) }

        var pager = view.findViewById<ViewPager>(R.id.pager)
        pager.adapter = adapter

        val handler = Handler()
        val Update = Runnable {
            if (currentPage ==  imgs.size) {
                currentPage = 0
            }
            pager.setCurrentItem(currentPage++, true)
        }

        timer = Timer() // This will create a new Thread

        timer?.schedule(object : TimerTask() {
            // task to be scheduled
            override fun run() {
                handler.post(Update)
            }
        }, DELAY_MS, PERIOD_MS)

        val requestBtn = view.findViewById<ImageButton>(R.id.requestBtn)
        requestBtn.setOnClickListener {

            val intent = Intent(context , RequestPage::class.java)
            startActivity(intent)
        }

        val donateBtn = view.findViewById<ImageButton>(R.id.donateBtn)
        donateBtn.setOnClickListener {

            val intent = Intent(context , DonatePage::class.java)
            startActivity(intent)
        }

        val availabilityBtn = view.findViewById<ImageButton>(R.id.availabilityBtn)
        availabilityBtn.setOnClickListener {

            val intent = Intent(context ,   AvailabilityCheck::class.java)
            startActivity(intent)
        }

        val nearbyBtn = view.findViewById<ImageButton>(R.id.nearbyBtn)
        nearbyBtn.setOnClickListener {

            val intent = Intent(context ,   NearBy::class.java)
            startActivity(intent)
        }


        return view
    }





}