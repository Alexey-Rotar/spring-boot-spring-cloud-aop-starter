package ru.gb.issue_service;

import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
// класс, обеспечивающий подключение к ресурсу book-service (провайдер ресурса book-service)
public class BookProvider {

    private final WebClient webClient;
//    private final EurekaClient eurekaClient;

    public BookProvider(EurekaClient eurekaClient, ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
//        this.eurekaClient = eurekaClient; // нужен при
    }

    public Book getRandomBook() {
        Book randomBook = webClient.get()
//                .uri("http://localhost:8580/book/random") // запрос напрямую к сервису, без Eureka!
//                .uri(getBookServiceIp() + "/book/random")
                .uri("http://book-service/book/random")
                .retrieve()
                .bodyToMono(Book.class)
                .block();
        return randomBook;
    }

//    private String getBookServiceIp(){
//        Application application = eurekaClient.getApplication("BOOK-SERVICE");
            // их может быть несколько с таким именем
            // т. е. может быть несколько серверов, выполняющих одну функцию, если большая нагрузка
//        List<InstanceInfo> instanceInfos = application.getInstances(); // поэтому лист

//        Random random = new Random();
            // берем любой в пределах списка
//        InstanceInfo randomInstance = instanceInfos.get(random.nextInt(instanceInfos.size()));
//        return "http://" + randomInstance.getIPAddr() + ":" + randomInstance.getPort();
//    }
}
