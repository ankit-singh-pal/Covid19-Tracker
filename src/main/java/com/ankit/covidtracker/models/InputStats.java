package com.ankit.covidtracker.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class InputStats {

    @Size(min = 3, max = 20)
    @NotBlank(message = "Enter country name")
    private String searchCountry;

    @Override
    public String toString() {
        return "InputStats{" +
                "searchCountry='" + searchCountry + '\'' +
                '}';
    }

    public String getSearchCountry() {
        return searchCountry;
    }

    public void setSearchCountry(String searchCountry) {
        this.searchCountry = searchCountry;
    }
}
