package by.training.project.beans;

import java.util.Objects;

public class Order extends Entity{
    private int hotelId;
    private int number;
    private int dateArrival;
    private int dateDepartment;
    private int timeArrival;
    private int timeDepartment;
    private int price;
    private int typeFood;
    private int typeAllocation;
    private int status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return hotelId == order.hotelId && number == order.number && dateArrival == order.dateArrival && dateDepartment == order.dateDepartment && timeArrival == order.timeArrival && timeDepartment == order.timeDepartment && price == order.price && typeFood == order.typeFood && typeAllocation == order.typeAllocation && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hotelId, number, dateArrival, dateDepartment, timeArrival, timeDepartment, price, typeFood, typeAllocation, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "hotelId=" + hotelId +
                ", number=" + number +
                ", dateArrival=" + dateArrival +
                ", dateDepartment=" + dateDepartment +
                ", timeArrival=" + timeArrival +
                ", timeDepartment=" + timeDepartment +
                ", price=" + price +
                ", typeFood=" + typeFood +
                ", typeAllocation=" + typeAllocation +
                ", status=" + status +
                "} " + super.toString();
    }
}
