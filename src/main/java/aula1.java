import model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class aula1 {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("BancoPU");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        //Find

        entityManager.getTransaction().begin();

        Cliente cliente = entityManager.find(Cliente.class, 8);

        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Nome " + cliente.getNome() + "Compra" + cliente.getCompras().getProduto());


        //Insert
        /*Cliente cliente1 = new Cliente();
        cliente1.setNome("Rodolfo");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente1);
        entityManager.getTransaction().commit();*/

        //Delete
        /*Cliente cliente = entityManager.find(Cliente.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();*/

        //Modify
        /*Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Paulo");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();*/

    }
}
