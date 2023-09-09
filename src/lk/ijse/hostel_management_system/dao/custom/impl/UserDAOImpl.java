package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.custom.UserDAO;
import lk.ijse.hostel_management_system.entity.User;
import lk.ijse.hostel_management_system.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    @Override
    public ArrayList<User> getData() {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean add(User entity) {
        return false;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public String getCurrentID() {
        return null;
    }

    @Override
    public String getUser(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            User user = session.get(User.class, id);
            transaction.commit();
            session.close();
            return user.getName();

        }catch (Exception ex){
            transaction.rollback();
            session.close();
            return null;
        }
    }

    @Override
    public String getPassword(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            User user = session.get(User.class, id);
            transaction.commit();
            session.close();
            return user.getPassword();

        }catch (Exception ex){
            transaction.rollback();
            session.close();
            return null;
        }
    }

    @Override
    public boolean updateUser_Pw(String newUserName, String newPw) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            User user = session.get(User.class, "1");
            user.setName(newUserName);
            user.setPassword(newPw);
            session.update(user);

            transaction.commit();
            session.close();
            return true;

        }catch (Exception ex){
            transaction.rollback();
            session.close();
            return false;
        }
    }
}
