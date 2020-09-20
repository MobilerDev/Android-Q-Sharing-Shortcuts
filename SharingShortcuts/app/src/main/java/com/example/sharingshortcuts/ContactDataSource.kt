package com.example.sharingshortcuts

object ContactDataSource {

    private val contacts: List<Contact> by lazy {
        listOf(
            Contact(
                "kisi1",
                "Kişi 1",
                R.drawable.person1
            ),
            Contact(
                "kisi2",
                "Kişi 2",
                R.drawable.person2
            ),
            Contact(
                "kisi3",
                "Kişi 3",
                R.drawable.person3
            )

        )
    }

    fun getAllContacts() = contacts

}