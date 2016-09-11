package boot.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import boot.dao.UserRepository;
import boot.domain.User;

@Service
public class MyService {


	@Resource
	private UserRepository userRepository;
	
	public String getPasswd(String username){
		return userRepository.getPassword(username);
	}
	
	public void saveUser(final User user){
		userRepository.saveUser(user);
	}

}
