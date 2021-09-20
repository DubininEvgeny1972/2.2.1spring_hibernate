package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    private int id;

    @Column(name = "model")
    private String car;

    @Column(name = "series")
    private int series;

    public Car() {
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public Car(String car, int series) {
        this.car = car;
        this.series = series;
    }

    public String getCar() {
        return car;
    }

    public int getSeries() {
        return series;
    }
}
