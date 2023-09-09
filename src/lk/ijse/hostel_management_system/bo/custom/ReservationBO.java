/*
 * Kasun Miuranga
 * Copyright (c) 2023
 */

package lk.ijse.hostel_management_system.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.CustomDTO;
import lk.ijse.hms.dto.ReservationDTO;
import lk.ijse.hms.dto.RoomsDTO;
import lk.ijse.hms.dto.StudentDTO;

import java.util.ArrayList;

public interface ReservationBO extends lk.ijse.hms.bo.SuperBO {
    String getCurrentID();

    ArrayList<RoomsDTO> getRoomsData();

    ArrayList<StudentDTO> getStudentData();

    ArrayList<CustomDTO> getReservationData();

    boolean addReservation(ReservationDTO reservationDTO);

    boolean deleteReservation(ReservationDTO reservationDTO);

    boolean updateReservation(ReservationDTO reservationDTO);
}
