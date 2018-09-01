package Mongo;

import java.net.UnknownHostException;

public class Testador {

	public static void main(String[] args) throws UnknownHostException {
		
		Conexao conexao = new Conexao();
		conexao.inserir("Kiko");
		//conexao.remover("Kiko");
		conexao.mostrar();
		
	}

}
