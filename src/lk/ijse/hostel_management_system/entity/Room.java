package lk.ijse.hostel_management_system.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    private String room_type_id;

    private String type;

    private String key_money;

    private int qty;

    @OneToMany(mappedBy = "room" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservationList = new ArrayList<>();

    @Override
    public String toString() {
        return "Room{" +
                "room_type_id='" + room_type_id + '\'' +
                ", type='" + type + '\'' +
                ", key_money='" + key_money + '\'' +
                ", qty=" + qty +
                ", reservationList=" + reservationList +
                '}';
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

    public Room() {
    }

    public Room(String room_type_id, String type, String key_money, int qty, List<Reservation> reservationList) {
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
        this.reservationList = reservationList;
    }
}
