package CommandProvider.Commands

import Products.Product
import java.time.LocalDateTime
import java.util.*

/**
 * Объект, представляющий команду для вывода информации о коллекции продуктов.
 */
object Info {

    /**
     * Команда вывода информации о коллекции продуктов.
     *
     * @param collection Коллекция объектов типа TreeMap, где ключ типа Int и значение типа Product.
     */
    fun InfoCommand(collection: TreeMap<Int, Product>) {
        val size = collection.size
        println("Размер коллекции: $size")

        if (size > 0) {
            var maxDate: LocalDateTime? = null
            for (sp in collection.values) {
                if (maxDate == null || maxDate.isBefore(sp.date)) {
                    maxDate = sp.date
                }
            }
            println("Дата последнего изменения коллекции: $maxDate")
        } else {
            println("Коллекция пуста, нет даты изменения.")
        }

        println("Кол-во элементов: $size")
    }
}
