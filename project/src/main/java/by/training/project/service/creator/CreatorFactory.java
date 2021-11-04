package by.training.project.service.creator;

import by.training.project.service.creator.reader.*;
import by.training.project.service.creator.reader.impl.*;
import by.training.project.service.creator.writer.BookingWriter;
import by.training.project.service.creator.writer.OrderWriter;
import by.training.project.service.creator.writer.UserWriter;
import by.training.project.service.creator.writer.impl.BookingWriterImpl;
import by.training.project.service.creator.writer.impl.OrderWriterImpl;
import by.training.project.service.creator.writer.impl.UserWriterImpl;

public final class CreatorFactory {
    private static final CreatorFactory instance = new CreatorFactory();
    private final UserReader userReaderImpl = new UserReaderImpl();
    private final HotelReader hotelReaderImpl = new HotelReaderImpl();
    private final UserWriter userWriterImpl = new UserWriterImpl();
    private final RoomReader roomReaderImpl = new RoomReaderImpl();
    private final BookingReader bookingReaderImpl = new BookingReaderImpl();
    private final BookingWriter bookingWriterImpl = new BookingWriterImpl();
    private final OrderWriter orderWriterImpl = new OrderWriterImpl();
    private final OrderReader orderReaderImpl = new OrderReaderImpl();

    private CreatorFactory() {}
    public static CreatorFactory getInstance(){
        return instance;
    }
    public UserReader getUserReader() { return userReaderImpl; }
    public HotelReader getHotelReader() { return hotelReaderImpl; }
    public UserWriter getUserWriter() { return userWriterImpl; }
    public RoomReader getRoomReader() { return roomReaderImpl; }
    public BookingReader getBookingReader() { return bookingReaderImpl; }
    public BookingWriter getBookingWriter() { return bookingWriterImpl; }
    public OrderWriter getOrderWriter() { return orderWriterImpl; }
    public OrderReader getOrderReader() { return orderReaderImpl; }
}
