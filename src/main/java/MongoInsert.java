import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
public class MongoInsert {

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("BigC");
			DBCollection table = db.getCollection("customers");
			BasicDBObject document = new BasicDBObject();
			document.put("name", "poy");
			document.put("age", 10);
			table.insert(document);
			System.out.println("Insert successfully");
		}catch (Exception e) {
		
		}
	}

}
