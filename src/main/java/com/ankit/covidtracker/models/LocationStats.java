package com.ankit.covidtracker.models;

public class LocationStats {
    private String state;
    private String country;
    private int latestDateCase;
    private int diffOfCase;
    private String searchCountry;


    public int getDiffOfCase() {
        return diffOfCase;
    }

    public void setDiffOfCase(int diffOfCase) {
        this.diffOfCase = diffOfCase;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestDateCase() {
        return latestDateCase;
    }

    public void setLatestDateCase(int latestDateCase) {
        this.latestDateCase = latestDateCase;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestDateCase=" + latestDateCase +
                '}';
    }
}
