package me.abebe.demo;

import me.abebe.demo.model.AppUser;
import me.abebe.demo.repo.AppRoleRepository;
import me.abebe.demo.repo.AppUserRepository;
import me.abebe.demo.repo.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    AppUserRepository userRepository;

    @Autowired
    AppRoleRepository roleRepository;

    @Autowired
    ProfileRepository profileRepository;

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("users", new AppUser());
        return "registeruser";

    }
    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("users", new AppUser());
        return "registeruser";
    }
    @RequestMapping("/register")
    public String addItems(Model model , AppUser user){

        user.addRole(roleRepository.findAppRoleByRoleName("USER"));
        userRepository.save(user);
        return "redirect:/";

    }
}
