package com.sap.anvil.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sap.anvil.R
import com.sap.anvil.data.DataSource
import com.sap.anvil.di.inject
import com.sap.anvil.session.UserSessionManager
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject lateinit var userSessionManager: UserSessionManager

    @Inject lateinit var localDataSource: DataSource.LocalDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textView = findViewById<TextView>(R.id.text_view_hello)
        val loginButton = findViewById<Button>(R.id.login_button)

        val data = localDataSource.getData()
        textView.text = data

        loginButton.setOnClickListener {
            val idEditText = findViewById<EditText>(R.id.id_edit_text)
            val id = idEditText.text.toString()
            login(id)
        }
    }

    private fun login(id: String) {
        userSessionManager.createSession(id)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}