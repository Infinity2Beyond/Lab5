package Utility;

import java.io.File;
import java.util.Scanner;

import java.io.FileNotFoundException;


import java.util.Stack;
import java.util.NoSuchElementException;

import Exceptions.ScriptRecursion;



public class Console {
	 private CommandManager commandManager;
     private Scanner userStreamReader;
     private HumanAskers asker;
     private Stack<String> scriptStack = new Stack<>();
	 protected static final String PS1 = "$ ";
     protected static final String PS2 = "=> ";
     
     public Console(CommandManager commandManager, Scanner userStreamReader, HumanAskers asker) {
         this.commandManager = commandManager;
         this.userStreamReader = userStreamReader;
         this.asker = asker;
     }
     /**
      * Mode for catching commands from user input.
      */
     public void interactiveMode() {
         /**
          * A variable for storing the exit code of the command.
          * 0 : nothing
          * 1 : continue
          * 2 : exit
          */
         int commandStatus;

         String[] userCommand = { "", "" };
         try {
             // A loop for catching commands from user input.
             do {
                 Console.print(PS1);
                 userCommand = (userStreamReader.nextLine().trim().toUpperCase() + " ").split(" ", 2);
                 userCommand[1] = userCommand[1].trim();
                 commandManager.addToHistory(userCommand[0]);
                 commandStatus = launchCommand(userCommand);
             } while (commandStatus != 2);

         } catch (NoSuchElementException exception) {
             Console.printerror("No user input detected!");
         } catch (IllegalStateException exception) {
             Console.printerror("Unexpected error!");
         }
     }
     
     /**
      * Mode for catching commands from a script.
      * 
      * @param argument Its argument.
      * @return Exit code.
      */
     public int scriptMode(String argument) {
         String[] userCommand = { "", "" };
         int commandStatus;
         scriptStack.add(argument);
         try (Scanner scriptScanner = new Scanner(new File(argument))) {
             if (!scriptScanner.hasNext())
                 throw new NoSuchElementException();
             Scanner tmpScanner = asker.getUserInputReader();
             asker.setUserInputReader(scriptScanner);
             asker.setFileMode();
             do {
                 userCommand = (scriptScanner.nextLine().trim().toUpperCase() + " ").split(" ", 2);
                 userCommand[1] = userCommand[1].trim();
               // A loop for catching commands from a script: Handle if the line is null.
                 while (scriptScanner.hasNextLine() && userCommand[0].isEmpty()) {
                     userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                     userCommand[1] = userCommand[1].trim();
                 }

                 Console.println(PS1 + String.join(" ", userCommand));

                // A check for recursion in the script.
                 if (userCommand[0].equals("execute_script")) {
                     for (String script : scriptStack) {
                         if (userCommand[1].equals(script))
                             throw new ScriptRecursion();
                     }
                 }
                 commandStatus = launchCommand(userCommand);
             } while (commandStatus == 0 && scriptScanner.hasNextLine());

             asker.setUserInputReader(tmpScanner);
             asker.setUserMode();
             if (commandStatus == 1 && !(userCommand[0].equals("execute_script") && !userCommand[1].isEmpty()))
                 Console.println("Check the script for the correctness of the entered data!");
             return commandStatus;
         } catch (FileNotFoundException exception) {
             Console.printerror("The script file was not found!");
         } catch (NoSuchElementException exception) {
             Console.printerror("Script file is empty!");
         } catch (ScriptRecursion exception) {
             Console.printerror("Scripts cannot be called recursively!");
         } catch (IllegalStateException exception) {
             Console.printerror("Unexpected error!");
             System.exit(0);
		} finally {
             scriptStack.remove(scriptStack.size() - 1);           
         }
         return 1;
     } 

     
     /**
      * Launch the command.
      * 
      * @param userCommand Command to launch.
      * @return Exit code.
      */
     private int launchCommand(String[] userCommand) {
         switch (userCommand[0]) {
             case "":
                 break;
             case "HELP":
                 if (!commandManager.Help(userCommand[1]))
                     return 1;
                 break;
             case "INFO":
                 if (!commandManager.Info(userCommand[1]))
                     return 1;
                 break;
             case "SHOW":
                 if (!commandManager.Show(userCommand[1]))
                     return 1;
                 break;
             case "ADD":
                 if (!commandManager.Add(userCommand[1]))
                     return 1;
                 break;
             case "UPDATE_BY_ID":
                 if (!commandManager.Update(userCommand[1]))
                     return 1;
                 break;
             case "REMOVE_BY_ID":
                 if (!commandManager.RemoveById(userCommand[1]))
                     return 1;
                 break;
             case "CLEAR":
                 if (!commandManager.Clear(userCommand[1]))
                     return 1;
                 break;
             case "SAVE":
                 if (!commandManager.Save(userCommand[1]))
                     return 1;
                 break;
             case "EXECUTE_SCRIPT":
                 if (!commandManager.ExecuteScript(userCommand[1]))
                     return 1;
                 else
                     return scriptMode(userCommand[1]);
             case "FILTER_LESS_THAN_IMPACT_SPEED":
                 if (!commandManager.FilterLessThanImpactSpeed(userCommand[1]))
                     return 1;
                 break;
             case "PRINT_DESCENDING":
                 if (!commandManager.PrintDescending(userCommand[1]))
                     return 1;
                 break;
             case "HISTORY":
                 if (!commandManager.History(userCommand[1]))
                     return 1;
                 break;
             case "SHUFFLE":
                 if (!commandManager.Shuffle(userCommand[1]))
                     return 1;
                 break;
             case "REORDER":
                 if (!commandManager.Reorder(userCommand[1]))
                     return 1;
                 break;
             case "MIN_BY_IMPACT_SPEED":
                 if (!commandManager.MinByImpactSpeed(userCommand[1]))
                     return 1;
                 break;
                 
             case "EXIT":
                 if (!commandManager.Exit(userCommand[1]))
                     return 1;
                 else
                     return 2;
             default:
                 if (!commandManager.noSuchCommand(userCommand[0]))
                     return 1;
         }
         return 0;
     }
     public static void print(Object toOut) {
	        System.out.print(toOut);
	    }
     
	 public static void println(Object toOut) {
	        System.out.println(toOut);
	        }
	   /**
	    * Prints error: toOut.toString() to Console
	    * @param toOut Error to print
	    */
	 public static void printerror(Object toOut) {
	       	System.out.println("Error: " + toOut);
	    }

	    /**
	     * Prints formatted 2-element table to Console
	     * @param element1 Left element of the row.
	     * @param element2 Right element of the row.
	     */
	 public static void printtable(Object element1, Object element2) {
	        System.out.printf("%-37s%-1s%n", element1, element2);
	    }

	  @Override
	 public String toString() {
	     return "Console (class for handling command input)";
	    }
	  
}
//"C:\Users\Admin\OneDrive\Desktop\nguyen\nguyen.json"
