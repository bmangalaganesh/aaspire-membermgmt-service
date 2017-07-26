package com.ibm.aaspire.poc.config;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//TODO Doing this the dirty way.
//We want to get this out of the way for now. We will extract the values doing the hard-way parsing the JSON info from VCAP_SERVICES
@Configuration
@Profile({ "dev", "test", "prod" })
public class AppConfig {

	private static Logger logger = LoggerFactory.getLogger(AppConfig.class);

	String dbUrl;

	@Value("${jdbc-protocol}")
	String protocol;

	@Value("${jdbc-driver}")
	String driver;

	@Bean
	@SuppressWarnings("unchecked")
	public DataSource dataSource() {

		// Extract the JDBC URL from the environment (for Docker and Kubernetes
		// environment)
		String memberDatabaseSecrets = System.getenv("MEMBER_SERVICES_DATABASE");

		if (memberDatabaseSecrets != null) {
			// Information is available via a Kubernetes secret..
			logger.info("Extracting info from a Kubernetes Secret from the environment.. - MEMBER_SERVICES_DATABASE");

			// This value would be like the line below
			// "{\"db_type\":\"postgresql\",\"name\":\"bmix-dal-yp-place-holder\",,\"ca_certificate_base64\":\"<base64...>==\",\"deployment_id\":\"58e4804ebb82e60011000e62\",\"uri\":\"postgres://admin:<Password>@bluemix-sandbox-.dblayer.com:25228/compose\"}";

			JsonParser parser = JsonParserFactory.getJsonParser();
			Map<String, Object> jsonMap = parser.parseMap(memberDatabaseSecrets);

			dbUrl = jsonMap.get("uri").toString();
			System.out.println("Postgres URL is:" + dbUrl);

		} else {
			logger.info("Extracting info from VCAP_SERVICES. This app is likely deployed as a CF App");
			String vcap = System.getenv("VCAP_SERVICES");

			JsonParser parser = JsonParserFactory.getJsonParser();
			Map<String, Object> jsonMap = parser.parseMap(vcap);
			List<?> postgresArr = (List<?>) jsonMap.get("compose-for-postgresql");
			Map<String, ?> compose = (Map<String, Object>) postgresArr.get(0);
			Map<String, ?> creds = (Map<String, ?>) compose.get("credentials");
			dbUrl = creds.get("uri").toString();
		}

		// Do the parsing activity here..
		String[] parts = dbUrl.split("(://|@)");
		String[] userAndPass = parts[1].split(":");
		String user = userAndPass[0];
		String pass = userAndPass[1];
		String url = parts[2];
		
		logger.info("Database URL that is extracted from the environment (VCAP or Kubernetes is: "+ url);

		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(protocol + "://" + url);
		dataSourceBuilder.username(user);
		dataSourceBuilder.password(pass);
		dataSourceBuilder.driverClassName(driver);
		return dataSourceBuilder.build();
	}

}
