@file:Suppress("UNUSED_PARAMETER")

package lesson1.task1

import junit.framework.Assert.assertEquals
import org.junit.Test
import kotlin.math.*

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
    (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */
fun main() {
    //val result = sqr(8)
    //println("8 x 8 = $result")
    var seconds = seconds(8,20,35)
    println(seconds)
    var quadratticEquationRoot = quadraticEquationRoot(1.0,-3.0,2.0)
    println(quadratticEquationRoot)
    //angleInRadian(36,14,35)
    var lengthInMeters = lengthInMeters(8,2,11)
    println(lengthInMeters)
    var travelMinutes = travelMinutes(9,25,1,1)
    println(travelMinutes)
    var trackLength = trackLength(4.0,5.0,6.0,8.0)
    println(trackLength)
}

/**
 * Тривиальная
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int {
    var sec = hours * 3600 + minutes * 60 + seconds
    return sec
}

/**
 * Тривиальная
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double {
    var vershoksInMetrs = 0.04445
    val length = (sagenes * 48 + arshins * 16 + vershoks) * vershoksInMetrs
    return length
}

/**
 * Тривиальная
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
//fun degrees (deg: Int, min: Int, sec: Int) = deg + min / 60 + sec / 3600

fun angleInRadian(deg: Int, min: Int, sec: Int): Double {
    val degrees = deg + min / 60 + sec / 3600
    var radian = (PI * degrees) / 180
    return radian
} //= (PI * degrees(deg, min, sec)/180)

/**
 * Тривиальная
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    var trackLength = sqrt ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))
    return trackLength
}

/**
 * Простая
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int {
    var thirdDigit = number / 100
    if (thirdDigit > 10) {
        thirdDigit % 10
    } else {
    }
    return thirdDigit
}

/**
 * Простая
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int {
    var departInMinutes = hoursDepart * 60 + minutesDepart
    var arriveInMinutes = hoursArrive * 60 + minutesArrive
    var differenceInMinutes = arriveInMinutes - departInMinutes
    if (arriveInMinutes < departInMinutes) {
        differenceInMinutes = 1440 + (arriveInMinutes - departInMinutes)
    } else {
        differenceInMinutes = arriveInMinutes - departInMinutes
    }
    return differenceInMinutes
}
// с максимальной разницей в 23 часа 59 минут и переходом на следующие сутки
/**
 * Простая
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double {
    //var accountInOneYear = initial * percent + initial
    //var accountInTwoYear = accountInOneYear * percent + accountInOneYear
    //var accountInThreeYear = accountInTwoYear * percent + accountInTwoYear
    //return accountInThreeYear.toDouble()
    var percentInFirstYear = initial * percent * 0.01
    var percentInSecondYear = (initial + percentInFirstYear) * percent * 0.01
    var percentInThirdYear = (initial + percentInFirstYear + percentInSecondYear) * percent * 0.01
    var accountInThreeYear = initial + percentInFirstYear + percentInSecondYear + percentInThirdYear
    return accountInThreeYear
}

/**
 * Простая
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int {
    var digit = number
    var numRevert = digit downTo 1
    return numRevert
}
