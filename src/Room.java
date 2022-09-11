import java.util.*;
public class Room {
  static Scanner scanner = new Scanner (System.in);
  private int row;
  private int col;
  private int rowTarget;
  private int colTarget;
  private String magic;
  private String[][]array;
  private boolean isFinished;


  Room(Player player,String[][] array, int row, int col, int rowTarget, int colTarget, String magic){
      this.row = row;
      this.col = col;
      this.rowTarget = rowTarget;
      this.colTarget = colTarget;
      this.magic = magic;
      this.array = array;

      Menu(player, array, row, col, rowTarget, colTarget, magic);
  }

  
  public static void Menu(Player player, String[][] array, int row, int col, int rowTarget, int colTarget, String magic){ 
	String sent = "boop";
	while (!sent.equals("EXIT")){
        array[row][col] = magic;
		display(array);
        if(row == rowTarget && col == colTarget){
            scanner.nextLine();
            System.out.println("Leaving room...");
            return;
        }
		System.out.println("\nrow: " + row);
		System.out.println("column: " + col);
		System.out.println("\nw - Move up                       I. View inventory" + "\ns - Move down"
							+ "\na - Move left" + "\nd - Move right"
							+ "\nx - Exit");
		sent = scanner.nextLine();

        if(sent.equals("I")){
            player.displayInventory();
        }
		if (sent.equals("w")){			
			row = moveUp(array, row, col, magic);
		}			
		if (sent.equals("s")){
			row = moveDown(array, row, col, magic);
		}
		if (sent.equals("a")){
			col = moveLeft(array, row, col, magic);
		}		
		if (sent.equals("d")){
			col = moveRight(array, row, col, magic);

		}				
		if (sent.equals("x")){
			System.exit(0);
		}	
	}
  }	
  
  public static void display(String[][] array){
	System.out.println("\n");
	for( int row = 0; row < array.length; row++){
		System.out.print("\n                ");
		for (int col = 0; col < array[row].length; col++){
			if (array[row][col] == null){
				array[row][col] = "#";
			}
			System.out.print(array[row][col]);
			System.out.print(" ");
		}
	}	  
  }
  
  public static int moveDown(String[][] array, int row, int col, String magic){
	array[row][col] = "_";
	row = row + 1;
	
	if (row < 0 || row > 4){
		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + 
							"Wait! You'll fall of the edge!");
		row = row - 1;
	}
	array[row][col] = magic;
	
	return row;
  }
  
  public static int moveUp(String[][] array, int row, int col, String magic){
	array[row][col] = "_";
	row = row - 1;
	if (row < 0 || row > 4){
		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + 
							"Wait! You'll fall of the edge!");
		row = row + 1;
	}
	array[row][col] = magic;
	

	return row;
  }
  
  public static int moveRight(String[][] array, int row, int col, String magic){
	array[row][col] = "_";
	col = col + 1;
	
	if (col < 0 || col > 4){
		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + 
							"Wait! You'll fall of the edge!");
		col = col - 1;
	}
	array[row][col] = magic;
	
	return col;
  }
  
   public static int moveLeft(String[][] array, int row, int col, String magic){
	array[row][col] = "_";
	col = col - 1;
	
	if (col < 0 || col > 4){
		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + 
							"Wait! You'll fall of the edge!");
		col = col + 1;
	}
	array[row][col] = magic;
	
	return col;
  }
}
