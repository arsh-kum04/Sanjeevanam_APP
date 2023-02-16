package com.example.sanjeevanam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sanjeevanam.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.BottomNavigator.setOnItemSelectedListener {

            when(it.itemId)
            {
                R.id.home -> replaceFragment(Home())
                R.id.profile -> replaceFragment(ProfilePage())
                R.id.explore -> replaceFragment(Explore())

                else ->{


                }
            }

            true
        }
    }

    private fun replaceFragment(fragment : Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout , fragment)
        fragmentTransaction.commit()
    }

}