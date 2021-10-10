package by.training.task01.service;

/**
 * Task22 is about formatting from time in seconds to time in HH:MM:SS
 */
public class Task22 {

    /**
     * time in seconds
     */
    private final int timeInSec;

    /**
     * @param timeInSec time in seconds
     */
    public Task22(int timeInSec) {
        this.timeInSec = timeInSec;
    }

    /**
     * @return time in format HH:MM:SS
     */
    public String getTime() {
        if (timeInSec < 0 ){
            return "Время неотрицательное число";
        }
        return timeInSec / 3600 + "ч " + (timeInSec % 3600) / 60 + "мин " + (timeInSec % 3600) % 60 + "c";
    }
}
