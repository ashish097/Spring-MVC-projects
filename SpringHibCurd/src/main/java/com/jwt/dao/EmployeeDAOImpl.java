package com.jwt.dao;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.jwt.model.Employee;


@Repository
@Configuration
public class EmployeeDAOImpl implements EmployeeDAO {

	
	private SessionFactory sessionFactory;
	
	//private HibernateTemplate hibernateTemplate;

	/*public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/

	
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	/*	Employee custModel = new Employee(employee.getId(),employee.getName(), employee.getEmail(), employee.getAddress(),employee
				.getTelephone());
		hibernateTemplate.saveOrUpdate(custModel);*/

	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() 
	{

		return sessionFactory.getCurrentSession().createQuery("from Employee")
				.list();
		/*List<Employee> emplist =  (List<Employee>).find("from Employee");
		return emplist;
		*/
	/*	List<Employee> arr = new ArrayList<Employee2>();
		String sql = "from Employee";
		
		List<Employee> list = (List<Employee>) hibernateTemplate.find(sql);
		for (Employee employee : list) 
		{
			
			Employee emp = new Employee2(employee.getId(),employee.getName(), employee.getEmail(), employee.getAddress(),employee
					.getTelephone());
			
			arr.add(emp);
		}
		return arr;*/
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, employeeId);
		
		if (null != employee) {
			sessionFactory.getCurrentSession().delete(employee);
		}

	}

	public Employee getEmployee(int empid) {
		
			
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, empid);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
	/*	Employee emp = new Employee(employee.getId(),employee.getName(), employee.getEmail(), employee.getAddress(),employee
				.getTelephone());*/
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
		return employee;
	}


	
}