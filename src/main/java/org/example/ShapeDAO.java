package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ShapeDAO {
    private Session session;

    public ShapeDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public void saveColor(Color color) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(color);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void save(Shape shape) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(shape);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Shape> findAll() {
        return session.createQuery("from Shape s where type(s) in (Rectangle, Triangle)", Shape.class).list();
    }

    public void close() {
        if (session != null) {
            session.close();
        }
    }
}
