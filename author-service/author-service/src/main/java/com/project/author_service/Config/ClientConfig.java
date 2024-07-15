package com.project.author_service.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

//	@Autowired
//	private RestTemplate restTemplate;
//	
//	public Object fetchBookByAuthId(int authorId) {
//		restTemplate.ex
//	}
	
	//private LoadBalancedExchangeFilterFunction filterFunction;
	
//	@Bean
//	 WebClient bookWebClient() {
//		return WebClient.builder()
//				.baseUrl("http://book-service")
//				.filter(filterFunction)
//				.build();
//	}
//	
//	@Bean
//	 BookClient bookClient() {
//		
//		HttpServiceProxyFactory httpServiceProxyFactory
//		  = HttpServiceProxyFactory
//		  .builder(WebClientAdapter.forClient(bookWebClient()))
//		  .build();
//	}
}
