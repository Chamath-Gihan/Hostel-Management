package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hostel_management_system.dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBO extends lk.ijse.hostel_management_system.bo.SuperBO {
    Boolean addStudent(StudentDTO studentDTO);

    Boolean deleteStudent(StudentDTO studentDTO);

    ArrayList<StudentDTO> getStudentData();

    String getCurrentID();

    Boolean updateStudent(StudentDTO studentDTO);
}
