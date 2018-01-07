package ru.vsu.amm.model;

public class ParckingPlace {

    private int id;
    private double latitude;
    private double longitude;
    private boolean isPaid;
    private String openTime;
    private String closeTime;
    private int numberOfFreeSpots;
    private int numberOfSpots;
    private String address;
    private String description;

    public ParckingPlace() {}

    public ParckingPlace(int id, double latitude, double longitude, boolean isPaid, String openTime, String closeTime,
                         int numberOfFreeSpots, int numberOfSpots, String address, String description) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isPaid = isPaid;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.numberOfFreeSpots = numberOfFreeSpots;
        this.numberOfSpots = numberOfSpots;
        this.address = address;
        this.description = description;
    }

    public ParckingPlace(int id, double latitude, double longitude, int numberOfFreeSpots, int numberOfSpots, String address) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numberOfFreeSpots = numberOfFreeSpots;
        this.numberOfSpots = numberOfSpots;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public int getNumberOfFreeSpots() {
        return numberOfFreeSpots;
    }

    public void setNumberOfFreeSpots(int numberOfFreeSpots) {
        this.numberOfFreeSpots = numberOfFreeSpots;
    }

    public int getNumberOfSpots() {
        return numberOfSpots;
    }

    public void setNumberOfSpots(int numberOfSpots) {
        this.numberOfSpots = numberOfSpots;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParckingPlace that = (ParckingPlace) o;

        if (id != that.id) return false;
        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return ParckingPlace.class.getSimpleName() +
                "{id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", isPaid=" + isPaid +
                ", openTime='" + openTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                ", numberOfFreeSpots=" + numberOfFreeSpots +
                ", numberOfSpots=" + numberOfSpots +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
