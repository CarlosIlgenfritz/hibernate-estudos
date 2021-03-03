import model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class aula2 {

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("BancoPU");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        /*String jpql = "select c from Cliente c";
        TypedQuery<Cliente> typedQuery = entityManager.createQuery(jpql, Cliente.class);
        List<Cliente> listaCliente = typedQuery.getResultList();

        listaCliente.forEach(cliente -> System.out.println(cliente.getNome()));*/

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
