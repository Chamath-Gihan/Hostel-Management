package lk.ijse.hostel_management_system.dao.custom;

import lk.ijse.hostel_management_system.dao.SuperDAO;
import lk.ijse.hostel_management_system.entity.CustomerEntity;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomerEntity> getData();
}
