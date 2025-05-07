package com.stoliar.usersubscriptionservice.repository;

import com.stoliar.usersubscriptionservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}