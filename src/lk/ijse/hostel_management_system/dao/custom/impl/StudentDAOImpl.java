package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.custom.StudentDAO;
import lk.ijse.hostel_management_system.entity.Student;
import lk.ijse.hostel_management_system.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;


public class StudentDAOImpl implements StudentDAO {
    public boolean add(Student student) {
        System.out.println(student.getId());
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            System.out.println(student.getId());
            session.save(student);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            transaction.rollback();
            session.close();
            return false;
        }
    }

    public ArrayList<Student> getData() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String sql = "SELECT * FROM Student ORDER BY CAST(SUBSTRING(id, 2) AS UNSIGNED)";
        NativeQuery sqlQuery = session.createSQLQuery(sql);

        sqlQuery.addEntity(Student.class);

        List <Student> studentList = sqlQuery.list();
        ArrayList<Student> studentData = new ArrayList<>();

        for(Student student : studentList){
            studentData.add(student);
        }

        return studentData;
    }

    public boolean delete(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Student student = session.load(Student.class, id);
            session.delete(student);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            return false;
        }
    }

    public String getCurrentID(){
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

       // session.createQuery("FROM employee ORDER BY CAST(SUBSTRING(EmpID, 2) AS UNSIGNED) DESC LIMIT 1");
      try{
          String sql = "SELECT * FROM Student ORDER BY CAST(SUBSTRING(id, 2) AS UNSIGNED) DESC LIMIT 1";
          NativeQuery sqlQuery = session.createSQLQuery(sql);

          sqlQuery.addEntity(Student.class);

          List <Student> studentList = sqlQuery.list();
          String id = null;
          for(Student student : studentList){
              id = student.getId();
          }
          transaction.commit();
          session.close();
          return id;

      }catch (Exception e){
          transaction.commit();
          session.close();
          return null;
      }
    }

    public boolean update(Student student){
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(student);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            transaction.rollback();
            session.close();
            return false;
        }
    }

}
