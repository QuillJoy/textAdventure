// import java.util.*;
// public class Inventory {
//     private List<Item>inventory = new ArrayList<>();
//     private Item[] equipment = new Item[1];

//     static Scanner sc2 = new Scanner(System.in);

//     public void addToInventory(Item item){

//         inventory.add(item);
//         System.out.println(item.getName() + " has been added to your inventory.");

//     }

//     public void equipItem(Item item){
//         if (item instanceof Weapon){
//             System.out.println("Equip " + item.getName() + "?");
//             System.out.println("--------------------------------------------------");
//             System.out.print("ENTER CHOICE <1. Yes | 2. No> : ");
//             int choice = sc2.nextInt();
//             sc2.nextLine();
//             System.out.println("--------------------------------------------------");

//             if(choice == 1){
//                 if(item == equipment[0]){
//                     System.out.println(item.getName() + " is already equipped.");
//                     return;
//                 }
//                 equipment[0] = item;
//                 System.out.println(item.getName() + " has been equipped.");
//             }
//             else{

//                 return;
//             }
//         }
//     }



//     public void displayInventory(){
//         for( int i = 0; i<inventory.size(); i++){
//             Item itemFromInventory = inventory.get(i);
//             String itemName = itemFromInventory.getName();
//             System.out.println((i+1) + ". " + itemName);
//         }
//         System.out.println("\n--------------------------------------------------");
//         System.out.print("ENTER CHOICE < " + (inventory.size() + 1) + " to return to menu| Access item number > : ");
//         int itemNumber = sc2.nextInt();
//         System.out.println("--------------------------------------------------\n");
        
//         if(itemNumber != inventory.size() + 1){
//             for( int i = 0; i<inventory.size(); i++){
//                 Item itemFromInventory = inventory.get(i);
//                 if (i == itemNumber - 1){
//                     equipItem(itemFromInventory);
//                 }
//             }  
//         }
//         else{
//             return;
//         }



//         sc2.nextLine();
//     }

//     public void displayEquipment(){
//         if(equipment[0] == null){
//             System.out.println("You have nothing equipped.");
//             sc2.nextLine();
//             return;
//         }
//         Item x = equipment[0];

//         System.out.println("Equipped: " + x.getName());
//         sc2.nextLine();
//     }



// }
