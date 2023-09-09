package lk.ijse.hostel_management_system.bo;

import lk.ijse.hostel_management_system.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hostel_management_system.bo.custom.impl.RoomsBOImpl;
import lk.ijse.hostel_management_system.bo.custom.impl.StudentBOImpl;
import lk.ijse.hostel_management_system.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static lk.ijse.hostel_management_system.bo.BOFactory boFactory;

    private BOFactory() {
    }

    public static lk.ijse.hostel_management_system.bo.BOFactory getBoFactory() {
        return boFactory == null ? boFactory = new lk.ijse.hostel_management_system.bo.BOFactory() : boFactory;
    }

    public enum Type {
        STUDENT,
        ROOM,
        RECEPTION,
        USER
    }

    public SuperBO getBO(Type type) {
        switch (type) {
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomsBOImpl();
            case RECEPTION:
                return new ReservationBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}

