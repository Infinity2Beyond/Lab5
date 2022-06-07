package Commands;

import Exceptions.WrongAmountOfElements;
import Utility.Console;

public class ExitCommand extends AbstractCommand {

    public ExitCommand() {
        super("Exit", ": Terminate program (without saving to file)");
    }

    /**
     * Executes to exit
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
