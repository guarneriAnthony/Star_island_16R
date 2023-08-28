package com.example.alphadomoarigato.ship

enum class TypeShip(val nameShip: String, val type: String, val equipage: Int, val size: Int, val armor: Float, var shieldStatus: Boolean, val shieldValue: Float, val dockMax: Int, var dockActualy: Int) {

    CHASSEUR("chasseur", "warShip", 10, 4, 100f, true, 100f, 100,0),
    FREGATE("fregate", "warShip", 3, 4, 100f, true, 100f, 100, 0),
    CROISEUR("croiseur", "warShip", 10, 4, 100f, true, 100f, 100, 0),
    CARGO("cargo", "warShip", 10, 4, 100f, true, 100f, 100, 0),
    WORLDSHIP("worldShip", "civilShip", 10, 4, 100f, true, 100f, 100, 0);
}