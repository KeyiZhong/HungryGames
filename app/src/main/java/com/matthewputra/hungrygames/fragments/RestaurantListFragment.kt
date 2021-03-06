package com.matthewputra.hungrygames.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.matthewputra.hungrygames.R
import com.matthewputra.hungrygames.controller.RestaurantListAdapter
import com.matthewputra.hungrygames.manager.RestaurantManager
import com.matthewputra.hungrygames.model.HungryGamesApp
import com.matthewputra.hungrygames.model.Restaurant
import kotlinx.android.synthetic.main.item_restaurant.*
import kotlinx.android.synthetic.main.restaurant_list.*

class RestaurantListFragment: Fragment() {

    private lateinit var restaurantListAdapter: RestaurantListAdapter
    private lateinit var restaurantList: List<Restaurant>
    lateinit var restaurantManager: RestaurantManager
    private lateinit var onRestaurantClickListener: OnRestaurantClickListener

    companion object {
        val TAG = RestaurantListFragment::class.java.simpleName

        const val ARG_LIST = "arg_list"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnRestaurantClickListener) {
            onRestaurantClickListener = context
        }

        restaurantManager = (this.activity?.applicationContext as HungryGamesApp).restaurantManager
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{args ->
            restaurantList = args.getParcelableArrayList<Restaurant>(ARG_LIST)!!.toList()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.restaurant_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restaurantList = (this.activity?.applicationContext as HungryGamesApp).restaurantManager.getList()

        restaurantListAdapter =
            RestaurantListAdapter(
                restaurantList
            )
        rvRestaurant.adapter = restaurantListAdapter

        restaurantListAdapter.onRestaurantClickListener = { restaurant ->
            onRestaurantClickListener.onRestaurantClicked(restaurant)
        }


        bGet.setOnClickListener {
            val itemRestaurantInfo = ItemRestaurantInfo()
            val argumentBundle = Bundle().apply {
                putParcelable(ItemRestaurantInfo.CHOSEN_RESTAURANT, restaurantManager.getChoice())
            }
            itemRestaurantInfo.arguments = argumentBundle
            val fragmentTransaction = fragmentManager?.beginTransaction()
            if (fragmentTransaction != null) {
                fragmentTransaction.replace(R.id.flFragmentContainer, itemRestaurantInfo, ItemRestaurantInfo.TAG)
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }

        bAdd.setOnClickListener {
            val addRestaurantFragment = AddRestaurantFragment()
            val fragmentTransaction = fragmentManager?.beginTransaction()
            if (fragmentTransaction != null) {
                fragmentTransaction.replace(R.id.flFragmentContainer, addRestaurantFragment, AddRestaurantFragment.TAG)
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }
    }
}

interface OnRestaurantClickListener {
    fun onRestaurantClicked(restaurant: Restaurant)
}