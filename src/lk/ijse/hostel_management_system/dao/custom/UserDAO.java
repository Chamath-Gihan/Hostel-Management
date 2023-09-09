package lk.ijse.hostel_management_system.dao.custom;

import lk.ijse.hostel_management_system.entity.User;

public interface UserDAO extends lk.ijse.hostel_management_system.dao.CrudDAO<User> {
    String getUser(String id);

    String getPassword(String id);

    boolean updateUser_Pw(String newUserName, String newPw);
}
