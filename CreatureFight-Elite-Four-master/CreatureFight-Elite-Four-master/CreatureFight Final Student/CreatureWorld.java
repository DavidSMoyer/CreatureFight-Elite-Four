/**
 * TODO (1): Write an assignment comment block and update it as you code
 * 
 * Name: David Scott Moyer
 * Teacher: Scott Hardman
 * Class: Software Development
 * Date: 18/12/2018
 */

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreatureWorld extends World
{
    //TODO (5): Change the data type of these two variables from Creature to String
    private String playerOneCreature;
    private String playerTwoCreature;
    
    private int turnNumber;
    
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    
    private boolean playerOneMenusAdded;
    private boolean playerTwoMenusAdded;
    
    private String playerOneName = "1";
    private String playerTwoName = "2";
    
    //TODO (80): Declare two Creature instance arrays, one for the collection of playerOneCreatures and one for the collection of playerTwoCreatures
    private Creature playerOneCreatures[];
    private Creature playerTwoCreatures[];

    /**
     * Default constructor for objects of class CreatureWorld.
     * 
     * @param There are no parameters
     * @return an object of class CreatureWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1);
        
        //TODO (6): Change these two variables to store the names of the playerOne and playerTwo Creatures, Charmander and Pikachu respectively
        playerOneCreature = "charmander";
        playerTwoCreature = "pikachu";
        
        /**
         * TODO (81): Initialize the playerOneCreatures array to a new Creature array that stores a 
         *          new Charmander object, a new Golem object, and a new Ivysaur object
         */
        playerOneCreatures = new Creature[]{new Charmander(this), new Golem(this), new Ivysaur(this)};
        
        /**
         * TODO (154): Initialize the playerTwoCreatures array to a new Creature array that stores a 
         *          new Pikachu object, a new Lapras object, and a new Pidgeot object
         */
        playerTwoCreatures = new Creature[] {new Pikachu(this), new Lapras(this), new Pidgeot(this)};

        prepareCreatures();

        turnNumber = 0;
        
        playerOneMenusAdded = false;
        playerTwoMenusAdded = false;
        
        Greenfoot.start();
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        List allObjects = getObjects(null);
        
        //TODO (7): Declare two local boolean variables called playerOneLose and playerTwoLose that are both initialized to true
        boolean playerOneLose = true;
        boolean playerTwoLose = true;
        
        if( turnNumber == 0 )
        {
            playerOneName = JOptionPane.showInputDialog( "Please enter your name, Player One:", null );
            playerTwoName = JOptionPane.showInputDialog( "Please enter your name, Player Two:", null );
            turnNumber = 1;
        }
        else if( turnNumber == 1 )
        {
            showText( "Your turn, " + playerOneName, getWidth()/2, getHeight()/2 );
            showText( "", getWidth()/2, getHeight()/2 + 26 );
        }
        else
        {
            showText( "Your turn, " + playerTwoName, getWidth()/2, getHeight()/2 );
            showText( "", getWidth()/2, getHeight()/2 + 26 );
        }

        if( playerOneMenusAdded == false )
        {
            if (playerOneCreature.equalsIgnoreCase("charmander"))
            {
                oneFightMenu = new Menu(" Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                oneSwitchMenu = new Menu(" Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else if (playerOneCreature.equalsIgnoreCase("golem"))
            {
                oneFightMenu = new Menu(" Fight ", " Tackle \n Earthquake ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                oneSwitchMenu = new Menu(" Switch ", " Charmander \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else
            {
                oneFightMenu = new Menu(" Fight ", " Tackle \n Razor Leaf ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                oneSwitchMenu = new Menu(" Switch ", " Charmander \n Golem ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            //TODO (95): If playerOneCreature equals (ignoring case) "Charmander"...
            
                //TODO (96): Place the oneFightMenu and oneSwitchMenu initializations for Charmander inside this if statement
                
            
            //TODO (97): Otherwise, if playerOneCreature equals (ignoring case) "Golem"...
            
                //TODO (98): Set oneFightMenu to a new Fight menu that has options for Tackle and Earthquake
                
                
                //TODO (99): Set oneSwitchMenu to a new Switch menu that has options to change to Charmander or Ivysaur
                
            
            //TODO (100): Otherwise...
            
                //TODO (101): Set oneFightMenu to a new Fight menu that has options for Tackle and Razor Leaf
                
                
                //TODO (102): Set oneSwitchMenu to a new Switch menu that has options to change to Charmander or Golem
                
            

            addObject(oneFightMenu, 173, getHeight() - 100 );
            addObject(oneSwitchMenu, 241, getHeight() - 100);
            
            playerOneMenusAdded = true;
        }

        if( playerTwoMenusAdded == false )
        {
            if (playerTwoCreature.equalsIgnoreCase("pikachu"))
            {
                twoFightMenu = new Menu(" Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                twoSwitchMenu = new Menu(" Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else if (playerTwoCreature.equalsIgnoreCase("lapras"))
            {
                twoFightMenu = new Menu(" Fight ", " Tackle \n Hydro Pump ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                twoSwitchMenu = new Menu(" Switch ", " Pikachu \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else
            {
                twoFightMenu = new Menu(" Fight ", " Tackle \n Wing Attack ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                twoSwitchMenu = new Menu(" Switch ", " Pikachu \n Lapras ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            //TODO (168): If playerTwoCreature equals (ignoring case) "Pikachu"...
            
                //TODO (169): Place the twoFightMenu and twoSwitchMenu initializations for Pikachu inside this if statement
                
            
            //TODO (170): Otherwise, if playerTwoCreature equals (ignoring case) "Lapras"...

                //TODO (171): Set twoFightMenu to a new Fight menu that has options for Tackle and Hydro Pump
                
                
                //TODO (172): Set twoSwitchMenu to a new Switch menu that has options to change to Pikachu or Pidgeot
                
            
            //TODO (173): Otherwise...
            
                //TODO (174): Set twoFightMenu to a new Fight menu that has options for Tackle and Wing Attack
                
                
                //TODO (175): Set twoSwitchMenu to a new Switch menu that has options to change to Pikachu or Golem
                
            
            
            
            addObject(twoFightMenu, 131, 75);
            addObject(twoSwitchMenu, 199, 75);
            
            playerTwoMenusAdded = true;
        }
        int index = 0;
        while(playerOneLose == true & index < playerOneCreatures.length)
        {
            if(playerOneCreatures[index].getHealthBar().getCurrent() > 0)
            {
                playerOneLose = false;
            }
            index++;
        }
        index = 0;
        while(playerTwoLose == true & index < playerOneCreatures.length)
        {
            if(playerTwoCreatures[index].getHealthBar().getCurrent() > 0)
            {
                playerTwoLose = false;
            }
            index++;
        }
        //TODO (176): Declare a for loop that runs while playerOneLose is true AND index is less than the length of the playerOneCreatures array
        
            //TODO (177): If the player one creature at the current index of the array's current health is greater than 0...
            
                //TODO (178): Set playerOneLose to false
                
        
        //TODO (179): Declare a for loop that runs while playerTwoLose is true AND index is less than the length of the playerTwoCreatures array

            //TODO (180): If the player two creature at the current index of the array's current health is greater than 0...
            
                //TODO (181): Set playerTwoLose to false
                
        
        //TODO (8): Change the condition of this if statement to check if playerOneLose is false
        //TODO (182): Change the condition of this if statement to check if playerOneLose is true
        if( playerOneLose == true )
        {
            removeObjects(allObjects);
            showText(playerTwoName + " wins!!", getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
        
        //TODO (9): Change the condition of this if statement to check if playerTwoLose is false
        //TODO (183): Change the condition of this if statement to check if playerTwoLose is true
        if( playerTwoLose == true )
        {
            removeObjects(allObjects);
            showText(playerOneName + " wins!!", getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }      
    }

    /**
     * prepareCreatures adds the creatures for both players to the world
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void prepareCreatures()
    {
        //TODO (10): Delete the next two lines inside the prepareCreatures method
        
        for(int i = 0;i < playerOneCreatures.length;i++)
        {
            if(i == 0)
            {
                addObject(playerOneCreatures[i],playerOneCreatures[i].getImage().getWidth()/2,getHeight()-playerOneCreatures[i].getImage().getHeight()/2);
            }
            else
            {
                playerOneCreatures[i].getImage().setTransparency(0);
                addObject(playerOneCreatures[i],0,getHeight()-playerOneCreatures[i].getImage().getHeight()/2);
            }
        }
        //TODO (82): Declare a loop that will allow you to access every element of the playerOneCreatures array
        
            //TODO (83): If the loop index is 0...
            
                /**
                 * TODO (84): Add the object stored at the current index of the playerOneCreatures array
                 *          at an x location of playerOneCreatures[i].getImage().getWidth()/2 and
                 *          a y location of getHeight() - playerOneCreatures[i].getImage().getHeight()/2
                 */
                
            
            //TODO (85): Otherwise...
            
                //TODO (86): Set the transparency of the image of the Creature that is stored at the current index of the playerOneCreatures array to 0
                
                
                /**
                 * TODO (87): Add the object stored at the current index of the playerOneCreatures array
                 *          at an x location of 0 and a y location of
                 *          getHeight() - playerOneCreatures[i].getImage().getHeight()/2
                 */
                
            
        
        for(int i = 0;i < playerTwoCreatures.length;i++)
        {
            if(i == 0)
            {
                addObject(playerTwoCreatures[i],getWidth() - playerTwoCreatures[i].getImage().getWidth()/2,playerTwoCreatures[i].getImage().getHeight()/2);
            }
            else
            {
                playerTwoCreatures[i].getImage().setTransparency(0);
                addObject(playerTwoCreatures[i],getWidth(),playerTwoCreatures[i].getImage().getHeight()/2);
            }
        }
        //TODO (155): Declare a loop that will allow you to access every element of the playerTwoCreatures array
        
            //TODO (156): If the loop index is 0...
            
                /**
                 * TODO (157): Add the object stored at the current index of the playerTwoCreatures array
                 *          at an x location of getWidth() - playerTwoCreatures[j].getImage().getWidth()/2
                 *          and a y location of playerTwoCreatures[j].getImage().getHeight()/2
                 */
                
            
            //TODO (158): Otherwise...
            
                //TODO (159): Set the transparency of the image of the Creature that is stored at the current index of the playerTwoCreatures array to 0
                
                
                /**
                 * TODO (160): Add the object stored at the current index of the playerTwoCreatures array
                 *          at an x location of the width of the world and a y location of playerTwoCreatures[j].getImage().getHeight()/2
                 */
                
        
    }
    
    /**
     * getPlayerOne returns player one's current creature for
     * use in other parts of the code or for the user's information
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Creature getPlayerOne()
    {
        //TODO (11): Declare a local Creature variable called currentPlayerOne initialized to null
        Creature currentPlayerOne = null;

        if (playerOneCreature.equalsIgnoreCase("charmander"))
        {
            currentPlayerOne = playerOneCreatures[0];
        }
        else if (playerOneCreature.equalsIgnoreCase("golem"))
        {
            currentPlayerOne = playerOneCreatures[1];
        }
        else
        {
            currentPlayerOne = playerOneCreatures[2];
        }
        //TODO (88): If playerOneCreature equals (ignoring case) Charmander...
        
            //TODO (89): Initialize currentPlayerOne to the first element of the playerOneCreatures array
            
        //TODO (90): If playerOneCreature equals (ignoring case) Golem...
        
            //TODO (91): Initialize currentPlayerOne to the second element of the playerOneCreatures array
            
        //TODO (92): Otherwise...
        
            //TODO (93): Initialize currentPlayerOne to the third element of the playerOneCreatures array
            
        
        
        //TODO (12): Change this to return the current player one
        return currentPlayerOne;
    }
    
    /**
     * getPlayerTwo returns player two's current creature for
     * use in other parts of the code or for the user's information
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Creature getPlayerTwo()
    {
        //TODO (13): Declare a local Creature variable called currentPlayerTwo initialized to null
        Creature currentPlayerTwo = null;

        if (playerTwoCreature.equalsIgnoreCase("Pikachu"))
        {
            currentPlayerTwo = playerTwoCreatures[0];
        }
        else if (playerTwoCreature.equalsIgnoreCase("lapras"))
        {
            currentPlayerTwo = playerTwoCreatures[1];
        }
        else
        {
            currentPlayerTwo = playerTwoCreatures[2];
        }
        //TODO (161): If playerTwoCreature equals (ignoring case) Pikachu...
        
            //TODO (162): Initialize currentPlayerTwo to the first element of the playerTwoCreatures array
            
        //TODO (163): If playerTwoCreature equals (ignoring case) Lapras...
        
            //TODO (164): Initialize currentPlayerTwo to the second element of the playerTwoCreatures array
            
        //TODO (165): Otherwise...
        
            //TODO (166): Initialize currentPlayerTwo to the third element of the playerTwoCreatures array
            
            

        //TODO (14): Change this to return the current player two
        return currentPlayerTwo;
    }
    
    /**
     * getTurnNumber returns a number that represents which player's
     * turn it is (either player 1 or player 2)
     * 
     * @param There are no parameters
     * @return An integer that represents which player's turn it is
     */
    public int getTurnNumber()
    {
        return turnNumber;
    }

    /**
     * setTurnNumber changes the turn number to the appropriate
     * number for which player's turn it is
     * 
     * @param turn is the number that represents which player's turn it is
     * @return Nothing is returned
     */
    public void setTurnNumber( int turn )
    {
        turnNumber = turn;
    }

    /**
     * TODO (15): Declare a changePlayerOne method that will be 
     *          accessed by other classes, does not return anything
     *          and has a String parameter called creature
     *          
     * TODO (16): Set the playerOneCreature variable to creature
     * 
     * TODO (17): Remove player one's fight menu
     * 
     * TODO (18): Remove player one's switch menu
     * 
     * TODO (19): Set the playerOneMenusAdded variable to reflect that
     *          there are no player one menus anymore
     */
    
    /**
     * Changes player one to a different creature, and add reset their menus.
     * 
     * @param creature The creature player one should be set to
     * @return Returns nothing
     */
    public void changePlayerOne(String creature)
    {
        playerOneCreature = creature;
        removeObject(oneFightMenu);
        removeObject(oneSwitchMenu);
        playerOneMenusAdded = false;
    }

    /**
     * TODO (20): Declare a changePlayerTwo method that will be 
     *          accessed by other classes, does not return anything
     *          and has a String parameter called creature
     *          
     * TODO (21): Set the playerTwoCreature variable to creature
     * 
     * TODO (22): Remove player two's fight menu
     * 
     * TODO (23): Remove player two's switch menu
     * 
     * TODO (24): Set the playerTwoMenusAdded variable to reflect that
     *          there are no player one menus anymore
     */
    
    /**
     * Changes player two to a different creature, and add reset their menus.
     * 
     * @param creature The creature player two should be set to
     * @return Returns nothing
     */
    public void changePlayerTwo(String creature)
    {
        playerTwoCreature = creature;
        removeObject(twoFightMenu);
        removeObject(twoSwitchMenu);
        playerTwoMenusAdded = false;
    }

    /**
     * TODO (25): Declare a getNewOneCreature method that will be
     *          accessed by other classes, return a Creature object
     *          and has a parameter called index. Type return null inside the method for now
     *          
     * TODO (94): Inside the method, change the return to return the player one creature stored
     *          at the given index of the player one creatures array
     */
    
    /**
     * Gets the creature object defined at the current index of player one's creatures array.
     * 
     * @param index The index to get a creature
     * @return Returns nothing
     */
    public Creature getNewOneCreature(int index)
    {
        return playerOneCreatures[index];
    }

    /**
     * TODO (26): Declare a getNewTwoCreature method that will be
     *          accessed by other classes, return a Creature object
     *          and has a parameter called index. Type return null inside the method for now
     *          
     * TODO (167): Inside the method, change the return to return the player two creature stored
     *          at the given index of the player two creatures array
     */
    
    /**
     * Gets the creature object defined at the current index of player two's creatures array.
     * 
     * @param index The index to get a creature
     * @return Returns nothing
     */
    public Creature getNewTwoCreature(int index)
    {
        return playerTwoCreatures[index];
    }
    
}
