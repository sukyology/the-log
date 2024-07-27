package leetcode.july

class MinimumCostToConvertString {

    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {



    }






}

fun createConvertCostMap() = mutableMapOf<FromChar, Destinations>()
fun createReverseCostMap() = mutableMapOf<ToChar, MutableMap<FromChar, Int>>()

val convertCostMap = createConvertCostMap()
val reverseCostMap = createReverseCostMap()

typealias FromChar = Char
typealias ToChar = Char
typealias Destinations = MutableMap<ToChar, Int>
typealias ConvertCostMap = MutableMap<FromChar, Destinations>

fun ConvertCostMap.insert(from: Char, to: Char, cost : Int) {
    val destinations = this[from]
    if (destinations == null) {
        this[from] = mutableMapOf(to to cost)
        return expand(from, to, cost)
    }
    val existingCost = destinations[to] ?: 0
    destinations[to] = minOfNonZero(existingCost, cost)
}

fun ConvertCostMap.expand(from: Char, to: Char, cost: Int) {
    val newFrom = to
    val newTos = this[newFrom] ?: return

    newTos.forEach { (newTo, cost) ->
        val existing = this[from]!![newTo] ?: 0
        val newCost = minOfNonZero(existing, cost)
        this[from]!![newTo] = newCost
        return this.expand(newFrom, newTo, newCost)
    }
}

fun minOfNonZero(a: Int, b: Int) : Int {
    if (a==0 && b == 0)
        throw Error("both cannot be zero")
    if (a == 0)
        return b
    if (b == 0)
        return a
    return minOf(a,b)
}

/**
 * map의 확장 방식이 순서에 영향을 받는가?
 *
 * a -> e 와 e -> z
 *
 * 어떻게 확장할까?
 * e -> z 로 확장할 때
 * a -> z 가 생겨야함.
 * e로 도착하는 방법을 찾아서 a -> z 연결 필요
 *
 * 반대의 경우
 * e -> z 와 a -> e
 *  a-> z가 생겨야 할 때
 *  e 에서 확장가능한 영역들을 찾아야함 (시작점이 e인
 *
 */