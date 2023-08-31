package com.example.alphadomoarigato

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.alphadomoarigato.databinding.ActivityMainBinding
import com.example.alphadomoarigato.ship.CivilShip
import com.example.alphadomoarigato.ship.Ship
import com.example.alphadomoarigato.ship.TypeShip
import com.example.alphadomoarigato.ship.WarShip


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tempArrayBtn = arrayListOf<RadioButton>()
        var userShip: Ship?

        fun addViewText(shipChoice: String) {
            binding.radioGroupId.removeAllViews()
            val textViewShip = Button(this)
            textViewShip.hint = "Vous avez choisis le ship $shipChoice"
            textViewShip.layoutParams = RadioGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )


            binding.radioGroupId.addView(textViewShip)
        }

        fun getNameFromShipChoice(text: String): ArrayList<String> {
            val tabAddShip = arrayListOf<String>()
            for (ship in TypeShip.values()) {
                if (ship.type.uppercase() == text) {
                    tabAddShip += ship.nameShip.uppercase()
                }
            }
            return tabAddShip
        }

        fun addButton(arrayOfTitle: List<String>) {
            binding.radioGroupId.removeAllViews()
            tempArrayBtn.clear()
            for (title in arrayOfTitle) {
                val button = RadioButton(this)
                button.text = title
                button.layoutParams = RadioGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                tempArrayBtn += button
                binding.radioGroupId.addView(button)
            }
        }

        fun addEventCreateShip() {
            binding.textView.text = "Choisir un ship :"
            for (iButton in tempArrayBtn) {
                iButton.setOnClickListener {
                    userShip = when (iButton.text) {
                        "CHASSEUR" -> WarShip(TypeShip.CHASSEUR)
                        "FREGATE" -> WarShip(TypeShip.FREGATE)
                        "CROISEUR" -> WarShip(TypeShip.CROISEUR)
                        "CARGO" -> WarShip(TypeShip.CARGO)
                        "WORLDSHIP" -> CivilShip(TypeShip.WORLDSHIP)
                        else -> {
                            null
                        }
                    }
                    binding.textView.visibility = View.INVISIBLE
                    if (userShip != null) {
                        addViewText(userShip!!.constuctShip.nameShip)
                    }
                }
            }
        }

        fun addButtonShipChoice() {
            for (i in tempArrayBtn) {
                i.setOnClickListener {
                    val shipChoice = getNameFromShipChoice(i.text.toString())
                    addButton(shipChoice)
                    addEventCreateShip()

                }
            }
        }

        fun getUniqueTypeFromTypeShip(): ArrayList<String> {
            val tabEnum = arrayListOf<String>()
            for (i in TypeShip.values()) {
                if (!tabEnum.contains(i.type.uppercase())) {
                    tabEnum += i.type.uppercase()
                }
            }
            return tabEnum
        }

        fun run() {
                val typesShip = getUniqueTypeFromTypeShip()
                addButton(typesShip)
                addButtonShipChoice()
        }
        run()


    }
}


