package az.kanan.model;

/**
 * Created by Kanan on 12/19/2016.
 */
public class City {

    private Long id;
    private String countryCode;
    private String standartCityName;
    private String realCity;
    private String region;
    private String population;
    private String latitude;
    private String longitude;

    public City() {
    }

    public City(Long id, String countryCode, String standartCityName, String realCity, String region, String population, String latitude, String longitude) {
        this.id = id;
        this.countryCode = countryCode;
        this.standartCityName = standartCityName;
        this.realCity = realCity;
        this.region = region;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public City(String countryCode, String standartCityName, String realCity, String region, String population, String latitude, String longitude) {
        this.countryCode = countryCode;
        this.standartCityName = standartCityName;
        this.realCity = realCity;
        this.region = region;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCityInStringFormat() {
        return countryCode + "," + standartCityName + "," + realCity + "," + region + "," + population + "," + latitude + "," + longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStandartCityName() {
        return standartCityName;
    }

    public void setStandartCityName(String standartCityName) {
        this.standartCityName = standartCityName;
    }

    public String getRealCity() {
        return realCity;
    }

    public void setRealCity(String realCity) {
        this.realCity = realCity;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", countryCode='" + countryCode + '\'' +
                ", standartCityName='" + standartCityName + '\'' +
                ", realCity='" + realCity + '\'' +
                ", region='" + region + '\'' +
                ", population='" + population + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
