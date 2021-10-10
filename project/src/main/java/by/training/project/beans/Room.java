package by.training.project.beans;

import java.util.Objects;

public class Room{
    private int number;
    private int hotelId;
    private int typeAllocation;
    private int typeComfort;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
        Room room = (Room) o;
        return number == room.number && hotelId == room.hotelId && typeAllocation == room.typeAllocation && typeComfort == room.typeComfort;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, hotelId, typeAllocation, typeComfort);
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", hotelId=" + hotelId +
                ", typeAllocation=" + typeAllocation +
                ", typeComfort=" + typeComfort +
                '}';
    }
}
