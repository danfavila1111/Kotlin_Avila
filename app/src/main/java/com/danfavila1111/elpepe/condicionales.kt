package com.danfavila1111.elpepe

class condicionales {
}

fun main() {
    print("Ingrese el número 1: ")
    var num1: Int= readLine()!!.toInt()
    print("Ingrese el número 2: ")
    var num2: Int= readLine()!!.toInt()

    if(num1>num2){
        println("El número $num1 es mayor que $num2")
    }
    else if (num1==num2){
        println("El número $num1 es igual que $num2")
    }
    else{
        println("El número $num2 es mayor que $num1")
    }



    print("Ingrese un numero de 1 a 20: ")
    var num3: Int= readLine()!!.toInt()

    if(num3 in 1..20){
        print("$num3")
    }
    else{
        print("El número $num3 no está dentro del rango requerido")
    }

    var results : Int = (1..50).random() // Generación de números aleatorios
    println("El numero es $results")

    when (results) {
        0 -> println("no hay resultados")
        1,2,3,4,5 -> println("Hay menos de 5 resultados")
        in 6..50 -> println("Hay entre 5 y 50 resultados!")
        else -> println("esos son bastantes resultados!")
    }

}