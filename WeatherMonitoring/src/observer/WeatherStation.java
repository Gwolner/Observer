package observer;

import modelo.observer.CurrentConditionsDisplay;
import modelo.observer.ForecastDisplay;
import modelo.observer.StatisticDisplay;
import modelo.subject.WeatherData;

//Estação de Monitoramento Climático
public class WeatherStation {
    public static void main(String[] args) {
        //Instanciando Monitorador
        WeatherData weatherData = new WeatherData();
        
        //Atribuindo o display aos dados da Estação
        CurrentConditionsDisplay ccd 
                = new CurrentConditionsDisplay(weatherData);
        StatisticDisplay sd = new StatisticDisplay(weatherData);
        ForecastDisplay fd = new ForecastDisplay(weatherData);
        
        //Simulando variações de valores na Estação
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
        
        ccd.cancel();//Observador cancela atualziações
//        weatherData.removeObserver(ccd);//Sujeito remove observador
        
//        weatherData.setMeasurements(70, 82, 33.2f);
//        weatherData.setMeasurements(72, 85, 29.6f);
//        weatherData.setMeasurements(77, 79, 30.3f);
    }
}
