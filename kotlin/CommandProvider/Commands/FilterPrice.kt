import Products.Product
import java.util.*

/**
 * Объект `FilterPrice` предоставляет функциональность для фильтрации коллекции продуктов по цене.
 *
 * Этот объект содержит метод `filterByPrice`, который фильтрует продукты в коллекции,
 * выводя только те, цена которых больше заданного значения.
 *
 * @author Endatee
 * @since 1.0
 */
object FilterPrice {
    /**
     * Фильтрует коллекцию продуктов по цене.
     *
     * Метод принимает коллекцию продуктов и ключ (цену), и выводит все продукты,
     * цена которых больше указанного значения. Если коллекция пуста или ключ равен `null`,
     * выводится соответствующее сообщение.
     *
     * @param collection Коллекция продуктов, представленная в виде `TreeMap<Int, Product>`.
     *                   Ключом является целое число, а значением — объект типа `Product`.
     * @param key Цена, по которой производится фильтрация. Если `null`, фильтрация не выполняется.
     *
     * @see Product
     * @see TreeMap
     */
    fun filterByPrice(collection: TreeMap<Int, Product>, key: Int?) {
        if (collection.isEmpty()) {
            println("Коллекция пуста.")
            return
        }

        if (key == null) {
            println("Ключ не может быть null.")
            return
        }

        var found = false
        for (product in collection.values) {
            val price = product.getPrice() // Убираем безопасный вызов
            if (key < price) {
                println(product)
                found = true
            }
        }

        if (!found) {
            println("Нет элементов, которые будут больше заданного price")
        }
    }
}