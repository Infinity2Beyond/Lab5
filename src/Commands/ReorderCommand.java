package Commands;

import Utility.CollectionManager;
import Utility.Console;

import java.util.Collections;

import Exceptions.CollectionIsEmpty;
import Exceptions.NotInDeclaredLimit;
import Exceptions.WrongAmountOfElements;

public class ReorderCommand extends AbstractCommand {
	private CollectionManager collectionManager;
	public ReorderCommand(CollectionManager collectionManager) {
		super ("Reorder", ": Reverse the order of elements in the collection");
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
            if (collectionManager.getCollection().isEmpty())
                throw new CollectionIsEmpty() ;
            if (collectionManager.collectionSize() == 1)
            	throw new NotInDeclaredLimit() ;
            Collections.reverse(collectionManager.getCollection());
            collectionManager.regenerateID();
            Console.println("Collection being reordered successfully!");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
        } catch (CollectionIsEmpty exception) {
        	Console.println("The collection is empty, cannot be reorder!");
        } catch (NotInDeclaredLimit exception) {
        	Console.println("The collection only have 1 element, so it can not be reorder!");
        }
        return false;
    }
}
