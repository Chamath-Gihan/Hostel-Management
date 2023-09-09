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
}
