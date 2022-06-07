package Commands;

import java.time.LocalDateTime ;
import Data.*;
import Exceptions.CollectionIsEmpty;
import Exceptions.HumanNotFound;
import Exceptions.WrongAmountOfElements;
import Exceptions.IncorrectInputInScript;
import Utility.HumanAskers;
import Utility.CollectionManager;
import Utility.Console;

public class UpdateIdCommand extends AbstractCommand {
	private CollectionManager collectionManager ;
	private HumanAskers asker;
	
	public UpdateIdCommand (CollectionManager collectionManager, HumanAskers asker) {
        super("Update_By_ID", ": Update the value of the collection element whose id is equal to the given one");
        this.collectionManager = collectionManager;
        this.asker = asker;
	}
	/**
     * Executes the command.
     * 
     * @return Command exit status.
     */
    /**
     * The command updates organization with the given ID 
     * 
     * @param argument the argument that the user entered.
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
            HumanBeing oldHumanbeing = collectionManager.getById(id);
            if (oldHumanbeing == null)
                throw new HumanNotFound();

            String name = oldHumanbeing.getName();
            Coordinates coordinates = oldHumanbeing.getCoordinates();
            LocalDateTime creationDate = oldHumanbeing.getCreationDate();
            boolean realHero = oldHumanbeing.getHero();
            Boolean Toothpick = oldHumanbeing.getToothpick();
            Double Speed = oldHumanbeing.getSpeed();
            Integer Minutes = oldHumanbeing.getMinutesWaiting();
            WeaponType weapon = oldHumanbeing.getWeaponType();
            Mood mood = oldHumanbeing.getMood();
            Car car = oldHumanbeing.getCar() ;
            
            

            collectionManager.removeFromCollection(oldHumanbeing);

            if (asker.askQuestion("Do you want to change this humanbeing's name?"))
                name = asker.askName();
            if (asker.askQuestion("Do you want to change this humanbeing's coordinates?"))
                coordinates = asker.askCoordinates();
            if (asker.askQuestion("Do you want to change the perception of this humanbeing as a true hero?"))
            	realHero = asker.askHero();
            if (asker.askQuestion("Do you want to change the perception that this humanbeing has a toothpick ?"))
            	Toothpick = asker.askToothpick();
            if (asker.askQuestion("Do you want to change this humanbeing's impact speed?"))
            	Speed = asker.askImpactSpeed();
            if (asker.askQuestion("Do you want to change this humanbeing's minutes of waiting?"))
            	Minutes = asker.askMinutesOfWaiting();
            if (asker.askQuestion("Do you want to change this humanbeing's weapon type?"))
            	weapon = asker.askWeaponType();
            if (asker.askQuestion("Do you want to change this humanbeing's mood?"))
            	mood = asker.askMood();
            if (asker.askQuestion("Do you want to change the perception that this humanbeing has a coolcar ?"))
            	car = asker.askCar();
            

            collectionManager.addToCollection(new HumanBeing(
                    id,
                    name,
                    coordinates,
                    creationDate,
                    realHero,
                    Toothpick,
                    Speed,
                    Minutes,
                    weapon,
                    mood,
                    car ));
            Console.println("Humanbeing successfully changed!");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Wrong Syntax! Type '" + getName() + "' to use this command");
        } catch (CollectionIsEmpty exception) {
            Console.printerror("Collection is empty!");
        } catch (HumanNotFound exception) {
            Console.printerror("There is no humanbeing with this ID in the collection!");
        } catch (IncorrectInputInScript exception) {
            Console.printerror("Data in script is not correct");
        }
        return false;
    }
}
