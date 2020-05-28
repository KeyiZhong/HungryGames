package com.matthewputra.hungrygames.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matthewputra.hungrygames.R
import com.matthewputra.hungrygames.fragments.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Change fragment here to be tested
        val fragmentTest = LoginFragment()

        // Test  fragment
        supportFragmentManager
            .beginTransaction()
            .add(R.id.flFragmentContainer, fragmentTest)
            .commit()
    }
}
