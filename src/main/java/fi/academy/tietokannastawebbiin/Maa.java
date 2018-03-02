package fi.academy.tietokannastawebbiin;

import org.springframework.stereotype.Component;

@Component
public class Maa {
    private String name;
    private String localName;
    private String capital;
    private int population;

    public Maa(){}

    public Maa(String name, String localName, String capital, int population) {
        this.name = name;
        this.localName = localName;
        this.capital = capital;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Maa{" +
                "name='" + name + '\'' +
                ", localName='" + localName + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                '}';
    }
}
