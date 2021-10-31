package by.training.project.beans;

import java.util.Objects;

public class Room extends Entity{
    private int hotelId;
    private int typeAllocation;
    private int typeComfort;

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

    public int getTypeAllocation() {
        return typeAllocation;
    }

    public void setTypeAllocation(int typeAllocation) {
        this.typeAllocation = typeAllocation;
    }

    public int getTypeComfort() {
        return typeComfort;
    }

    public void setTypeComfort(int typeComfort) {
        this.typeComfort = typeComfort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return getNumber() == room.getNumber() && hotelId == room.hotelId && typeAllocation == room.typeAllocation && typeComfort == room.typeComfort;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hotelId, typeAllocation, typeComfort);
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + getNumber() +
                "hotelId=" + hotelId +
                ", typeAllocation=" + typeAllocation +
                ", typeComfort=" + typeComfort +
                "}";
    }
}
