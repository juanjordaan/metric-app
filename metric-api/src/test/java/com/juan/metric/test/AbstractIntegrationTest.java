package com.juan.metric.test;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.lang.reflect.ParameterizedType;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;

import com.juan.metric.MetricApplication;
import com.juan.metric.interfaces.rest.ApiDtoResponse;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT, classes=MetricApplication.class)
public abstract class AbstractIntegrationTest <Dto extends ApiDtoResponse>{
	@Autowired
	protected TestRestTemplate restTemplate;
	
	protected HttpHeaders defaultHeaders = new HttpHeaders();
	
	protected final Class<Dto> dtoClass;
	
	@SuppressWarnings("unchecked")
	public AbstractIntegrationTest() {
		this.dtoClass = (Class<Dto>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Before
	public void setup() {
		defaultHeaders.add(CONTENT_TYPE, APPLICATION_JSON_VALUE);
		defaultHeaders.add(ACCEPT, APPLICATION_JSON_VALUE);
		
		//LoggingSystem system = LoggingSystem.get(ClassLoader.getSystemClassLoader());
		//system.setLogLevel("com.mm.test.application", LogLevel.DEBUG);
		
		//LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		//StatusPrinter.print(lc);
	}
	
	protected abstract String getRestPath();
}
