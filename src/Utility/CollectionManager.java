package Utility;

import java.time.LocalDateTime;
import java.util.Stack;

import Data.*;
import Exceptions.CollectionIsEmpty;

public class CollectionManager {
	private Stack<HumanBeing> HumanCollection = new Stack<> () ;
	private LocalDateTime lastInputTime;
	private LocalDateTime lastSaveTime;
    private FileManager fileManager;
    
    public CollectionManager (FileManager fileManager) {
    	this.lastInputTime = null ;
    	this.lastSaveTime = null ;
    	this.fileManager = fileManager ;
    	loadCollection();
    	regenerateID ();
    	
    }
    /**
     * Get the collection of organizations
     * 
     * @return An ArrayList of Organization objects.
     */
    public Stack<HumanBeing> getCollection() {
        return HumanCollection;
    }
    /**
     * `regenerateID()`: Regenerates the ID for each organization in the collection
     */
    public void regenerateID(){
    	Stack<HumanBeing> collection = getCollection();
        long id = 1;
        for(HumanBeing humanbeing : collection){
        	humanbeing.setId(id++);
        }
    }
    /**
     * Get the last time the database was initialized
     * 
     * @return The last time the table was initialized.
     */
    public LocalDateTime getLastInputTime() {
        return lastInputTime;
    }

    /**
     * Get the last time the file was saved
     * 
     * @return The last save time.
     */
    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }
    /**
     * Get the name of type of the collection
     * 
     * @return The name of type of the collection.
     */
    public String collectionType() {
        return HumanCollection.getClass().getName();
    }
    /**
     * Get the number of organizations in the collection
     * 
     * @return The size of the organization collection.
     */
    public int collectionSize() {
        return HumanCollection.size();
    }
    /**
     * Get the first organization in the collection
     * 
     * @return The first organization in the collection.
     */
    public HumanBeing getFirst() {
        if (HumanCollection.isEmpty())
            return null;
        return HumanCollection.get(0);
    }

    /**
     * Get the last organization in the collection
     * 
     * @return The last organization in the collection.
     */
    public HumanBeing getLast() {
        if (HumanCollection.isEmpty())
            return null;
        return HumanCollection.get(collectionSize() - 1);
    }
    
    /**
     * Get an humanbeing by its ID
     * 
     * @param id The id of the organization to retrieve.
     * @return The Organization object that has the same id as the id parameter.
     */
    public HumanBeing getById(long id) {
        for (HumanBeing humanbeing : HumanCollection) {
            if (Long.valueOf(humanbeing.getId()).equals(id)) {
                return humanbeing;
            }
        }
        return null;
    }
    /**
     * Add an humanbeing to the collection of organizations
     * 
     * @param organization The organization to add to the collection.
     */
    public void addToCollection(HumanBeing humanbeing) {
    	HumanCollection.add(humanbeing);
    }
    /**
     * Remove an humanbeing from the collection
     * 
     * @param organization The organization to be removed from the collection.
     */
    public void removeFromCollection(HumanBeing humanbeing) {
    	HumanCollection.remove(humanbeing);
    }
    
    
    
    /**
     * Clear all humanbeing in the collection.
     */
    public void clearCollection() {
    	HumanCollection.clear();
    }

    /**
     * Generates next ID. It will be (the bigger one + 1).
     * 
     * @return Next ID.
     */
    public Long generateNextId() {
        if (HumanCollection.isEmpty())
            return 1L;
        return getLast().getId() + 1;
    }

    /**
     * Saves the collection to file.
     */
    public void saveCollection() {
        fileManager.writeCollection(HumanCollection);
    	//fileManager.writeCollection();
        lastSaveTime = LocalDateTime.now();
    }
    /**
     * Loads the collection from file.
     */
    private void loadCollection() {
    	HumanCollection = fileManager.readCollection();
        lastInputTime = LocalDateTime.now();
    }
       
    public HumanBeing MinByImpactSpeed() throws CollectionIsEmpty {	
        if (HumanCollection.isEmpty()) throw new CollectionIsEmpty();      
        HumanBeing minHuman = getFirst();
        for (HumanBeing humanbeing : HumanCollection) {
            if (humanbeing.getSpeed().compareTo(minHuman.getSpeed()) < 0) {
            	minHuman = humanbeing;
            }
        }     
        return minHuman;
    }
    
    public String PrintMinSpeed(HumanBeing humanbeing) throws CollectionIsEmpty {
    	humanbeing = MinByImpactSpeed();
    	String info = humanbeing.toString() + "\n\n" ;
    	for (HumanBeing humanbeing2 : HumanCollection) {
    		if (humanbeing2.getSpeed().compareTo(humanbeing.getSpeed()) == 0 
    				&& humanbeing2.compareTo(humanbeing) != 0 ) {
    			info += humanbeing2.toString() + "\n\n" ;
    		}
    	}
    	return info;  	
    }

    public String FilterLessByImpactSpeed (Double ImpactSpeed) {
        String info = "";
        
        for (HumanBeing humanbeing : HumanCollection) {
        	if (humanbeing.getSpeed() - ImpactSpeed < 0 ) 
        		info += humanbeing + "\n\n";
        }
        return info.trim();
    }
    
       
    @Override
    public String toString() {
        if (HumanCollection.isEmpty())
            return "The collection is empty!";

        String info = "";
        for (HumanBeing humanbeing : HumanCollection) {
            info += humanbeing;
            if (humanbeing != getLast())
                info += "\n\n";
        }
        return info;
    }
}
