package Nosunwoo.NiceTest.test.chatting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // WebSocket 엔드포인트 등록
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:8080", "http://localhost:8081", "http://localhost:3000", "http://github-action-chatting-app.s3-website.ap-northeast-2.amazonaws.com");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 메시지 브로커 구성
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}

