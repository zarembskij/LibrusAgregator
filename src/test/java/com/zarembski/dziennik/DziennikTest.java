package com.zarembski.dziennik;

import com.zarembski.dziennik.api.APIAccessFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DziennikTest {

	@Autowired
	APIAccessFactory apiAccessFactory;
	@Test
	public void contextLoads() throws IOException {
		Assert.notNull(apiAccessFactory.getAuthToken());
	}

}
