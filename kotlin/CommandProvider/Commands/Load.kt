package CommandProvider.Commands

import Data.DataProvider
import Products.Product
import java.util.*
import Products.Coordinates
import Products.Organization
import java.time.LocalDateTime

object Load {
    fun LoadCollection(fileName: String, dp: DataProvider, collection: TreeMap<Int, Product>) {
        val lines = dp.LoadScript(fileName)

        for (line in lines) {
            try {
                val data = line.removeSurrounding("[", "]").split(",")
                if (data.size != 9) {
                    println("Ошибка: Некорректное количество данных в строке: $line")
                    continue
                }

                val key = data[0].trim().toInt()
                val x = data[1].trim().toInt()
                val y = data[2].trim().toDouble()
                val organizationName = data[3].trim()
                val employeesCount = data[4].trim().toInt()
                val numberOfOrganization = data[5].trim().toInt()
                val productName = data[6].trim()
                val unitOfMeasure = data[7].trim().toInt()
                val price = data[8].trim().toInt()

                if (numberOfOrganization !in 1..3) {
                    println("Ошибка: Некорректное значение NumberOfOrganization в строке: $line")
                    continue
                }
                if (unitOfMeasure !in 1..4) {
                    println("Ошибка: Некорректное значение UnitOfMeasure в строке: $line")
                    continue
                }

                // Создаем объект Coordinates
                val coordinates = Coordinates(ignoreInit = true).apply {
                    setX(x)
                    setY(y)
                }

                // Создаем объект Organization
                val organization = Organization().apply {
                    putName(organizationName)
                    setEmployeesCount(employeesCount) // Исправлено: передаем employeesCount
                    setId()
                    setOrganizationType(numberOfOrganization)
                }

                // Создаем объект Product
                val product = Product(ignoreInit = true).apply {
                    setId()
                    setPrice(price)
                    putName(productName)
                    putOrganization(organization)
                    putCoordinate(coordinates)
                    putUnitOfMeasureType(unitOfMeasure)
                    putDate(LocalDateTime.now()) // Исправлено: убрано указание типа
                }

                // Добавляем продукт в коллекцию
                collection[key] = product

            } catch (e: NumberFormatException) {
                println("Ошибка: Некорректный формат числа в строке: $line")
            } catch (e: Exception) {
                println("Ошибка при обработке строки: $line")
                e.printStackTrace()
            }
        }
    }
}