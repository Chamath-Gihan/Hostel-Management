package lk.ijse.hostel_management_system.bo.custom.impl;

import lk.ijse.hostel_management_system.bo.custom.RoomsBO;
import lk.ijse.hostel_management_system.dao.FactoryDAO;
import lk.ijse.hostel_management_system.dao.custom.RoomsDAO;
import lk.ijse.hostel_management_system.dto.RoomsDTO;
import lk.ijse.hostel_management_system.entity.Room;

import java.util.ArrayList;

public class RoomsBOImpl implements RoomsBO {

    RoomsDAO roomDAO = (RoomsDAO) FactoryDAO.getFactoryDAO().getDAO(FactoryDAO.Types.ROOM);

    @Override
    public Boolean addRoom(RoomsDTO roomsDTO) {
        Room room = new Room(
                roomsDTO.getRoom_type_id(),
                roomsDTO.getType(),
                roomsDTO.getKey_money(),
                roomsDTO.getQty());
        room.setRoom_type_id(roomsDTO.getRoom_type_id());
        room.setType(roomsDTO.getType());
        room.setKey_money(roomsDTO.getKey_money());
        room.setQty(roomsDTO.getQty());
        return roomDAO.add(room);
    }

    @Override
    public Boolean deleteRoom(RoomsDTO roomsDTO) {
        return roomDAO.delete(roomsDTO.getRoom_type_id());
    }

    @Override
    public ArrayList<RoomsDTO> getRoomsData() {
        ArrayList<RoomsDTO> RoomDTOs = new ArrayList<>();
        ArrayList<Room> roomData = roomDAO.getData();

        for (Room r : roomData) {
            RoomDTOs.add(new RoomsDTO(
                    r.getRoom_type_id(),
                    r.getType(),
                    r.getKey_money(),
                    r.getQty()));
        }
        return RoomDTOs;
    }

    public String getCurrentID() {
        return roomDAO.getCurrentID();
    }

    @Override
    public Boolean updateRoom(RoomsDTO roomsDTO) {
        Room room = new Room(
                roomsDTO.getRoom_type_id(),
                roomsDTO.getType(),
                roomsDTO.getKey_money(),
                roomsDTO.getQty());
        room.setRoom_type_id(roomsDTO.getRoom_type_id());
        room.setType(roomsDTO.getType());
        room.setKey_money(roomsDTO.getKey_money());
        room.setQty(roomsDTO.getQty());
        return roomDAO.update(room);
    }
}
