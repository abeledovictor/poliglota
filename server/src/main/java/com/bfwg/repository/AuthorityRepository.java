package com.bfwg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bfwg.model.Authority;
import com.bfwg.model.UserRoleName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
  Authority findByName(UserRoleName name);
}
