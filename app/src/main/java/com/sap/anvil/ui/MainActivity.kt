package com.sap.anvil.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sap.anvil.R
import com.sap.anvil.data.DataSource
import com.sap.anvil.di.inject
import com.sap.anvil.session.UserSessionManager
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var userSessionManager: UserSessionManager

    @Inject lateinit var remoteDataSource: DataSource.RemoteDataSource

    @Inject lateinit var localDataSource: DataSource.LocalDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view_hello)
        val logoutButton = findViewById<Button>(R.id.logout_button)

        val data = remoteDataSource.getData()
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