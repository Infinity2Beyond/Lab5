package Utility;

import java.util.ArrayList;
import java.util.List;

import Commands.Command;
import Exceptions.HistoryIsEmpty;


public class CommandManager {
	private final int COMMAND_HISTORY_SIZE = 16;

    private String[] commandHistory = new String[COMMAND_HISTORY_SIZE];
    private List<Command> commands = new ArrayList<>();
    private Command HelpCommand;
    private Command InfoCommand;
    private Command ShowCommand;
    private Command AddCommand;
    private Command UpdateIdCommand;
    private Command RemoveByIdCommand;
    private Command ClearCommand;
    private Command SaveCommand;
    private Command ExitCommand;
    private Command ExecuteScriptCommand;
    private Command FilterLessThanImpactSpeedCommand;
    private Command PrintDescendingCommand;
    private Command HistoryCommand;
    private Command ShuffleCommand;
    private Command ReorderCommand;
    private Command MinByImpactSpeedCommand;
    
    public CommandManager(Command HelpCommand, Command InfoCommand, Command ShowCommand, Command AddCommand, Command UpdateIdCommand,
            Command RemoveByIdCommand, Command ClearCommand, Command SaveCommand, Command ExitCommand, Command ExecuteScriptCommand,
            Command FilterLessThanImpactSpeedCommand, Command PrintDescendingCommand, Command HistoryCommand, Command ShuffleCommand,
            Command ReorderCommand, Command MinByImpactSpeedCommand) {
    	this.HelpCommand = HelpCommand;
        this.InfoCommand = InfoCommand;
        this.ShowCommand = ShowCommand;
        this.AddCommand = AddCommand;
        this.UpdateIdCommand = UpdateIdCommand;
        this.RemoveByIdCommand = RemoveByIdCommand;
        this.ClearCommand = ClearCommand;
        this.SaveCommand = SaveCommand;
        this.ExitCommand = ExitCommand;
        this.ExecuteScriptCommand = ExecuteScriptCommand;
        this.FilterLessThanImpactSpeedCommand = FilterLessThanImpactSpeedCommand;
        this.PrintDescendingCommand = PrintDescendingCommand;
        this.HistoryCommand = HistoryCommand;
        this.ShuffleCommand = ShuffleCommand;
        this.ReorderCommand = ReorderCommand;
        this.MinByImpactSpeedCommand = MinByImpactSpeedCommand;
        
        commands.add(InfoCommand);
        commands.add(ShowCommand);
        commands.add(AddCommand);
        commands.add(UpdateIdCommand);
        commands.add(RemoveByIdCommand);
        commands.add(ClearCommand);
        commands.add(SaveCommand);
        commands.add(ExitCommand);
        commands.add(ExecuteScriptCommand);
        commands.add(FilterLessThanImpactSpeedCommand);
        commands.add(PrintDescendingCommand);
        commands.add(HistoryCommand);
        commands.add(ShuffleCommand);
        commands.add(ReorderCommand);
        commands.add(MinByImpactSpeedCommand);
        
    }
    /**
     * @return The command history.
     */
    public String[] getCommandHistory() {
        return commandHistory;
    }

    /**
     * @return List of manager's commands.
     */
    public List<Command> getCommands() {
        return commands;
    }
    /**
     * Adds command to command history.
     * @param commandToStore Command to add.
     */
    public void addToHistory(String commandToStore) { 

        for (Command command : commands) {
            if (command.getName().toUpperCase().split(" ")[0].equals(commandToStore) ) {
                for (int i = COMMAND_HISTORY_SIZE-1; i>0; i--) {
                    commandHistory[i] = commandHistory[i-1];
                }
                commandHistory[0] = commandToStore.toLowerCase();
            }
        }
    }

    /**
     * Prints that command is not found.
     * @param command Command, which is not found.
     * @return Command exit status.
     */
    public boolean noSuchCommand(String command) {
        Console.println("Command  '" + command + "' not found. Type 'Help' for help.");
        return false;
    }
    
    /**
     * Prints info about the all commands.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean Help(String argument) {
        if (HelpCommand.execute(argument)) {
            for (Command command : commands) {
                Console.printtable(command.getName(), command.getDescription());
            }
            return true;
        } else 
        	return false;
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean Info(String argument) {
        return InfoCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean Show(String argument) {
        return ShowCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean Add(String argument) {
        return AddCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean Update(String argument) {
        return UpdateIdCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean RemoveById(String argument) {
        return RemoveByIdCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean Clear(String argument) {
        return ClearCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean Save(String argument) {
        return SaveCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean Exit(String argument) {
        return ExitCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean ExecuteScript(String argument) {
        return ExecuteScriptCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean FilterLessThanImpactSpeed(String argument) {
        return FilterLessThanImpactSpeedCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean PrintDescending(String argument) {
        return PrintDescendingCommand.execute(argument);
    }

    /**
     * Prints the history of used commands.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean History(String argument) {
        if (HistoryCommand.execute(argument)) {
            try {
            	int S = 0;
                Console.println("Last used commands:");
                for (int i=1; i<commandHistory.length; i++) {
                		if (commandHistory[i] != null) {
                			Console.println(" " + i + ":"  + commandHistory[i]);
                			S += 1; 
                		}
                		if (S == 0) throw new HistoryIsEmpty();
                }      
                return true;
            } catch (HistoryIsEmpty exception) {
                Console.println("Not a single command has been used yet!");
            }
        }
        return false;
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean Shuffle(String argument) {
        return ShuffleCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean Reorder(String argument) {
        return ReorderCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean MinByImpactSpeed(String argument) {
        return MinByImpactSpeedCommand.execute(argument);
    }

    @Override
    public String toString() {
        return "CommandManager ";
    }
   

}
