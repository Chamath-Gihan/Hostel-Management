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

    
}
