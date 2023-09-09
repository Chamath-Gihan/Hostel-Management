package lk.ijse.hostel_management_system.dto;

import lk.ijse.hostel_management_system.entity.Room;
import lk.ijse.hostel_management_system.entity.Student;

import java.time.LocalDate;

public class ReservationDTO {

    private String res_id;

    private LocalDate res_date;

    private String status;

    private Student student;
    private Room room;

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "res_id='" + res_id + '\'' +
                ", res_date=" + res_date +
                ", status='" + status + '\'' +
                ", student=" + student +
                ", room=" + room +
                '}';
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public LocalDate getRes_date() {
        return res_date;
    }

    public void setRes_date(LocalDate res_date) {
        this.res_date = res_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ReservationDTO() {
    }

    public ReservationDTO(String res_id, LocalDate res_date, String status, Student student, Room room) {
        this.res_id = res_id;
        this.res_date = res_date;
        this.status = status;
        this.student = student;
        this.room = room;
    }
}
