package com.nondo.springboot.user.repository;

import com.nondo.springboot.user.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
