package Commands;

import Utility.CollectionManager;
import Utility.Console;
import Exceptions.WrongAmountOfElements;

public class SaveCommand extends AbstractCommand {
	private CollectionManager collectionManager ;
	
	public SaveCommand (CollectionManager collectionManager) {
		super ("Save", ": Save collection to the file") ;
		this.collectionManager = collectionManager ;
	}
	/**
     * Save the collection to the file
     * 
     * @param argument The argument passed to the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty())
                throw new WrongAmountOfElements();
            collectionManager.saveCollection();
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Type '" + getName() + "' to use this command");
        }
        return false;
    }

}
