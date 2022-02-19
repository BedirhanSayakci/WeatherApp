import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Form1 {

    int frameWitdh_X = 500;
    int frameWitdh_Y = 500;



    JFrame frame = new JFrame();
    JTextField locationText = new JTextField(); 
    JButton button = new JButton("Enter");
    JLabel tempLabel = new JLabel("TEMP:");
    JLabel gustLabel = new JLabel("GUST SPEED:");
    JLabel couldsLabel = new JLabel("COULDS:");
    JLabel iconTextLabel = new JLabel();
    JLabel iconLabel = new JLabel();


    WeatherData weatherData = new WeatherData();
    WeatherProg weatherProg = new WeatherProg();

    public void form(){

        frame.setSize(frameWitdh_X,frameWitdh_Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        locationText.setBounds(150,10,200,30);
        button.setBounds(200,40,100,30);
        tempLabel.setBounds(200,70, 100,30); 
        gustLabel.setBounds(200,100, 200,30);
        couldsLabel.setBounds(200,130, 100,30);
        iconTextLabel.setBounds(200,230, 100,50);
        iconLabel.setBounds(200,200, 100,50);

    
        button.addActionListener(new Action() {
    
            @Override
            public void actionPerformed(ActionEvent e) {
                
                weatherData.weatherData(locationText.getText());
    
                tempLabel.setText("TEMP: " + weatherData.getTemp() + "C");
                gustLabel.setText("GUST SPEED: " + weatherData.getSpeed() + "m/s");
                couldsLabel.setText("CLOUD: " + weatherData.getCloud() + "%");
        }
    
            @Override
            public Object getValue(String key) {
                // TODO Auto-generated method stub
                return null;
            }
    
            @Override
            public void putValue(String key, Object value) {
                // TODO Auto-generated method stub
                
            }
    
            @Override
            public void setEnabled(boolean b) {
                // TODO Auto-generated method stub
                
            }
    
            @Override
            public boolean isEnabled() {
                // TODO Auto-generated method stub
                return false;
            }
    
            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {
                // TODO Auto-generated method stub
                
            }
    
            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {
                // TODO Auto-generated method stub
                
            }
            
        });
    
    
        frame.add(locationText);
        frame.add(button);
        frame.add(tempLabel);
        frame.add(gustLabel);
        frame.add(couldsLabel);
        frame.add(iconTextLabel);
        frame.add(iconLabel);
        
        frame.setLayout(null);
        frame.setVisible(true);	

}
}

