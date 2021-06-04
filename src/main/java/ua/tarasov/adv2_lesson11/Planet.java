package ua.tarasov.adv2_lesson11;

public enum Planet {
    MERCURY(0),
    VENUS(0),
    EARTH(1),
    MARS(2),
    JUPITER(79),
    SATURN(82),
    URANUS(27),
    NEPTUNE(14);
    private final int numberOfSatellite;
    Planet(int numberOfSatellite){
        this.numberOfSatellite = numberOfSatellite;
    }

    public int getNumberOfSatellite() {
        return numberOfSatellite;
    }
}
