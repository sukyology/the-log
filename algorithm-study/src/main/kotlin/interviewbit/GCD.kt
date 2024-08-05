package interviewbit

import kotlin.math.max
import kotlin.math.min

class GCD {
    tailrec fun euclidean(one: Int, two: Int): Int {
        val a = max(one, two)
        val b = min(one, two)
        if (b == 0) return a
        return euclidean(b, a % b)
    }

    fun cpFact(a: Int, b: Int) : Int {
        val gcd = euclidean(a, b)
        val answer = a / gcd
        return answer
    }
}