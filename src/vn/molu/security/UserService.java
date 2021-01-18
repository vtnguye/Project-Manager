package vn.molu.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.molu.dao.impl.UserDAOImpl;

@Service("userService")
public class UserService implements UserDetailsService {

	UserDAOImpl repository = new UserDAOImpl();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("==========UserService============");
		try {
			vn.molu.domain.User obj = repository.login(username);
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User(obj.getUsername(), obj.getPassword(), true, true, true, true, authorities);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
