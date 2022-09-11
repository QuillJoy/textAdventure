import java.util.*;
public abstract class Enemy extends Entity{
    protected int damage;

    Scanner sc3 = new Scanner(System.in);


    public int getDamage(){
        return damage;
    }

    public void attack(Player player, Enemy enemy){
        player.setHealth(player.getHealth()-enemy.getDamage());

        System.out.print("The " + enemy.getName() + " attacks " + player.getName());
        sc3.nextLine();     

    }



}
