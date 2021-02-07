import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
public class MongoUpdate {

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("BigC");
			DBCollection table = db.getCollection("customers");
			BasicDBObject query = new BasicDBObject();
			query.put("name", "Tome");
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("age", 18);
			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);
			table.update(query, updateObj);
			System.out.println("Update successfully");	
		}catch(Exception e){
		
		}
	}
}
