/*
 * Kasun Miuranga
 * Copyright (c) 2023
 */

package lk.ijse.hostel_management_system.bo;

import lk.ijse.hms.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hms.bo.custom.impl.RoomsBOImpl;
import lk.ijse.hms.bo.custom.impl.StudentBOImpl;
import lk.ijse.hms.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static lk.ijse.hms.bo.BOFactory boFactory;

    private BOFactory() {
    }

    public static lk.ijse.hms.bo.BOFactory getBoFactory() {
        return boFactory == null ? boFactory = new lk.ijse.hms.bo.BOFactory() : boFactory;
    }

    public enum Type {
        STUDENT,
        ROOM,
        RECEPTION,
        USER
    }

    public lk.ijse.hms.bo.SuperBO getBO(Type type) {
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

