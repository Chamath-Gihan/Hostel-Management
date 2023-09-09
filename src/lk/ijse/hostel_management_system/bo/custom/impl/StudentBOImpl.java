package lk.ijse.hostel_management_system.bo.custom.impl;

import lk.ijse.hostel_management_system.bo.custom.StudentBO;
import lk.ijse.hostel_management_system.dao.FactoryDAO;
import lk.ijse.hostel_management_system.dao.custom.StudentDAO;
import lk.ijse.hostel_management_system.dto.StudentDTO;
import lk.ijse.hostel_management_system.entity.Student;

import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) FactoryDAO.getFactoryDAO().getDAO(FactoryDAO.Types.STUDENT);

    public Boolean addStudent(StudentDTO studentDTO) {
        Student student = new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact_no(),
                studentDTO.getDob(),
                studentDTO.getGender());
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setContact_no(studentDTO.getContact_no());
        student.setDob(studentDTO.getDob());
        student.setGender(studentDTO.getGender());
        System.out.println(studentDTO.getId());
        System.out.println(student.getId());
        return studentDAO.add(student);
    }

    public Boolean deleteStudent(StudentDTO studentDTO) {
        return studentDAO.delete(studentDTO.getId());
    }

    public ArrayList<StudentDTO> getStudentData() {
        ArrayList<StudentDTO> StudentDTOs = new ArrayList<>();
        ArrayList<Student> studentData = studentDAO.getData();

        for (Student std : studentData) {
            StudentDTOs.add(new StudentDTO(std.getId(),
                    std.getName(), std.getAddress(),
                    std.getContact_no(),
                    std.getDob(),
                    std.getGender()));
        }
        return StudentDTOs;
    }

    public String getCurrentID() {
        return studentDAO.getCurrentID();
    }

    @Override
    public Boolean updateStudent(StudentDTO studentDTO) {
        Student student = new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact_no(),
                studentDTO.getDob(),
                studentDTO.getGender());
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setContact_no(studentDTO.getContact_no());
        student.setDob(studentDTO.getDob());
        student.setGender(studentDTO.getGender());
        System.out.println(studentDTO.getId());
        System.out.println(student.getId());
        return studentDAO.update(student);
    }
}
