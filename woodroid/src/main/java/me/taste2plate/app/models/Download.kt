package me.taste2plate.app.models

import java.io.Serializable

class Download : Serializable {
    lateinit var id: String
    lateinit var name: String
    lateinit var file: String
}
