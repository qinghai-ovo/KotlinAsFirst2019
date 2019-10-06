@file:Suppress("Гао Цзяньфэн 3530901/90001")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val a: Int = number / 1000
    val b: Int = (number - a * 1000) / 100
    val c: Int = (number - a * 1000 - b * 100) / 10
    val d: Int = (number - a * 1000 - b * 100 - c * 10)
    return when {
        a + b == c + d -> true
        else -> false
    }
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    return when{
        x1 - x2 == y1 - y2 -> true
        x2 - x1 == y1 - y2 -> true
        x1 == x2 -> true
        y1 == y2 -> true
        else -> false
    }
}

/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    if (month == 2) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) return 29
        else return 28
    } else return when(month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        else -> 30
    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    val d: Double = sqrt(sqr(x1 - x2) + sqr(y1 - y2))
    return when {
        d <= (r2 - r1) -> true
        else -> false
    }
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean{
    return when{
        a <= r && b <= s -> true
        a <= r && c <= s -> true
        a <= s && b <= r -> true
        a <= s && c <= r -> true
        b <= r && c <= s -> true
        b <= s && c <= r -> true
        else -> false
    }
}

