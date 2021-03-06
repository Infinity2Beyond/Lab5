package Commands;

import Utility.Console;
import Exceptions.WrongAmountOfElements;

public class ExecuteScriptFileCommand extends AbstractCommand {
	public ExecuteScriptFileCommand () {
		super ("Execute_Script <file_path>", ": Execute script from specified file");
	}
	/**
     * Execute a script
     * 
     * @param argument The argument is the name of the script file.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty())
                throw new WrongAmountOfElements();
            Console.println("Executing command from the script '" + argument + "'...");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
        }
        return false;
    }

}
