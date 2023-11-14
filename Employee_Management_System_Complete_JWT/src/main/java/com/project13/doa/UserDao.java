package com.project13.doa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project13.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
