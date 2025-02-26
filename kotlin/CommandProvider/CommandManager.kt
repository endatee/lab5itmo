package CommandProvider

import CommandProvider.Commands.*
import Data.DataProvider
import FilterPrice
import FilterUnit
import Products.JustScanner
import Products.JustScanner.Scan
import Products.Product
import java.util.*
import Products.UnitOfMeasure


/**
 * Класс CommandManager управляет выполнением команд, введенных пользователем.
 * Он взаимодействует с коллекцией продуктов и выполняет различные операции в зависимости от введенной команды.
 */
class CommandManager {
    private val dp = DataProvider() // Провайдер данных
    private val collection = TreeMap<Int, Product>() // Коллекция продуктов, отсортированная по ключу

    /**
     * Метод CommandChecker анализирует введенную пользователем строку и выполняет соответствующую команду.
     *
     * @param userString Введенная пользователем строка, содержащая команду и, возможно, дополнительные аргументы.
     */
    fun CommandChecker(userString: String) {
        val trimmedString = userString.trim() // Удаление лишних пробелов в начале и конце строки
        if (trimmedString.isEmpty()) {
            println("Ошибка: Введена пустая строка. Пожалуйста, введите команду.")
            return
        }

        // Разделение строки на слова по пробелам
        val commandToWords = trimmedString.split("\\s+".toRegex()).toTypedArray()
        val command = commandToWords[0] // Первое слово - это команда

        // Обработка команды "help"
        if (command == "help" && commandToWords.size == 1) {
            Help.HelpCommand()
        }

        // Обработка команды "insert"
        else if (command == "insert" && commandToWords.size == 1) {
            while (true) {
                print("Введите key: ")
                val key = Scan()
                try {
                    val intKey = key.toInt()

                    if (collection.contains(intKey)) {
                        println("Элемент с таким key уже существует. Попробуйте снова.")
                    } else {
                        Insert.InsertCommand(collection, intKey)
                        break
                    }
                } catch (e: NumberFormatException) {
                    println("Надо ввести int!")
                }
            }
        }

        // Обработка команды "updateid"
        else if (command == "updateid" && commandToWords.size == 1) {
            while (true) {
                print("Введите key, который хотите изменить ")
                val key = Scan()
                try {
                    Updateid.UpdateCommand(collection, key.toInt())
                    break
                } catch (e: NumberFormatException) {
                    println("Надо ввести int! ")
                }
            }
        }

        // Обработка команды "show"
        else if (command == "show" && commandToWords.size == 1) {
            Show.ShowCommand(collection)
        }

        // Обработка команды "remove"
        else if (command == "remove" && commandToWords.size == 1) {
            while (true) {
                print("Введите key ")
                val key = Scan()
                try {
                    Remove.removeCommand(collection, key.toInt())
                    break
                } catch (e: NumberFormatException) {
                    println("Надо ввести int!")
                }
            }
        }

        // Обработка команды "clear"
        else if (command == "clear" && commandToWords.size == 1) {
            Clear.clearCollection(collection)
        }

        // Обработка команды "info"
        else if (command == "info" && commandToWords.size == 1) {
            Info.InfoCommand(collection)
        }

        // Обработка команды "remove_greater"
        else if (command == "remove_greater" && commandToWords.size == 1) {
            while (true) {
                print("Введите key, выше которого нужно удалить ")
                val key = Scan()
                try {
                    RemoveGreater.removeGreaterByKey(collection, key.toInt())
                    break
                } catch (e: NumberFormatException) {
                    println("Надо ввести int!")
                }
            }
        }

        // Обработка команды "remove_lower"
        else if (command == "remove_lower" && commandToWords.size == 1) {
            while (true) {
                print("Введите key, ниже которого нужно удалить ")
                val key = Scan()
                try {
                    RemoveLower.removeLowerByKey(collection, key.toInt())
                    break
                } catch (e: NumberFormatException) {
                    println("Надо ввести int!")
                }
            }
        }

        // Обработка команды "exit"
        else if (command == "exit" && commandToWords.size == 1) {
            Exit.exitCommand()
        }

        // Обработка команды "filterByUnitOfMeasure"
        else if (command == "filterByUnitOfMeasure" && commandToWords.size == 1) {
            while (true) {
                println("Введите номер UnitOfMeasure, чтобы вывести все элементы с ним")
                println("1 - METERS\n2 - SQUARE_METERS\n3 - GRAMS\n4 - MILLIGRAMS")
                try {
                    val Unit = JustScanner.Scan().toInt()
                    if (Unit < 1 || Unit > 4) {
                        println("Вы указали неправильный номер! Проверьте и введите еще раз")
                    } else {
                        when (Unit) {
                            1 -> FilterUnit.filterByUnitOfMeasure(collection, UnitOfMeasure.METERS)
                            2 -> FilterUnit.filterByUnitOfMeasure(collection, UnitOfMeasure.SQUARE_METERS)
                            3 -> FilterUnit.filterByUnitOfMeasure(collection, UnitOfMeasure.GRAMS)
                            4 -> FilterUnit.filterByUnitOfMeasure(collection, UnitOfMeasure.MILLIGRAMS)
                        }
                        break
                    }
                } catch (e: NumberFormatException) {
                    println("Надо ввести int!")
                }
            }
        }

        // Обработка команды "filterGreaterThanPrice"
        else if (command == "filterGreaterThanPrice" && commandToWords.size == 1) {
            while (true) {
                print("Введите price, чтобы вывести все product, у которых цена будет больше  ")
                val key = Scan()
                try {
                    FilterPrice.filterByPrice(collection, key.toInt())
                    break
                } catch (e: NumberFormatException) {
                    println("Надо ввести int!")
                }
            }
        }

        // Обработка команды "groupByCreationDate"
        else if (command == "groupByCreationDate" && commandToWords.size == 1) {
            GroupByCreationDate.sortProductsByDate(collection)
        }

        // Обработка команды "save"
        else if (command == "save" && commandToWords.size == 1) {
            print("Имя файла чтоб сохранить коллекцию в него: ")
            val file = Scan()
            Save.SaveCommand(collection, file)
        }

        // Обработка команды "replaceIfLower"
        else if (command == "replaceIfLower" && commandToWords.size == 1) {
            while (true) {
                println("Введите номер характеристики, которую хотите сравнить:")
                try {
                    println("1 - Price\n2 - EMPLOYEESCOUNT")
                    val Unit = JustScanner.Scan().toInt()
                    if (Unit < 1 || Unit > 2) {
                        println("Вы указали неправильный номер! Проверьте и введите еще раз")
                    } else {
                        when (Unit) {
                            1 -> ReplaceIfLower.replaceIfLower(collection, Unit)
                            2 -> ReplaceIfLower.replaceIfLower(collection, Unit)
                        }
                        break
                    }
                } catch (e: NumberFormatException) {
                    println("Надо ввести int!")
                }
            }
        }

        // Обработка команды "ExecuteScriptCommand"
        else if (command == "ExecuteScriptCommand" && commandToWords.size == 1) {
            print("Имя файла чтоб выполнить скрипт из него: ")
            val file = Scan()
            ReadScript.ExecuteScriptCommand(file, dp)
        }
    }
}