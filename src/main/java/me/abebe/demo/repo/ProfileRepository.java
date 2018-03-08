package me.abebe.demo.repo;

import me.abebe.demo.profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<profile, Long> {
}
