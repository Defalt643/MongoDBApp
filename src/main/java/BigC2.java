import java.util.*;

import com.mongodb.*;
public class BigC2 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		try {
			String menu;
			do {
				System.out.println("********** Data Management for bigc Customer **********\nMENU\n0. Exit");
				System.out.println("1. Showing All of Databases Name\n2. Showing All of Document of the customer Collection");
				System.out.println("3. Adding the Person information\n4. Editing the Person information\n5. Removing the Person information");
				System.out.print("\nInput Number: ");
				MongoClient mongo =new MongoClient("localhost",27017);
				DB db = mongo.getDB("bigc");
				DBCollection table = db.getCollection("customer");
				menu=kb.next();
				switch(menu) {
				case "0":
					System.out.println("\n\n********** Exit *************\nThank you for Data Managing\nGoodbye\n\n");
					break;
				case "1":
					System.out.println("\n\n********** Show All of Databases Name *************");
					List<String> dbs = mongo.getDatabaseNames();
					int i=0;
					for(String DB : dbs) {
						i++;
						System.out.println(i+". "+DB);
					}System.out.println("\n");
					break;
				case "2":
					System.out.println("\n\n********* Showing All of Document of the Customer Collection ********");
					DBCursor cursor = table.find();
					DBCursor cursor2 = table.find();
					while(cursor.hasNext()) {
						System.out.println("Name: "+cursor.next().get("name")+"\nAge:"+cursor2.next().get("age")+"\n-----------------------------------------");
					}System.out.println("\n");
					break;
				case "3":
					System.out.println("\n\n************ Adding the Person information ************************\n\n");
					break;
				case "4":
					System.out.println("\n\n************ Editing the Person information *************************\n\n");
					break;
				case "5":
					System.out.println("\n\n************ Removing the Person information *************************\n\n");
					break;
				default:
					System.out.println("\n\nYour input are mismatch, please enter the correct number.\n\n");
				}
			}while(!menu.equals("0"));
			
		}catch(Exception e) {
			
		}

	}

}
