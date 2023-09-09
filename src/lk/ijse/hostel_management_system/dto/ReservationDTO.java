package lk.ijse.hostel_management_system.dto;

import java.time.LocalDate;

public class ReservationDTO {

    private String res_id;

    private LocalDate res_date;

    private String status;

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "res_id='" + res_id + '\'' +
                ", res_date=" + res_date +
                ", status='" + status + '\'' +
                '}';
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public LocalDate getRes_date() {
        return res_date;
    }

    public void setRes_date(LocalDate res_date) {
        this.res_date = res_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReservationDTO() {
    }

    public ReservationDTO(String res_id, LocalDate res_date, String status) {
        this.res_id = res_id;
        this.res_date = res_date;
        this.status = status;
    }
}
