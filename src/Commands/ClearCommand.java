package Commands;

import Utility.CollectionManager;
import Utility.Console;
import Exceptions.CollectionIsEmpty;
import Exceptions.WrongAmountOfElements;

public class ClearCommand extends AbstractCommand {
	private CollectionManager collectionManager ;
	public ClearCommand(CollectionManager collectionManager) {
		super ("Clear", ": Clear the collection") ;
		this.collectionManager = collectionManager ;
	}
	/**
     * Clear the collection
     * 
     * @param argument The argument is the string that is passed to the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmpty();
            collectionManager.clearCollection(); 
            Console.println("The collection is clear!");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
        } catch (CollectionIsEmpty exception) {
			Console.println("The collection is already empty!");
		}
        return false;
    }
	

}
