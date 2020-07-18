/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spirit.login.auditing;


import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.spirit.login.entities.CustomUser;

/**
 *
 * @author Zizo
 */
public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
   return Optional.of(System.getProperty("zizoTest"));
//           Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//            if (authentication == null || !authentication.isAuthenticated()) {
//              return  Optional.of("test");
//            }
//            return Optional.of(((CustomUser) authentication.getPrincipal()).getUsername());
   }
   
} 