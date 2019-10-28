package repository;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import enums.Situacao;

import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;

public class MongoDB {
	
	
	public void MongoInsert(String name, String cpf, Long id, String status) {
		MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongoClient = new MongoClient(connectionString); //connect with database
		MongoDatabase database = mongoClient.getDatabase("StundentsDatabase"); //Acess a database
		MongoCollection<Document> collection = database.getCollection("Students");//Acess a collection
		
		 Document doc = new Document("name", "MongoDB")
	             .append("type", "database")
	             .append("nome", name)
	             .append("cpf", cpf)
	             .append("id", id)
	             .append("method", status)
	             ;
		
			collection.insertOne(doc);
		}
		
	}

