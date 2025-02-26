package CommandProvider.Commands

import Products.Product
import java.util.*

/**
 * Объект `Clear` предоставляет метод для очистки коллекции продуктов.
 *
 * Этот объект содержит метод `clearCollection`, который очищает переданную коллекцию
 * и выводит сообщение о результате операции.
 *
 * @author Endate
 * @since 1.0
 */
object Clear {
    /**
     * Очищает переданную коллекцию продуктов.
     *
     * Если коллекция уже пуста, выводится сообщение о том, что коллекция и так пуста.
     * В противном случае коллекция очищается, и выводится сообщение об успешной очистке.
     *
     * @param collection Коллекция продуктов, представленная в виде `TreeMap<Int, Product>`.
     *                   Ключом является целое число, а значением — объект типа `Product`.
     *
     * @see Product
     * @see TreeMap
     */
    fun clearCollection(collection: TreeMap<Int, Product>) {
        if (collection.isEmpty()) {
            println("Коллекция и так пуста.")
        } else {
            collection.clear()
            println("Коллекция очищена.")
        }
    }
}