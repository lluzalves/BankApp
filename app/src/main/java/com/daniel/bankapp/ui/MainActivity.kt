package com.daniel.bankapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.daniel.bankapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        ).navigate(R.id.loginFragment)
    }
}
