package poo.DAO;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import poo.models.Departamento;
import poo.models.Empresa;

import java.util.Collections;
import java.util.List;

public class DepartamentoDAO {
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

    public void salvarDepartamento(Departamento departamento) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(departamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Empresa getEmpresa(int id) {
        try (Session session = sessionFactory.openSession()) {
           return session.get(Empresa.class, id);
        }
    }

    public List<Departamento> getAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT DISTINCT d FROM Departamento d " +
                    "LEFT JOIN FETCH d.funcionarios f ";
            Query<Departamento> query = session.createQuery(hql, Departamento.class);
            List<Departamento> departamentos = query.list();

            // Carregar manualmente a segunda coleção (projetos) para cada departamento
            for (Departamento departamento : departamentos) {
                Hibernate.initialize(departamento.getProjetos());
            }

            return departamentos;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    /*public List<Departamento> getAllProjects() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT DISTINCT departamento FROM Departamento departamento LEFT JOIN FETCH departamento.projetos";
            Query<Departamento> query = session.createQuery(hql, Departamento.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }*/

    public Departamento getDepartamentoById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Departamento.class, id);
        }
    }

    public void atualizarDepartamento(Departamento departamento) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(departamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deletarDepartamento(Departamento departamento) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(departamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
