package me.abebe.demo.repo;

import me.abebe.demo.Profile;
import me.abebe.demo.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Iterable<Profile> findByUsersIn(AppUser users);
}
