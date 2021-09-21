package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "auto_id")
    private Long id;

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

    public Long getId() {
        return id;
    }
}
