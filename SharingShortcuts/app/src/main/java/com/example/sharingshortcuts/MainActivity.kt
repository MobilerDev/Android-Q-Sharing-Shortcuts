package com.example.sharingshortcuts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.Person
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import kotlinx.android.synthetic.main.sharingshortcut_activity_main.*


class MainActivity : AppCompatActivity() {

    private val CATEGORY_TEXT_SHARE_TARGET =
        "com.example.android.sharingshortcuts.category.TEXT_SHARE_TARGET"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sharingshortcut_activity_main)

        setupView()
        addShareShortcuts(this)

    }


    private fun addShareShortcuts(context: Context) {
        val shortcutInfoList = mutableListOf<ShortcutInfoCompat>()

        shortcutInfoList.add(
        ShortcutInfoCompat.Builder(context, "kisi1")
                .setShortLabel("Kişi 1")
                .setPerson(toPerson())
                .setIcon(IconCompat.createWithResource(context, R.drawable.ic_android_red))
                .setCategories(setOf(CATEGORY_TEXT_SHARE_TARGET))
                .setLongLived(true)
                .setIntent(Intent(Intent.ACTION_DEFAULT))
                .build())


        ShortcutManagerCompat.addDynamicShortcuts(context, shortcutInfoList)

    }

    private fun toPerson(): Person {
        return Person.Builder()
                .setKey("kisi1")
                .setName("Kişi 1")
                .build()
    }

    private fun setupView() {
        mainShareButton.setOnClickListener {
            val input = getInput()
            if (isInputValid(input)) {
                shareInput(input)
            } else {
                displayErrorMessage()
            }
        }
    }


    private fun getInput(): String = mainEditText.text.toString()

    private fun isInputValid(input: String): Boolean = input.isNotBlank()

    private fun shareInput(input: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, input)
        }
        startActivity(Intent.createChooser(intent, getString(R.string.main_chooser_title)))
    }

    private fun displayErrorMessage() =
        Toast.makeText(this, R.string.main_invalid_input_error, Toast.LENGTH_SHORT).show()


}
