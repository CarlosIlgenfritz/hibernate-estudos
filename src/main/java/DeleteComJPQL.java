import model.Cliente;
import model.Compras;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;

public class DeleteComJPQL {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("BancoPU");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        Compras compras = new Compras();
        compras.setProduto("Arroz");
        Cliente cliente = new Cliente();
        cliente.setNome("Rodolfo");
        cliente.setCompras(compras);

        entityManager.getTransaction().begin();
        entityManager.persist(compras);
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();

        entityManager.createQuery("delete from Cliente c where id = :idCliente")
                .setParameter("idCliente", 1)
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
