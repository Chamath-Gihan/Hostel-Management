package lk.ijse.hostel_management_system.entity;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    private String res_id;

    @Column(columnDefinition = "DATE")
    private String res_date;

    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private Room room;

    @Override
    public String toString() {
        return "Reservation{" +
                "res_id='" + res_id + '\'' +
                ", res_date='" + res_date + '\'' +
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

    public String getRes_date() {
        return res_date;
    }

    public void setRes_date(String res_date) {
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

    public Reservation() {
    }

    public Reservation(String res_id, String res_date, String status, Student student, Room room) {
        this.res_id = res_id;
        this.res_date = res_date;
        this.status = status;
        this.student = student;
        this.room = room;
    }
}
