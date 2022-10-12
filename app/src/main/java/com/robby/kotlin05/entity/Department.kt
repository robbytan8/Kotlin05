package com.robby.kotlin05.entity

data class Department (private val id: String, private val name: String) {
    override fun toString(): String {
        return "$id $name"
    }
}