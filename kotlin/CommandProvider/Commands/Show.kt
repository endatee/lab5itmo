package CommandProvider.Commands

import Products.Product
import java.util.*

/**
 * Объект, представляющий команду для отображения содержимого коллекции продуктов.
 */
object Show {

    /**
     * Выводит на экран все элементы коллекции продуктов.
     *
     * @param collection Коллекция объектов типа TreeMap, где ключ типа Int и значение типа Product.
     */
    fun ShowCommand(collection: TreeMap<Int, Product>) {
        for ((key, value) in collection) {
            println("Key: $key")
            println("Value: $value")
            println()
        }
    }
}
