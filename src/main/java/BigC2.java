import java.net.UnknownHostException;
import java.util.*;
import com.mongodb.*;
public class BigC2 {
	public static void DisplayDocumentWithPassword() throws UnknownHostException {
		MongoClient mongo =new MongoClient("localhost",27017);
		DB db = mongo.getDB("bigc");
		DBCollection table = db.getCollection("customer");
		DBCursor cursor = table.find();							//create a variable DBCursor type from DBCursor class and assign it to a cursor that will iterate over every object.
		int o=0;									//create a variable int type named "o" and assign it to 0
		while(cursor.hasNext()) {							//create loop while cursor.hasNext() are return true.
			cursor.next();								//moves the cursor ahead by one.
			o++;									//o=o+1
			if(cursor.hasNext()) {							//Checks if there is another object available. 
				System.out.println(o+". Name: "+cursor.curr().get("name")+"\n   Age: "+cursor.curr().get("age")+"\n   Password: "+cursor.curr().get("password")+"\n-----------------------------------------");
				//print sequence of the document and the information in it includes name and age and password. And print "-----------------------------------------" and Leave 1 line.
			}else {
				System.out.println(o+". Name: "+cursor.curr().get("name")+"\n   Age: "+cursor.curr().get("age")+"\n   Password: "+cursor.curr().get("password")+"\n\n");
				//print sequence of the document and the information in it includes name and age and password.And leave 2 lines by using and \n\n.
			}
		}
	}public static void DisplayDocument() throws UnknownHostException {
		MongoClient mongo =new MongoClient("localhost",27017);
		DB db = mongo.getDB("bigc");
		DBCollection table = db.getCollection("customer");
		DBCursor cursor = table.find();							//create a variable DBCursor type from DBCursor class and assign it to a cursor that will iterate over every object.
		int o=0;									//create a variable int type named "o" and assign it to 0
		while(cursor.hasNext()) {							//create loop while cursor.hasNext() are return true.
			cursor.next();								//moves the cursor ahead by one.
			o++;									//o=o+1
			if(cursor.hasNext()) {							//Checks if there is another object available. 
				System.out.println(o+". Name: "+cursor.curr().get("name")+"\n   Age: "+cursor.curr().get("age")+"\n-----------------------------------------");
				//print sequence of the document and the information in it includes name and age. And print "-----------------------------------------" and Leave 1 line.
			}else {
				System.out.println(o+". Name: "+cursor.curr().get("name")+"\n   Age: "+cursor.curr().get("age")+"\n\n");
				//print sequence of the document and the information in it includes name and age.And leave 2 lines by using and \n\n.
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		boolean login=false;
		try {
			String menu,login_name = null;//create variable string type named "menu" and "login_name" to store name of user who logged in.
			do {
				MongoClient mongo =new MongoClient("localhost",27017);		//Create object named "mongo" for connect to the databases.
				DB db = mongo.getDB("bigc");					//Create a variable DB type named "db" and assign it to the "bigc" database.
				DBCollection table = db.getCollection("customer");		//Create a variable DBCollection type named "table" and assign it to the "customer" collection.
				while(true) {
					if(login==true) {
						break;
					}System.out.println("*** Data Management for BigC Customer ***");
					System.out.print("******* Login ******\nUser: ");
					String user=kb.next();
					System.out.print("Password: ");
					String password=kb.next();
					BasicDBObject query = new BasicDBObject();
					query.put("name", user);
					query.put("password", password);
					DBCursor cursor = table.find(query);
					if(cursor.hasNext()) {
						login=true;
						login_name=user;
						break;
					}else {
						System.out.println("Login failed.\nIncorrect information, please you input tried again");
					}
				}
				System.out.println("Login Successfully, Welcome "+login_name+"!!");
				System.out.println("   ********** Data Management for BigC Customer *************\n   MENU\n0. Exit");
				System.out.println("1. Showing All of Databases Name\n2. Showing All of Document of the Customer Collection");//Display menu
				System.out.println("3. Adding the Person information\n4. Editing the Person information\n5. Removing the Person information");//Display menu
				System.out.print("\nInput menu number: ");				//Display "Input menu number:"
				menu=kb.next(); 							//Take input from user.
				switch(menu) {								//use switch case instead if-else statement.
				case "0"://if menu = 0 .
					System.out.println("\n********** Exit *************\nThank you for Data Managing\nGoodbye\n\n");//print interface.
					break;								//break.
				case "1":								//if menu = 1.
					System.out.println("\n********** Show All of Databases Name *************");//print interface.
					List<String> dbs = mongo.getDatabaseNames();			//create List string type named "dbs" and assign it to database name from method .getDatabaseNames()
					int i=0;							//create a variable int type named "i" and assign it to 0 for count and display databases sequence.
					for(String DB : dbs) {						//create for loop to display database name.
						i++;							//i=i+1
						System.out.println(i+". "+DB);				//print databases sequence and database name.
					}System.out.println("\n");					//Leave 2 lines by using println and \n
					break;								//break;
				case "2":								//if menu=2
					System.out.println("\n********* Showing All of Document of the Customer Collection ********");//print interface.
					DisplayDocument();
					break;								//break;
				case "3":
					System.out.println("\n************ Adding the Person information ************************");
					BasicDBObject document = new BasicDBObject();
					System.out.print("Name: ");
					document.put("name", kb.next());
					System.out.print("Age: ");
					document.put("age", kb.nextInt());
					System.out.print("Password: ");
					document.put("password", kb.next());
					table.insert(document);
					System.out.println("****** Adding successfully ******");
					DisplayDocumentWithPassword();
					break;
				case "4":
					System.out.println("\n\n************ Editing the Person information *************************");
					BasicDBObject query = new BasicDBObject();
					BasicDBObject newDocument = new BasicDBObject();
					BasicDBObject updateObj = new BasicDBObject();
					while(true) {
						System.out.print("Data finding (Name):");
						String name=kb.next();
						query.put("name", name);
						DBCursor cursor = table.find(query);
						if(cursor.hasNext()) {
							System.out.print("**Old data:**\nName:"+cursor.next().get("name")+"\nAge:"+cursor.curr().get("age")+"\nPassword:"+cursor.curr().get("password"));
							System.out.print("\n**New data:**\nName:");
							newDocument.put("name", kb.next());
							System.out.print("Age:");
							newDocument.put("age", kb.nextInt());
							System.out.print("Password:");
							newDocument.put("password", kb.next());
							updateObj.put("$set", newDocument);
							table.update(query, updateObj);
							System.out.println("****** Editing Data Successfully ******");
							DisplayDocumentWithPassword();
							break;
						}else {
							System.out.println("\""+name+"\" Not found in database.");
						}
					}
					break;
				case "5":
					System.out.println("\n************ Removing the Person information *************************");
					while(true) {
						BasicDBObject Searchquery = new BasicDBObject();
						System.out.print("Data finding (Name):");
						String name=kb.next();
						Searchquery.put("name", name);
						DBCursor cursor = table.find(Searchquery);
						if(cursor.hasNext()) {
							System.out.println("**Remove Data:**");
							System.out.println("Name:"+cursor.next().get("name")+"\nAge:"+cursor.curr().get("age"));
							while(true) {
								System.out.print("Are you sure (Y/N):");
								char check = kb.next().charAt(0);
								if(check=='Y') {
									Searchquery.put("age", cursor.curr().get("age"));
									table.remove(Searchquery);
									System.out.println("****** Remove Successfully ******");
									DisplayDocument();
									break;
								}else if(check=='N') {
									System.out.println("****** Remove Cancel ******");
									DisplayDocument();
									break;
								}else {
									System.out.println("Incorrect information, please you input tried again");
									continue;
								}
							}
						}else {
							System.out.println("Incorrect information, please you input tried again");
							continue;
						}
						break;
					}break;

				default:
					System.out.println("\nYour input are mismatch, please enter the correct number.\n\n");
				}
			}while(!menu.equals("0"));
			
		}catch(Exception e) {
			System.out.println("Connection lost.(ERROR:42)");
		}

	}

}
