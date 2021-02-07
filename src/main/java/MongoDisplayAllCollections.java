import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;
import com.mongodb.MongoException;
import java.util.List;
import java.util.Set;
public class MongoDisplayAllCollections{
	public static void main(String [ ] args) {
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("BigC");
			Set<String> tables = db.getCollectionNames();
			for(String coll : tables){
				System.out.println(coll);
				}
			}catch (Exception e) {
		}
	}
}