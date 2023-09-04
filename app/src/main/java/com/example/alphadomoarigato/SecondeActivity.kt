package com.example.alphadomoarigato

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

import com.example.alphadomoarigato.databinding.SecondeActivityBinding

class SecondeActivity: AppCompatActivity() {
    private  lateinit var binding: SecondeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fun addButton() {
                val button = Button(this)
                button.text = "azazazaz"
                button.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )


        }
        addButton()

    }
}