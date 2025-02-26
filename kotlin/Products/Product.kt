package Products

import java.io.Serializable
import java.time.LocalDateTime

/**
 * Класс Product представляет собой продукт с различными атрибутами, такими как идентификатор, имя, координаты, дата создания, цена, единица измерения и организация.
 * Все поля класса имеют определенные ограничения и правила инициализации.
 *
 * @property id Уникальный идентификатор продукта. Генерируется автоматически и должен быть больше 0.
 * @property name Название продукта. Не может быть пустой строкой.
 * @property coordinates Координаты продукта. Не может быть null.
 * @property date Дата создания продукта. Генерируется автоматически и не может быть null.
 * @property Price Цена продукта. Должна быть больше 0.
 * @property UnitOfMeasureType Единица измерения продукта. Не может быть null.
 * @property organization Организация, связанная с продуктом. Может быть null.
 *
 * @constructor Создает новый объект Product. Если параметр ignoreInit равен false, инициализирует все поля продукта.
 * @param ignoreInit Если true, пропускает инициализацию полей продукта. По умолчанию false.
 */
class Product (private val ignoreInit: Boolean = false): Serializable {
    // Документация для полей класса
    var id: Int = 0
        private set
    var name: String? = null
        private set
    private var coordinates: Coordinates? = null
    var date: LocalDateTime = LocalDateTime.now()
    private var Price: Int = 0
    var UnitOfMeasureType: UnitOfMeasure? = null
        private set
    var organization: Organization? = null

    init {
        if (!ignoreInit) {
            setOrganization()
            setId()
            setName()
            setUnitOfMeasure()
            makePrice()
            setCoordinates()
            println("Product $name создан")
        }
    }

    /**
     * Устанавливает координаты продукта.
     */
    fun setCoordinates() {
        coordinates = Coordinates()
    }

    /**
     * Устанавливает организацию для продукта. Пользователь может выбрать, добавлять ли организацию.
     */
    fun setOrganization() {
        var OrganizationChoice: Int
        while (true) {
            try {
                print("Если хотите добавить Organization, введите 1 иначе 2: ")
                OrganizationChoice = JustScanner.Scan().toInt()
                if (OrganizationChoice != 1 && OrganizationChoice != 2) {
                    println("Введите 1 или 2!")
                } else {
                    break
                }
            } catch (e: NumberFormatException) {
                println("Надо ввести int!")
            }
        }
        when (OrganizationChoice) {
            1 -> {
                organization = Organization()
                organization!!.makeOrganization()
            }
            2 -> {}
        }
    }

    /**
     * Устанавливает единицу измерения для продукта.
     */
    fun setUnitOfMeasure() {
        while (true) {
            println("Введите номер UnitOfMeasure")
            println("1 - METERS\n2 - SQUARE_METERS\n3 - GRAMS\n4 - MILLIGRAMS")
            try {
                val Unit = JustScanner.Scan().toInt()
                if (Unit < 1 || Unit > 4) {
                    println("Вы указали неправильный номер! Проверьте и введите еще раз")
                } else {
                    when (Unit) {
                        1 -> UnitOfMeasureType = UnitOfMeasure.METERS
                        2 -> UnitOfMeasureType = UnitOfMeasure.SQUARE_METERS
                        3 -> UnitOfMeasureType = UnitOfMeasure.GRAMS
                        4 -> UnitOfMeasureType = UnitOfMeasure.MILLIGRAMS
                    }
                    break
                }
            } catch (e: NumberFormatException) {
                println("Надо ввести int!")
            }
        }
    }

    /**
     * Устанавливает цену продукта. Цена должна быть больше 0.
     */
    fun makePrice() {
        while (true) {
            print("Введите Price(0<price): ")
            try {
                val price = JustScanner.Scan()
                if (price.toInt() < 0) {
                    println("Значение price должно быть больше 0")
                } else {
                    setPrice(price.toInt())
                    break
                }
            } catch (e: NumberFormatException) {
                println("Надо ввести Integer")
            }
        }
    }

