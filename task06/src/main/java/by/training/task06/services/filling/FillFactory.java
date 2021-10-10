package by.training.task06.services.filling;

import by.training.task06.services.filling.impl.FillMod;
import by.training.task06.services.filling.impl.FillRace;
import by.training.task06.services.filling.impl.FillRandom;
import by.training.task06.services.filling.impl.FillSize;

public class FillFactory {
    private static final FillFactory instance = new FillFactory();
    private final Filling fillRaceImpl = new FillRace();
    private final Filling fillRandomImpl = new FillRandom();
    private final Filling fillSizeImpl = new FillSize();
    private final Filling fillModImpl = new FillMod();

    private FillFactory() {}
    public static FillFactory getInstance(){
        return instance;
    }
    public Filling getFillRace(){
        return fillRaceImpl;
    }
    public Filling getFillRandom() { return fillRandomImpl;}
    public Filling getFillSize() { return  fillSizeImpl; }
    public Filling getFillMod() { return fillModImpl; }

}
