package poo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import poo.models.Departamento;
import poo.models.Funcionario;
import poo.models.Projeto;

import java.util.Collections;
import java.util.List;

public class FuncionarioDAO {
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

    public void salvarFuncionario(Funcionario funcionario) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(funcionario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Funcionario> getAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Funcionario";
            Query<Funcionario> query = session.createQuery(hql, Funcionario.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Funcionario getFuncionarioById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Funcionario.class, id);
        }
    }

    public Departamento getDepartamento(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Departamento.class, id);
        }
    }

    public Projeto getProjeto(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Projeto.class, id);
        }
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(funcionario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    public void deletarFuncionario(Funcionario funcionario) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(funcionario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
