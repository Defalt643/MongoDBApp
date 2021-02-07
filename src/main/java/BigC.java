import java.util.*;
import com.mongodb.*;
public class BigC {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String menu;
		try {
			do {
				System.out.println("********** Data Management for BigC Customer **********\nMENU\n0. Exit");
				System.out.println("1. Showing All of Databases Name\n2. Showing All of Document of the Customer Collection");
				System.out.println("3. Adding the Person information\n4. Editing the Person information\n5. Removing the Person information");
				MongoClient mongo =new MongoClient("localhost",27017);
				DB db = mongo.getDB("BigC");
				DBCollection table = db.getCollection("customer");
				System.out.print("Input Number: ");
				menu=kb.next();
				switch(menu) {
				case "0":
					System.out.println("\n\n********** Exit *************\nThank you for Data Managing\nGoodbye");
					break;
				case "1":
					System.out.println("\n\n********** Show All of Databases Name *************");
					List<String> dbs = mongo.getDatabaseNames();
					int i=0;
					for(String DB : dbs) {
						i++;
						System.out.println(i+". "+DB);
					}
					System.out.println("\n");
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
					System.out.println("\n\n************ Adding the Person information ************************");
					BasicDBObject document = new BasicDBObject();
					System.out.print("Name : ");
					document.put("name", kb.next());
					System.out.print("Age : ");
					document.put("age", kb.nextInt());
					table.insert(document);
					System.out.println("Add successfully\n\n");
					break;
				case "4":
					System.out.println("\n\n************ Editing the Person information *************************");
					BasicDBObject query = new BasicDBObject();
					BasicDBObject newDocument = new BasicDBObject();
					BasicDBObject updateObj = new BasicDBObject();
					System.out.print("Name : ");
					query.put("name", kb.next());
					System.out.print("*** Edit information ***\nName : ");
					newDocument.put("name", kb.next());
					System.out.print("Age : ");
					newDocument.put("age", kb.nextInt());
					updateObj.put("$set", newDocument);
					table.update(query, updateObj);
					System.out.println("Edit successfully\n\n");
					break;
				case "5":
					System.out.println("\n\n************ Removing the Person information *************************");
					BasicDBObject searchQuery = new BasicDBObject();
					System.out.print("Name : ");
					searchQuery.put("name", kb.next());
					table.remove(searchQuery);
					System.out.println("Remove successfully\n\n");
					break;
				default:
					System.out.println("\n\nYour input are mismatch please enter the correct number");
				}
			}while(!menu.equals("0"));
		}catch(Exception e) {
			System.out.println("Error");
		}

	}

}
