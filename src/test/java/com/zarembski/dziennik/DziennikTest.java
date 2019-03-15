package com.zarembski.dziennik;

import com.zarembski.dziennik.api.ApiAccessFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DziennikTest {

	@Autowired
	ApiAccessFactory apiAccessFactory;
	@Test
	public void contextLoads() {
		Assert.notNull(apiAccessFactory.getAuthToken());
	}

}
