package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		//instanciando um objeto do TIPO PESSOA... Ou seja estamos chamando a CLASSE
		//Pessoa e passando alguns valores para os ATRIBUTOS/VARIAVEIS ID, NOME, EMAIL
		//e chamando esse OBJETO do tipo PESSOA de P1...	P2 e P3 tbm s�o
			//OBS: o ID � NULL pq o BANCO q vai DEFINIR o valor e nao nos...
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		//criando um OBJETO chamado EMF que � um OBJETO do tipo ENTITYMANAGERFACTORY
		//e para ele nos vamos chamar o METODO CreateEntityManagerFactory e passar o valor
		//EXEMPLO-JPA... Pois � o NOME/APELIDO q foi dado para a CONEXAO ao BANCO, q esta 
		//no arquivo PERSISTENCE.XML dentro de "src/main/resources"/META-INF
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
			//o ENTITYMANAGER serve para fazer as ALTERA�OES no 
			//BANCO... ADD, LER, EDIT, REMOVE, etc...
		EntityManager em = emf.createEntityManager();
		
		//inciando uma TRANSACAO com o BANCO
		em.getTransaction().begin();		
		//SALVANDO os OBJ do tipo PESSOA feito acima no BANCO
		//para isso vamos CHAMAR o ENTITYMANAGER (EM) e com o METODO PERSIST vamos passar
		//o OBJETO q queremos salvar no caso P1, P2 e P3
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		//
		//finalizando a transacao e salvando as altera��es... no CASO salvando os valores
		//q foram add no banco
		em.getTransaction().commit();

		System.out.print("pronto");
	}

}
