package snofang.repub.trepub.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.dsl.BooleanExpression;

import snofang.repub.trepub.entity.QUserEntity;
import snofang.repub.trepub.entity.UserEntity;
import snofang.repub.trepub.repository.UserRepository;

@Transactional
@Service(value = "userDetailsService")
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String input) {
		UserEntity user = null;

		if (input.contains("@"))
			user = userRepository.findByEmail(input);
		else
			user = userRepository.findByUsername(input);

		if (user == null)
			throw new BadCredentialsException("Bad credentials");

		new AccountStatusUserDetailsChecker().check(user);

		return user;
	}
	
	public Page<UserEntity> getUsers(String userName, Pageable p){
		QUserEntity que = QUserEntity.userEntity;
		BooleanExpression e1 = que.username.like(userName);
		return this.userRepository.findAll(e1, p);
	}
	
	public UserEntity createUser(UserEntity userEntity) {
		return this.userRepository.save(userEntity);
	}
	
	

}
