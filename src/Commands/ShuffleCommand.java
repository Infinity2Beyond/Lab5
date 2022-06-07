package Commands;

import Utility.CollectionManager;
import Utility.Console;

import java.util.Collections;

import Exceptions.WrongAmountOfElements;
import Exceptions.CollectionIsEmpty;
import Exceptions.NotInDeclaredLimit;

public class ShuffleCommand extends AbstractCommand {
	private CollectionManager collectionManager;
	public ShuffleCommand(CollectionManager collectionManager) {
		super ("Shuffle ", ": Shuffle the order of elements in the collection");
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
            Collections.shuffle(collectionManager.getCollection());
            collectionManager.regenerateID();
            Console.println("Collection being shuffle successfully!");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
        } catch (CollectionIsEmpty exception) {
        	Console.println("The collection is empty, cannot be shuffle!");
        } catch (NotInDeclaredLimit exception) {
        	Console.println("The collection only have 1 element, so it can not be shuffle!");
        }
        return false;
    }
}

