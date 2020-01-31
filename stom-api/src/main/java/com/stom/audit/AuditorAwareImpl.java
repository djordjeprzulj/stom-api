package com.stom.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username;
    	if (principal instanceof UserDetails) {
    		  username = ((UserDetails)principal).getUsername();
    		} else {
    		  username = principal.toString();
    		}
        return Optional.of(username);
        // Use below commented code when will use Spring Security.
    }
}
