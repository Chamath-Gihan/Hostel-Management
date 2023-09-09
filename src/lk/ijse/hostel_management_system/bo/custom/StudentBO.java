/*
 * Kasun Miuranga
 * Copyright (c) 2023
 */

package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBO extends lk.ijse.hms.bo.SuperBO {
    Boolean addStudent(StudentDTO studentDTO);

    Boolean deleteStudent(StudentDTO studentDTO);

    ArrayList<StudentDTO> getStudentData();

    String getCurrentID();

    Boolean updateStudent(StudentDTO studentDTO);
}
