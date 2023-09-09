package lk.ijse.hostel_management_system.dao;

import lk.ijse.hostel_management_system.dao.custom.impl.*;

public class FactoryDAO {
    private static lk.ijse.hostel_management_system.dao.FactoryDAO factoryDAO;

    private FactoryDAO() {
    }

    public static lk.ijse.hostel_management_system.dao.FactoryDAO getFactoryDAO() {
        return factoryDAO == null ? factoryDAO = new lk.ijse.hostel_management_system.dao.FactoryDAO() : factoryDAO;
    }

    public enum Types {
        STUDENT,
        ROOM,
        RECEPTION,
        JOIN_QUERY,
        USER
    }

    public SuperDAO getDAO(Types types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomsDAOImpl();
            case RECEPTION:
                return new ReservationDAOImpl();
            case JOIN_QUERY:
                return new QueryDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
