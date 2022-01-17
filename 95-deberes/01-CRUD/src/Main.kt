import java.io.*
import java.util.*
import kotlin.collections.ArrayList


fun main() {

    val scanner = Scanner(System.`in`)
    Futbolistas.leerArchivoFutbolistas()
    Goles.leerArchivoGoles()

    do {
        print(
            "Bienvenidos\n" +
                    "Seleccione la entidad\n" +
                    "1: Futbolistas\n" +
                    "2: Goles\n" +
                    "0: Salir\n" +
                    "Opcion: "
        )
        var opcionMenu = scanner.nextLine().toInt()
        when (opcionMenu) {
            1 -> {
                Futbolistas.mostrarFutbolistas(Futbolistas.listaFutbolistas)
                do {
                    print(
                        "Seleccione la operación a realizar\n" +
                                "1: Ingresar Futbolista\n" +
                                "2: Consultar Futbolista\n" +
                                "3: Actualizar Futbolista\n" +
                                "4: Eliminar Futbolista\n" +
                                "0: Salir\n" +
                                "Opcion: "
                    )
                    var opcionFutbolista = scanner.nextLine().toInt()
                    when (opcionFutbolista) {
                        1 -> {
                            println("Ingrese el id de la Futbolista")
                            var id = scanner.nextLine().toInt()
                            println("Ingrese el nombre de la Futbolista")
                            var nombre = scanner.nextLine()
                            var fecNacimiento = Date()
                            var actividad = true
                            do {
                                print(
                                    "Seleccione si esta en actividad o no\n" +
                                            "1: Si\n" +
                                            "2: No\n" +
                                            "Opcion: "
                                )
                                var opcionActividad = scanner.nextLine().toInt()
                                if (opcionActividad == 1) {
                                    actividad = true
                                } else if (opcionActividad == 2) {
                                    actividad = false
                                } else {
                                    println("Seleccione la opción correcta")
                                }
                            } while (opcionActividad != 1 && opcionActividad != 2)
                            println("Ingrese el promedio de goles por partido")
                            var proGPP = scanner.nextLine().toDouble()
                            var nuevoFutbolista = Futbolistas(id, nombre, fecNacimiento, actividad, proGPP)
                            Futbolistas.insertarFutbolista(nuevoFutbolista)
                            break
                        }
                        2 -> {
                            do {
                                print(
                                    "1: Consultar por id\n" +
                                            "2: Consultar por nombre\n" +
                                            "3: Consultar por fecha de nacimiento\n" +
                                            "4: Consultar por actividad\n" +
                                            "5: Consultar por promedio de goles por partido\n" +
                                            "0: Salir\n" +
                                            "Opcion: "
                                )
                                var opcionConsulta = scanner.nextLine().toInt()
                                when (opcionConsulta) {
                                    1 -> {
                                        print("Ingrese el id: ")
                                        var id = scanner.nextLine().toInt()
                                        Futbolistas.mostrarFutbolistas(Futbolistas.buscarFutbolistaId(id))
                                        break
                                    }
                                    2 -> {
                                        print("Ingrese el nombre: ")
                                        var nombre = scanner.nextLine()
                                        Futbolistas.mostrarFutbolistas(Futbolistas.buscarFutbolistaNombre(nombre))
                                        break
                                    }
                                    3 -> {
                                        print("Ingrese la fecha de nacimiento: ")
                                        var fecha = Date()
                                        Futbolistas.mostrarFutbolistas(Futbolistas.buscarFutbolistaFecNacimiento(fecha))
                                        break
                                    }
                                    4 -> {
                                        do {
                                            print(
                                                "Escoja la opcion: \n" +
                                                        "1: Si\n" +
                                                        "2: No\n" +
                                                        "0: Salir\n" +
                                                        "Opcion: "
                                            )
                                            var consultaActividad = scanner.nextLine().toInt()
                                            if (consultaActividad == 1) {
                                                Futbolistas.mostrarFutbolistas(Futbolistas.buscarFutbolistaActividad(true))
                                                break
                                            } else if (consultaActividad == 2) {
                                                Futbolistas.mostrarFutbolistas(Futbolistas.buscarFutbolistaActividad(false))
                                                break
                                            } else {
                                                println("Escoja la opción correcta")
                                            }
                                        } while (consultaActividad != 0)
                                        break
                                    }
                                    5 -> {
                                        print("Ingrese el promedio de goles por partido: ")
                                        var proGPP = scanner.nextLine().toDouble()
                                        Futbolistas.mostrarFutbolistas(Futbolistas.buscarFutbolistaProGPP(proGPP))
                                        break
                                    }
                                    0 -> {

                                    }
                                    else -> {
                                        println("Ingrese la opcion correcta")
                                    }
                                }
                            } while (opcionConsulta != 0)
                        }
                        3 -> {
                            do {
                                print(
                                    "1: Actualizar nombre\n" +
                                            "2: Actualizar fecha de nacimiento\n" +
                                            "3: Actualizar si esta en actividad\n" +
                                            "4: Actualizar promedio de goles por partido\n" +
                                            "0: Salir\n" +
                                            "Opcion: "
                                )
                                var opcionActualizar = scanner.nextLine().toInt()
                                when (opcionActualizar) {
                                    1 -> {
                                        print("Ingrese el id del futbolista a actualizar: ")
                                        var id = scanner.nextLine().toInt()
                                        print("Ingrese el nombre: ")
                                        var nombre = scanner.nextLine().toString()
                                        Futbolistas.actualizarFutbolistaNombre(id, nombre)
                                        break
                                    }
                                    2 -> {
                                        print("Ingrese el id del futbolista a actualizar: ")
                                        var id = scanner.nextLine().toInt()
                                        print("Ingrese la fecha de nacimiento: ")
                                        var fecha = Date()
                                        Futbolistas.actualizarFutbolistaFecNacimiento(id, fecha)
                                        break
                                    }
                                    3 -> {
                                        print("Ingrese el id del futbolista a actualizar: ")
                                        var id = scanner.nextLine().toInt()
                                        do {
                                            print(
                                                "1: Si\n" +
                                                        "2: No\n" +
                                                        "0: Salir\n" +
                                                        "Opcion: "
                                            )
                                            var opcionActualizarActividad = scanner.nextLine().toInt()
                                            if (opcionActualizarActividad == 1) {
                                                Futbolistas.actualizarFutbolistaActividad(id, true)
                                                break
                                            } else if (opcionActualizarActividad == 2) {
                                                Futbolistas.actualizarFutbolistaActividad(id, false)
                                                break
                                            } else {
                                                println("Ingrese la opcion correcta")
                                            }
                                        } while (opcionActualizarActividad != 0)
                                        break
                                    }
                                    4 -> {
                                        print("Ingrese el id del futbolista a actualizar: ")
                                        var id = scanner.nextLine().toInt()
                                        print("Ingrese el promedio de goles por partido: ")
                                        var proGPP = scanner.nextLine().toDouble()
                                        Futbolistas.actualizarFutbolistaProGPP(id, proGPP)
                                        break
                                    }
                                    0 -> {

                                    }
                                    else -> {
                                        println("Ingrese la opcion correcta")
                                    }
                                }
                            } while (opcionActualizar != 0)
                        }
                        4 -> {
                            println("Ingrese el id del futbolista a eliminar")
                            var id = scanner.nextLine().toInt()
                            Futbolistas.eliminarFutbolista(id)
                            break
                        }
                        0 -> {

                        }
                        else -> println("Ingrese la opcion correcta")
                    }

                } while (opcionFutbolista != 0)
            }
            2 -> {
                Goles.mostrarGoles(Goles.listaGoles)
                do {
                    print(
                        "Selecciona la operación a realizar\n" +
                                "1: Ingresar Gol\n" +
                                "2: Consultar Gol\n" +
                                "3: Actualizar Gol\n" +
                                "4: Eliminar Gol\n" +
                                "0: Salir\n" +
                                "Opcion: "
                    )
                    var opcionGol = scanner.nextLine().toInt()
                    when (opcionGol) {
                        1 -> {
                            println("Ingrese el id del Gol")
                            var id = scanner.nextLine().toInt()
                            println("Ingrese el tipo de Gol")
                            var tipo = scanner.nextLine()
                            var fecAnotacion = Date()
                            var penal = true
                            do {
                                print(
                                    "Seleccione si es de penal o no\n" +
                                            "1: Si\n" +
                                            "2: No\n" +
                                            "Opcion: "
                                )
                                var opcionPenal = scanner.nextLine().toInt()
                                if (opcionPenal == 1) {
                                    penal = true
                                } else if (opcionPenal == 2) {
                                    penal = false
                                } else {
                                    println("Seleccione la opción correcta")
                                }
                            } while (opcionPenal != 1 && opcionPenal != 2)
                            println("Inrese el minuto de anotacion")
                            var minuto = scanner.nextLine().toDouble()
                            var idFutbolista: Int
                            do {
                                println("Seleccione el id del Futbolista del Gol")
                                Futbolistas.listaFutbolistas.forEach { println("${it.id}: " + "${it.nombre}") }
                                idFutbolista = scanner.nextLine().toInt()
                                var bandera = false
                                Futbolistas.listaFutbolistas.forEach {
                                    if (it.id == idFutbolista) {
                                        bandera = true
                                    }
                                }
                            } while (!bandera)
                            var nuevoGol = Goles(id, tipo, Date(), penal, minuto, idFutbolista)
                            Goles.insertarGol(nuevoGol)
                            break
                        }
                        2 -> {
                            do {
                                print(
                                    "1: Consultar por id\n" +
                                            "2: Consultar por tipo\n" +
                                            "3: Consultar por fecha de anotacion\n" +
                                            "4: Consultar por penal\n" +
                                            "5: Consultar por munito\n" +
                                            "6: Consultar por id del Futbolista\n" +
                                            "0: Salir" +
                                            "Opcion: "
                                )
                                var opcionConsulta = scanner.nextLine().toInt()
                                when (opcionConsulta) {
                                    1 -> {
                                        print("Ingrese el id: ")
                                        var id = scanner.nextLine().toInt()
                                        Goles.mostrarGoles(Goles.buscarGolId(id))
                                        break
                                    }
                                    2 -> {
                                        print("Ingrese el tipo: ")
                                        var tipo = scanner.nextLine()
                                        Goles.mostrarGoles(Goles.buscarGolTipo(tipo))
                                        break
                                    }
                                    3 -> {
                                        print("Ingrese la fecha de anotacion: ")
                                        var fecAnotacion = Date()
                                        Goles.mostrarGoles(Goles.buscarGolFecAnotacion(fecAnotacion))
                                        break
                                    }
                                    4 -> {
                                        do {
                                            print(
                                                "Escoja la opcion: \n" +
                                                        "1: Si\n" +
                                                        "2: No\n" +
                                                        "0: Salir\n" +
                                                        "Opcion: "
                                            )
                                            var consultaPenal = scanner.nextLine().toInt()
                                            if (consultaPenal == 1) {
                                                Goles.mostrarGoles(Goles.buscarGolPenal(true))
                                                break
                                            } else if (consultaPenal == 2) {
                                                Goles.mostrarGoles(Goles.buscarGolPenal(false))
                                                break
                                            } else {
                                                println("Escoja la opción correcta")
                                            }
                                        } while (consultaPenal != 0)
                                        break
                                    }
                                    5 -> {
                                        print("Ingrese el minuto del Gol: ")
                                        var minuto = scanner.nextLine().toDouble()
                                        Goles.mostrarGoles(Goles.buscarGolMinuto(minuto))
                                        break
                                    }
                                    6 -> {
                                        var idFutbolista: Int
                                        do {
                                            println("Seleccione el id del Futbolista del Gol")
                                            Futbolistas.listaFutbolistas.forEach { println("${it.id}: " + "${it.nombre}") }
                                            idFutbolista = scanner.nextLine().toInt()
                                            var bandera = false
                                            Futbolistas.listaFutbolistas.forEach {
                                                if (it.id == idFutbolista) {
                                                    bandera = true
                                                }
                                            }
                                        } while (!bandera)
                                        Goles.mostrarGoles(Goles.buscarGolIdFutbolista(idFutbolista))
                                        break
                                    }
                                    0 -> {

                                    }
                                    else -> {
                                        println("Escoja la opción correcta")
                                    }
                                }
                            } while (opcionConsulta != 0)
                        }
                        3 -> {
                            do {
                                print(
                                    "1: Actualizar nombre\n" +
                                            "2: Actualizar fecha de anotacion\n" +
                                            "3: Actualizar si es penal o no\n" +
                                            "4: Actualizar minuto\n" +
                                            "5: Actualizar id del Futbolista\n" +
                                            "0: Salir\n" +
                                            "Opcion: "
                                )
                                var opcionActualizar = scanner.nextLine().toInt()
                                when (opcionActualizar) {
                                    1 -> {
                                        print("Ingrese el id del gol a actualiazr")
                                        var id = scanner.nextLine().toInt()
                                        print("Ingrese el tipo: ")
                                        var tipo = scanner.nextLine().toString()
                                        Goles.actualizarGolTipo(id, tipo)
                                        break
                                    }
                                    2 -> {
                                        print("Ingrese el id del gol a actualiazr")
                                        var id = scanner.nextLine().toInt()
                                        print("Ingrese la fecha de anotacion: ")
                                        var fecAnotacion = Date()
                                        Goles.actualizarGolFecAnotacion(id, fecAnotacion)
                                        break
                                    }
                                    3 -> {
                                        print("Ingrese el id del gol a actualiazr")
                                        var id = scanner.nextLine().toInt()
                                        do {
                                            print(
                                                "1: Si\n" +
                                                        "2: No\n" +
                                                        "0: Salir\n" +
                                                        "Opcion: "
                                            )
                                            var opcionActualizarPenal = scanner.nextLine().toInt()
                                            if (opcionActualizarPenal == 1) {
                                                Goles.actualizarGolPenal(id, true)
                                                break
                                            } else if (opcionActualizarPenal == 2) {
                                                Goles.actualizarGolPenal(id, false)
                                                break
                                            } else {
                                                println("Ingrese la opcion correcta")
                                            }
                                        } while (opcionActualizarPenal != 0)
                                    }
                                    4 -> {
                                        print("Ingrese el id del gol a actualiazr")
                                        var id = scanner.nextLine().toInt()
                                        print("Ingrese el costo: ")
                                        var minuto = scanner.nextLine().toDouble()
                                        Goles.actualizarGolMinuto(id, minuto)
                                        break
                                    }
                                    5 -> {
                                        print("Ingrese el id del gol a actualiazr")
                                        var id = scanner.nextLine().toInt()
                                        print("Ingrese el idl futbolista: ")
                                        var idFutbolista = scanner.nextLine().toInt()
                                        Goles.actualizarGolIdFutbolista(id, idFutbolista)
                                        break
                                    }
                                    0 -> {

                                    }
                                    else -> {
                                        println("Ingrese la opcion correcta")
                                    }
                                }
                            } while (opcionActualizar != 0)
                        }
                        4 -> {
                            println("Ingrese el id del gol a eliminar")
                            var id = scanner.nextLine().toInt()
                            Goles.eliminarGol(id)
                            break
                        }
                        0 -> {

                        }
                        else -> {
                            println("Escoja la opción correcta")
                        }
                    }
                } while (opcionGol != 0)
            }
            0 -> {

            }
            else -> {
                println("Escoja la opción correcta")
            }
        }
    } while (opcionMenu != 0)
}

