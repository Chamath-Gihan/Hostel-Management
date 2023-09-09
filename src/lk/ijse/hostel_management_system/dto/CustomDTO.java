package lk.ijse.hostel_management_system.dto;

import lk.ijse.hostel_management_system.entity.Reservation;
import lk.ijse.hostel_management_system.entity.Room;
import lk.ijse.hostel_management_system.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomDTO {

    // reservation
    private String res_id;
    private LocalDate res_date;
    private String status;

    private Student student;
    private Room room;

    // Room
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;
    private List<Reservation> reservationList = new ArrayList<>();

    // Student
    private String id;
    private String name;
    private String address;
    private String contact_no;
    private String dob;
    private String gender;
}
