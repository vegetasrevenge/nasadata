package com.finalproject.nasadata.domain;

import javax.persistence.*;

@Entity
@Table(name="meteorite")
public class Meteorite {

    private String name;
    private Integer meteoriteId;
    private String nameType;
    private String recClass;
    private Double mass;
    private String fall;
    private Integer year;
    private Double recLat;
    private Double recLong;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getMeteoriteId() {
        return meteoriteId;
    }
    public void setMeteoriteId(Integer id) {
        this.meteoriteId = id;
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
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meteorite meteorite = (Meteorite) o;

        return meteoriteId.equals(meteorite.meteoriteId);
    }

    @Override
    public int hashCode() {
        return meteoriteId.hashCode();
    }

    @Override
    public String toString() {
        return "Meteorite{" +
                "name='" + name + '\'' +
                ", id=" + meteoriteId +
                ", nameType='" + nameType + '\'' +
                ", reClass='" + recClass + '\'' +
                ", mass=" + mass +
                ", fall='" + fall + '\'' +
                ", timestamp='" + year + '\'' +
                ", recLat=" + recLat +
                ", recLong=" + recLong +
                '}';
    }

}



