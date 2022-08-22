import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class GetSetData {

    String path = System.getProperty("user.home") + File.separator + ".lanMessenger";
    File configFile = new File(path + File.separator + "config.properties");
    Properties properties = new Properties();
    FileReader reader;
    FileWriter writer;
    public String getUsername(){
        try {
            reader = new FileReader(configFile);
            properties.load(reader);
            return properties.getProperty("USERNAME");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getFontSize(){
        try {
            reader = new FileReader(configFile);
            properties.load(reader);
            if (properties.getProperty("FONTSIZE") != null)
                return Integer.parseInt(properties.getProperty("FONTSIZE"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 12;
    }

    public void setUsername(String username){
        properties.setProperty("USERNAME", username);
        try {
            writer = new FileWriter(configFile);
            properties.store(writer, null);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFontSize(String fontSize){

        properties.setProperty("FONTSIZE", fontSize);
        try {
            writer = new FileWriter(configFile);
            properties.store(writer, null);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
