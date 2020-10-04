package com.example.sharingshortcuts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.sharingshortcut_activity_send_message.*

class ShareActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sharingshortcut_activity_send_message)
        setupView(extractMessageFrom(intent))

    }

    private fun extractMessageFrom(intent: Intent): String {

        return intent.getStringExtra(Intent.EXTRA_TEXT)
    }



    private fun setupView( message: String) {
        sendMessageMessageTextView.text = message
        sendMessageButton.setOnClickListener {
            val toastMessage = getString(R.string.send_message_success_message)
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()
            finish()
        }
    }


}