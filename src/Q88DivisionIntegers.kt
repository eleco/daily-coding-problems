//Implement division of two positive integers without using the division, multiplication, or modulus operators.
// Return the quotient as an integer, ignoring the remainder.

object Q88DivisionIntegers {
    @JvmStatic
    fun main(args: Array<String>) {
        divide(35, 7)
        divide(35, 6)
    }

    fun divide(divisor: Int, dividend: Int) {
        var quotient = 0;

        var tmpDivisor = divisor

        while (tmpDivisor >= dividend) {
            tmpDivisor -= dividend;
            quotient++;
        }
        val remainder = divisor - (quotient * dividend);
        println("divisor $divisor dividend $dividend quotient $quotient remainder $remainder")
    }
}