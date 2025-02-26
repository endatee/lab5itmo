package Products

import java.io.Serializable

/**
 * Класс Organization представляет организацию с уникальным идентификатором,
 * именем, количеством сотрудников, и типом организации.
 * Реализует интерфейс Serializable.
 */
class Organization : Serializable {

    /**
     * Уникальный идентификатор организации.
     * Должен быть не null, больше 0 и уникальным.
     * Генерируется автоматически.
     */
    var id: Int = 0
        private set

    /**
     * Имя организации. Не может быть null или пустой строкой.
     */
    var name: String? = null

    /**
     * Количество сотрудников. Не может быть null и должно быть больше 0.
     */
    var marinesCount: Int = 0
        private set

    /**
     * Тип организации. Не может быть null.
     */
    var organizationType: OrganizationType? = null
        private set

    /**
     * Метод для инициализации полей организации через пользовательский ввод.
     */
    fun makeOrganization() {
        setId()
        while (true) {
            print("Введите имя Organization: ")
            val name = JustScanner.Scan()
            if (name.trim().isEmpty()) {
                println("Вы ввели пустую строку!")
            } else {
                putName(name)
                break
            }
        }

        while (true) {
            print("Введите 0<employeesCount: ")
            val mc = JustScanner.Scan()
            try {
                if (mc.toInt() > 0) {
                    setEmployeesCount(mc.toInt())
                    break
                } else {
                    println("Число должно быть больше 0!")
                }
            } catch (e: NumberFormatException) {
                println("Надо ввести int!")
            }
        }

        while (true) {
            println("Введите номер организации")
            println("1 - COMMERCIAL\n2 - GOVERNMENT\n3 - PRIVATE_LIMITED_COMPANY")
            try {
                val choice = JustScanner.Scan().toInt()
                when (choice) {
                    1 -> organizationType = OrganizationType.COMMERCIAL
                    2 -> organizationType = OrganizationType.GOVERNMENT
                    3 -> organizationType = OrganizationType.PRIVATE_LIMITED_COMPANY
                    else -> println("Вы указали неправильный номер! Проверьте и введите еще раз")
                }
                break
            } catch (e: NumberFormatException) {
                println("Надо ввести int!")
            }
        }
    }

    /**
     * Задает уникальный идентификатор организации.
     */
    fun setId() {
        this.id = (Math.random() * 1000000).toInt() + 1
    }

    /**
     * Устанавливает имя организации.
     *
     * @param name имя организации.
     */
    fun putName(name: String) {
        this.name = name
    }

    /**
     * Устанавливает количество сотрудников.
     *
     * @param mc количество сотрудников.
     */
    fun setEmployeesCount(mc: Int) {
        marinesCount = mc
    }

    /**
     * Возвращает имя организации.
     *
     * @return имя организации.
     */
    fun reviewName(): String? {
        return name
    }

    /**
     * Возвращает количество сотрудников.
     *
     * @return количество сотрудников.
     */
    fun getEmployeesCount(): Int {
        return marinesCount
    }

    /**
     * Устанавливает тип организации.
     *
     * @param x номер организации.
     * @throws IllegalArgumentException если номер не соответствует ни одному типу.
     */
    fun setOrganizationType(x: Int) {
        when (x) {
            1 -> this.organizationType = OrganizationType.COMMERCIAL
            2 -> this.organizationType = OrganizationType.GOVERNMENT
            3 -> this.organizationType = OrganizationType.PRIVATE_LIMITED_COMPANY
            else -> throw IllegalArgumentException("Неправильный тип организации")
        }
    }

    /**
     * Возвращает строковое представление организации.
     *
     * @return строка с данными об организации.
     */
    override fun toString(): String {
        return ("\n\tname: $name\n\temployeesCount: $marinesCount\n\tOrganizationType: $organizationType\n\tId: $id")
    }
}