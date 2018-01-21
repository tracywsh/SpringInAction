package root;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import entity.Action;

@Component
public class SpitterUserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		List<GrantedAuthority> authorities = 
				new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return new User("admin","landsea",authorities);
	}
	
	@Action(name="拦截")
	public void addAnnotation(){}
	
	public void addMethod(){}

}
