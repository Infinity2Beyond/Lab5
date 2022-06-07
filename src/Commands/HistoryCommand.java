package Commands;

import Exceptions.WrongAmountOfElements;
import Utility.Console;

public class HistoryCommand extends AbstractCommand {

    public HistoryCommand() {
        super("History", ": Display history of the last 15 used commands");
    }

    /**
     * The command shows 15 last commands.
     * 
     * @param argument The argument passed to the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty())
                throw new WrongAmountOfElements();
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
        }
        return false;
    }
}