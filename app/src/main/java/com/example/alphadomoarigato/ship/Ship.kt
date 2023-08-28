package com.example.alphadomoarigato.ship

import kotlinx.coroutines.awaitAll

open class Ship(val constuctShip: TypeShip) {
    val cc = constuctShip.type

    fun enableShield(){
        constuctShip.shieldStatus = true
        println("Le shield du ship ${constuctShip.name} est activé, il a une valeur de ${constuctShip.shieldValue}")
    }
    fun disableShield(){
        constuctShip.shieldStatus = false
        println("Le shield du ship ${constuctShip.name} est desactivé, il a une vaelur de ${constuctShip.shieldValue}")
    }
    fun loadCargo(weight: Int){
        val slot = weight / 10
        val freeSlotForLoadCargo = (constuctShip.dockMax - constuctShip.dockActualy) - (constuctShip.equipage * 10)
        if (constuctShip.equipage >= 3){
            if (slot <= freeSlotForLoadCargo){
                constuctShip.dockActualy += slot
                println("On peu charger les $weight/Kg de cargaisons, elle prendra $slot places, il reste ${constuctShip.dockMax-constuctShip.dockActualy} slots.")
            } else {
                println("Il ne reste que $freeSlotForLoadCargo slot, soit ${freeSlotForLoadCargo*10}/kg de chargement libre ")
            }
        } else {
            println("Lequipage est trop petit pour charger le ship")
        }

    }
    fun unloadCargo(weight: Int) {
        val slot = weight / 10
        if(slot > constuctShip.dockActualy){
            println(constuctShip.dockActualy)
            println("Vous essayer de decharger plus que les ${constuctShip.dockActualy} slot de marchandise dans le ship")
        } else {
            constuctShip.dockActualy -= slot
            println("Vous avez decharger ${weight}/Kg et il reste ${constuctShip.dockActualy*10}/Kg dans le ship.")
            println("Il reste donc ${constuctShip.dockMax-constuctShip.dockActualy} slot disponible, soit ${(constuctShip.dockMax-constuctShip.dockActualy)*10}/Kg de place.")
        }
    }

}