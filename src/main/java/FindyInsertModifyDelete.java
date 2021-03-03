import model.Cliente;
import model.Compras;
import model.DadosPessoais;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindyInsertModifyDelete {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("BancoPU");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        //Insert
        Compras compras = new Compras();
        compras.setProduto("Arroz");


        DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setSexo('M');
        dadosPessoais.setIdade(20);

        Cliente cliente = new Cliente();
        cliente.setNome("Rodolfo");
        cliente.setCompras(compras);
        cliente.setDadosPessoais(dadosPessoais);

        entityManager.getTransaction().begin();
        entityManager.persist(compras);
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();


        //Find

        entityManager.getTransaction().begin();

        Cliente clienteProcurado = entityManager.find(Cliente.class, 1);

        entityManager.getTransaction().commit();
        System.out.println("Nome: " + clienteProcurado.getNome() + " Compra: " + clienteProcurado.getCompras().getProduto());
        System.out.println("Idade: " + clienteProcurado.getDadosPessoais().getIdade() + " Sexo: " + clienteProcurado.getDadosPessoais().getSexo());

        //Modify
        Cliente clienteModfiicado = entityManager.find(Cliente.class, 1);
        cliente.setNome("Paulo");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        //Delete
        Cliente clienteInserido = new Cliente();
        clienteInserido.setNome("Pedro");
        Cliente clienteDeletado = entityManager.find(Cliente.class, 1);

        entityManager.getTransaction().begin();
        entityManager.persist(clienteInserido);
        entityManager.remove(clienteDeletado);
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
