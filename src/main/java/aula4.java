import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class aula4 {

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("BancoPU");

    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        entityManager.getTransaction().begin();

        entityManager.createQuery("update Cliente c set c.nome = 'Paulinho' where c.id = :idCliente")
                .setParameter("idCliente", 3)
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
