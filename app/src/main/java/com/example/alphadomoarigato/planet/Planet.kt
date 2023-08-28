package com.example.alphadomoarigato.planet

import com.example.alphadomoarigato.planet.Planet.PlanetFindCount.nbrPlanetFind

open class Planet(val name: String, val diameter: Int, val matter: String, val atmosphere: Atmosphere, val sunDistance: Float) {

    object PlanetFindCount{
         var nbrPlanetFind = 0
         var nbrTotalVisiter = 0
    }
    init {
        nbrPlanetFind++
    }

}