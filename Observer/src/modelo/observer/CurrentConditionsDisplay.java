package modelo.observer;

import interfaces.weatherdata.DisplayElement;
import interfaces.observer.Subject;
import interfaces.observer.Observer;


public class CurrentConditionsDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;
    
    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current condition: "+temperature+
            "Fº degress, "+humidity+" humididy and "+pressure+" kPa.");
    }
    
    public void cancel(){
        this.weatherData.removeObserver(this);
    }
}
