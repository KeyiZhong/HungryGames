package com.matthewputra.hungrygames.manager

class UserManager {

    private lateinit var username: String
    private lateinit var password: String

    fun setUsername(name: String) {
        username = name
    }

    fun setPassword(pass: String) {
        password = pass
    }

    fun getUsername(): String {
        return username
    }

    fun getPassword(): String {
        return password
    }
}