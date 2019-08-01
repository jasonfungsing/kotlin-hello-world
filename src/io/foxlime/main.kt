package io.foxlime

import java.lang.NumberFormatException
import java.util.*

fun main(args: Array<String>) {
    println("Hello, World")

    var q = Question()
    val immutableQ = Question()

    q.Answer = "30"
    immutableQ.Answer = "40"

    q.display()
    println("The answer to the question ${q.Question} is ${q.Answer}")

    val messge = if (q.Answer == q.ConnectAnswer) {
        "You were connect"
    } else {
        "Try again?"
    }

    println(messge)

    var nullableq: Question? = Question()
//    nullableq.Answer // this will fail at compile time as the nullableq can be null
    nullableq?.Answer = "42"

    q.printResult()

    // try catch
    val number: Int? = try {
        Integer.parseInt(q.Answer)
    } catch (e: NumberFormatException) {
        null
    }

    println("Number is $number")

    //for loop
    for (i in 1..10) { // include 10
        println(i)
    }

    for (i in 1 until 10) { // exclude 10
        println(i)
    }

    for (i in 10 downTo 1 step 2) {
        println(i)
    }

    var ages = TreeMap<String, Int>()
    ages["Jason"] = 18
    ages["Mike"] = 80

    for ((name, age) in ages) {
        println("$name is $age")
    }

    val numbers = listOf(1, 2, 3, 4, 5)

    for ((index, element) in numbers.withIndex()) {
        println("$element at $index")
    }

    var range = 'a'..'z' //range in kotlin is very powerful
}

class Question {

    var Answer: String = "" // any value in kotlin by default can not be null
    var NullableAnswer: String? = null // to tell compiler, I want this variable can be null
    var ConnectAnswer = "50"
    val Question: String = "What is the answer to life"

    fun display() {
        println("You said $Answer")
    }

    fun printResult() { // when
        when (Answer) {
            ConnectAnswer -> print("correct")
            else -> print("try again?")
        }
    }
}