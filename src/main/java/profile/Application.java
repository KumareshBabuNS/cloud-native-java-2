package profile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

@Configuration
public class Application {

	private final Log log = LogFactory.getLog(getClass());
		
	@Bean
	static PropertySourcesPlaceholderConfigurer pspc() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Configuration
	@Profile("prod")
	@PropertySource("application-prod.properties")
	public static class ProdConfiguration {
		
		@Bean
		InitializingBean init() {
			return () -> LogFactory.getLog(getClass()).info("Prod InitializingBean");
		}
	}
	
	@Configuration
	@Profile({"default", "dev"})
	@PropertySource("application.properties")
	public static class DefaultConfiguration {
		
		@Bean
		InitializingBean init() {
			return () -> LogFactory.getLog(getClass()).info("default InitializingBean");
		}
	}
	
	@Bean
	InitializingBean which(Environment e, @Value("${configuration.projectName}") String projectName) {
		return () -> {
			log.info("activeProfiles: '" + StringUtils.arrayToCommaDelimitedString(e.getActiveProfiles()) + "'");
			log.info("configuration.projectName: " + projectName);
		};
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("prod");
		ctx.register(Application.class);
		ctx.refresh();
		ctx.close();
	}

}
