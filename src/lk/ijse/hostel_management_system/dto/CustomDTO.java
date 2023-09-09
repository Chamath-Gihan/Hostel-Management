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

    public CustomDTO(String res_id, LocalDate res_date, String room_type_id, String type, String id, String name, String key_money, String status) {

    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "res_id='" + res_id + '\'' +
                ", res_date=" + res_date +
                ", status='" + status + '\'' +
                ", student=" + student +
                ", room=" + room +
                ", room_type_id='" + room_type_id + '\'' +
                ", type='" + type + '\'' +
                ", key_money='" + key_money + '\'' +
                ", qty=" + qty +
                ", reservationList=" + reservationList +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
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

    public String getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(String room_type_id) {
        this.room_type_id = room_type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey_money() {
        return key_money;
    }

    public void setKey_money(String key_money) {
        this.key_money = key_money;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CustomDTO() {
    }

    public CustomDTO(String res_id, LocalDate res_date, String status, Student student, Room room, String room_type_id, String type, String key_money, int qty, List<Reservation> reservationList, String id, String name, String address, String contact_no, String dob, String gender) {
        this.res_id = res_id;
        this.res_date = res_date;
        this.status = status;
        this.student = student;
        this.room = room;
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
        this.reservationList = reservationList;
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact_no = contact_no;
        this.dob = dob;
        this.gender = gender;
    }
}
