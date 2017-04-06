package com.ibm.aaspire.poc.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({ "dev", "test", "prod" })
public class AppConfig {

	@Value("${postgresURL}")
	String dbUrl;

	@Value("${jdbc-protocol}")
	String protocol;

	@Value("${jdbc-driver}")
	String driver;

	@Bean
	public DataSource dataSource() {

		String vcap = System.getenv("VCAP_SERVICES");

		System.err.println("VCAP Services:" + vcap);

		JsonParser parser = JsonParserFactory.getJsonParser();
		Map<String, Object> jsonMap = parser.parseMap(vcap);
		// Do the parsing activity here..

		String[] parts = dbUrl.split("(://|@)");
		String[] userAndPass = parts[1].split(":");
		String user = userAndPass[0];
		String pass = userAndPass[1];
		String url = parts[2];

		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(protocol + "://" + url);
		dataSourceBuilder.username(user);
		dataSourceBuilder.password(pass);
		dataSourceBuilder.driverClassName(driver);
		return dataSourceBuilder.build();
	}

}
