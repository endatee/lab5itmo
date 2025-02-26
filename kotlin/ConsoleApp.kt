import CommandProvider.CommandManager
import CommandProvider.Commands.Help
import CommandProvider.Commands.Load
import Products.JustScanner

object ConsoleApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val server = CommandManager()
        Help.HelpCommand()
        while (true) {
            server.CommandChecker(JustScanner.Scan())
        }
    }
}

