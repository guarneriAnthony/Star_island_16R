package com.example.alphadomoarigato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import com.example.alphadomoarigato.databinding.ActivityMainBinding
import com.example.alphadomoarigato.planet.Atmosphere
import com.example.alphadomoarigato.planet.Planet
import com.example.alphadomoarigato.planet.PlanetRock
import com.example.alphadomoarigato.ship.CivilShip
import com.example.alphadomoarigato.ship.TypeShip
import com.example.alphadomoarigato.ship.WarShip
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val fregate = WarShip(TypeShip.FREGATE)
        val fregate1 = WarShip(TypeShip.FREGATE)
        val fregate2 = WarShip(TypeShip.FREGATE)
        val worldShip = CivilShip(TypeShip.WORLDSHIP)
        val worldShip1 = CivilShip(TypeShip.WORLDSHIP)
        var shipArray = arrayOf(fregate, worldShip)
        val shipArray2 = arrayOf(fregate1,fregate2,worldShip1)

        val atmosphereGlobal = Atmosphere(1.1f, 2.2f, 3.3f)
        val planetGlobal = Planet("terre", 100, "rock", atmosphereGlobal, 1.1f)
        val mars = PlanetRock("mars", 100, "gaz", atmosphereGlobal, 50.0f, 16, 0, shipArray)


        val btn = findViewById<Button>(R.id.btnLayoutId)
        btn.setOnClickListener(){
            println(btn.text)
        }

//        val textInputLayout = findViewById<TextInputLayout>(R.id.textInputLayout)
//        val editText = textInputLayout.editText
//
//        textInputLayout.setOnClickListener(){
//            println(textInputLayout.editText)
//        }
//
//        val inputValue = editText?.text.toString()
//
//        binding.textView.text = inputValue

//        try {
//            val br = BufferedReader(InputStreamReader(System.`in`))
//            println("Choisir un Ship: ")
//            val shipChoice = br.readLine()
//            println(shipChoice)
//            br.close()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }




        }


//        mars.comeInPlanet(shipArray2)
//        mars.leavePlanet(shipArray)
//        fregate.loadCargo(100)
//        fregate.unloadCargo(50)
    }
