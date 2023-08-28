package com.example.alphadomoarigato.planet

class Atmosphere(private val hydrogene: Float, private val methane: Float, private val azote: Float) {
        fun printComposition() {
            println("Composition ${this.hydrogene}, ${this.methane}, ${this.azote}")
    }
}