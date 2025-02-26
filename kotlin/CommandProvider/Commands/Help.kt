package CommandProvider.Commands

object Help {
    /**
     * display help on available commands
     */
    fun HelpCommand() {
        println("\n====================\n")

        println("help - доступные команды")
        println("info - информация о коллекции")
        println("insert - добавить новый элемент с заданным ключом")
        println("updateid - обновить значение элемента коллекции, id которого равен заданному")
        println("show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении")
        println("remove - удалить элемент из коллекции по его ключу")
        println("remove - удалить элемент из коллекции по его ключу")
        println("clear - очистить коллекцию")
        println("info - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)")
        println("remove_greater - удалить из коллекции все элементы, превышающие заданный")
        println("remove_lower - удалить из коллекции все элементы, меньшие, чем заданный")
        println("exit - завершить программу")
        println("filterByUnitOfMeasure - вывести элементы, значение поля unitOfMeasure которых равно заданному")
        println("filterGreaterThanPrice - вывести элементы, значение поля price которых больше заданного")
        println("groupByCreationDate - вывести элементы, значение поля price которых больше заданного")
        println("save - сохранить в csv")
        println("replaceIfLower - заменить значение по ключу, если новое значение меньше старого")
        println("ExecuteScriptCommand - считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.")
        println("\n====================\n")
    }
}
