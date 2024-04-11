package com.hibernate.HibernateHQLExamples;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
        Configuration con=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        
       /* Random r=new Random();
        
        for(int i=0;i<=50;i++) {
        	Student stu=new Student();
        	stu.setRollno(i);
        	stu.setName("Name "+ i);
        	stu.setMarks(r.nextInt(100));
        	session.save(stu);
        }*/
        
        /*Query q=session.createQuery("from Student where rollno=8");
        Student student=(Student) q.uniqueResult();
        System.out.println(student);*/
        //print only one value
        
        
        //Query q=session.createQuery("from Student");//print all the student records
        
        /*Query q=session.createQuery("from Student where marks > 50");//print student marks greater than 50
        List<Student> s=q.list();
        for(Student st:s) {
        	System.out.println(st);
        }*/
        
        Query q=session.createQuery("select rollno,name,marks from Student where rollno=8");
        Object[] student=(Object[]) q.uniqueResult();
        for(Object o:student) {
        	System.out.println(o);
        }
        
        
        
        session.getTransaction().commit();
        session.close();
        sf.close();
        }
}
