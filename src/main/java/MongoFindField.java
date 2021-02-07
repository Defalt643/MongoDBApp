import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
public class MongoFindField {

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("BigC");
			DBCollection table = db.getCollection("customers");
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", "Joe");
			DBCursor cursor = table.find(searchQuery);
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		}catch (Exception e) {
		
		}
	}
}
