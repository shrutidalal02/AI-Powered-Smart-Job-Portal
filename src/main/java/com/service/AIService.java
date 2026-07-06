package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AIService {

    @Value("${groq.api.key}")
    private String apiKey;

    public String extractSkills(String resumeText) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.groq.com/openai/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        
        System.out.println("API KEY = " + apiKey);
        
       // headers.setBearerAuth(apiKey);

        headers.set("Authorization", "Bearer " + apiKey);

        // Message
        Map<String, String> message = new HashMap<>();

        message.put("role", "user");

        message.put(
                "content",
                "Extract technical skills from this resume text: "
                        + resumeText
        );

        List<Map<String, String>> messages = List.of(message);

        // Request body
        Map<String, Object> requestBody = new HashMap<>();
        
        //requestBody.put("model", "llama-3.3-70b-versatile");

        requestBody.put("model", "llama-3.1-8b-instant");
        
//        requestBody.put(
//                "model",
//                "llama3-8b-8192"
//        );

        requestBody.put("messages", messages);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(requestBody, headers);
        
        try {

            ResponseEntity<String> response =
                    restTemplate.postForEntity(
                            url,
                            request,
                            String.class
                    );
            
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(response.getBody());

            String result = root
                    .get("choices")
                    .get(0)
                    .get("message")
                    .get("content")
                    .asText();

            return result;

           // return response.getBody();

        } catch (Exception e) {

            e.printStackTrace();

            return e.getMessage();
        }
    }
}




//@Service
//public class AIService {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Value("${openrouter.api.key}")
//    private String apiKey;
//
//
//    public String extractSkills(String resumeText) {
//
//        String url = "https://openrouter.ai/api/v1/chat/completions";
//        
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        System.out.println(apiKey);
//
//        headers.set("Authorization", "Bearer " + apiKey);
//        //headers.setBearerAuth(apiKey);
//
//        headers.add("HTTP-Referer", "http://localhost:8081");
//
//        headers.add("X-Title", "AI Job Portal");
//
//
//        // Message
//        Map<String, String> message = new HashMap<>();
//
//        message.put("role", "user");
//
//        message.put(
//            "content",
//            "Extract technical skills from this resume text: "
//                    + resumeText
//        );
//
//
//        // Request body
//        
//        Map<String, Object> requestBody = new HashMap<>();
//
//        requestBody.put(
//                "model",
//                "openai/gpt-3.5-turbo"
//        );
//
//        requestBody.put("messages", message);
//        
////        Map<String, Object> requestBody = new HashMap<>();
////        requestBody.put(
////        		"model",
////        		"microsoft/phi-3-mini-128k-instruct:free"
////        		);
////        
////        
//////        requestBody.put(
//////            "model",
//////            "google/gemma-2-9b-it:free"
//////        );
////
////        requestBody.put(
////            "messages",
////            List.of(message)
////        );
//        
//        
//        
////        HttpHeaders headers = new HttpHeaders();
////
////        headers.setContentType(MediaType.APPLICATION_JSON);
////
////        headers.setBearerAuth(apiKey);
////
////        headers.add("HTTP-Referer", "http://localhost:8081");
////
////        headers.add("X-Title", "AI Job Portal");
//
////        HttpHeaders headers = new HttpHeaders();
////
////        headers.setContentType(MediaType.APPLICATION_JSON);
////
////        headers.setBearerAuth(apiKey);
//
//        // Message
////        Map<String, String> message = new HashMap<>();
////
////        message.put("role", "user");
////
////        message.put("content",
////                "Extract technical skills from this resume text: "
////                        + resumeText);
////
////        // Request body
////       
////        Map<String, Object> requestBody = new HashMap<>();
////        
////        requestBody.put(
////        	    "model",
////        	    "openai/gpt-3.5-turbo"
////        	);
//        
////        requestBody.put(
////        	    "model",
////        	    "google/gemma-2-9b-it:free"
////        	);
////        requestBody.put(
////        	    "model",
////        	    "meta-llama/llama-3-8b-instruct:free"
////        	);
//        
////        requestBody.put("model",
////                "mistralai/mistral-7b-instruct:free");
//        
//       // requestBody.put("model", "openai/gpt-3.5-turbo");
//
////        requestBody.put("messages", List.of(message));
//
//        HttpEntity<Map<String, Object>> entity =
//                new HttpEntity<>(requestBody, headers);
//
//        ResponseEntity<String> response =
//                restTemplate.exchange(
//                        url,
//                        HttpMethod.POST,
//                        entity,
//                        String.class
//                );
//
//        return response.getBody();
//    }
//}
//
////import java.util.HashMap;
////import java.util.Map;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.http.*;
////import org.springframework.stereotype.Service;
////import org.springframework.web.client.RestTemplate;
////
////@Service
////public class AIService {
////
////    @Autowired
////    private RestTemplate restTemplate;
////
////    @Value("${gemini.api.key}")
////    private String apiKey;
////
////
////    public String extractSkills(String resumeText) {
////
////        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key="
////                + apiKey;
////
////        // Prompt
////        String prompt = "Extract technical skills from this resume text: " + resumeText;
////
////        // Request body
////        Map<String, Object> textMap = new HashMap<>();
////        textMap.put("text", prompt);
////
////        Map<String, Object> part = new HashMap<>();
////        part.put("parts", new Object[]{textMap});
////
////        Map<String, Object> requestBody = new HashMap<>();
////        requestBody.put("contents", new Object[]{part});
////
////        // Headers
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON);
////
////        HttpEntity<Map<String, Object>> entity =
////                new HttpEntity<>(requestBody, headers);
////
////        // API call
////        ResponseEntity<String> response = restTemplate.exchange(
////                url,
////                HttpMethod.POST,
////                entity,
////                String.class
////        );
////
////        return response.getBody();
////    }
////}
