import java.util.*;
import com.mongodb.*;
public class BigC2 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		try {
			String menu;//create variable string type named "menu".
			do {
				System.out.println("********** Data Management for BigC Customer **********\nMENU\n0. Exit");//Display menu
				System.out.println("1. Showing All of Databases Name\n2. Showing All of Document of the Customer Collection");//Display menu
				System.out.println("3. Adding the Person information\n4. Editing the Person information\n5. Removing the Person information");//Display menu
				System.out.print("\nInput menu number: ");					//Display "Input menu number:"
				MongoClient mongo =new MongoClient("localhost",27017);		//Create object named "mongo" for connect to the databases.
				DB db = mongo.getDB("bigc");								//Create a variable DB type named "db" and assign it to the "bigc" database.
				DBCollection table = db.getCollection("customer");			//Create a variable DBCollection type named "table" and assign it to the "customer" collection.
				menu=kb.next(); 											//Take input from user.
				DBCursor cursor = table.find();								//create a variable DBCursor type from DBCursor class and assign it to a cursor that will iterate over every object.
				switch(menu) {												//use switch case instead if-else statement.
				case "0"://if menu = 0 .
					System.out.println("\n********** Exit *************\nThank you for Data Managing\nGoodbye\n\n");//print interface.
					break;													//break.
				case "1":													//if menu = 1.
					System.out.println("\n********** Show All of Databases Name *************");//print interface.
					List<String> dbs = mongo.getDatabaseNames();			//create List string type named "dbs" and assign it to database name from method .getDatabaseNames()
					int i=0;												//create a variable int type named "i" and assign it to 0 for count and display databases sequence.
					for(String DB : dbs) {									//create for loop to display database name.
						i++;												//i=i+1
						System.out.println(i+". "+DB);						//print databases sequence and database name.
					}System.out.println("\n");								//Leave 2 lines by using println and \n
					break;													//break;
				case "2":													//if menu=2
					System.out.println("\n********* Showing All of Document of the Customer Collection ********");//print interface.
					int o=0;												//create a variable int type named "o" and assign it to 0
					while(cursor.hasNext()) {								//create loop while cursor.hasNext() are return true.
						cursor.next();										//moves the cursor ahead by one.
						o++;												//o=o+1
						if(cursor.hasNext()) {								//Checks if there is another object available. 
							System.out.println(o+". Name: "+cursor.curr().get("name")+"\n   Age: "+cursor.curr().get("age")+"\n-----------------------------------------");
							//print sequence of the document and the information in it includes name and age. And print "-----------------------------------------" and Leave 1 line.
						}else {
							System.out.println(o+". Name: "+cursor.curr().get("name")+"\n   Age: "+cursor.curr().get("age"));
							//print sequence of the document and the information in it includes name and age.
						}
					}System.out.println("\n");								//Leave 2 lines by using println and \n
					break;													//break;
				case "3":
					System.out.println("\n************ Adding the Person information ************************");
					BasicDBObject document = new BasicDBObject();
					System.out.print("Name: ");
					document.put("name", kb.next());
					System.out.print("Age: ");
					document.put("age", kb.nextInt());
					table.insert(document);
					System.out.println("****** Adding successfully ******");
					o=0;													//create a variable int type named "o" and assign it to 0
					while(cursor.hasNext()) {								//create loop while cursor.hasNext() are return true.
						cursor.next();										//moves the cursor ahead by one.
						o++;												//o=o+1
						if(cursor.hasNext()) {								//Checks if there is another object available. 
							System.out.println(o+". Name: "+cursor.curr().get("name")+"\n   Age: "+cursor.curr().get("age")+"\n-----------------------------------------");
							//print sequence of the document and the information in it includes name and age. And print "-----------------------------------------" and Leave 1 line.
						}else {
							System.out.println(o+". Name: "+cursor.curr().get("name")+"\n   Age: "+cursor.curr().get("age"));
							//print sequence of the document and the information in it includes name and age.
						}
					}System.out.println("\n");
					break;
				case "4":
					System.out.println("\n************ Editing the Person information *************************\n\n");
					break;
				case "5":
					System.out.println("\n************ Removing the Person information *************************\n\n");
					break;
				default:
					System.out.println("\nYour input are mismatch, please enter the correct number.\n\n");
				}
			}while(!menu.equals("0"));
			
		}catch(Exception e) {
			
		}

	}

}