package br.com.seteideias.consumer.component;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientComponent {
    @Bean
    public WebClient webClientProdutos(WebClient.Builder builder){
        return builder
                .baseUrl("http://localhost:8002")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public WebClient webClientPrecos(WebClient.Builder builder){
        return builder
                .baseUrl("http://localhost:8001")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public void apenasPrinta (){
        System.err.println("APENAS PRINTA!!!!");
    }
}
