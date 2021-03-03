import model.Cliente;
import model.Compras;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UtilizandoJPQLEhPassagemDeParametro {

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("BancoPU");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        Compras compras = new Compras();
        compras.setProduto("Arroz");
        Cliente clientePersistido = new Cliente();
        clientePersistido.setNome("Rodolfo");
        clientePersistido.setCompras(compras);

        entityManager.getTransaction().begin();
        entityManager.persist(compras);
        entityManager.persist(clientePersistido);
        entityManager.getTransaction().commit();


        String jpql = "select c from Cliente c where id = :idCliente";
        TypedQuery<Cliente> typedQuery = entityManager
                .createQuery(jpql, Cliente.class)
                .setParameter("idCliente", 1);
        List<Cliente> listaCliente = typedQuery.getResultList();

        listaCliente.forEach(cliente -> System.out.println(cliente.getNome()));

        entityManager.close();
        entityManagerFactory.close();
    }
}
