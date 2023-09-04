package com.example.alphadomoarigato

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alphadomoarigato.databinding.ActivityMainBinding
import com.example.alphadomoarigato.ship.CivilShip
import com.example.alphadomoarigato.ship.Ship
import com.example.alphadomoarigato.ship.TypeShip
import com.example.alphadomoarigato.ship.WarShip


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    companion object {
        var userShip: Ship? = null
    }
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tempArrayBtn = arrayListOf<RadioButton>()


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
                        val intent = Intent(this, SecondeActivity::class.java)
                        addViewText(userShip!!.constuctShip.nameShip)
                        startActivity(intent)
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


        val coroutineScope = MainScope()
        fun executeCall() {
            // Utilisez la CoroutineScope pour lancer la coroutine.
            coroutineScope.launch(Dispatchers.Main) {
                try {
                    // Votre code de requête réseau ici.

                    val response = ApiClient.apiService.getPostById(4)

                    if (response.isSuccessful && response.body() != null) {
                        val content = response.body()
                        // Faites quelque chose avec les données récupérées.
                        println(content)
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Error Occurred: ${response.message()}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                } catch (e: Exception) {
                    Toast.makeText(
                        this@MainActivity,
                        "Error Occurred: ${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        fun onDestroy() {
            super.onDestroy()
            // Assurez-vous d'annuler la CoroutineScope lorsque l'activité est détruite.
            coroutineScope.cancel()
        }
        executeCall()



    }
}


