package org.example.petproj.utils;

import org.example.petproj.exeptions.ConnectionFailedExeption;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MyRestClient {

    private RestClient restClient;

    public Map<String, Double> getMatches() {
        return matches;
    }

    private Map<String, Double> matches = null;
    private String body;

    //getting connected and recieving html code
    public MyRestClient getConnection(String localDate){
        if(localDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            restClient = RestClient.builder().baseUrl("https://www.cbr.ru/currency_base/daily?UniDbQuery.Posted=True&UniDbQuery.To=" + localDate).build();
        }else{
            restClient = RestClient.builder().baseUrl("https://www.cbr.ru/currency_base/daily").build();
        }
        body = restClient.get().retrieve().body(new ParameterizedTypeReference<String>() {});
        if(body == null){
            try {
                throw new ConnectionFailedExeption("Your connection to server is not successful. Please, fix it to continue");
            } catch (ConnectionFailedExeption e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }



    public Map<String, Double> findOnSiteByPattern(){//(String pattern){
        matches = new HashMap<>();
        Pattern pattern = Pattern.compile("<td>\\d+</td>(\\s|\\n)*<td>[а-яА-Я ]+</td>(\\s|\\n)*<td>\\d+,\\d+</td>");
        Matcher matcher = pattern.matcher(body);

        while(matcher.find()){
            String[] currentLine = matcher.group().split("</td>(\\s|\\n)*<td>");
            String amount = currentLine[0].replace("<td>", "");
            String name = currentLine[1];
            String value = currentLine[2].replace("</td>", "").replace(',', '.');
            double doubleValue = Double.parseDouble(value);
            double doubleAmount = Double.parseDouble(amount);
            matches.put(name, (double) doubleValue/doubleAmount);
        }
        matches.put("Российский рубль", 1D);
        return matches;
    }
}
