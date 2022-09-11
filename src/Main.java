import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        Main houseKeeping = new Main();
        Player player = houseKeeping.callHouseKeeping();

        Main caveEntrance = new Main();
        caveEntrance.theCaveEntrance(player);

        Main caveEntranceFight = new Main();
        caveEntranceFight.theCaveEntranceFight(player);

        String[][]array = new String[5][5];
        
        Room room = new Room(player, array, 0, 0, 4,4,"o");



    }





    public Player callHouseKeeping(){
        clearConsole();
        return startStory();
    }

    public void theCaveEntrance(Player player){
        System.out.println("The cave entrance beckons, " + player.getName() + ", but preparations are in order.");
        System.out.println("A sword lies at your feet, memorabilia of efforts past.");
        sc.nextLine();
        Sword sword = new Sword();

        player.addToInventory(sword);

        String enterTheCave = "Enter the cave ";
        displayMenu(player, enterTheCave);
    }

    public void theCaveEntranceFight(Player player){
        System.out.println("You turn away from the cave and watch as the sun's last marks dissipates from the sky. You take a deep breath, and suddenly hear a growl from behind.");
        sc.nextLine();
        Ghoul ghoul = new Ghoul();
        attackState(player, ghoul);


        String actuallyEnterTheCave = "Enter the cave";

        System.out.println("You wipe the blood off your sword on the Ghoul's corpse. The Cave has played it's first hand. Now, it's your turn.\n");
        System.out.println("You notice a glowing red vial dropped by the Ghoul");

        HealthPotion potion = new HealthPotion();
        player.addToInventory(potion);
        

        displayMenu(player, actuallyEnterTheCave);


    }







    public void attackState(Player player, Enemy enemy){
        System.out.println("It's the Battle of " + player.getName() + " and... the " + enemy.getName() + "!");
        sc.nextLine();

        Item[] x= player.getEquipment();
        Item weapon = x[0];
        while(weapon == null){
            System.out.println("You have nothing equipped!");
            weapon = player.inCombatNoEquipment();
        }


        while (player.getHealth() > 0 && enemy.getHealth() > 0){
            System.out.println("\n" + player.getName() + "'s health: " + player.getHealth() + "                  " +
                                 enemy.getName() + "'s health: " + enemy.getHealth());

            System.out.println("What do you want to do?");
            System.out.println("1. Attack                            2. View Inventory");
            
            System.out.println("--------------------------------------------------");
            System.out.print("ENTER CHOICE: ");
            int combatChoice = sc.nextInt();
            sc.nextLine();
            System.out.println("--------------------------------------------------");

            switch(combatChoice){
                case 1:
                    player.attack(player, enemy);
                    if(enemy.getHealth() <=0){
                        break;
                    }
                    enemy.attack(player, enemy);
                    break;
                case 2:
                    player.displayInventoryDuringCombat();
                    break;
                case 3:
                    player.displayEquipment();
            }
            
        }

        if(player.getHealth() <= 0){
            System.out.println(player.getName() + " died!");
            System.exit(0);
        }

        System.out.println(enemy.getName() + " was slain!");
        sc.nextLine();
    }















    public void displayMenu(Player player, String continueGame){

        int menuChoice = 671;
        int exitMenu = 4;
        while (menuChoice != exitMenu){
            System.out.println("-----------------What do you want to do?------------------\n");
            System.out.println("                       Health: " + player.getHealth());
            System.out.println("1. View inventory                     2. View Equipment ");
            System.out.println("3. " + continueGame + "                               ");
            System.out.println("\n--------------------------------------------------");
            System.out.print("ENTER CHOICE: ");
            menuChoice = sc.nextInt();
            sc.nextLine();
            System.out.println("--------------------------------------------------\n");

            if(menuChoice < 1 || menuChoice > exitMenu){
                System.out.println(menuChoice + " is not a valid input. Please enter a number between 1 and " + exitMenu);
                System.out.println("--------------------------------------------------");
                System.out.print("ENTER CHOICE: ");
                menuChoice = sc.nextInt();
                sc.nextLine();
                System.out.println("--------------------------------------------------");
            }
            
            switch(menuChoice){
                case 1:
                    player.displayInventory();
                    break;

                case 2:
                    player.displayEquipment();
                    break;
                case 3:
                    return;
            }
                
                
                
                
                
                
        }

    }


    public Player startStory(){
        System.out.println("Twilight falls onto the cave's entrance. \nUngodly noises emit from below. \nA lone figure stands, ready to reclaim what's rightfully theirs.");
        System.out.println("Some may call them brave. Many will cry foolishness. All, however, shall call them...");
        System.out.println("\n--------------------------------------------------");
        System.out.print("ENTER NAME: ");
        String name = sc.nextLine();
        Player player = new Player(name);
        System.out.println("--------------------------------------------------\n");

        return player;
    }

    public void clearConsole(){
        for (int i = 0; i < 20; i++){
            System.out.println();
        }
    }

}
