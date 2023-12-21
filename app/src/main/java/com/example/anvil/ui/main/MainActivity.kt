package com.example.anvil.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.anvil.R
import com.example.anvil.di.inject
import com.example.anvil.session.UserSessionManager
import com.example.anvil.ui.login.LoginActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var userSessionManager: UserSessionManager

    @Inject lateinit var viewModelFactory: MainViewModel.Factory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view_hello)
        val logoutButton = findViewById<Button>(R.id.logout_button)

        val data = viewModel.getData()
        textView.text = data

        logoutButton.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        userSessionManager.resetSession()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}