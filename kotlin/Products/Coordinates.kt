package Products

import Products.JustScanner.Scan
import java.io.Serializable

/**
 * Класс Coordinates представляет собой пару координат x и y.
 * Позволяет инициализировать значения по умолчанию через пользовательский ввод,
 * если не установлен флаг ignoreInit. Класс сериализуемый.
 */
class Coordinates(private val ignoreInit: Boolean = false) : Serializable {
    private var x = 0
    private var y = 0.0

    /**
     * Инициализирует координаты через пользовательский ввод, если ignoreInit не установлен.
     * Пользователю предлагается ввести значения, которые удовлетворяют следующим условиям:
     * x > -771 и y < 770.
     */
    init {
        if (!ignoreInit) {
            while (true) {
                try {
                    print("Введите (Long)x>-771: ")
                    val xInput = Scan().toLong()
                    if (xInput > -771) {
                        x = xInput.toInt()
                        break
                    } else {
                        println("Число должно быть больше -771!")
                    }
                } catch (e: NumberFormatException) {
                    println("Надо ввести значение Long!")
                }
            }
            while (true) {
                try {
                    print("Введите (double)y<770: ")
                    val yInput = Scan().toDouble()
                    if (yInput < 770) {
                        y = yInput
                        break
                    } else {
                        println("Число должно быть меньше 770!")
                    }
                } catch (e: NumberFormatException) {
                    println("Надо ввести значение double!")
                }
            }
        }
    }

    /**
     * Возвращает строковое представление координат.
     *
     * @return строка вида "x: значение, y: значение".
     */
    override fun toString(): String {
        return ("x: $x, y: $y")
    }

    /**
     * Устанавливает значение координаты x.
     *
     * @param x новое значение для x.
     */
    fun setX(x: Int) {
        this.x = x
    }

    /*
     * Устанавливает значение координаты y.
     *
     * @param y новое значение для y.
     */
    fun setY(y: Double) {
        this.y = y
    }
}
