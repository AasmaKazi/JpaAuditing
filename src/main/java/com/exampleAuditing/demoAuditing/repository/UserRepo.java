package com.exampleAuditing.demoAuditing.repository;

import com.exampleAuditing.demoAuditing.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
