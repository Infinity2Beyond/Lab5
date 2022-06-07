package Commands;

import Utility.CollectionManager;
import Utility.Console;

import java.util.Collections;

import Exceptions.CollectionIsEmpty;
import Exceptions.NotInDeclaredLimit;
import Exceptions.WrongAmountOfElements;

public class PrintDescending extends AbstractCommand {
	private CollectionManager collectionManager;
	
	public PrintDescending(CollectionManager collectionManager) {
		super ("Print_Descending", ": Display the elements of the collection in descending order");
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
            Console.println(collectionManager);
            Collections.reverse(collectionManager.getCollection());
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
        } catch (CollectionIsEmpty exception) {
        	Console.println("The collection is empty, cannot be print in descending order!");
        } catch (NotInDeclaredLimit exception) {
        	Console.println("The collection only have 1 element, so it cannot be print in descending order!");
        }
        return false;
    }
}
