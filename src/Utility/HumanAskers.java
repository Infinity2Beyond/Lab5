package Utility;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Data.*;
import Exceptions.MustBeNotEmpty;
import Exceptions.NotInDeclaredLimit;
import Exceptions.IncorrectInput;
import Exceptions.IncorrectInputInScript;

public class HumanAskers {
	private final int MAX_X = 352;
	private Scanner UserinputReader ;
	private boolean fileMode;
	
	public HumanAskers (Scanner UserinputReader) {
		this.UserinputReader = UserinputReader ;
		fileMode = false ;
	}
	/**
     * Sets a InputStream to scan user input.
     * 
     * @param inputReader InputStreamReader to set.
     */
	public void setUserInputReader(Scanner UserinputReader) {
		this.UserinputReader = UserinputReader ;
	}
	 /**
     * Get InputStreamReaderr when interacting with Console.
     * @return InputStreamReaderr, which uses for user input.
     */
	public Scanner getUserInputReader() {
		return UserinputReader ;
	}
	
	public void setFileMode () {
		fileMode = true;
	}
	
	public void setUserMode () {
		fileMode = false;
	}
	
	public long askID() throws IncorrectInputInScript {
		String StrID ;
		Long ID;
        while (true) {
            try {
                Console.println("Enter ID:");
                Console.print(Console.PS2);
                StrID = UserinputReader.nextLine().trim();
                if (StrID.equals(""))
                    throw new MustBeNotEmpty();
                if (fileMode)
                    Console.println(StrID);
                    ID = Long.parseLong(StrID);
                if (ID < 1) throw new IncorrectInput();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("The ID is not recognized!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (MustBeNotEmpty exception) {
                Console.printerror("The ID cannot be empty!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NumberFormatException exception) {
                Console.printerror("ID must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            } catch (IncorrectInput exception) {
                Console.printerror("Input must be bigger than 0!");
                if (fileMode) throw new IncorrectInputInScript();
            }
        }
        return ID;
	}
	
	
	/**
     * Asks a user the humanbeing's name.
     * 
     * @return Humanbeing's name.
     * @throws IncorrectInputInScriptException iff script is running and something
     *                                         goes wrong.
     */
	public String askName() throws IncorrectInputInScript {
        String name;
        while (true) {
            try {
                Console.println("Enter name:");
                Console.print(Console.PS2);
                name = UserinputReader.nextLine().trim();
                if (fileMode)
                    Console.println(name);
                if (name.equals(""))
                    throw new MustBeNotEmpty();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("The name is not recognized!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (MustBeNotEmpty exception) {
                Console.printerror("The name cannot be empty!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }
        }
        return name;
    }
	/**
     * Asks a user the organization's X coordinate.
     * 
     * @return Organization's X coordinate.
     * @throws IncorrectInputInScriptException If script is running and something
     *                                         goes wrong.
     */
    public int askX() throws IncorrectInputInScript {
        String strX;
        int x;
        while (true) {
            try {
                Console.println("Enter X coordinate:");
                Console.print(Console.PS2);
                strX = UserinputReader.nextLine().trim();
                if (strX.equals("")) throw new MustBeNotEmpty();
                if (fileMode)
                    Console.println(strX);
                x = Integer.parseInt(strX);
                if (x > MAX_X)
                    throw new NotInDeclaredLimit();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("The X coordinate is not recognized!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NumberFormatException exception) {
                Console.printerror("The X coordinate must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NotInDeclaredLimit exception) {
                Console.printerror("The X coordinate cannot exceed " + MAX_X + "!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            } catch(MustBeNotEmpty exception) {
            	Console.printerror("The input for X can not be empty") ;
            	if (fileMode) throw new IncorrectInputInScript();
            }
        }
        return x;
    }
    /**
     * Asks a user the organization's Y coordinate.
     * 
     * @return Organization's Y coordinate.
     * @throws IncorrectInputInScriptException If script is running and something
     *                                         goes wrong.
     */
    public Integer askY() throws IncorrectInputInScript {
        String strY;
        Integer y;
        while (true) {
            try {
                Console.println("Enter Y coordinate: ");
                Console.print(Console.PS2);
                strY = UserinputReader.nextLine().trim();
                if (strY.equals("")) throw new MustBeNotEmpty();
                if (fileMode)
                    Console.println(strY);
                y = Integer.parseInt(strY);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("The Y coordinate is not recognized!");
                if (fileMode) throw new IncorrectInputInScript();       
            } catch (NumberFormatException exception) {
                Console.printerror("The Y coordinate must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            } catch(MustBeNotEmpty exception) {
            	Console.printerror("The input for Y can not be empty") ;
            	if (fileMode) throw new IncorrectInputInScript();
            }
        }
        return y;
    }
    /**
     * Asks a user the humanbeing's coordinates.
     * @return Humanbeing's coordinates.
     * @throws IncorrectInput If script is running and something goes wrong.
     */
    public Coordinates askCoordinates() throws IncorrectInputInScript {
        int x;
        Integer y;
        x = askX();
        y = askY();
        return new Coordinates(x, y);
    }
    
    public Double askImpactSpeed() throws IncorrectInputInScript {
    	String StrImpactSpeed ;
    	Double ImpactSpeed ;
    	while (true) {
            try {
                Console.println("Enter impact speed: ");
                Console.print(Console.PS2);
                StrImpactSpeed = UserinputReader.nextLine().trim();
                if (StrImpactSpeed.equals("")) throw new MustBeNotEmpty();
                if (fileMode)
                    Console.println(StrImpactSpeed);
                ImpactSpeed = Double.parseDouble(StrImpactSpeed);
                if (ImpactSpeed < 0) throw new IncorrectInput();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("The Impact Speed is not recognized!");
                if (fileMode) throw new IncorrectInputInScript();  
            } catch (NumberFormatException exception) {
                Console.printerror("The Impact Speed must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
                
            } catch (IncorrectInput exception) {
                Console.printerror("The input must be at least equal to 0 or bigger!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch(MustBeNotEmpty exception) {
            	Console.printerror("The input for Impact Speed can not be empty") ;
            	if (fileMode) throw new IncorrectInputInScript();
            }
        }
        return ImpactSpeed;  	
    }
    
    public Integer askMinutesOfWaiting() throws IncorrectInputInScript {
    	String StrMinutesOfWaiting;
    	Integer MinutesOfWaiting ;
    	while (true) {
            try {
                Console.println("Enter minutes of waiting: ");
                Console.print(Console.PS2);
                StrMinutesOfWaiting = UserinputReader.nextLine().trim();
                if (StrMinutesOfWaiting.equals("")) throw new MustBeNotEmpty();
                if (fileMode) Console.println(StrMinutesOfWaiting);
                MinutesOfWaiting = Integer.parseInt(StrMinutesOfWaiting);
                if (MinutesOfWaiting < 0 ) throw new IncorrectInput() ;
                break;
                
            } catch (NoSuchElementException exception) {
                Console.printerror("The minutes of waiting is not recognized!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NumberFormatException exception) {
                Console.printerror("The minutes of waiting must be represented by a number!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            } catch (IncorrectInput exception) {
                Console.printerror("The input must be at least equal to 0 or bigger ");
                if (fileMode) throw new IncorrectInputInScript();
            }  catch(MustBeNotEmpty exception) {
            	Console.printerror("The input for Minutes Of Waiting can not be empty") ;
            	if (fileMode) throw new IncorrectInputInScript();
            }
        }
        return MinutesOfWaiting;  	
    }
    
    public WeaponType askWeaponType() throws IncorrectInputInScript {
    	String StrWeaponType;
    	WeaponType weaponType;
    	 while (true) {
             try {
                 Console.println("List of weapon type - "  + WeaponType.nameList());
                 Console.println("Enter Humanbeing's weapon type:");
                 Console.print(Console.PS2);
                 StrWeaponType = UserinputReader.nextLine().trim();
                 if (StrWeaponType.equals("")) throw new MustBeNotEmpty();
                 if (fileMode) Console.println(StrWeaponType);
                 weaponType = WeaponType.valueOf(StrWeaponType.toUpperCase());
                 break;
             } catch (NoSuchElementException exception) {
                 Console.printerror("That weapon type is not recognized!");
                 if (fileMode) throw new IncorrectInputInScript();
             } catch (IllegalArgumentException exception) {
                 Console.printerror("That weapon type is not listed!");
                 if (fileMode) throw new IncorrectInputInScript();    
             } catch (IllegalStateException exception) {
                 Console.printerror("Unexpected error!");
                 System.exit(0);
             } catch(MustBeNotEmpty exception) {
             	Console.printerror("The input for Weapon Type can not be empty") ;
             	if (fileMode) throw new IncorrectInputInScript();
             } 
         }
         return weaponType;
     }

    public Mood askMood() throws IncorrectInputInScript {
    	String StrMood ;
    	Mood mood ;
    	while (true) {
            try {
                Console.println("List of mood - "  + Mood.nameList());
                Console.println("Enter Humanbeing's mood:");
                Console.print(Console.PS2);
                StrMood = UserinputReader.nextLine().trim();
                if (StrMood.equals("")) throw new MustBeNotEmpty();
                if (fileMode) Console.println(StrMood);
                mood = Mood.valueOf(StrMood.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("That mood is not recognized!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalArgumentException exception) {
                Console.printerror("That mood is not listed!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            } catch(MustBeNotEmpty exception) {
             	Console.printerror("The input for Mood can not be empty") ;
             	if (fileMode) throw new IncorrectInputInScript();
             }
        }
        return mood; 	
    }
    
    public boolean askHero () throws IncorrectInputInScript {
    	String StrHero ;
    	boolean Hero ;
    	while (true) {
            try {
            	String s1 = "YES" ;
            	String s2 = "NO" ;
                Console.println("Do this humanbeing a hero? (Yes/No) ");
                Console.print(Console.PS2);
                StrHero = UserinputReader.nextLine().trim();
                if (StrHero.equals("")) throw new MustBeNotEmpty();
                if (fileMode) Console.println(StrHero);
                if (StrHero.toUpperCase().compareTo(s1) == 0) {
                    Hero = true;                	
                }else if (StrHero.toUpperCase().compareTo(s2) == 0) {
                	Hero = false;
                }else {
                	throw new NumberFormatException();                       	   	
                }
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("The input is not recognized!");
                if (fileMode) throw new IncorrectInputInScript();     
            } catch (NumberFormatException exception) {
                Console.printerror("The input must be yes or no!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            }  catch(MustBeNotEmpty exception) {
            	Console.printerror("The input can not be empty") ;
            	if (fileMode) throw new IncorrectInputInScript();
            }
        }
        return Hero ;
    	
    }
    
    public Boolean askToothpick () throws IncorrectInputInScript {
    	String StrToothpick ;
    	Boolean Toothpick ;
    	while (true) {
            try {
            	String s1 = "YES" ;
            	String s2 = "NO" ;
                Console.println("Do this humanbeing has a toothpick? (Yes/No) ");
                Console.print(Console.PS2);
                StrToothpick = UserinputReader.nextLine().trim();
                if (StrToothpick.equals("")) throw new MustBeNotEmpty();
                if (fileMode) Console.println(StrToothpick);
                if (StrToothpick.toUpperCase().compareTo(s1) == 0) {
                	Toothpick = true;                	
                }else if (StrToothpick.toUpperCase().compareTo(s2) == 0) {
                	Toothpick = false;
                }else {
                	throw new NumberFormatException();                       	   	
                }
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("The input is not recognized!");
                if (fileMode) throw new IncorrectInputInScript();       
            } catch (NumberFormatException exception) {
                Console.printerror("The input must be yes or no!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            } catch(MustBeNotEmpty exception) {
            	Console.printerror("The input can not be empty") ;
            	if (fileMode) throw new IncorrectInputInScript();
            }
        }
        return Toothpick ;	
    }
    
    public boolean askCool() throws IncorrectInputInScript {
    	String StrCool ;
    	Boolean Cool ;
    	while (true) {
            try {
            	String s1 = "YES" ;
            	String s2 = "NO" ;
                Console.println("Do this humanbeing have a cool car? (Yes/No) ");
                Console.print(Console.PS2);
                StrCool = UserinputReader.nextLine().trim();
                if (StrCool.equals("")) throw new MustBeNotEmpty();
                if (fileMode) Console.println(StrCool);
                if (StrCool.toUpperCase().compareTo(s1) == 0) {
                	Cool = true;                	
                }else if (StrCool.toUpperCase().compareTo(s2) == 0) {
                	Cool = false;
                }else {
                	throw new NumberFormatException();                       	   	
                }
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("The input is not recognized!");    
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NumberFormatException exception) {
                Console.printerror("The input must be yes or no!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            } catch(MustBeNotEmpty exception) {
            	Console.printerror("The input can not be empty") ;
            	if (fileMode) throw new IncorrectInputInScript();
            }
        }
        return Cool ;
    }
    
    public Car askCar() throws IncorrectInputInScript {
        boolean cool;
        cool = askCool();
        return new Car(cool);
    }
    
    public boolean askQuestion(String question) throws IncorrectInputInScript {
        String finalQuestion = question + " (Y/N):";
        String answer;
        while (true) {
            try {
                Console.println(finalQuestion);
                Console.print(Console.PS2);
                answer = UserinputReader.nextLine().trim().toUpperCase();
                if (answer.equals("")) throw new MustBeNotEmpty();
                if (fileMode) Console.println(answer);
                if (!answer.equals("Y") && !answer.equals("N"))
                    throw new NotInDeclaredLimit();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Answer not recognized!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (NotInDeclaredLimit exception) {
                Console.printerror("The answer must be represented by 'Y' or 'N'!");
                if (fileMode) throw new IncorrectInputInScript();
            } catch (IllegalStateException exception) {
                Console.printerror("Unexpected error!");
                System.exit(0);
            } catch(MustBeNotEmpty exception) {
            	Console.printerror("The input can not be empty") ;
            	if (fileMode) throw new IncorrectInputInScript();
            }
        }
        return (answer.equals("Y")) ? true : false;
    }

    	
    @Override
    public String toString() {
        return "HumanAsker (helper class for queries to the user)";
    }
}


