import java.util.*;
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
public class MongoConnectDB{
    public static void main(String[] args) {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);

            System.out.println("Connect successfully");
            
        }catch(Exception e) {
        
        }
    }
}