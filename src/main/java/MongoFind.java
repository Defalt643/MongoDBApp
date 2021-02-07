import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
public class MongoFind {

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("BigC");
			DBCollection table = db.getCollection("customer");
			DBCursor cursor = table.find();
			while (cursor.hasNext()) {
			System.out.println(cursor.next());
			}
		}catch(Exception e) {
		
		}
	}
}
