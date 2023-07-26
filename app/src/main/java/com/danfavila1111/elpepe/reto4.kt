package com.danfavila1111.elpepe

class reto4 {
    private var saldoDisponible: Double = 6500.0

    fun acceder(celular: String, clave: String) {
        var intentos = 3

        while (intentos > 0) {
            println("Ingrese su número de celular (10 dígitos numéricos):")
            val inputCelular: String = readLine()!!

            if (inputCelular.matches(Regex("\\d{10}"))) {
                println("Ingrese su clave de 4 dígitos:")
                val inputClave: String = readLine()!!

                if (inputClave.matches(Regex("\\d{4}"))) {
                    if (inputCelular == celular && inputClave == clave) {
                        println("¡Bienvenido a Nequi!")
                        return // Sale de la función si el acceso es exitoso
                    } else {
                        intentos--
                        if (intentos > 0) {
                            println("Los datos no son correctos. Cuenta con $intentos intentos más.")
                        } else {
                            println("Los datos ingresados no son correctos. Ya no tienes intentos.")
                        }
                    }
                } else {
                    println("La clave debe tener exactamente 4 dígitos numéricos.")
                }
            } else {
                println("El número de celular debe tener exactamente 10 dígitos numéricos.")
            }
        }
    }

    fun mostrarSaldo() {
        println("Su saldo es: $saldoDisponible")
    }

    fun sacar() {
        println("Elige una opción para sacar dinero:")
        println("1. Cajero")
        println("2. Punto físico")

        val opcion: Int = readLine()!!.toInt()

        if (saldoDisponible < 2000) {
            println("No te alcanza para hacer el retiro.")
        } else {
            println("Ingrese el monto a retirar:")
            val monto: Int = readLine()!!.toInt()

            if (monto <= saldoDisponible) {
                println("Confirmar retiro de $monto:")
                val confirmacion: Int = readLine()!!.toInt()

                if (confirmacion == 1) {
                    saldoDisponible -= monto
                    val codigoRetiro = (100000..999999).random()
                    println("Retiro exitoso. Código de retiro: $codigoRetiro")
                } else {
                    println("Retiro cancelado.")
                }
            } else {
                println("Saldo insuficiente para realizar el retiro.")
            }
        }
    }

    fun enviar() {
        println("Ingrese el número de teléfono al que desea enviar dinero:")
        val numeroTelefono: String = readLine()!!

        if (numeroTelefono.matches(Regex("\\d{10}"))) {
            println("Ingrese el valor a enviar:")
            val valorEnviar: Double = readLine()!!.toDouble()

            if (valorEnviar <= saldoDisponible) {
                saldoDisponible -= valorEnviar
                println("Envío de dinero exitoso a $numeroTelefono por valor de $valorEnviar")
            } else {
                println("No es posible enviar el dinero. Saldo insuficiente.")
            }
        } else {
            println("El número de celular debe tener exactamente 10 dígitos numéricos.")
        }
    }

    fun recargar() {
        println("Ingrese el valor a recargar:")
        val valorRecarga: Double = readLine()!!.toDouble()

        println("¿Desea realizar la recarga por valor de $valorRecarga? (si/no)")
        val confirmacion: String = readLine()!!

        if (confirmacion.equals("si", ignoreCase = true)) {
            saldoDisponible += valorRecarga
            println("Recarga exitosa. Nuevo saldo: $saldoDisponible")
        } else {
            println("Recarga cancelada.")
        }
    }
}

fun main() {
    val celular = "3052823381"
    val clave = "9876"
    val nequi = reto4()
    nequi.acceder(celular, clave)

    var continuar = true

    while (continuar) {
        println("¿Qué acción desea realizar?")
        println("1. Mostrar saldo")
        println("2. Sacar dinero")
        println("3. Enviar dinero")
        println("4. Recargar")
        println("5. Salir")

        val opcion: Int = readLine()!!.toInt()

        when (opcion) {
            1 -> nequi.mostrarSaldo()
            2 -> nequi.sacar()
            3 -> nequi.enviar()
            4 -> nequi.recargar()
            5 -> {
                println("Saliendo de Nequi...")
                continuar = false
            }
            else -> println("Opción inválida. Intente de nuevo.")
        }
    }
}
