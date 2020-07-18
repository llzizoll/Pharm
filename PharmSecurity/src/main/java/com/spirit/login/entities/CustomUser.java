/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spirit.login.entities;

import java.util.Collection;
  import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Zizo
 */
public class CustomUser extends User{
  private static final long serialVersionUID = -3531439484732724601L;
 
  private final String firstName; 
  private final String lastName;
  private String email;

  public CustomUser(String username, String password, boolean enabled,
         boolean accountNonExpired, boolean credentialsNonExpired,
         boolean accountNonLocked, 
         Collection authorities,
         String firstName,String lastName,String email) {

             super(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);
             this.firstName = firstName;
             this.lastName = lastName;
             this.email=email;
             
     }

   
  public static long getSerialversionuid() {
        return serialVersionUID;
     } 

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    
  
}
