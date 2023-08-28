package com.example.alphadomoarigato.planet

import com.example.alphadomoarigato.ship.Ship

interface Livable {

    fun comeInPlanet(shipTryInc: Array<Ship>)
    fun leavePlanet(shipTryLeave: Array<Ship>)
}