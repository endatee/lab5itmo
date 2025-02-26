package CommandProvider.Commands

import Products.Product
import java.util.*

/**
 * Объект, представляющий команду для удаления продукта из коллекции.
 */
object Remove {

    /**
     * Удаляет продукт из коллекции по заданному ключу.
     *
     * @param collection Коллекция объектов типа TreeMap, где ключ типа Int и значение типа Product.
     * @param key Ключ продукта, который необходимо удалить из коллекции.
     */
    fun removeCommand(collection: TreeMap<Int, Product>, key: Int) {
        if (collection.containsKey(key)) {
            collection.remove(key)
            println("Элемент с ключом $key удален.")
        } else {
            println("Элемент с ключом $key не найден.")
        }
    }
}
