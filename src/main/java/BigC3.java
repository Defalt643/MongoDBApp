import java.util.*;
import com.mongodb.*;
public class BigC3 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String menu;
		try {
			do {
				System.out.println("********** Data Management for BigC Customer **********\nMENU\n0. Exit");
				System.out.println("1. Showing All of Databases Name\n2. Showing All of Document of the Customer Collection");
				System.out.println("3. Adding the Person information\n4. Editing the Person information\n5. Removing the Person information");
				MongoClient mongo =new MongoClient("localhost",27017);
				DB db = mongo.getDB("bigc");
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
					while(cursor.hasNext()) {
						cursor.next();
						if(cursor.hasNext()) {
							System.out.println("Name: "+cursor.curr().get("name")+"\nAge:"+cursor.curr().get("age")+"\n-----------------------------------------");
						}else {
							System.out.println("Name: "+cursor.curr().get("name")+"\nAge:"+cursor.curr().get("age"));
						}
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
					String name=kb.next();
					query.put("name", name);
					DBCursor cursor3 = table.find();
					boolean found=false;
					for(int j=0;j<cursor3.count();j++) {
						if(cursor3.next().get("name").equals(name)) {
							found=true;
						}
					}
					if(found==true) {
						System.out.print("*** Edit information ***\nName : ");
						newDocument.put("name", kb.next());
						System.out.print("Age : ");
						newDocument.put("age", kb.nextInt());
						updateObj.put("$set", newDocument);
						table.update(query, updateObj);
						System.out.println("Edit successfully\n\n");
					}else {
						System.out.println("\""+name+"\" Not found in database.\n\n");
					}
					break;
				case "5":
					System.out.println("\n\n************ Removing the Person information *************************");
					BasicDBObject searchQuery = new BasicDBObject();
					System.out.print("Name : ");
					name=kb.next();
					searchQuery.put("name", name);
					DBCursor cursor4 = table.find();
					boolean found2=false;
					for(int j=0;j<cursor4.count();j++) {
						if(cursor4.next().get("name").equals(name)) {
							found2=true;
						}
					}if(found2==true) {
						table.remove(searchQuery);
						System.out.println("Remove successfully\n\n");
					}else {
						System.out.println("\""+name+"\" Not found in database.\n\n");
					}
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
