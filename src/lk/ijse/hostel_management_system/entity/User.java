package lk.ijse.hostel_management_system.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String id;

    private String name;

    private String password;
}
