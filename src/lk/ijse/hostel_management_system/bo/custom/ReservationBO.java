/*
 * Kasun Miuranga
 * Copyright (c) 2023
 */

package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hostel_management_system.dto.CustomDTO;
import lk.ijse.hostel_management_system.dto.ReservationDTO;
import lk.ijse.hostel_management_system.dto.RoomsDTO;
import lk.ijse.hostel_management_system.dto.StudentDTO;

import java.util.ArrayList;

public interface ReservationBO extends lk.ijse.hostel_management_system.bo.SuperBO {
    String getCurrentID();

    ArrayList<RoomsDTO> getRoomsData();

    ArrayList<StudentDTO> getStudentData();

    ArrayList<CustomDTO> getReservationData();

    boolean addReservation(ReservationDTO reservationDTO);

    boolean deleteReservation(ReservationDTO reservationDTO);

    boolean updateReservation(ReservationDTO reservationDTO);
}
