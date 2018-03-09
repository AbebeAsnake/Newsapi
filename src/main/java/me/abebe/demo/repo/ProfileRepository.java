package me.abebe.demo.repo;

import me.abebe.demo.Profile;
import me.abebe.demo.model.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Iterable<Profile> findByUsersIn(AppUser users);
    List<Profile> findDistinctByUsersIn(AppUser user);

    Profile findDistinctByUsersInAndId(AppUser user, long id);
    Profile findById(long id);
}
