package Commands;

import Utility.CollectionManager;
import Utility.Console;
import Exceptions.CollectionIsEmpty;
import Exceptions.WrongAmountOfElements;

public class MinByImpactSpeedCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    /**
     * Constructor
     * @param collectionManager instance of CollectionManager
     */
    public MinByImpactSpeedCommand(CollectionManager collectionManager) {
        super("Min_By_Impact_Speed", ": Display any object from the collection whose impactSpeed field value is the minimum");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            Console.print(collectionManager.PrintMinSpeed(collectionManager.MinByImpactSpeed()));
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Type '" + getName() + "' to use this command");
        } catch (CollectionIsEmpty exception) {
            Console.printerror("Collection is empty");
        }
        return false;
    }
}
