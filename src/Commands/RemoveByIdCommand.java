package Commands;

import Exceptions.WrongAmountOfElements;
import Exceptions.CollectionIsEmpty;
import Exceptions.HumanNotFound;
import Exceptions.IncorrectInputInScript;
import Data.HumanBeing;
import Utility.CollectionManager;
import Utility.Console;
import Utility.HumanAskers;

public class RemoveByIdCommand extends AbstractCommand {
	private CollectionManager collectionManager ;
	private HumanAskers asker;

	
	public RemoveByIdCommand (CollectionManager collectionManager, HumanAskers asker) {
		super("Remove_By_ID", ": Remove items from collection by id");
		this.collectionManager = collectionManager ;
		this.asker = asker;
	}
	/**
     * Remove an organization from the collection
     * 
     * @param argument The argument that is passed to the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty())
                throw new WrongAmountOfElements();
            if (collectionManager.collectionSize() == 0)
                throw new CollectionIsEmpty();
            long id = asker.askID();
            HumanBeing HumanBeingToRemove = collectionManager.getById(id);
            if (HumanBeingToRemove == null)
                throw new HumanNotFound();
            collectionManager.removeFromCollection(HumanBeingToRemove);
            collectionManager.regenerateID();
            Console.println("Humanbeing successfully removed!");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
        } catch (CollectionIsEmpty exception) {
            Console.printerror("The collection is empty!");
        } catch (HumanNotFound exception) {
            Console.printerror("There is no humanbeing with this ID in the collection!");
        } catch (IncorrectInputInScript exception) {
            Console.printerror("Data in script is not correct");
        }
        return false;
    }

}
