package com.spring.demo.bean;

public class City {

    private String cityName;

    private Integer population;

    public City() {
        System.out.println("City init with constructor");

    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", population=" + population +
                '}';
    }
}
