import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public Main() {
        SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
        sessionFactory.close();
    }

    public static void main(String[] args) {
        new Main();
    }
}
