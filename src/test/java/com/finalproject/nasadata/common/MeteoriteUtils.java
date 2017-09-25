package com.finalproject.nasadata.common;

import com.finalproject.nasadata.domain.Meteorite;
import org.junit.Test;

import java.awt.*;
import java.util.List;


public class MeteoriteUtils {

    public static Meteorite createTestMeteorite() {

        Meteorite meteorite = new Meteorite();

        String name = Long.toString(System.currentTimeMillis());
        String nameType = "sample nametype";
        String recClass = "sample reClass";
        Double mass = 10.0;
        String fall = "Found";
        String year = "1989";
        Double recLat = 10.0002;
        Double recLong = -11.394;
//        String geoLocation = new Point();

//        geoLocation.setLocation(recLat, recLong);

        meteorite.setName(name);
        meteorite.setNameType(nameType);
        meteorite.setRecClass(recClass);
        meteorite.setMass(mass);
        meteorite.setFall(fall);
        meteorite.setYear(year);
        meteorite.setRecLat(recLat);
        meteorite.setRecLong(recLong);
//        meteorite.setGeolocation(geoLocation);
        return meteorite;

    }

    public static Meteorite findInList(List<Meteorite> meteoriteList, String name) {
        for (Meteorite meteorite : meteoriteList) {
            if(meteorite.getName().equals(name)) {
                return meteorite;
            }
        }
        return null;
    }
}
