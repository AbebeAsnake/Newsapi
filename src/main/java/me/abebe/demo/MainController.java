package me.abebe.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {
    @RequestMapping("/")
    public @ResponseBody String showNews(){
        RestTemplate restTemplate = new RestTemplate();
        Articles article = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&apiKey=7f54c2f6c69248f0b2af877e2362420e", Articles.class);

return article.getValue().getTitle();
    }
}
