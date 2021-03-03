import model.Cliente;
import model.Compras;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateComJPQLEhPassagemDeParametro {

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

        entityManager.createQuery("update Cliente c set c.nome = 'Paulinho' where c.id = :idCliente")
                .setParameter("idCliente", 1)
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
