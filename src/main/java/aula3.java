import model.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.List;

public class aula3 {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("BancoPU");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        entityManager.getTransaction().begin();

        entityManager.createQuery("delete from Cliente c where id = :idCliente")
                .setParameter("idCliente", 1)
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
