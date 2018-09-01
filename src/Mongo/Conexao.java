package Mongo;

import java.net.UnknownHostException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class Conexao {
	
	DB BaseDeDados;
	DBCollection Colecao;
	BasicDBObject Document = new BasicDBObject();
	
	@SuppressWarnings("deprecation")
	public Conexao() throws UnknownHostException {
		
		Mongo mongo = new Mongo ("localhost",27017);
		BaseDeDados = mongo.getDB("pets");
		Colecao = BaseDeDados.getCollection("animal");
		System.out.println("Conexão realizada com sucesso");
	}
	
	public boolean inserir(String gato) {
		Document.put("nome", gato);
		Colecao.insert(Document);
		return true;
	}
	
	public void mostrar() {
		DBCursor cursor = Colecao.find();
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
	
	public boolean atualizar(String antigo, String novo) {
		Document.put("nome", antigo);
		BasicDBObject Novo = new BasicDBObject();
		Novo.put("nome", novo);
		Colecao.findAndModify(Document, Novo);
		return true;
	}
	
	public boolean remover(String dado) {
		Document.put("nome", dado);
		Colecao.remove(Document);
		return true;
	}
	
}