    /**
     * Устанавливает цену продукта.
     *
     * @param price Цена продукта. Должна быть больше 0.
     */
    fun setPrice(price: Int) {
        Price = price
    }

    /**
     * Устанавливает уникальный идентификатор продукта. Идентификатор генерируется автоматически.
     */
    fun setId() {
        this.id = (Math.random() * 1000000).toInt() + 1
    }

    /**
     * Устанавливает имя продукта.
     *
     * @param name Имя продукта. Не может быть пустой строкой.
     */
    fun putName(name: String) {
        this.name = name
    }

    /**
     * Устанавливает организацию для продукта.
     *
     * @param Organization Организация, связанная с продуктом.
     */
    fun putOrganization(Organization: Organization) {
        this.organization = Organization
    }

    /**
     * Устанавливает координаты продукта.
     *
     * @param coordinate Координаты продукта.
     */
    fun putCoordinate(coordinate: Coordinates) {
        this.coordinates = coordinate
    }

    /**
     * Устанавливает имя продукта. Пользователь вводит имя с консоли.
     */
    fun setName() {
        while (true) {
            print("Введите имя: ")
            name = JustScanner.Scan()
            if (name!!.replace(" ".toRegex(), "") == "") {
                println("Вы ввели пустую строчку! Имя не может быть пустой строчкой.")
            } else {
                break
            }
        }
    }

    /**
     * Устанавливает единицу измерения продукта.
     *
     * @param x Номер единицы измерения.
     * @throws IllegalArgumentException Если номер единицы измерения неверный.
     */
    fun putUnitOfMeasureType(x: Int) {
        when (x) {
            1 -> this.UnitOfMeasureType = UnitOfMeasure.METERS
            2 -> this.UnitOfMeasureType = UnitOfMeasure.SQUARE_METERS
            3 -> this.UnitOfMeasureType = UnitOfMeasure.GRAMS
            4 -> this.UnitOfMeasureType = UnitOfMeasure.MILLIGRAMS
            else -> throw IllegalArgumentException("Invalid unit of measure type")
        }
    }

    /**
     * Устанавливает дату создания продукта.
     *
     * @param date Дата создания продукта.
     */
    fun putDate(date: LocalDateTime) {
        this.date = date
    }

    /**
     * Возвращает цену продукта.
     *
     * @return Цена продукта.
     */
    fun getPrice(): Int {
        return Price
    }

    /**
     * Возвращает имя продукта.
     *
     * @return Имя продукта или "Unknown", если имя не установлено.
     */
    fun retrieveName(): String {
        return name ?: "Unknown"
    }

    /**
     * Возвращает идентификатор продукта.
     *
     * @return Идентификатор продукта.
     */
    fun retrieveId(): Int {
        return id
    }

    /**
     * Возвращает строковое представление продукта.
     *
     * @return Строковое представление продукта.
     */
    override fun toString(): String {
        return ("""
     Name: $name
     id: $id
     Координаты: $coordinates
     Дата: ${date}
     price: $Price, UnitOfMeasure : ${UnitOfMeasureType}
     Organization: ${organization}
     """.trimIndent())
    }

    /**
     * Возвращает координаты продукта.
     *
     * @return Координаты продукта или null, если не установлены.
     */
    fun getCoordinate(): Coordinates? {
        return coordinates
    }

    /**
     * Возвращает дату создания продукта.
     *
     * @return Дата создания продукта или null, если не установлена.
     */
    fun getLocalDateTime(): LocalDateTime? {
        return date
    }

    /**
     * Возвращает единицу измерения продукта.
     *
     * @return Единица измерения продукта или null, если не установлена.
     */
    fun getUniteOfMeasure(): UnitOfMeasure? {
        return UnitOfMeasureType
    }

    /**
     * Возвращает организацию, связанную с продуктом.
     *
     * @return Организация или null, если не установлена.
     */
    fun retrieveOrganization(): Organization? {
        return organization
    }
}

/**
 * Заглушка для метода makePrice. Не реализован.
 */
private fun makePrice() {
    TODO("Not yet implemented")
}

