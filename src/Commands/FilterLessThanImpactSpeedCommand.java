package Commands;

import Exceptions.CollectionIsEmpty;
import Exceptions.IncorrectInputInScript;
import Exceptions.WrongAmountOfElements;
import Utility.CollectionManager;
import Utility.Console;
import Utility.HumanAskers;

public class FilterLessThanImpactSpeedCommand extends AbstractCommand {
	private CollectionManager collectionManager;
	private HumanAskers asker;
	
	public FilterLessThanImpactSpeedCommand (CollectionManager collectionManager, HumanAskers asker) {
		super ("Filter_Less_Than_Impact_Speed ", 
				": Display all elements whose Impact Speed field value is less than the specified one");
		this.collectionManager = collectionManager ;
		this.asker = asker;
	}
	/**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmpty();

            Double impactSpeed = asker.askImpactSpeed();
            String filteredInfo = collectionManager.FilterLessByImpactSpeed(impactSpeed);
            if (!filteredInfo.isEmpty()) {
                Console.println(filteredInfo);
                return true;
            } else Console.println("There are no elements whose ImpactSpeed field value is smaller than the specified one");
        } catch (WrongAmountOfElements exception) {
            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
        } catch (CollectionIsEmpty exception) {
            Console.printerror("Collection is empty");
        } catch (IncorrectInputInScript exception) {
            Console.printerror("Data in script is not correct");
        }
        return false;
    }
	

}
