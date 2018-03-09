package me.abebe.demo;

import me.abebe.demo.model.AppUser;
import me.abebe.demo.repo.AppRoleRepository;
import me.abebe.demo.repo.AppUserRepository;
import me.abebe.demo.repo.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    AppRoleRepository appRoleRepository;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    ProfileRepository profileRepository;
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
        model.addAttribute("profile", new Profile());
        model.addAttribute("cat", Category.class);
            return "addtoprofile";
        }

    @RequestMapping("/searchterm")
    public String findTopics(HttpServletRequest request, Model model, @ModelAttribute Profile profile){

        String s = request.getParameter("q");
        String s2 = request.getParameter("cats");
//Category.ENTERTAINMENT.getCategoryId();
System.out.println(s2);
model.addAttribute("s",s);
String url ="https://newsapi.org/v2/everything?q=" + s+ "&apiKey=7f54c2f6c69248f0b2af877e2362420e";
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
    @GetMapping("/listprofile")
    public String showProfile(Model model, Authentication auth){
        AppUser user = appUserRepository.findAppUserByUsername(auth.getName());
        Iterable<Profile> prof = profileRepository.findDistinctByUsersIn(user);
        List<Articles> art = new ArrayList<>();

        model.addAttribute("hey",  art);
        for (Profile p: prof)
        {
            String urlt ="https://newsapi.org/v2/everything?q=" +
                    p.getTopic()+
                    "&apiKey=7f54c2f6c69248f0b2af877e2362420e";
           // String urlc ="https://newsapi.org/v2/everything?q=" + p.getCategory()+ "&apiKey=7f54c2f6c69248f0b2af877e2362420e";
            RestTemplate restTemplateT = new RestTemplate();
            NewsApi apit = restTemplateT.getForObject(urlt , NewsApi.class);
            //model.addAttribute("topics", apit.getArticles());
            art= apit
                    .getArticles();
            model.addAttribute("topics",  art);


           /* RestTemplate restTemplateC = new RestTemplate();
            NewsApi apic = restTemplateC.getForObject(urlc , NewsApi.class);

            model.addAttribute("categories", apic.getArticles());*/
            //title
        }
//model.addAttribute("list", profileRepository.findByUsersIn(user));

return "myprofile";
    }
    @RequestMapping("/addtopiccategory")
    public String topicCategory(@Valid @ModelAttribute Profile profile, BindingResult result, Model model, Authentication auth, HttpServletRequest request ){
       // profileRepository.save(profile);
        String s = request.getParameter("search");
        String s2 = request.getParameter("cats");
        AppUser user = appUserRepository.findAppUserByUsername(auth.getName());
        profile.addUser(user);
        if (result.hasErrors()) {
            return "addtoprofile";
        }
        profileRepository.save(profile);
        return "redirect:/listprofile";
    }
    @GetMapping("/addprofile")
    public String addToProfile(Model model){
        model.addAttribute("profile", new Profile());
        return "addtoprofile";
    }
    @GetMapping("/showprofile")
    public String shoeProfile(Model model, Authentication auth){
        AppUser user = appUserRepository.findAppUserByUsername(auth.getName());
        model.addAttribute("prof",profileRepository.findByUsersIn(user) );
        //System.out.println(profileRepository.findByUsersIn(user));

        return "showprofile";
    }
@GetMapping("/delete/{id}")
    public String deleteProfile(@PathVariable("id") long id, Model model){
    Profile profile = profileRepository.findById(id);
       profileRepository.delete(profile);
       return "redirect:/showprofile";
}

    @GetMapping("/view/{id}")
    public String viewprofiles(@PathVariable("id") long id, Model model, Authentication auth, HttpServletRequest request){
        String r = request.getParameter("r");
        Profile profile = profileRepository.findById(id);

        AppUser user = appUserRepository.findAppUserByUsername(auth.getName());
       Profile prof = profileRepository.findDistinctByUsersInAndId(user,id);

        String urlt ="https://newsapi.org/v2/everything?q=" +
                prof.getTopic()+
                "&apiKey=7f54c2f6c69248f0b2af877e2362420e";
        // String urlc ="https://newsapi.org/v2/everything?q=" + p.getCategory()+ "&apiKey=7f54c2f6c69248f0b2af877e2362420e";
        RestTemplate restTemplateT = new RestTemplate();
        NewsApi apit = restTemplateT.getForObject(urlt , NewsApi.class);

        model.addAttribute("topics", apit.getArticles());
        return "myprofile";
    }
    ////////////////////////////////////////////


    }
