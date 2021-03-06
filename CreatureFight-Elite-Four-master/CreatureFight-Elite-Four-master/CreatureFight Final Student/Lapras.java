import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * TODO (152): Copy all code below public class Pikachu and paste it below.
 *          You will make a few changes to the code to make it appropriate for
 *          Lapras. These are listed in order from top to bottom:
 *              - Change the constructor to say Lapras instead of Pikachu
 *              - Lapras has 900 points of health
 *              - Lapras's type is Water
 *              - In the constructor, add a line at the end to set the transparency
 *                of the image of the health bar to 0
 *              - Show text that Lapras has fainted when its health bar's value is 
 *                less than or equal to 0
 *                  - When Lapras faints, you should be checking if getNewTwoCreature at 0
 *                    still has health first
 *                      - You should be switching to Creature 0 if this is the case
 *              - Lapras's second attack...
 *                  - if used against an fire type...
 *                      - Should do two times 100 points of damage (DON'T DO THE MATH! Write the math expression)
 *                      - Should display that the attack is super effective at a location of
 *                        half the width of the world and half the height of the world plus 26
 *                  - otherwise, if used against a rock type...
 *                      - Should do two times 100 points of damage (DON'T DO THE MATH! Write the math expression)
 *                      - Should display that the attack is super effective at a location of
 *                        half the width of the world and half the height of the world plus 26
 *                  - otherwise, if used against a grass type...
 *                      - Should do half of 100 points of damage (DON'T DO THE MATH! Write the math expression)
 *                      - Should display that the attack is not very effective at a location of
 *                        half the width of the world and half the height of the world plus 26
 *                      - Should delay the scenario by 30 act cycles
 *                  - otherwise...
 *                      - Should do 100 points of damage
 *              - In switchCreature...
 *                      - If idx is equal to 0...
 *                          - Change player two to Pikachu
 *              
 */
public class Lapras extends Creature
{
    /**
     * Constructor for objects of class Lapras
     * 
     * @param w is a reference to the world that Lapras gets added to
     * @return An object of type Pikachu
     */
    public Lapras(World w)
    {
        super(900, 2, "Water");
        getImage().scale(150, 100);
        w.addObject( getHealthBar() , 100, 25 );
        getHealthBar().getImage().setTransparency(0);
    }
    
    /**
     * Act - do whatever the Pikachu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        CreatureWorld playerWorld = (CreatureWorld)getWorld();

        if( getHealthBar().getCurrent() <= 0 )
        {
            getWorld().showText("Lapras has fainted...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
            Greenfoot.delay(30);
            
            if (playerWorld.getNewTwoCreature(0).getHealthBar().getCurrent() > 0)
            {
                switchCreature(0);
                playerWorld.setTurnNumber(2);
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                getWorld().removeObject(this);
            }
            else if (playerWorld.getNewTwoCreature(2).getHealthBar().getCurrent() > 0)
            {
                switchCreature(2);
                playerWorld.setTurnNumber(2);
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                getWorld().removeObject(this);
            }
            //TODO (142): If the current health of the health bar of the new two creature at index 1 in player world is greater than 0...
            
                //TODO (143): Call the switchCreature method using a value of 1 as the parameter
                
                
                //TODO (144): Set the turn number in player world to 2
                
                
                //TODO (145): Clear the text (using an empty String, "") at the location that it stated Pikachu had fainted
                
                
                //TODO (146): Remove this object from the world
                
            
            //TODO (147): Otherwise, if the current health of the health bar of the new two creature at index 2 in player world is greater than 0...
            
                //TODO (148): Call the switchCreature method using a value of 2 as the parameter
                
                
                //TODO (149): Set the turn number in player world to 2
                
                
                //TODO (150): Clear the text (using an empty String, "") at the location that it stated Pikachu had fainted
                
                
                //TODO (151): Remove this object from the world
                
            
        }
    } 

    /**
     * attack takes away health from the enemy Creature using one of
     * two predefined attacks
     * 
     * @param idx is the index of the attack option selected
     * @return Nothing is returned
     */
    public void attack(int idx)
    {
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        Creature enemy = playerWorld.getPlayerOne();
        String enemyType = enemy.getType();
        
        //TODO (109): Make a call to the attackAnimation method
        attackAnimation();

        if( idx == 0 )
        {
            enemy.getHealthBar().add( -30 );
        }
        else
        {
            if(enemyType.equalsIgnoreCase("fire"))
            {
                enemy.getHealthBar().add(-100*2);
                playerWorld.showText("It's super effective!",playerWorld.getWidth()/2,playerWorld.getHeight()/2+26);
                Greenfoot.delay(30);
            }
            else if(enemyType.equalsIgnoreCase("rock"))
            {
                enemy.getHealthBar().add(-100*2);
                playerWorld.showText("It's super effective!",playerWorld.getWidth()/2,playerWorld.getHeight()+26);
                Greenfoot.delay(30);
            }
            else if (enemyType.equalsIgnoreCase("grass"))
            {
                enemy.getHealthBar().add(-100/2);
                playerWorld.showText("It's not very effective...",playerWorld.getWidth()/2,playerWorld.getHeight()+26);
                Greenfoot.delay(30);
            }
            else
            {
                enemy.getHealthBar().add( -100 );
            }
            //TODO (110): If the enemy type equals (ignoring case) Rock...
            
                //TODO (111): The enemy receives zero damage
                
                
                /**
                 * TODO (112): Show text that states the attack has no effect at a x location of half the width of the world 
                 *          and a y location of half the height of the world plus 26 pixels
                 */
                
                
                //TODO (113): Delay the scenario by 30 pixels
                
            
            //TODO (114): If the enemy type equals (ignoring case) Grass...
            
                //TODO (115): The enemy only receives half damage of the normal attack (65 points). DON'T DO THE MATH! Just type the mathematical expression you would use
                
                
                /**
                 * TODO (116): Show text that states the attack was not very effective at a x location of half the width of the world 
                 *          and a y location of half the height of the world plus 26 pixels
                 */
                
                
                //TODO (117): Delay the scenario by 30 pixels
                
            
            //TODO (118): Otherwise...
            
                //TODO (119): Take the line from below that takes away 65 points of health and place it inside this else

            
            
        }

        playerWorld.setTurnNumber(1);
    }

    /**
     * TODO (103): Declare an attackAnimation method that has no
     *          parameters and no return type
     *          
     * TODO (104): Declare two local variables, originalX and originalY
     *          that are set to the current X and current Y locations
     *          
     * TODO (105): Declare a loop that will run 15 times
     * 
     *      TODO (106): Set the location to 1 less than the current X location
     *               and two more than the current y location (you shouldn't
     *               be using the variables that you created earlier)
     *               
     *      TODO (107): Delay the scenario 1 act cycle
     *      
     * TODO (108): Set the location back to the original x and y locations 
     */
    
    /**
     * Creates the animation for attacking the enemy.
     * 
     * @param None There are no parameters
     * @return Returns nothing
     */
    private void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        for(int i = 0;i < 15;i++)
        {
            setLocation(getX()-1,getY()+2);
            Greenfoot.delay(1);
        }
        setLocation(originalX,originalY);
    }
    

    /**
     * TODO (120): Declare a switchCreature method that will be accessed
     *          by other classes, has no return type, and has a parameter
     *          called idx
     *          
     * TODO (121): Declare a local CreatureWorld variable called playerWorld that stores a reference to the CreatureWorld
     * 
     * TODO (122): Declare a local Creature variable called switchCreature that is
     *          initialized to get a new player one creature using the idx parameter
     *          
     * TODO (123): If the current health of the health bar of the switchCreature is less than or equal to 0...
     * 
     *      TODO (124): Use JOptionPane to show a message dialog with null as the first parameter and a message that
     *               let's the player know that the Creature they have chosen to switch to has fainted and they must
     *               select a different option
     *               
     * TODO (125): Otherwise...
     * 
     *      TODO (126): Use a loop that will loop while the x location of this creature
     *               is less than the width of the world minus 1
     *               
     *          TODO (127): Inside this loop, set the location to 5 more than the current x location and the current y location
     *          
     *          TODO (128): Delay the scenario by 2 act cycles
     *          
     *      TODO (129): Set the transparency of the image of this object to 0
     *      
     *      TODO (130): Set the transparency of the image of the health bar to 0
     *      
     *      TODO (131): If idx is equal to 1...
     *      
     *          TODO (132): Change player two in playerWorld to Lapras
     *          
     *      TODO (133): Otherwise...
     *      
     *          TODO (134): Change player two in playerWorld to Pidgeot
     *          
     *      TODO (135): Call the switchedIn method of switchCreature
     *      
     *      TODO (136): Set turn number in playerWorld to 1
     *          
     */
    
    /**
     * Switches the current creature to one that hasn't fainted
     * 
     * @param idx The index of the creature to switch to
     * @return Returns nothing
     */
    public void switchCreature(int idx)
    {
        CreatureWorld playerWorld = ((CreatureWorld)getWorld());
        Creature switchCreature = playerWorld.getNewTwoCreature(idx);
        if(switchCreature.getHealthBar().getCurrent() <= 0)
        {
            JOptionPane.showMessageDialog(null,"That creature has fainted! Pick another one!");
        }
        else
        {
            while(getX() < playerWorld.getWidth()-1)
            {
                setLocation(getX()+5,getY());
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            if (idx == 0)
            {
                playerWorld.changePlayerTwo("pikachu");
            }
            else
            {
                playerWorld.changePlayerTwo("pidgeot");
            }
            switchCreature.switchedIn();
            playerWorld.setTurnNumber(1);
        }
    }

    /**
     * TODO (137): Declare a method called switchedIn that will be accessed by
     *          other classes, has no return type, and no parameters
     *          
     * TODO (138): Set the transparency of the image of Pikachu and the
     *          transparency of the image of the health bar to full
     *          
     * TODO (139): Declare a loop that will repeat while the x location of Pikachu
     *          is greater than the width of the world minus half the width of the image of Pikachu
     *          
     *      TODO (140): Set the location of Pikachu to the current x location minus 5
     *               and the current y location
     *               
     *      TODO (141): Delay the scenario by two cycles
     */
    
    /**
     * Runs when the creature is switched in, making it visible
     * 
     * @param None There are no parameters
     * @return Returns nothing
     */
    public void switchedIn()
    {
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        while(getX() > getWorld().getWidth()-getImage().getWidth()/2)
        {
            setLocation(getX()-5,getY());
            Greenfoot.delay(2);
        }
    }
}
