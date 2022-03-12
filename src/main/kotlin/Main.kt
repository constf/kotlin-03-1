package ru.netology.kotlin031

const val JUST_NOW = 60
const val HOUR_VERGE = 60 * 60
const val DAY_VERGE = 24 * 60 * 60
const val TODAY = DAY_VERGE * 2
const val YESTERDAY = DAY_VERGE * 3
const val LONG_AGO = DAY_VERGE * 3

const val STR_JUSTNOW = "только что"
const val STR_TODAY = "сегодня"
const val STR_YESTERDAY = "вчера"
const val STR_LONGAGO = "давно"


fun main() {
    println("Программа Только-Что: Определение словесного описания времени прошедшего после события, по секундам.")

    while (true) {
        print("Введите количество секунд после события или end для выхода: ")
        val userInput = readLine()
        if (userInput == "end")
            break

        var secondsInput: Int = 0

        try {
            secondsInput = userInput?.toInt()!!
        } catch (e: Exception) {
            println("Прошу вести целое число или end!")
            continue
        }
        if (secondsInput < 0) {
            println("Прошу вести целое число больше 0 или end!")
            continue
        }

        val stringWord: String = when {
            secondsInput!! <= JUST_NOW -> STR_JUSTNOW
            secondsInput!! <= HOUR_VERGE -> getMinutesString(secondsInput)
            secondsInput!! <= DAY_VERGE -> getHoursString(secondsInput)
            secondsInput!! <= TODAY -> STR_TODAY
            secondsInput!! <= YESTERDAY -> STR_YESTERDAY
            secondsInput!! > LONG_AGO -> STR_LONGAGO
            else -> STR_LONGAGO
        }

        println("Пользователь был в сети $stringWord \n\n")
    }
}


fun getMinutesString(seconds: Int): String {
    val minutes: Int = seconds / 60

    val wordOut: String = when {
        minutes in 5..20 -> "минут"
        minutes % 10 == 1 -> "минуту"
        minutes % 10 in 2..4 -> "минуты"
        else -> "минут"
    }

    return "$minutes $wordOut назад"
}


fun getHoursString(seconds: Int): String {
    val hours: Int = seconds / 3600

    val wordOut: String = when {
        hours in 5..20 -> "часов"
        hours % 10 == 1 -> "час"
        hours % 10 in 2..4 -> "часа"
        else -> "часов"
    }

    return "$hours $wordOut назад"
}
