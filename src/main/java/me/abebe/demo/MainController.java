package me.abebe.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @GetMapping("/")
    public String show(Model model){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=7f54c2f6c69248f0b2af877e2362420e";
        NewsApi api = restTemplate.getForObject(url, NewsApi.class);

        //RestTemplate restTemplate2 = new RestTemplate();
        //Articles article = restTemplate.getForObject(url, Articles.class);
        //Source sources = restTemplate2.getForObject("https://newsapi.org/v2/sources?apiKey=7f54c2f6c69248f0b2af877e2362420e", Source.class);

       // Articles articles = new Articles();
       List<Articles> art = new ArrayList<>();
       art= api
               .getArticles();
        model.addAttribute("hey",  art);
        //model.addAttribute("src", sources.getName());
        //model.addAttribute("src");
       /* for (Articles arts: art)
        {
            model.addAttribute("hey",  art);
            // title

            System.out.println(arts.getSources().getName());

            //System.out.println(arts.getDescription());
            //System.out.println(arts.getSources().getName());
            //System.out.println(arts.getUrl());
            //System.out.println(arts.getUrlToImage());
            //model.addAttribute("title", arts.getAuthor());
        }*/
       //model.addAttribute("hello", api.getArticles());
   //return api.getArticles();
      // System.out.println(sources.getName());
       return  "index";

    }
    @GetMapping("/searchterm")
        public String getsearch(Model model){
            return "addtoprofile";
        }

    @RequestMapping("/searchterm")
    public String findTopics(HttpServletRequest request, Model model){
String s = request.getParameter("search");
model.addAttribute(s);
String url ="https://newsapi.org/v2/everything?q=" + s+ "&apiKey=7f54c2f6c69248f0b2af877e2362420e";
        System.out.println(url);
RestTemplate restTemplate = new RestTemplate();
NewsApi api = restTemplate.getForObject(url , NewsApi.class);
        List<Articles> art = new ArrayList<>();
        art= api
                .getArticles();

model.addAttribute("everything " , art);

        for (Articles arts: art)
        {
            model.addAttribute("hey",  art);
            // title
           // System.out.println(arts.getSources().getName());
        }

return "searchresult";
    }
}
