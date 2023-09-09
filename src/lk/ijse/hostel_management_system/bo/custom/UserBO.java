/*
 * Kasun Miuranga
 * Copyright (c) 2023
 */

package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hms.bo.SuperBO;

public interface UserBO extends lk.ijse.hms.bo.SuperBO {
    String getUser(String id);

    String getPassword(String id);

    boolean updateUser_Pw(String newUserName, String newPw);
}
