package az.kanan.controller;


import az.kanan.db.QueriesDB;
import az.kanan.model.City;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import sun.text.normalizer.UTF16;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by Kanan on 12/19/2016.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("/")
    public String defaultMethod() {
        return "index";
    }


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getCityList() {
        QueriesDB queriesDB = new QueriesDB();
        String json = null;
        try {
            List<City> cityList = queriesDB.getCitiesList();
            if (cityList != null) {
                json = new Gson().toJson(cityList);
            } else {
                json = "{\"error\":\"We cannot get data\"}";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(value = "/toCity", method = RequestMethod.GET)
    public String getCityPage(ModelMap modelMap) {
        QueriesDB queriesDB = new QueriesDB();
        try {
            List<City> cityList = queriesDB.getCitiesList();
            modelMap.put("cityList", cityList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "citiesPage";
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody()
    public String insertCity(@RequestBody String value) {
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(value);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        City city = new City();
        city.setCountryCode(jsonObject.get("countryCode").toString().replaceAll("\"", ""));
        city.setStandartCityName(jsonObject.get("standartCityName").toString().replaceAll("\"", ""));
        city.setRealCity(jsonObject.get("realCity").toString().replaceAll("\"", ""));
        city.setRegion(jsonObject.get("region").toString().replaceAll("\"", ""));
        city.setPopulation(jsonObject.get("population").toString().replaceAll("\"", ""));
        city.setLatitude(jsonObject.get("latitude").toString().replaceAll("\"", ""));
        city.setLongitude(jsonObject.get("longitude").toString().replaceAll("\"", ""));

        QueriesDB queriesDB = new QueriesDB();
        Boolean isSended = false;
        String result = "";
        try {
            isSended = queriesDB.insertCityData(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isSended) {
            result = "{\"info\":\"Data was inserted\"}";
        } else {
            result = "{\"error\":\"Data was not inserted\"}";
        }

        return result;
    }


}
