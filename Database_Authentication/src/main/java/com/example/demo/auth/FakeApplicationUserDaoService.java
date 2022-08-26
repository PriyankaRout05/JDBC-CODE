package com.example.demo.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import static com.example.demo.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
		return getApplicationUsers()
				.stream()
				.filter(applicationUser -> username.equals(applicationUser.getUsername()))
				.findFirst();
	}
	
		private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
        		new ApplicationUser(
                        STUDENT.grantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "priya",
                        true,
                        true,
                        true,
                        true
                
        				 ),
                new ApplicationUser(
                        ADMIN.grantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "linda",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMINTRAINEE.grantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "tom",
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }
}