class Futbolistas(

    id: Int,
    nombre: String,
    fecNacimiento: Date,
    actividad: Boolean,
    proGPP: Double

) {

    var id: Int = id
    var nombre: String = nombre
    var fecNacimiento: Date = fecNacimiento
    var actividad: Boolean = actividad
    var proGPP: Double = proGPP

    init { }

    companion object {

        var listaFutbolistas = ArrayList<Futbolistas>()

        fun insertarFutbolista(nuevoFutbolista: Futbolistas) {

            listaFutbolistas.add(nuevoFutbolista)
            actualizarArchivoFutbolistas()
            mostrarFutbolistas(listaFutbolistas)

        }

        fun buscarFutbolistaId(id: Int): ArrayList<Futbolistas> {
            return listaFutbolistas.filter { it.id == id } as ArrayList<Futbolistas>
        }

        fun buscarFutbolistaNombre(nombre: String): ArrayList<Futbolistas> {
            return listaFutbolistas.filter { it.nombre == nombre } as ArrayList<Futbolistas>
        }

        fun buscarFutbolistaFecNacimiento(fecNacimiento: Date): ArrayList<Futbolistas> {
            return listaFutbolistas.filter { it.fecNacimiento == fecNacimiento } as ArrayList<Futbolistas>
        }

        fun buscarFutbolistaActividad(actividad: Boolean): ArrayList<Futbolistas> {
            return listaFutbolistas.filter { it.actividad == actividad } as ArrayList<Futbolistas>
        }

        fun buscarFutbolistaProGPP(proGPP: Double): ArrayList<Futbolistas> {
            return listaFutbolistas.filter { it.proGPP == proGPP } as ArrayList<Futbolistas>
        }

        fun actualizarFutbolistaNombre(id: Int, nombre: String) {
            listaFutbolistas.filter { it.id == id }.map { it.nombre = nombre }
            actualizarArchivoFutbolistas()
            mostrarFutbolistas(listaFutbolistas)
        }

        fun actualizarFutbolistaFecNacimiento(id: Int, fecNacimiento: Date) {
            listaFutbolistas.filter { it.id == id }.map { it.fecNacimiento = fecNacimiento }
            actualizarArchivoFutbolistas()
            mostrarFutbolistas(listaFutbolistas)
        }

        fun actualizarFutbolistaActividad(id: Int, actividad: Boolean) {
            listaFutbolistas.filter { it.id == id }.map { it.actividad = actividad }
            actualizarArchivoFutbolistas()
            mostrarFutbolistas(listaFutbolistas)
        }

        fun actualizarFutbolistaProGPP(id: Int, proGPP: Double) {
            listaFutbolistas.filter { it.id == id }.map { it.proGPP = proGPP }
            actualizarArchivoFutbolistas()
            mostrarFutbolistas(listaFutbolistas)
        }

        fun eliminarFutbolista(id: Int) {
            listaFutbolistas = listaFutbolistas.filter { it.id != id } as ArrayList<Futbolistas>
            actualizarArchivoFutbolistas()
            mostrarFutbolistas(listaFutbolistas)
        }

        fun mostrarFutbolistas(ArregloFutbolistas: ArrayList<Futbolistas>) {
            println("Id,Nombre,Fecha de nacimiento,Actividad,Promedio de goles por partido")
            ArregloFutbolistas.forEach { motoActual: Futbolistas ->
                println(
                    "${motoActual.id}," +
                            "${motoActual.nombre}," +
                            "${motoActual.fecNacimiento}," +
                            "${motoActual.actividad}," +
                            "${motoActual.proGPP}"
                )
            }
            println("")
        }

        fun actualizarArchivoFutbolistas() {
            val ruta = "src/futbolistas.csv"
            try {
                FileWriter(ruta, false).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            out.print("ID,Nombre,Fecha de nacimiento,Actividad,Promedio de goles por partido\n")
                        }
                    }
                }
            } catch (e: IOException) {
                //exception handling left as an exercise for the reader
            }
            try {
                FileWriter(ruta, true).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            //out.print(listaFutbolistas.forEach { futActual: Futbolistas -> "${futActual.id}" })
                            listaFutbolistas.forEach { futActual: Futbolistas -> out.print("${futActual.id},${futActual.nombre},${futActual.fecNacimiento},${futActual.actividad},${futActual.proGPP}\n") }
                        }
                    }
                }
            } catch (e: IOException) {
                //exception handling left as an exercise for the reader
            }
        }

        fun leerArchivoFutbolistas() {

            var miLector = Scanner(File("src/futbolistas.csv"))
            var cabecera = miLector.hasNextLine()
            var fila = miLector.nextLine()
            var datos = StringTokenizer(fila, ",")

            while (datos.hasMoreTokens()) {
                datos.nextToken()
            }

            while (miLector.hasNextLine()) {

                fila = miLector.nextLine()
                datos = StringTokenizer(fila, ",")

                while (datos.hasMoreTokens()) {

                    var id = datos.nextToken().toInt()
                    var nombre = datos.nextToken()
                    var fecNacimiento = datos.nextToken()
                    var actividad = datos.nextToken().toBoolean()
                    var proGPP = datos.nextToken().toDouble()
                    var miFutbolista = Futbolistas(id, nombre, Date(), actividad, proGPP)
                    listaFutbolistas.add(miFutbolista)

                }

            }

        }

    }

}

