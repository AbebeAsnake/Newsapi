package me.abebe.demo.repo;

import me.abebe.demo.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
