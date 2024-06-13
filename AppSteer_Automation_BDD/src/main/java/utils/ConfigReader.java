package utils;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.util.Properties;

	public class ConfigReader {
	    private Properties prop;

	    public Properties init_prop() {
	        prop = new Properties();
	        try (InputStream input = new FileInputStream(".\\src\\test\\resource\\config\\config.properties")) {
	        	prop.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return prop;
	    }

	    public String getProperty(String key) {
	    	 prop = new Properties();
		        try (InputStream input = new FileInputStream(".\\src\\test\\resource\\config\\config.properties")) {
		        	prop.load(input);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }	        return prop.getProperty(key);
	    }

	    public static void main(String[] args) {
	        ConfigReader configReader = new ConfigReader();
	        String browser = configReader.getProperty("browser");
	        String url = configReader.getProperty("url");
	        String username = configReader.getProperty("username");
	        String password = configReader.getProperty("password");

	        System.out.println("Browser: " + browser);
	        System.out.println("URL: " + url);
	        System.out.println("Username: " + username);
	        System.out.println("Password: " + password);
	    }
	}
