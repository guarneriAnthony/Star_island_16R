package com.example.alphadomoarigato.ship

enum class TypeShip(val nameShip: String, val type: String, val equipage: Int, val size: Int, val armor: Float, var shieldStatus: Boolean, val shieldValue: Float, val dockMax: Int, var dockActualy: Int) {

    CHASSEUR("chasseur", "WarShip", 10, 4, 100f, true, 100f, 100,0),
    FREGATE("fregate", "warShip", 3, 4, 100f, true, 100f, 100, 0),
    CROISEUR("croiseur", "WarShip", 10, 4, 100f, true, 100f, 100, 0),
    CARGO("cargo", "WarShip", 10, 4, 100f, true, 100f, 100, 0),
    WORLDSHIP("worldShip", "CivilShip", 10, 4, 100f, true, 100f, 100, 0);
}