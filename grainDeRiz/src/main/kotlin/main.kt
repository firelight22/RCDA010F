import java.math.BigInteger

fun main() {
    var nbGrzRiz = BigInteger.ONE
    var totalGrRiz = nbGrzRiz
    for (case in 2..64){
        nbGrzRiz = nbGrzRiz.multiply(BigInteger.TWO)
        println("$nbGrzRiz")
        totalGrRiz += nbGrzRiz
    }
    println("Le nombre de grain de riz sur l'échiquier est de $totalGrRiz")
}