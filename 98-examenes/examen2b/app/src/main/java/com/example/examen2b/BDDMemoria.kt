package com.example.examen2b

class BDDMemoria {

    companion object {

        val arrOFutbolista = arrayListOf<OFutbolista>()
        val arrOGol = arrayListOf<OGol>()

        init {

            arrOFutbolista
                .add(
                    OFutbolista( 1, "Josef Bican", false, 1.51 )
                )
            arrOFutbolista
                .add(
                    OFutbolista( 2, "Cristiano Ronaldo", true, 0.73 )
                )
            arrOFutbolista
                .add(
                    OFutbolista( 3, "Pele", false, 0.92 )
                )

            arrOGol
                .add(
                    OGol( 1, "Derecha", false, 87.05, 1 )
                )

            arrOGol
                .add(
                    OGol( 2, "Cabeza", false, 80.49, 2 )
                )

            arrOGol
                .add(
                    OGol( 3, "Derecha", true, 60.32, 3 )
                )

        }

    }

}