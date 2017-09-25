package com.finalproject.nasadata.domain;




import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name="meteorite")
public class Meteorite {

    private String name;
    private Integer id;
    private String nameType;
    private String recClass;
    private Double mass;
    private String fall;
    private String year;
    private Double recLat;
    private Double recLong;

    private String geolocation;


    public Meteorite() {
    }

    @Column(name="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="nametype")
    public String getNameType() {
        return nameType;
    }
    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Column(name="recclass")
    public String getRecClass() {
        return recClass;
    }
    public void setRecClass(String reClass) {
        this.recClass = recClass;
    }

    @Column(name="mass")
    public Double getMass() {
        return mass;
    }
    public void setMass(Double mass) {
        this.mass = mass;
    }

    @Column(name="fall")
    public String getFall() {
        return fall;
    }
    public void setFall(String fall) {
        this.fall = fall;
    }

    @Column(name="year")
    public String getYear() {
        return year;
    }
    public void setYear(String timestamp) {
        this.year = year;
    }

    @Column(name="reclat")
    public Double getRecLat() {
        return recLat;
    }
    public void setRecLat(Double recLat) {
        this.recLat = recLat;
    }

    @Column(name="reclong")
    public Double getRecLong() {
        return recLong;
    }
    public void setRecLong(Double recLong) {
        this.recLong = recLong;
    }

    @Column(name="geolocation")
    public String getGeolocation() {
        return geolocation;
    }
    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meteorite meteorite = (Meteorite) o;

        if (!name.equals(meteorite.name)) return false;
        if (!id.equals(meteorite.id)) return false;
        if (!nameType.equals(meteorite.nameType)) return false;
        if (!recClass.equals(meteorite.recClass)) return false;
        if (!mass.equals(meteorite.mass)) return false;
        if (!fall.equals(meteorite.fall)) return false;
        if (year != null ? !year.equals(meteorite.year) : meteorite.year != null) return false;
        if (recLat != null ? !recLat.equals(meteorite.recLat) : meteorite.recLat != null) return false;
        if (recLong != null ? !recLong.equals(meteorite.recLong) : meteorite.recLong != null) return false;
        return geolocation != null ? geolocation.equals(meteorite.geolocation) : meteorite.geolocation == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + nameType.hashCode();
        result = 31 * result + recClass.hashCode();
        result = 31 * result + mass.hashCode();
        result = 31 * result + fall.hashCode();
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (recLat != null ? recLat.hashCode() : 0);
        result = 31 * result + (recLong != null ? recLong.hashCode() : 0);
        result = 31 * result + (geolocation != null ? geolocation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Meteorite{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", nameType='" + nameType + '\'' +
                ", reClass='" + recClass + '\'' +
                ", mass=" + mass +
                ", fall='" + fall + '\'' +
                ", timestamp='" + year + '\'' +
                ", recLat=" + recLat +
                ", recLong=" + recLong +
                ", geolocation=" + geolocation +
                '}';
    }

}



