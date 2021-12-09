import java.util.*

fun main() {

    println("Hola Mundo"); // ; -> No es requerido
    // Tipo nombre = valor;
    // Int edad = 12;

    //INMUTABLES
    val inmutable: String = "Adrian";
    // inmutable = "Vicente"; // X

    // MUTABLES (var)
    var mutable: String = "Vicente;"
    mutable = "Adrian";

    // val > var

    // Sintaxis Y Duck Typing

    val ejemploVariable = "Nombre;"
    var edadEjemplo: Int = 12;
    // edadEjemplo = 14.2;

    // Tipos de Variable JAVA

    val nombreProfesor: String = "Adrian Eguez";
    val sueldo: Double = 1.2;
    val estadoCivil: Char = 'S';
    val fechaNacimieto: Date = Date();

    // Condicionales

    if ( true ) {
        // Verdadero
    } else {
        // Falso
    }

    // Switch Estado -> S -> C -> !!!!!

    val estadoCivilWhen: String = "S"

    when ( estadoCivilWhen) {
        ( "S" ) -> {
            println( "Acercarse" )
        }
        ( "C" ) -> {
            println( "Alejarse" )
        }
        "UN" -> println( "Hablar" )
        else -> println( "No reconocido" )
    }
    val coqueteo = if( estadoCivilWhen == "S" ) "SI" else "NO"
    // Condicion ? bloque-true : bloque-false

    imprimirNombre( nombre = "Adrian" )

    // Named Parameters
    calcularSueldo(
        bonoEspecial = 15.00,
        //tasa = 12.00,
        sueldo = 150.00,
    )
    calcularSueldo(
        tasa = 14.00,
        bonoEspecial = 30.00,
        sueldo = 1000.00
    )

    // Tipos de Arreglos

    // Arreglo Estatico
    val arregloEstatico: Array<Int> = arrayOf(1,2,3)

    // Arreglo Dinamico
    val arregloDinamico:ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9,10)
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    // OPERADORES

    // FOR EACH -> Unit
    // Iterar un Arreglo

    val respuestaForEach: Unit = arregloDinamico
        .forEach{ valorActual: Int ->
            println("Valor actual: ${valorActual}" )
        }
    arregloDinamico
        .forEachIndexed { indice: Int, valorActual: Int ->
            println("Valor ${valorActual} Indice: ${indice}")
        }
    println(respuestaForEach)

    // MAP -> mUTA EL ARREGLO (cMABIA EL ARREGLO)
    // 1) eNVIAMOS EL NUEVO VALOR DE LA ITERACION
    // 2) Nos devuelve es un NUEVO AREEGLO con los valores modificados

    val respuestaMap: List<Double> = arregloDinamico
        .map { valorActual: Int ->
            return@map valorActual.toDouble() + 100.00
        }

    println( respuestaMap )

    val respuestaMapDos = arregloDinamico.map { it + 15 }
        //.map { valorActual: int ->
        //    return@map valorActual + 15
        //}

    println( respuestaMapDos )

    // Filter -> Filtrar el arreglo
    // 1) Devolver una expresion (True o False)
    // 2) Nuevo arreglo filtrado
    val respuestaFilter: List<Int> = arregloDinamico
        .filter { valorActual: Int ->
            val mayoresACinco : Boolean = valorActual > 5   //Expresion condicion
            return@filter mayoresACinco
        }
    val respuestaFilterDos = arregloDinamico.filter { it <= 5 }
    println( respuestaFilter )
    println( respuestaFilterDos )

    // Or And
    // Or -> Any (Alguno cumple?)
    // And -> All (Todos cumplen)

    val respuestaAny: Boolean = arregloDinamico
        .any {valorActual: Int ->
            return@any ( valorActual > 5 )
        }
    println( respuestaAny ) // True

    val respuestaAll: Boolean = arregloDinamico
        .all { valorActual: Int ->
            return@all ( valorActual > 5 )
        }
    println( respuestaAll ) // False

    // Reduce -> Valor acumulado
    // Valor acumulado = 0 (Siempre 0 en el lenguaje Kotlin)
    // [1, 2, 3, 4, 5] -> Sumemos todos los valores del arreglo
    // valorIteracion1 = valorEmpieza + 1 = 0 + 1 = 1 -> Iteracion 1
    // valorIteracion2 = valorIteracion1 + 2 = 1 + 2 = 3 -> Iteracion 2
    // valorIteracion3 = valorIteracion2 + 3 = 3 + 3 = 6 -> Iteracion 3
    // valorIteracion4 = valorIteracion3 + 4 = 6 + 4 = 10 -> Iteracion 4
    // valorIteracion5 = valorIteracion4 + 5 = 10 + 5 = 15 -> Iteracion 5

    val respuestaReduce: Int = arregloDinamico
        .reduce {
                acumulado: Int, valorActual: Int ->
            return@reduce ( acumulado + valorActual )   // -> Logica negocio
        }
    println( respuestaReduce )

    // 100
    // [12, 15, 8, 10]
    val arregloDanio = arrayListOf<Int>(12, 15, 8, 10)
    val respuestaReduceFold = arregloDanio
        .fold(
            initial = 100,
            {
                acumulado, valorActualIteracion ->
                return@fold acumulado - valorActualIteracion
            }
        )
    println( respuestaReduceFold )

    val vidaActual: Double = arregloDinamico
        .map { it * 2.3 }   // Arreglo
        .filter { it > 20 } // Arreglo
        .fold(initial = 100.00, { acc, i -> acc - i })  // Valor
        .also { println( it ) } // Ejecutar codigo extra
    println( "Valor vida actual ${vidaActual}" )    //  3.4


}

// void imprimirnombre (String nombre)
fun imprimirNombre ( nombre: String ):  Unit { // Unit es el void, y es opcional
    println( "Nombre: ${nombre}" )
}

fun calcularSueldo (
    sueldo: Double, // Requerido
    tasa: Double = 12.00, // Opcional (Defecto)
    bonoEspecial: Double? = null // Opcional (Null) -> nullable
): Double {
    if ( bonoEspecial == null ) {
        return sueldo * ( 100/tasa )
    } else {
        return sueldo * (100/tasa) + bonoEspecial
    }
}

abstract class NumerosJava {
    protected  val numeroUno: Int   //propiedad clase
    private  val numeroDos: Int //Propiedad clase
    constructor(
        uno: Int,   //Parametros requeridos
        dos: Int    //Parametros requeridos
    ) {
        //this.numeroUno = uno
        //this.numeroDos = dos
        numeroUno = uno
        numeroDos = dos
        println( "Inicializar" )
    }
}

abstract class Numeros (
    // Constructor primario
    protected  val numeroUno: Int   //propiedad clase
    protected  val numeroDos: Int //Propiedad clase
) {
    init {  // Bloque inicio del constructor primario
        println( "Inicializar" )
    }
}
// instancia.numeroUno
// instancia.numeroDos

class Suma(
    // Constructor primario
    uno: Int,   // Parametro requerido
    dos: Int    // Parametro requerido
) : Numeros(    // Constructor "papa" (super)
    uno,
    dos
) {
    init {  // Es el bloque de codigo del constructor primario
        this.numeroUno
        this.numeroDos
        // X -> this.uno -> NO EXISTEN
        // X -> this,dos -> NO EXISTEN
    }
    // public fun sumar(): Int {
    fun sumar(): Int {
        // val total: Int = this.numeroUno + this.numeroDos
        val total: Int = numeroUno + numeroDos
        return total
    }
}
