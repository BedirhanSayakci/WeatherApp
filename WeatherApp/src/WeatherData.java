import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import com.google.gson.Gson;



public class WeatherData {

    private double temp;
    private int cloud;
    private double gust;
    private double speed;
    private BufferedImage icons;
    private URL imageIcons;

    WeatherProg weatherProg = new WeatherProg();

    public void weatherData(String loc){

    String API_KEY = "";
	String LOCATION = loc;
    String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION +  "&appid=" + API_KEY + "&units=metric"; 
	
    try {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        String line;
        
        while((line = rd.readLine()) != null) {
            
            result.append(line);
            
        }
        rd.close();
        
        System.out.println(result);
        
        String res = result.toString();
        Gson converter = new Gson();
        WeatherProg weatherProg = converter.fromJson(res , WeatherProg.class);

        URL urlIcon = new URL("http://openweathermap.org/img/wn/" + weatherProg.weather.get(0).getIcon() + ".png");        
        //String i = weatherProg.weather.get(0).getIcon();

        System.out.println(urlIcon);

        temp = weatherProg.main.getTemp();
        gust = weatherProg.wind.getGust();
        cloud = weatherProg.clouds.getAll();
        setSpeed(weatherProg.wind.getSpeed());

        BufferedImage image = ImageIO.read(urlIcon);

        icons = image;
        imageIcons = urlIcon;


    }
    catch(IOException a)
    {
        System.out.println(a.getMessage());
    }
}

    public URL getImageIcons() {
        return imageIcons;
    }

    public void setImageIcons(URL imageIcons) {
        this.imageIcons = imageIcons;
    }

    public BufferedImage getIcons() {
        return icons;
    }

    public void setIcons(BufferedImage icons) {
        this.icons = icons;
    }

    public double getGust() {
        return gust;
    }



    public void setGust(Double gust) {
        this.gust = gust;
    }



    public int getCloud() {
        return cloud;
    }



    public void setCloud(int cloud) {
        this.cloud = cloud;
    }



    public double getTemp() {
        return temp;
    }



    public void setTemp(double temp) {
        this.temp = temp;
    }

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}


