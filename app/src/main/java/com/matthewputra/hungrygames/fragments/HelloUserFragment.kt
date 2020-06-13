package com.matthewputra.hungrygames.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matthewputra.hungrygames.R
import com.matthewputra.hungrygames.model.HungryGamesApp
import kotlinx.android.synthetic.main.hello_username.*

class HelloUserFragment: Fragment() {

    private lateinit var restaurantApp: HungryGamesApp

    companion object {
        val TAG: String = HelloUserFragment::class.java.simpleName
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        restaurantApp = context.applicationContext as HungryGamesApp
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.hello_username, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButtonParty()

        // Set a welcome message
        tvUsername.text = getString(R.string.welcome_user).format(restaurantApp.userManager.getUsername())
    }

    private fun initButtonParty() {
        bParty.setOnClickListener {
            val restaurantListFragment = RestaurantListFragment()
            activity?.supportFragmentManager?.let{ fragManager ->
                fragManager
                    .beginTransaction()
                    .add(R.id.flFragmentContainer, restaurantListFragment, RestaurantListFragment.TAG)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}