package com.matthewputra.hungrygames.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.matthewputra.hungrygames.R
import com.matthewputra.hungrygames.fragments.LoginFragment
import com.matthewputra.hungrygames.model.HungryGamesApp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLoginFragment()
        addFragmentBackButton()
    }

    private fun initLoginFragment() {
        val loginFragment = LoginFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.flFragmentContainer, loginFragment, LoginFragment.TAG)
            .commit()
    }

    private fun addFragmentBackButton() {
        supportFragmentManager.addOnBackStackChangedListener {
            val hasBackStack = supportFragmentManager.backStackEntryCount > 0

            if (hasBackStack) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            } else {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.popBackStack()
        return super.onNavigateUp()
    }
}
