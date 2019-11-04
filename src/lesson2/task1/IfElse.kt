@file:Suppress("Гао Цзяньфэн 3530901/90001")

package lesson2.task1

import lesson1.task1.discriminant
import kotlin.math.max
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    val y1 = age % 10
    when (age) {
        in 1..20 -> return when (age) {
            1 -> "$age год"
            2, 3, 4 -> "$age года"
            else -> "$age лет"
        }
        in 100..120 -> return when (age) {
            101 -> "$age год"
            102, 103, 104 -> "$age года"
            else -> "$age лет"
        }
        else -> return when (y1) {
            1 -> "$age год"
            2, 3, 4 -> "$age года"
            else -> "$age лет"
        }
    }
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(
    t1: Double, v1: Double,
    t2: Double, v2: Double,
    t3: Double, v3: Double
): Double {
    val s1 = t1 * v1
    val s2 = t2 * v2
    val s3 = t3 * v3
    val s = s1 + s2 + s3
    val sh = s / 2
    return if (sh <= s1)
        sh / v1
    else {
        if (sh <= s1 + s2)
            (sh - s1) / v2 + t1
        else (sh - s1 - s2) / v3 + t1 + t2
    }
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
): Int {
    when {
        kingX == rookX1 -> return when {
            kingX == rookX2 -> 3
            kingY == rookY2 -> 3
            else -> 1
        }
        kingY == rookY1 -> return when {
            kingX == rookX2 -> 3
            kingY == rookY2 -> 3
            else -> 1
        }
        else -> return when {
            kingX == rookX2 -> 2
            kingY == rookY2 -> 2
            else -> 0
        }
    }
}


/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(
    kingX: Int, kingY: Int,
    rookX: Int, rookY: Int,
    bishopX: Int, bishopY: Int
): Int {
    when {
        kingX - bishopX == kingY - bishopY -> return when {
            kingX == rookX -> 3
            kingY == rookY -> 3
            else -> 2
        }
        bishopX - kingX == kingY - bishopY -> return when {
            kingX == rookX -> 3
            kingY == rookY -> 3
            else -> 2
        }
        else -> return when {
            kingX == rookX -> 1
            kingY == rookY -> 1
            else -> 0
        }
    }
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 * 锐角 0 直角 1 钝角 2
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    val t: Double
    val y: Double
    val u: Double
    if (a >= b && a >= c) {
        if (b >= c) {
            t = a
            y = b
            u = c
        } else {
            t = a
            y = c
            u = b
        }
    } else if (b >= a && b >= c) {
        if (a >= c) {
            t = b
            y = a
            u = c
        } else {
            t = b
            y = c
            u = a
        }
    } else {
        if (a >= b) {
            t = c
            y = a
            u = b
        } else {
            t = c
            y = b
            u = a
        }
    }
    val e: Double = t * t - (y * y + u * u)
    return if (a + b >= c && a + c >= b && b + c >= a) {
        when {
            e < 0 -> 0
            e > 0 -> 2
            else -> 1
        }
    } else -1
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    return if (b >= d) {
        when {
            a > d -> -1
            a in c..d -> d - a
            else -> d - c
        }
    } else {
        when {
            c > b -> -1
            c in a..b -> b - c
            else -> b - a
        }
    }
}