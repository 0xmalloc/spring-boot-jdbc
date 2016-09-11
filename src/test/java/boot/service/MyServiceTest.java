package boot.service;

import javax.annotation.Resource;

import org.junit.Test;

import boot.domain.User;
import boot.service.MyService;
import boot.support.SpringTxTestCase;

public class MyServiceTest extends SpringTxTestCase{

	@Resource
	private MyService myService;
	
	@Test
	public void getPassword(){
		String password = myService.getPasswd("zhujinjun");
		assertEquals("888888", password);
	}
	
	@Test
	public void saveUser(){
		User user = new User();
		user.setUsername("zhangsan1");
		user.setPassword("111111");
		myService.saveUser(user);
	}

}
