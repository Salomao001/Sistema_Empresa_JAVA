package poo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import poo.models.Departamento;
import poo.models.Projeto;
import poo.models.Empresa;

import java.util.Collections;
import java.util.List;

public class ProjetoDAO {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void close() {
        sessionFactory.close();
    }

    public void salvarProjeto(Projeto projeto) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(projeto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Departamento getDepartamento(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Departamento.class, id);
        }
    }

    public List<Projeto> getAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT DISTINCT projeto FROM Projeto projeto LEFT JOIN FETCH projeto.funcionarios";
            Query<Projeto> query = session.createQuery(hql, Projeto.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Projeto getProjetoById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Projeto.class, id);
        }
    }

    public void atualizarProjeto(Projeto projeto) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(projeto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deletarProjeto(Projeto projeto) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(projeto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
