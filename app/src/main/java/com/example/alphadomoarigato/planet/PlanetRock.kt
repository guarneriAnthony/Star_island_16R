package com.example.alphadomoarigato.planet

import com.example.alphadomoarigato.ship.Ship

class PlanetRock(
    name: String, diameter: Int, matter: String, atmosphere: Atmosphere, sunDistance: Float,
    val parkingMax: Int, var parkingActualy: Int = 0, var shipIncArray: Array<Ship>)
    : Planet(name, diameter, matter, atmosphere, sunDistance), Livable{


    override fun comeInPlanet(shipTryInc: Array<Ship>) {
        var spaceForPark = 0
        var countSpaceFree = 0
        for (ship in shipTryInc){
            spaceForPark += ship.constuctShip.size
        }
        if (spaceForPark <= (parkingMax - parkingActualy)){
            parkingActualy += spaceForPark
            countSpaceFree = parkingMax - parkingActualy
            for (shipToAdd in shipTryInc){
               this.shipIncArray += shipToAdd
            }
            println("Les ship arrivent sur la planette ${this.name}. Il reste $countSpaceFree places sur $parkingMax.")
        } else if(spaceForPark > parkingMax){
            println("Vous ne pouvez pas venir, nous disposons que de $parkingMax et vous avez besoin de $spaceForPark")
        } else {
            println("Vous ne pouvez pas venir, nous disposont de $parkingActualy et vos ships prennent $spaceForPark places.")
        }
    }

    override fun leavePlanet(shipTryLeave: Array<Ship>) {
        for (shipToDelete in shipTryLeave){
            parkingActualy -= shipToDelete.constuctShip.size
            this.shipIncArray = shipIncArray.filterNot { shipTryLeave.contains(it) }.toTypedArray()
            parkingActualy = shipIncArray.sumOf { it.constuctShip.size }
            println("Le ship ${shipToDelete.constuctShip.name} part ;")
        }
        for (ship in shipIncArray){
            println("Il reste le ships : ${ship.constuctShip.name}, sur ${this.name}.")
        }
        println("Apres leur depart il reste $parkingActualy places.")
    }



}