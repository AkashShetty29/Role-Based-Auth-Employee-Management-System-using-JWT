package com.project13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project13.doa.RoleDao;
import com.project13.doa.UserDao;
import com.project13.entity.Role;
import com.project13.entity.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);
        
        Role managerRole = new Role();
        managerRole.setRoleName("Manager");
        managerRole.setRoleDescription("Manager role");
        roleDao.save(managerRole);
        
        Role hrRole = new Role();
        hrRole.setRoleName("HR");
        hrRole.setRoleDescription("HR role");
        roleDao.save(hrRole);
        
        Role teamLeadRole = new Role();
        teamLeadRole.setRoleName("TeamLead");
        teamLeadRole.setRoleDescription("Team Lead role");
        roleDao.save(teamLeadRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
        
      User managerUser = new User();
      managerUser.setUserName("manager123");
      managerUser.setUserPassword(getEncodedPassword("manager@123"));
      managerUser.setUserFirstName("raj");
      managerUser.setUserLastName("sharma");
      Set<Role> managerRoles = new HashSet<>();
      managerRoles.add(managerRole);
      managerUser.setRole(managerRoles);
      userDao.save(managerUser);
      
      
      User hrUser = new User();
      hrUser.setUserName("HR123");
      hrUser.setUserPassword(getEncodedPassword("HR@123"));
      hrUser.setUserFirstName("Thej");
      hrUser.setUserLastName("sharma");
      Set<Role> HRRoles = new HashSet<>();
      HRRoles.add(hrRole);
      hrUser.setRole(HRRoles);
      userDao.save(hrUser);
      
      User teamLeadUser = new User();
      teamLeadUser.setUserName("TeamLead123");
      teamLeadUser.setUserPassword(getEncodedPassword("TeamLead@123"));
      teamLeadUser.setUserFirstName("Akash");
      teamLeadUser.setUserLastName("Shetty");
      Set<Role> teamLeadRoles = new HashSet<>();
      teamLeadRoles.add(teamLeadRole);
      teamLeadUser.setRole(teamLeadRoles);
      userDao.save(teamLeadUser);
        
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
