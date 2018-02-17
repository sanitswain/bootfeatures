package practice.boot.features.conditionals;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is a sample for ConditionalOnProperty where reporting scheduler bean
 * will be created based on a given condition. In development some features
 * might not be required, in such cases it is a good idea to not to create these
 * beans at all.
 * 
 * Following are the steps required:
 * 
 * 1. Create features.properties file and include feature enabling keys.
 * 		Example: app.reporting-scheduler.enable
 * 
 * 2. Configure @PropertySource("features.properties") in Starter class
 * 
 * 3. Annotate conditional beans with @ConditionalOnProperty
 * 		Example: @ConditionalOnProperty(name = "app.reporting-scheduler.enable")
 *
 *
 * @ConditionalOnProperty resolves properties from environment properties or
 * system properties. So including @PropertySource registers properties into 
 * spring application environment and looked while creating beans.
 */
@Configuration
public class AppFeaturesConfiguration {

	@Bean("reportingScheduler")
	@ConditionalOnProperty(name = "app.reporting-scheduler.enable")
	public SampleScheduler sampleScheduler() {
		return new SampleScheduler("This is a conditional scheduler.");
	}

	public static class SampleScheduler {
		private String text;

		public SampleScheduler(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return "SampleScheduler [text=" + text + "]";
		}

	}
}
