package Commands;

import java.time.LocalDateTime;
import Exceptions.WrongAmountOfElements;
import Exceptions.IncorrectInputInScript;
import Utility.CollectionManager;
import Utility.Console;
import Utility.HumanAskers;
import Data.HumanBeing;

public class AddCommand extends AbstractCommand {
	private CollectionManager collectionManager;
    private HumanAskers asker;
	
	public AddCommand(CollectionManager collectionManager, HumanAskers asker) {
		super ("Add",": Add new element to the collection");
		this.collectionManager = collectionManager ;
		this.asker = asker;
	}
	/**
     * Add an organization to the collection
     * 
     * @param argument The argument is the user input.
     * @return statement of the command.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty())
                throw new WrongAmountOfElements();
            collectionManager.addToCollection(new HumanBeing(
                    collectionManager.generateNextId(),
                    asker.askName(),
                    asker.askCoordinates(),
                    LocalDateTime.now(),
                    asker.askHero(),
                    asker.askToothpick(),
                    asker.askImpactSpeed(),
                    asker.askMinutesOfWaiting(),
                    asker.askWeaponType(),
                    asker.askMood(),
                    asker.askCar() ));
            Console.println("Human Being added successfully!");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
        } catch (IncorrectInputInScript exception) {
            Console.printerror("Data in script is not correct");
        }
        return false;
    }

}
