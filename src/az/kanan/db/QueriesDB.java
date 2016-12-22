package az.kanan.db;


import az.kanan.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kanan on 12/19/2016.
 */
public class QueriesDB {

    ConnectorDB connector = new ConnectorDB();

    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<City> getCitiesList() throws SQLException {
        List<City> cityList = new ArrayList<>();
        String sql = "SELECT id, country, city, accent_city, region, population, latitude, longitude FROM cities.data";
        try {
            c = connector.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    cityList.add(new City(rs.getLong("id"),
                            rs.getString("country"),
                            rs.getString("city"),
                            rs.getString("accent_city"),
                            rs.getString("region"),
                            rs.getString("population"),
                            rs.getString("latitude"),
                            rs.getString("longitude")));
                }

            } else {
                System.out.println("Connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(c, ps, rs);
            setNullElements();
        }
        return cityList;
    }


    public Boolean insertCityData(City city) throws SQLException {
        Boolean isrResultOk = null;
        String sql = "INSERT INTO cities.data(country,city,accent_city,region,population,latitude,longitude)\n" +
                "values(?,?,?,?,?,?,?)";
        try {
            c = connector.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, city.getCountryCode());
                ps.setString(2, city.getStandartCityName());
                ps.setString(3, city.getRealCity());
                ps.setString(4, city.getRegion());
                ps.setString(5, city.getPopulation());
                ps.setString(6, city.getLatitude());
                ps.setString(7, city.getLongitude());
                int numCheker = ps.executeUpdate();
                if (numCheker == 0) {
                    isrResultOk = false;
                } else {
                    isrResultOk = true;
                }
            } else {
                System.out.println("Connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(c, ps, rs);
            setNullElements();
        }
        return isrResultOk;
    }


    public City getCityByValue() {
        return null;
    }


    private void setNullElements() {
        c = null;
        ps = null;
        rs = null;
    }

}
