package modelo.observer;

import interfaces.weatherdata.DisplayElement;
import interfaces.observer.Subject;
import interfaces.observer.Observer;
import java.text.DecimalFormat;


public class StatisticDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public StatisticDisplay(Subject weatherData){
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
        System.out.println("AVG/Max/Min temperature: "+
                df.format(temperature*1.1)+" / "+
                df.format(temperature*1.30)+" / "+
                df.format(temperature*0.90));
    }
    
    public void cancel(){
        this.weatherData.removeObserver(this);
    }
    
}
