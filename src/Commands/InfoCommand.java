package Commands;

import java.time.LocalDateTime ;
import Utility.CollectionManager;
import Utility.Console;
import Exceptions.WrongAmountOfElements;

public class InfoCommand extends AbstractCommand {
	private CollectionManager collectionManager ;
	
	public InfoCommand (CollectionManager collectionManager) {
		super ("Info", ": Print out information about the collection(type, initialization date, number of elements, etc)");
		this.collectionManager = collectionManager;
	}
	/**
	    * Prints information about the collection
	    * 
	    * @param argument The argument is the string that is passed to the command.
	    * @return Command exit status.
	    */
	    @Override
	    public boolean execute(String argument) {
	        try {
	            if (!argument.isEmpty())
	                throw new WrongAmountOfElements();
	            LocalDateTime lastInputTime = collectionManager.getLastInputTime();
	            String lastInputTimeString = (lastInputTime == null) ? "no initialization has yet taken place in this session"
	                    : lastInputTime.toLocalDate().toString() + " " + lastInputTime.toLocalTime().toString();

	            LocalDateTime lastSaveTime = collectionManager.getLastSaveTime();
	            String lastSaveTimeString = (lastSaveTime == null) ? "in this session has not yet occurred"
	                    : lastSaveTime.toLocalDate().toString() + " " + lastSaveTime.toLocalTime().toString();

	            Console.println("Collection Information:");
	            Console.println(" Type: " + collectionManager.collectionType());
	            Console.println(" Number of elements: " + collectionManager.collectionSize());
	            Console.println(" Date of the last save: " + lastSaveTimeString);
	            Console.println(" Date of last initialization: " + lastInputTimeString);
	            return true;
	        } catch (WrongAmountOfElements exception) {
	            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
	        }
	        return false;
	    }

}
