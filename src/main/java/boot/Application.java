package boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties
@SpringBootApplication
public class Application {

	private final Log log = LogFactory.getLog(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	public Application(ConfigurationProjectProperties properties) {
		log.info("------- projectName : " + properties.getProjectName());
	}
	
}

@Component
@ConfigurationProperties("configuration")
class ConfigurationProjectProperties {
	
	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
