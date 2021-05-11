package shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingBill
{
	  public static void main(String[] args) {
		  
		  
	
	  TreeMap<Integer,String> tm1= new TreeMap <Integer,String>();
	  TreeMap<String,Double> tm2= new TreeMap <String,Double>();
	  
	  
	    String itemName = null;
	    int quantity = 0;
	    double price=0.0;
	    double totalPrice = 0.0;
	    double overAllPrice = 0.0;
	    int code;
	    char choice = '\0';
	    
	//Database Connections
		   
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","Ranga@123");
			String sql="SELECT * FROM items";
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery(sql);
			
			
			System.out.println("Id Name Price\n");
			while (result.next()) {
				int id=result.getInt(1);
				String name=result.getString(2);
				double pricedb=result.getDouble(3);
				
				System.out.println(id+ " " +name+ " "  +pricedb);
				tm1.put(id, name);
				tm2.put(name, pricedb);
			}
		    
		    connection.close();
	  }
	  	
		catch(SQLException e)
	    {
	    	System.out.println("not connected");
	    }
		
		
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		List<Item> item = new ArrayList<Item>();
		
		do {
		      // read input values
		      System.out.println("Welcome!!Enter item Id would you like to purchase");
		      code = scan.nextInt();
		      System.out.print("Quantity: ");
		      quantity = scan.nextInt();
		
		      itemName=tm1.get(code);
		      price=tm2.get(itemName);

		      // calculate total price for that product
		      totalPrice = price * quantity;

		      // calculate overall price
		      overAllPrice += totalPrice;

		      // create Product class object and add it to the list
		      item.add( new Item(
		          itemName, quantity, price, totalPrice) );

		      // ask for continue?
		      System.out.print("Want to add more item? (y or n): ");
		      choice = scan.next().charAt(0);

		      // read remaining characters, don't store (no use)
		      scan.nextLine();
		    } while (choice == 'y' || choice == 'Y');

		    // display all product with its properties
		    Item.displayFormat();
		    for (Item i : item) {
		      i.display();
		    }

		    // overall price
		    System.out.println("\nTotal Price = " + overAllPrice);

		    // close Scanner
		    scan.close();
		
		
	  }
	  
}	    
	  
	    
