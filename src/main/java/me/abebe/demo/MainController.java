package me.abebe.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {
    @RequestMapping("/")
    public @ResponseBody List<Articles> show(HttpServletRequest request){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=7f54c2f6c69248f0b2af877e2362420e";
        NewsApi api = restTemplate.getForObject(url, NewsApi.class);
        Articles article = restTemplate.getForObject(url, Articles.class);
        Sources sources = restTemplate.getForObject(url, Sources.class);

   //return api.getArticles();
       return  api.getArticles();

    }
}
