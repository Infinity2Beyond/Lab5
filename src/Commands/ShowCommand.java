package Commands;

import Utility.CollectionManager;
import Utility.Console;
import Exceptions.WrongAmountOfElements;

public class ShowCommand extends AbstractCommand {
	private CollectionManager collectionManager;
	public ShowCommand(CollectionManager collectionManager) {
		super ("Show", ": Display all items in the collection");
		this.collectionManager = collectionManager;
	}
	/**
     * print out the collection
     * 
     * @param argument The argument passed to the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty())
                throw new WrongAmountOfElements();
            Console.println(collectionManager);
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
        }
        return false;
    }
}