class Goles(

    id: Int,
    tipo: String,
    fecAnotacion: Date,
    penal: Boolean,
    minuto: Double,
    idFutbolista: Int

) {

    var id = id
    var tipo = tipo
    var fecAnotacion = fecAnotacion
    var penal = penal
    var minuto = minuto
    var idFutbolista = idFutbolista

    init { }

    companion object {

        var listaGoles = ArrayList<Goles>()

        fun insertarGol(nuevoGol: Goles) {
            listaGoles.add(nuevoGol)
            actualizarArchivoGoles()
            mostrarGoles(listaGoles)
        }

        fun buscarGolId(id: Int): ArrayList<Goles> {
            return listaGoles.filter { it.id == id } as ArrayList<Goles>
        }

        fun buscarGolTipo(tipo: String): ArrayList<Goles> {
            return listaGoles.filter { it.tipo == tipo } as ArrayList<Goles>
        }

        fun buscarGolFecAnotacion(fecAnotacion: Date): ArrayList<Goles> {
            return listaGoles.filter { it.fecAnotacion == fecAnotacion } as ArrayList<Goles>
        }

        fun buscarGolPenal(penal: Boolean): ArrayList<Goles> {
            return listaGoles.filter { it.penal == penal } as ArrayList<Goles>
        }

        fun buscarGolMinuto(minuto: Double): ArrayList<Goles> {
            return listaGoles.filter { it.minuto == minuto } as ArrayList<Goles>
        }

        fun buscarGolIdFutbolista(idFutbolista: Int): ArrayList<Goles> {
            return listaGoles.filter { it.idFutbolista == idFutbolista } as ArrayList<Goles>
        }

        fun actualizarGolTipo(id: Int, tipo: String) {
            listaGoles.filter { it.id == id }.map { it.tipo = tipo }
            actualizarArchivoGoles()
            mostrarGoles(listaGoles)
        }

        fun actualizarGolFecAnotacion(id: Int, fecAnotacion: Date) {
            listaGoles.filter { it.id == id }.map { it.fecAnotacion = fecAnotacion }
            actualizarArchivoGoles()
            mostrarGoles(listaGoles)
        }

        fun actualizarGolPenal(id: Int, penal: Boolean) {
            listaGoles.filter { it.id == id }.map { it.penal = penal }
            actualizarArchivoGoles()
            mostrarGoles(listaGoles)
        }

        fun actualizarGolMinuto(id: Int, minuto: Double) {
            listaGoles.filter { it.id == id }.map { it.minuto = minuto }
            actualizarArchivoGoles()
            mostrarGoles(listaGoles)
        }

        fun actualizarGolIdFutbolista(id: Int, idFutbolista: Int) {
            listaGoles.filter { it.id == id }.map { it.idFutbolista = idFutbolista }
            actualizarArchivoGoles()
            mostrarGoles(listaGoles)
        }

        fun eliminarGol(id: Int) {
            listaGoles = listaGoles.filter { it.id != id } as ArrayList<Goles>
            actualizarArchivoGoles()
            mostrarGoles(listaGoles)
        }

        fun mostrarGoles(arregloGoles: ArrayList<Goles>) {
            println("Id,Tipo,Fecha de anotacion,Penal,Minuto,Id Futbolista")
            arregloGoles.forEach { golActual: Goles ->
                println(
                    "${golActual.id}," +
                            "${golActual.tipo}," +
                            "${golActual.fecAnotacion}," +
                            "${golActual.penal}," +
                            "${golActual.minuto}," +
                            "${golActual.idFutbolista}"
                )
            }
            println("")
        }

        fun actualizarArchivoGoles() {
            val ruta = "src/goles.csv"
            try {
                FileWriter(ruta, false).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            out.print("Id,Tipo,Fecha de anotacion,Penal,Minuto,Id Futbolista\n")
                        }
                    }
                }
            } catch (e: IOException) {
                //exception handling left as an exercise for the reader
            }
            try {
                FileWriter(ruta, true).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            listaGoles.forEach { motoActual: Goles ->
                                out.print(
                                    "${motoActual.id},${motoActual.tipo},${motoActual.fecAnotacion}," +
                                            "${motoActual.penal},${motoActual.minuto},${motoActual.idFutbolista}\n"
                                )
                            }
                        }
                    }
                }
            } catch (e: IOException) {
                //exception handling left as an exercise for the reader
            }

        }

        fun leerArchivoGoles() {

            var miLector = Scanner(File("src/goles.csv"))
            var cabecera = miLector.hasNextLine()
            var fila = miLector.nextLine()
            var datos = StringTokenizer(fila, ",")

            while (datos.hasMoreTokens()) {
                datos.nextToken()
            }

            while (miLector.hasNextLine()) {

                fila = miLector.nextLine()
                datos = StringTokenizer(fila, ",")
                while (datos.hasMoreTokens()) {

                    var id = datos.nextToken().toInt()
                    var tipo = datos.nextToken()
                    var fecAnotacion = datos.nextToken()
                    var penal = datos.nextToken().toBoolean()
                    var minuto = datos.nextToken().toDouble()
                    var idFutbolista = datos.nextToken().toInt()
                    var miGol = Goles(id, tipo, Date(), penal, minuto, idFutbolista)
                    listaGoles.add(miGol)

                }

            }

        }

    }

}