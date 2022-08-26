package com.SbSecurity.configuaration;

import java.security.Permission;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;
import static com.SbSecurity.configuaration.ApllicationUserPermission.*;

public enum ApplicationUserRole {
	STUDENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, SRUDENT_READ,STUDENT_WRITE)),
	ADMINTRAINEE(Sets.newHashSet(COURSE_READ, SRUDENT_READ));
	

	private final Set<ApllicationUserPermission> permissions;
	
  ApplicationUserRole(Set<ApllicationUserPermission> permissions) {
		this.permissions = permissions;
	}
  public Set<ApllicationUserPermission> getPermissions(){
	  return permissions;
  }
  public Set<SimpleGrantedAuthority> grantedAuthorities(){
	  Set<SimpleGrantedAuthority> permissions= getPermissions().stream()
			  .map(Permission -> new SimpleGrantedAuthority(Permission.getPermission()))
			  .collect(Collectors.toSet());
	  permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
	  return permissions;
	  
	 
	  
	  
  }

}
