package com.ngimbis.labs.watchthis.repository;

import com.ngimbis.labs.watchthis.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
