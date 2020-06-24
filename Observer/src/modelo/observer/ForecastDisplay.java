package modelo.observer;

import interfaces.observer.Observer;
import interfaces.observer.Subject;
import interfaces.weatherdata.DisplayElement;
import java.text.DecimalFormat;

public class ForecastDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;
    
    public ForecastDisplay(Subject weatherData){
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
        DecimalFormat df = new DecimalFormat("#.00");
        float result = (humidity*pressure+pressure)/temperature;
        if(result <= 20.00){
            System.out.println("Dry weather, low humidity.");
        }else if(result > 20.00 && result < 40.00){
            System.out.println("Favorable climate, regulated humidity");
        }else if(result >= 40.00){
            System.out.println("Probability of rain with strong winds");
        }
    }
    
    public void cancel(){
        this.weatherData.removeObserver(this);
    }
}
