package model;

import java.io.Serializable;

/**
 * Created by ealexhaywood on 5/13/17.
 */
public class User implements Serializable {

    private String name;
    private boolean isPrime;
    private String location;
    private boolean isFirstClass;

    public User(String name, boolean isPrime, String location, boolean isFirstClass) {
        this.name = name;
        this.isPrime = isPrime;
        this.location = location;
        this.isFirstClass = isFirstClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isFirstClass() {
        return isPrime;
    }

    public void setFirstClass(boolean prime) {
        isPrime = prime;
    }

    @Override
    public String toString() {
        return name;
    }
}
