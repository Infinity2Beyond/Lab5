package Utility;

import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Stack;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.IOException;


import java.lang.reflect.Type;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonParseException;

import Data.HumanBeing;


public class FileManager {
	private Gson gson = new Gson() ;
	private String Argument ;
	public FileManager(String Argument) {
		this.Argument = Argument ;
	}
	
    public void writeCollection(Collection<?> collection) {
	       if (Argument != null) {
	           try (OutputStreamWriter collectionFileWriter = 
	        		new OutputStreamWriter(new FileOutputStream(Argument))) {
	               collectionFileWriter.write(gson.toJson(collection));
	               Console.println("Collection successfully saved to file!");
	               
	           } catch (IOException exception) {
	                Console.printerror("The download file is a directory/cannot be opened!");
	           }
	        }  else Console.printerror("Boot file system Argument not found!");
    }


    public Stack<HumanBeing> readCollection() {
    	 if (Argument != null) { 
    		 try (InputStreamReader collectionFileReader 
    		     = new InputStreamReader(new FileInputStream (Argument))) {
    			 Stack<HumanBeing> collection;
    		
                 Type collectionType = new TypeToken<Stack<HumanBeing>>() {}.getType();
                 collection = gson.fromJson(collectionFileReader, collectionType);
                 //System.out.println(collectionFileReader);
                 if (collection == null) throw new NoSuchElementException() ;                 
                 Console.println("Collection successfully uploaded!");
                 return collection;
    		 } catch (FileNotFoundException exception) {
                 Console.printerror("Boot file not found!");
             } catch (NoSuchElementException exception) {
                 Console.printerror("The boot file is empty!");
             } catch (JsonParseException | NullPointerException exception) {
                 Console.printerror("Required collection not found in upload file!");
             } catch (IOException exception) {
	                Console.printerror("The download file is a directory/cannot be opened!");
             } catch (IllegalStateException exception) {
                 Console.printerror("Unexpected error!");
                 System.exit(0);
             } 
    	 } else Console.printerror("Boot file system Argument not found!");
    	 return new Stack<HumanBeing> ();	
    }
    @Override
    public String toString() {
        String string = "FileManager (class for working with file)";
        return string;
    }
}


