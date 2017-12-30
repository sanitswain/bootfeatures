package practice.boot.features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * It is sometime difficult to configure each and every property using @Value,
 * so boot provides ConfigurationProperties feature to auto binding of
 * properties with the bean.
 * </p>
 * 
 * For custom property validation refer
 * https://github.com/spring-projects/spring-boot/tree/v1.4.7.RELEASE/spring-boot-samples/spring-boot-sample-property-validation
 * 
 * @see https://docs.spring.io/spring-boot/docs/1.4.7.RELEASE/reference/htmlsingle/#boot-features
 * 
 */
@Component
@ConfigurationProperties(prefix = "project")
public class ConfigurationPropertiesTest {

	// @Value("${project.name}")
	@NotNull
	private String name;
	private String description;

	/*
	 * For nested POJOs, if it has default constructor the setter not required.
	 * Otherwise nested POJO instance should be explicitly instantiated.
	 */
	private DistributionList dl = new DistributionList();

	/*
	 * In order to validate values of nested properties, you must annotate the
	 * associated field as @Valid to trigger its validation
	 */
	@Valid
	private Technology technology = new Technology();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DistributionList getDl() {
		return dl;
	}

	public Technology getTechnology() {
		return technology;
	}

	public static class DistributionList {
		/*
		 * For map setter is not required.
		 */
		private Map<String, String> adteam = new HashMap<>();
		private Map<String, String> supportteam = new HashMap<>();
		private Map<String, String> bateam = new HashMap<>();

		public Map<String, String> getAdteam() {
			return adteam;
		}

		public Map<String, String> getSupportteam() {
			return supportteam;
		}

		public Map<String, String> getBateam() {
			return bateam;
		}

		@Override
		public String toString() {
			return "DL [adteam=" + adteam + ", supportteam=" + supportteam + ", bateam=" + bateam + "]";
		}

	}

	public static class Technology {

		private List<String> frontend;
		private List<String> backend;

		@NotEmpty
		private List<String> middlelayer;

		public List<String> getFrontend() {
			return frontend;
		}

		public void setFrontend(List<String> frontend) {
			this.frontend = frontend;
		}

		public List<String> getBackend() {
			return backend;
		}

		public void setBackend(List<String> backend) {
			this.backend = backend;
		}

		public List<String> getMiddlelayer() {
			return middlelayer;
		}

		public void setMiddlelayer(List<String> middlelayer) {
			this.middlelayer = middlelayer;
		}

		@Override
		public String toString() {
			return "Technology [frontend=" + frontend + ", backend=" + backend + ", middlelayer=" + middlelayer + "]";
		}

	}

	@Override
	public String toString() {
		return "ConfigurationPropertiesTest [name=" + name + ", description=" + description + ", dl=" + dl
				+ ", technology=" + technology + "]";
	}

}
