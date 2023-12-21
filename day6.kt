package com.victormrequena.day6

fun main() {
    val input = """Time:        52     94     75     94
Distance:   426   1374   1279   1216"""
    val numbersRegex = Regex("\\d+")
    val timesList = input.lines().take(1)
        .flatMap { line ->
            numbersRegex.findAll(line)
                .map {
                    it.value.toInt()
                }
        }
    val distancesList = input.lines().drop(1)
        .flatMap { line ->
            numbersRegex.findAll(line)
                .map {
                    it.value.toInt()
                }
        }
    val result = timesList.zip(distancesList)
        .map { pair ->
            (1..pair.first).count {
                it * (pair.first - it) > pair.second
            }
        }
        .reduce { a, b -> a * b}

    println(result)

    val time = input.lines().take(1)
        .map { line ->
            numbersRegex.findAll(line)
                .map { it.value }
                .reduce { a, b -> a + b }
                .toLong()
        }.first()
    val distance = input.lines().drop(1)
        .map { line ->
            numbersRegex.findAll(line)
                .map { it.value }
                .reduce { a, b -> a + b }
                .toLong()
        }.first()
    println(time)
    println(distance)

    val result2 = (1..time)
        .count {
            it * (time - it) > distance
        }
    println(result2)
}
