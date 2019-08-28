package io.reflectoring.starter;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "eventstarter.enabled", havingValue = "true")
@EnableConfigurationProperties(EventListenerProperties.class)
class EventAutoConfiguration {

	@Bean
	EventPublisher eventPublisher(List<EventListener> listeners){
		return new EventPublisher(listeners);
	}

}
