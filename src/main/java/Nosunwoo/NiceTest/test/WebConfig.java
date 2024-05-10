    package Nosunwoo.NiceTest.test;

    import org.springframework.context.annotation.Configuration;
    import org.springframework.web.servlet.config.annotation.CorsRegistry;
    import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


    // 스프링 서버 전역적으로 CORS 설정
    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {

            registry.addMapping("/**")
                    .allowedOrigins("http://3.39.62.170:80","http://127.0.0.1:5500","http://github-action-s3-list-app.s3-website.ap-northeast-2.amazonaws.com","http://localhost:8080", "http://localhost:5173","http://localhost:8081", "http://localhost:3000", "http://github-action-chatting-app.s3-website.ap-northeast-2.amazonaws.com","http://kim-maru.com") // 허용할 출처 추가
                    .allowedMethods("GET", "POST","DELETE","PUT") // 허용할 HTTP method
                    .allowCredentials(true) // 쿠키 인증 요청 허용
                    //.allowedOriginPatterns("*") //추가한 부분
                    .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱2
        }
//

    }
