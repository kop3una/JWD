package by.training.project.service.creator;

import by.training.project.service.creator.reader.HotelReader;
import by.training.project.service.creator.reader.UserReader;
import by.training.project.service.creator.reader.impl.HotelReaderImpl;
import by.training.project.service.creator.reader.impl.UserReaderImpl;
import by.training.project.service.creator.writer.UserWriter;
import by.training.project.service.creator.writer.impl.UserWriterImpl;

public final class CreatorFactory {
    private static final CreatorFactory instance = new CreatorFactory();
    private final UserReader userReaderImpl = new UserReaderImpl();
    private final HotelReader hotelReaderImpl = new HotelReaderImpl();
    private final UserWriter userWriterImpl = new UserWriterImpl();

    private CreatorFactory() {}
    public static CreatorFactory getInstance(){
        return instance;
    }
    public UserReader getUserReader() { return userReaderImpl; }
    public HotelReader getHotelReader() { return hotelReaderImpl; }
    public UserWriter getUserWriter() { return userWriterImpl; }
}
