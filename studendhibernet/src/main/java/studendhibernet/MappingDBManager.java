package studendhibernet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDBManager {
	public static void main(String[] args) {
//		onetoonesave();
//		onetomanysave();
		
//		manytomanysave();
//		onetoonefetch();
		
//		onetooneupdate();
//		onetoonedelete();
		
//		onetomanyfetch();
//		onetomanydelete();
	}

	private static void onetomanydelete() {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();	
		
		Department departmentdelete=session.get(Department.class, 1);
		session.delete(departmentdelete);
		
		transaction.commit();
		session.close();
	}

	private static void onetomanyfetch() {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		
		Department department=session.get(Department.class, 1);
		
		System.out.println("Name: "+department.getName());
		System.out.println("Students in department: "+department.getName()+" is "+department.getStudents().size());
		
		for(Student student:department.getStudents()) {
			System.out.println("Student name: "+student.getName());
		}
		transaction.commit();
		session.close();
	}


	private static void onetoonedelete() {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		
		Student student=session.get(Student.class, 1);
		
		session.delete(student);
		
		transaction.commit();
		session.close();
	}

	private static void onetooneupdate() {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		
		Student student=session.get(Student.class, 1);
		
		Address address=new Address();
		address.setCity("AA");
		address.setSubcity("Yeka");
		
		session.save(address);
		student.setAddress(address);
		
		
		transaction.commit();
		session.close();
	}

	private static void onetoonefetch() {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		
		Student stdents=session.get(Student.class, 5);
		System.out.println("Name: "+stdents.getName());
		System.out.println("Address: "+stdents.getAddress().getCity());
		
		transaction.commit();
		session.close();
	}

	private static void manytomanysave() {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		
		Student student=new Student();
		student.setName("manytomanyOne");
		
		Student student1=new Student();
		student1.setName("manytomanyTwo");
		
		Student student2=new Student();
		student2.setName("manytomanyThree");
		
		Project project1=new Project();
		project1.setTitle("CUSTOME-PROJECT");
		
		Project project2=new Project();
		project2.setTitle("CUSTOME-PROJECT-TOW");
		
		student.getProjects().add(project1);
		project1.getStudents().add(student);
		
		student.getProjects().add(project2);
		project2.getStudents().add(student);
		
		student1.getProjects().add(project2);
		project2.getStudents().add(student1);
		
		session.save(student);
		session.save(student1);
		session.save(student2);
		
		session.save(project1);
		session.save(project2);
		
		transaction.commit();
		session.close();
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
