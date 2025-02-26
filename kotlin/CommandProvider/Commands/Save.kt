package CommandProvider.Commands

import Products.JustScanner.Scan
import Products.Product
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.util.*

/**
 * Объект, представляющий команду для сохранения коллекции продуктов в файл.
 */
object Save {

    /**
     * Сохраняет коллекцию продуктов в CSV-файл.
     *
     * @param collection Коллекция объектов типа TreeMap, где ключ типа Int и значение типа Product.
     * @param fileName Имя файла, в который будет сохранена коллекция.
     * @return Имя файла, в который была сохранена коллекция.
     */
    fun SaveCommand(collection: TreeMap<Int, Product>, fileName: String): String {
        var processedFileName = fileName.replace(" ".toRegex(), "").replace("\\.".toRegex(), "")

        if (processedFileName == "") {
            processedFileName = "data"
        }

        processedFileName += ".csv"

        try {
            BufferedWriter(FileWriter(processedFileName)).use { writer ->
                for ((key, marine) in collection) {
                    writer.write(key.toString() + "," + productToCSV(marine))
                    writer.newLine()
                }
            }
            println("Успешно сохранено!")
        } catch (e: IOException) {
            println("Ошибка при сохранении в файл: " + e.message)
        }

        return processedFileName
    }


    /**
     * Преобразует объект Product к строке формата CSV.
     *
     * @param product Объект типа Product для преобразования.
     * @return Строка, представляющая продукт в формате CSV.
     */
    private fun productToCSV(product: Product): String {
        return "Имя: " + product.retrieveName() +
                ", Id: " + product.retrieveId() +
                ", Координаты: " + product.getCoordinate() +
                ", Время создания: " + product.getLocalDateTime() +
                ", Измерение: " + product.getUniteOfMeasure() +
                ", Организация " + product.retrieveOrganization()
    }
}
