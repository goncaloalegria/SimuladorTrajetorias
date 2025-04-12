
import kotlin.math.*

fun equacaoX(veloInicial:Double,tempo:Double, anguloGraus: Double): Double {
    val anguloRad = anguloGraus * PI / 180
    val x : Double= tempo*(veloInicial* cos(anguloRad))
    return x
}

fun equacaoY(altInicial:Double,veloInicial:Double,tempo: Double, anguloGraus: Double): Double {
    val anguloRad = anguloGraus * PI / 180

    val y : Double=altInicial + tempo*(veloInicial* sin(anguloRad))-10*tempo.pow(2)
    return y
}


fun main() {

    var tempo = 0.0
    var repetir: String
    println()
    println("Bem-vindo ao Simulador de Trajétorias de Fundamentos de Física!\n\nSelecione a opção que desejar, conforme as varáveis que pretende introduzir.\n\n" +
            "1. Altura Inicial, Velocidade Inicial e Ângulo \n2. Tempo Total e Alcance " +
            "\n0. Sair")

    var opcaoMenu = readLine()?.toIntOrNull()
    while (opcaoMenu == null || opcaoMenu < 0 || opcaoMenu > 3) {
        println("Opção inválida. Por favor, tente novamente.")
        opcaoMenu = readLine()?.toIntOrNull()
    }
    if (opcaoMenu == 1) {
        do {
            println("Introduza a altura do gráfico:")
            var alturaGrafico = readLine()?.toIntOrNull()
            while (alturaGrafico == null || alturaGrafico < 0) {
                println("Altura invalida. Por favor, introduza novamente.")
                alturaGrafico = readLine()?.toIntOrNull()
            }
            println("Introduza a largura do gráfico:")
            var larguraGrafico = readLine()?.toIntOrNull()
            while (larguraGrafico == null || larguraGrafico < 0) {
                println("Largura invalida. Por favor, introduza novamente.")
                larguraGrafico = readLine()?.toIntOrNull()
            }
            println("Introduza a altura inicial (m):")
            var altInicial = readLine()?.toDoubleOrNull()
            while (altInicial == null || altInicial < 0) {
                println("Altura inválida. Por favor, introduza novamente.")
                altInicial = readLine()?.toDoubleOrNull()
            }
            println("Introduza a Velocidade Inicial (m/s):")
            var veloInicial = readLine()?.toDoubleOrNull()
            while (veloInicial == null || veloInicial < 0) {
                println("Velocidade invalida. Por favor, introduza novamente.")
                veloInicial = readLine()?.toDoubleOrNull()
            }
            println("Introduza o ângulo em graus (0-90):")
            var anguloGraus = readLine()?.toDoubleOrNull()
            while (anguloGraus == null || anguloGraus !in (0.0..90.0)) {
                println("Ângulo inválido. Por favor, introduza novamente.")
                anguloGraus = readLine()?.toDoubleOrNull()
            }
            val grafico = Chart(larguraGrafico, alturaGrafico)

            var y = 0.0

            while (y >= 0) {
                val x = equacaoX(veloInicial, tempo, anguloGraus)
                y = equacaoY(altInicial, veloInicial, tempo, anguloGraus)
                grafico.ponto(x, y)
                tempo += 0.001
            }
            println("\n\nTrajetória da bola:")

            grafico.draw()

            val anguloRad = anguloGraus * PI / 180
            val tempoVoo = ((veloInicial * sin(anguloRad)) + sqrt((veloInicial * sin(anguloRad)).pow(2) + 2 * 20 * altInicial)) / 20
            val deslocamentoX = (veloInicial * cos(anguloRad)) * tempoVoo
            println("Tempo (s)\tX (m)\t")
            println(String.format("%.2f\t\t%.2f", tempoVoo, deslocamentoX))

            println("\nDeseja repetir esta simulação? (Sim/Nao)")
            repetir = readLine() ?: ""
            while (repetir != "Sim" && repetir != "Nao") {
                println("Escolha inválida. Por favor, insira 'Sim' para utilizar o simulador novamente ou 'Nao' para sair.")
                repetir = readLine() ?: ""
            }

        } while (repetir == "Sim")

    } else if (opcaoMenu == 2) {
        do {
            println("Introduza a altura do gráfico:")
            var alturaGrafico = readLine()?.toIntOrNull()
            while (alturaGrafico == null || alturaGrafico < 0) {
                println("Altura invalida. Por favor, introduza novamente.")
                alturaGrafico = readLine()?.toIntOrNull()
            }
            println("Introduza a largura do gráfico:")
            var larguraGrafico = readLine()?.toIntOrNull()
            while (larguraGrafico == null || larguraGrafico < 0) {
                println("Largura invalida. Por favor, introduza novamente.")
                larguraGrafico = readLine()?.toIntOrNull()
            }
            println("Introduza o Tempo total de voo (s):")
            var tempoTVoo = readLine()?.toDoubleOrNull()
            while (tempoTVoo == null || tempoTVoo < 0) {
                println("Velocidade invalida. Por favor, introduza novamente.")
                tempoTVoo = readLine()?.toDoubleOrNull()
            }
            println("Introduza o alcance do lançamento (m):")
            var alcance = readLine()?.toDoubleOrNull()
            while (alcance == null || alcance <=0) {
                println("Ângulo inválido. Por favor, introduza novamente.")
                alcance = readLine()?.toDoubleOrNull()
            }
            val grafico = Chart(larguraGrafico, alturaGrafico)
            val veloInicialx :Double = alcance / tempoTVoo
            val veloInicialy :Double= (20 * tempoTVoo) / 2
            val veloInicial :Double= sqrt(veloInicialx.pow(2) + veloInicialy.pow(2))
            val anguloRad :Double= atan(veloInicialy/veloInicialx)
            val anguloGraus :Double= anguloRad / PI * 180
            val alturaMax :Double= veloInicialy.pow(2)/(2*20)

            while (tempo<=tempoTVoo) {
                val x = veloInicialx * tempo
                val y = veloInicialy * tempo - 0.5 * 20 * tempo.pow(2)
                    grafico.ponto(x, y)
                tempo+=0.001
            }

            println("\n\nTrajetória da bola:")
            grafico.draw()

            println("Velocidade Inicial (m/s)\tÂngulo (g)\tAltura Máxima(m)")
            println(String.format("\t%.2f\t\t\t\t\t%.2f\t\t\t\t%.2f", veloInicial, anguloGraus,alturaMax))

            println("\nDeseja repetir esta simulação? (Sim/Nao)")
            repetir = readLine() ?: ""
            while (repetir != "Sim" && repetir != "Nao") {
                println("Escolha inválida. Por favor, insira 'Sim' para utilizar o simulador novamente ou 'Nao' para sair.")
                repetir = readLine() ?: ""
            }
        } while (repetir == "Sim")
    }
    println("A sair...")
}

