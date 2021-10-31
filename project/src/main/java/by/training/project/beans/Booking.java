package by.training.project.beans;


import java.sql.Date;
import java.util.Objects;

public class Booking extends Entity{
    private int hotelId;
    private Date dateArrival;
    private Date dateDepartment;

    public int getNumber() {
        return getId();
    }

    public void setNumber(int number) {
        setId(number);
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public Date getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    public Date getDateDepartment() {
        return dateDepartment;
    }

    public void setDateDepartment(Date dateDepartment) {
        this.dateDepartment = dateDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Booking booking = (Booking) o;
        return hotelId == booking.hotelId && dateArrival == booking.dateArrival && dateDepartment == booking.dateDepartment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hotelId, dateArrival, dateDepartment);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "hotelId=" + hotelId +
                ", dateArrival=" + dateArrival +
                ", dateDepartment=" + dateDepartment +
                "} " + super.toString();
    }
}


