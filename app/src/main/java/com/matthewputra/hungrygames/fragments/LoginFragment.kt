package com.matthewputra.hungrygames.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.matthewputra.hungrygames.R
import com.matthewputra.hungrygames.activity.RestaurantApp
import com.matthewputra.hungrygames.manager.UserManager
import com.matthewputra.hungrygames.model.HungryGamesApp
import kotlinx.android.synthetic.main.login_page.*
import kotlinx.android.synthetic.main.login_page.view.*

class LoginFragment: Fragment() {

    private lateinit var userManager: UserManager

    companion object {
        val TAG: String = LoginFragment::class.java.simpleName
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userManager = (this.activity?.applicationContext as HungryGamesApp).userManager
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.login_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            val usernameText = view.findViewById<EditText>(R.id.etUsername)
            val username = usernameText.text.toString()

            val passwordText = view.findViewById<EditText>(R.id.etPassword)
            val password = passwordText.text.toString()

            userManager.setUsername(username)
            userManager.setPassword(password)

            if (userManager.getUsername() != "" && userManager.getPassword() != "") {
                val helloUserFragment = HelloUserFragment()
                val fragmentTransaction = fragmentManager?.beginTransaction()
                if (fragmentTransaction != null) {
                    fragmentTransaction.replace(R.id.flFragmentContainer, helloUserFragment)
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            } else {
                Toast.makeText(context, "Please enter a valid username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}