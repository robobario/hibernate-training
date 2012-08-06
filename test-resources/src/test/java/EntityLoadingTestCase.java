import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

import java.util.Collection;

public class EntityLoadingTestCase {

    protected SessionFactory sessionFactory;
    private Collection<Class> classes;
    private Transaction tx;
    protected Session session;

    public EntityLoadingTestCase(Collection<Class> classes){
        this.classes = classes;
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:test");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        configuration.setProperty("hibernate.show_sql","true");
        for (Class<?> clazz : classes) {
            configuration.addAnnotatedClass(clazz);
        }
        sessionFactory = configuration.buildSessionFactory();
    }

    @Before
    public void setUp(){
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

    @After
    public void rollback(){
        tx.rollback();
        session.close();
    }
}
