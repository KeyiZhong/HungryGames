package com.matthewputra.hungrygames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Change fragment here to be tested
        val fragmentTest = RestaurantListFragment()

        // Test  fragment
        supportFragmentManager
            .beginTransaction()
            .add(R.id.flFragmentContainer, fragmentTest)
            .commit()
    }
}
