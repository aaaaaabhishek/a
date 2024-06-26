package com.DB_Excel.Repositary;

import com.DB_Excel.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User, Long> {
}
