package ru.itementor.spring.boot_rest_template.demo.Service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itementor.spring.boot_rest_template.demo.model.User;

@Service
public class ApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://94.198.50.185:7081/api/users";
    private String sessionId;

    public void runClient() {
        //Get запрос - получить пользователей
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class);
        sessionId = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        System.out.println("Session Id: " + sessionId);

        //Post запрос - добавить пользователя
        User newUser = new User(3l, "James", "Brown", (byte) 19);
        headers.set("Cookie", sessionId);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> createRequest = new HttpEntity<>(newUser, headers);
        ResponseEntity<String> postResponse = restTemplate.exchange(baseUrl, HttpMethod.POST, createRequest, String.class);
        System.out.println("Part 1: " + postResponse.getBody());

        //Put запрос - изменить пользователя
        User updatedUser = new User(3L, "Thomas", "Shelby", (byte) 25);
        HttpEntity<User> updateRequest = new HttpEntity<>(updatedUser, headers);
        ResponseEntity<String> putResponse = restTemplate.exchange(baseUrl, HttpMethod.PUT, updateRequest, String.class);
        System.out.println("Part 2: " + putResponse.getBody());

        //Delete запрос - удалить пользователя
        HttpEntity<String> deleteRequest = new HttpEntity<>(headers);
        ResponseEntity<String> deleteResponse = restTemplate.exchange(baseUrl + "/3", HttpMethod.DELETE, deleteRequest, String.class);
        System.out.println("Part 3: " + deleteResponse.getBody());

        String finalCode = postResponse.getBody() + putResponse.getBody() + deleteResponse.getBody();
        System.out.println("Final Code: " + finalCode);


    }

}
