package my.pack.addressbook.tests;

import my.pack.addressbook.model.ContactData;
import my.pack.addressbook.model.GroupData;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.System.out;

public class HBConnectionTest {
    private SessionFactory sessionFactory;

    @BeforeClass
    protected void setUp() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .build();
        try {
            sessionFactory =
                    new MetadataSources(registry)
                            .addAnnotatedClasses(ContactData.class, GroupData.class)
                            .buildMetadata()
                            .buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we
            // had trouble building the SessionFactory so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    @Test
    public void testHBConnection() {
        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from ContactData where deprecated is null", ContactData.class) // from ContactData where YEAR(deprecated) = 0000
                    .getResultList()
                    .forEach(contact ->
                    {out.println(contact);
                    out.println(contact.getGroups());});
        });

    }
}
