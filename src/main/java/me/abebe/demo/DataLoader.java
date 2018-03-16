package me.abebe.demo;

import me.abebe.demo.model.AppRole;
import me.abebe.demo.model.AppUser;
import me.abebe.demo.repo.AppRoleRepository;
import me.abebe.demo.repo.AppUserRepository;
import me.abebe.demo.repo.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    AppUserRepository userRepository;

    @Autowired
    AppRoleRepository roleRepository;

    @Autowired
    ProfileRepository profileRepository;
    @Override
    public void run(String... args) throws Exception {
// add role
        AppRole role = new AppRole();
        role.setRoleName("USER");
        roleRepository.save(role);

        role = new AppRole();
        role.setRoleName("ADMIN");
        roleRepository.save(role);
// addd user
        AppUser user = new AppUser();
        user.setFirstName("user");
        user.setLastName("lastName");
        user.setEmail("user@email.com");
        user.setImage("http://www.nurseryrhymes.org/nursery-rhymes-styles/images/john-jacob-jingleheimer-schmidt.jpg");
        user.setPassword("pass");
        user.setUsername("user");
        user.addRole(roleRepository.findAppRoleByRoleName("USER"));
        userRepository.save(user);
// add admin
        AppUser admin = new AppUser();
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setEmail("admin@email.com");
        admin.setImage("http://www.nurseryrhymes.org/nursery-rhymes-styles/images/john-jacob-jingleheimer-schmidt.jpg");
        admin.setPassword("pass");
        admin.setUsername("admin");
        admin.addRole(roleRepository.findAppRoleByRoleName("ADMIN"));
        userRepository.save(admin);

        //add profile
        Profile pro = new Profile();
        pro.addUser(userRepository.findAppUserByUsername("user"));
        pro.setTopic("Music");
        //pro.setCategory(Category.ENTERTAINMENT);
        profileRepository.save(pro);

    }
}
