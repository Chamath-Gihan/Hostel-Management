package lk.ijse.hostel_management_system.dao.custom.impl;

import lk.ijse.hostel_management_system.dao.custom.QueryDAO;
import lk.ijse.hostel_management_system.entity.CustomerEntity;

import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomerEntity> getData() {
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        String sql = "SELECT res_id, res_date, r.room_type_id, r.type, s.id, s.name, r.key_money, status " +
//                "FROM Reservation " +
//                "INNER JOIN Student s on reservation.student_id = s.id " +
//                "INNER JOIN Room r on reservation.room_type_id = r.room_type_id " +
//                "ORDER BY CAST(SUBSTRING(res_id, 3) AS UNSIGNED)";
//        NativeQuery sqlQuery = session.createSQLQuery(sql);
//
//
//        sqlQuery.addScalar("res_id", StringType.INSTANCE);
//        sqlQuery.addScalar("res_date", LocalDateType.INSTANCE);
//        sqlQuery.addScalar("room_type_id", StringType.INSTANCE);
//        sqlQuery.addScalar("type", StringType.INSTANCE);
//        sqlQuery.addScalar("id", StringType.INSTANCE);
//        sqlQuery.addScalar("name", StringType.INSTANCE);
//        sqlQuery.addScalar("key_money", StringType.INSTANCE);
//        sqlQuery.addScalar("status", StringType.INSTANCE);
//
//        sqlQuery.setResultTransformer(Transformers.aliasToBean(CustomEntity.class));
//
//        List<CustomEntity> customEntities = sqlQuery.list();
        ArrayList<CustomerEntity> customData = new ArrayList<>();
//
//        for (CustomEntity entity : customEntities) {
//            customData.add(entity);
//        }

        return customData;
    }
}
