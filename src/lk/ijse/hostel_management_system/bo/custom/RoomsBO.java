package lk.ijse.hostel_management_system.bo.custom;


import lk.ijse.hostel_management_system.dto.RoomsDTO;

import java.util.ArrayList;

public interface RoomsBO extends lk.ijse.hostel_management_system.bo.SuperBO {
    Boolean addRoom(RoomsDTO roomsDTO);

    Boolean deleteRoom(RoomsDTO roomsDTO);

    ArrayList<RoomsDTO> getRoomsData();

    //String getCurrentID();

    Boolean updateRoom(RoomsDTO roomsDTO);
}
