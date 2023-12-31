package com.project13.doa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project13.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
