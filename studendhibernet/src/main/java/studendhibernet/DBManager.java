package studendhibernet;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBManager {
public static void main(String[] args) {
	
	// Insert and Display
//	System.out.print("working");
	Student student=new Student();
	student.setName("update");
//	
//	saveStudent(student);
//	List<Student> studentlist=getAllStudent();
//	
//	for(Student st:studentlist) {
//		System.out.println("Name"+st.getId()+" "+st.getName());
//	}
//	delete(3);
	update(1,student);
	System.out.print("Done");
}

private static void update(int i, Student student) {
	Session session=getSession();
	Transaction transaction=session.beginTransaction();
	
	Student studentFound=(Student)session.createQuery("FROM Student WHERE id="+i).getSingleResult();
	studentFound.setName(student.getName());
	transaction.commit();
	session.close();
}

private static void delete(int i) {
	Session session=getSession();
	Transaction transaction=session.beginTransaction();
	
	Query query=session.createQuery("DELETE FROM Student WHERE id=:studentId");
	query.setParameter("studentId", i);
	int rows=query.executeUpdate();
	
	transaction.commit();
	session.close();
}
private static List<Student> getAllStudent() {
	Session session=getSession();
	Transaction transaction=session.beginTransaction();
	//CRUD
	List<Student> students=session.createQuery("FROM Student").list();
	
	transaction.commit();
	session.close();
	return students;
}
private static void saveStudent(Student student) {
	Session session=getSession();
	Transaction transaction=session.beginTransaction();
	//CRUD
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
