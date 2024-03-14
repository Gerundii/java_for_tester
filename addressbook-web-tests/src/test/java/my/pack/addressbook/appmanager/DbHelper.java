package my.pack.addressbook.appmanager;

import my.pack.addressbook.model.ContactData;
import my.pack.addressbook.model.GroupData;
import my.pack.addressbook.model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

import static java.lang.System.out;

public class DbHelper {
    private final SessionFactory sessionFactory;

    public DbHelper() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
        sessionFactory = new MetadataSources(registry)
                //.addAnnotatedClass(ContactData.class)
                .addAnnotatedClasses(ContactData.class, GroupData.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    public Groups groups () {
        /*sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from GroupData", GroupData.class)
                    .getResultList()
                    .forEach(group -> out.println(group));
        });*/
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData> result = session.createQuery("from GroupData", GroupData.class).list();
        session.getTransaction().commit();
        session.close();
        return new Groups(result);
    }
}
