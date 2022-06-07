package Run;


import java.util.Scanner;


import Commands.AddCommand;
import Commands.ClearCommand;
import Commands.ExecuteScriptFileCommand;
import Commands.ExitCommand;
import Commands.FilterLessThanImpactSpeedCommand;
import Commands.HelpCommand;
import Commands.HistoryCommand;
import Commands.InfoCommand;
import Commands.MinByImpactSpeedCommand;
import Commands.RemoveByIdCommand;
import Commands.SaveCommand;
import Commands.ShowCommand;
import Commands.UpdateIdCommand;
import Commands.PrintDescending;
import Commands.ReorderCommand;
import Commands.ShuffleCommand;


import Utility.*;

public class App {
	public static void main(String[] args) {
		    Scanner  userScanner = new Scanner (System.in);
            //final String envVariable = "C:\\Users\\Admin\\OneDrive\\Desktop\\nguyen\\nguyen.json" ;
            final String Argument = args[0] ;
            HumanAskers asker = new HumanAskers(userScanner);
            FileManager fileManager = new FileManager(Argument);
            CollectionManager collectionManager = new CollectionManager(fileManager);
            CommandManager commandManager = new CommandManager(
                    new HelpCommand(),
                    new InfoCommand(collectionManager),
                    new ShowCommand(collectionManager),
                    new AddCommand(collectionManager, asker),
                    new UpdateIdCommand(collectionManager, asker),
                    new RemoveByIdCommand(collectionManager, asker),
                    new ClearCommand(collectionManager),
                    new SaveCommand(collectionManager),
                    new ExitCommand(),
                    new ExecuteScriptFileCommand(),
                    new FilterLessThanImpactSpeedCommand(collectionManager, asker),
                    new PrintDescending(collectionManager),
                    new HistoryCommand(),
                    new ShuffleCommand(collectionManager),
                    new ReorderCommand(collectionManager),
                    new MinByImpactSpeedCommand(collectionManager));
                                        
            Console console = new Console(commandManager, userScanner, asker);
            //System.out.println(System.getenv());
            //System.out.println(envVariable);
            //System.out.println(HumanBeing.class);
            console.interactiveMode();    
            
    }
}
