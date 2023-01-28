package studendhibernet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDBManager {
	public static void main(String[] args) {
//		onetoonesave();
		onetomanysave();
	}

	private static void onetomanysave() {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Student student=new Student();
		student.setName("manyuser1");
		
		Department department=new Department();
		department.setName("Computer Science");
		
		student.setDeparment(department);
		
		session.save(department);
		session.save(student);
		
		
		transaction.commit();
		session.close();
	}

	private static void onetoonesave() {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();

		Address address=new Address();
		address.setCity("Addis");
		address.setSubcity("bole");
		
		Student student=new Student();
		student.setName("user1");
		student.setAddress(address);
		
		session.save(address);
		session.save(student);
		
		transaction.commit();
		session.close();
	}
	static Session getSession(){
		Configuration cnfg=new Configuration();
		cnfg.configure("hibernate.cfg.xml");
		
		Session session=cnfg.buildSessionFactory().openSession();	
		return session;
	}
}
