# Weather Monitoring - Monitorador climático 

## Objetivo

O objetivo deste projeto é permitir que os dados de uma estação climática (temperatura, umidade e pressão), sempre que sofrerem alterações, sejam disponibilizados para um monitorador climático.

A estação registra um valor para temperatura, para umidade e outro para pressão e envia estes valores para o monitorador. Quando qualquer uma dessas grandezas variar, o novo valor registrado será enviado ao monitorador, a fim de atualizar seus dados.

## Monitorador

O monitorador é composto por três telas (displays) principais, podendo ser expansível caso necessário. 

Cada display possui uma finalidade: <b>Condições atuais</b> exibe temperatura, umidade e pressão conforme registrado na estação climática, <b>Condições futuras</b> exibe uma previsão do tempo com base na pressão e um índice específico e <b>Status meteorológico</b> exibe as temperaturas média, mínima e máxima.

Para uma nova tela ser adicionada no monitorador, basta que sua classe implemente a interface DisplayElement. 

## GoF Observer

Para permitir que cada display fosse atualizado com os novos valores foi utilizado o padrão comportamental Observer, um dos tipos de Padrões de Projetos conhecido como GoF (Gang of Four). Com ele é possível que uma classe (chamada de Subject) envie informações para várias outras classes (chamadas de Observer) e, sempre que essas informações sofrerem modificações, envie a nova informação para cada Observer.  

Assim, cada Observer se mantem atualizado da informação fornecido pelo Subject a medida que ela for sendo alterada (Como no exemplo, a cada variação de temperatura, pressão ou umidade, as telas do monitorador são atualziadas).

```java
//Estação de Monitoramento Climático
public class WeatherStation {
    public static void main(String[] args) {
        //Instanciando Monitorador
        WeatherData weatherData = new WeatherData();
        
        //Atribuindo o display aos dados da Estação
        CurrentConditionsDisplay ccd
            = new CurrentConditionsDisplay(weatherData);
    
        //Simulando variações de valores na Estação
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
```

```java
//Saída
Current condition: 80.0Fº degress and 65.0 humididy
Current condition: 82.0Fº degress and 70.0 humididy
Current condition: 78.0Fº degress and 90.0 humididy
```

## Ideia do projeto

A estação climática e seu monitorador foram inspirados no exemplo-problema abordado no livro "Use a Cabeça! Padrões de Projetos", 2ª edição revisada da Editora Alta Books.
