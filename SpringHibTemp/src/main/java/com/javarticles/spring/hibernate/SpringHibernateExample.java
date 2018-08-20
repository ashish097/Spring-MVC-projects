/*package com.javarticles.spring.hibernate;

import java.io.IOException;
import java.util.List;

import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateExample {
    private SessionFactory sessionFactory;
    public static void main(String[] args) throws MappingException, IOException {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringHibernateExample springHibernateExample = (SpringHibernateExample) context.getBean("springHibernateExample");
        springHibernateExample.execute();
    }
    
    public void execute() throws MappingException, IOException {
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            Query query = session.createQuery("from Employee where name='Joe'");
            @SuppressWarnings("unchecked")
			List<Employee> empList = query.list();
            System.out.println("Employees found: " + empList.size());
            for(Employee emp: empList) {
                session.delete(emp);
                System.out.println("Deleted " + emp);
            }
            tx.commit();
            
            System.out.println("Create new employee Joe");
            tx = session.getTransaction();
            tx.begin();
            Employee emp = new Employee();
            emp.setName("Joe");
            session.saveOrUpdate(emp);
            tx.commit();
            
            query = session.createQuery("from Employee where name='Joe'");
            System.out.println("List all employees: " + query.list());
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;

        } finally {
            session.close();
        }
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
*/