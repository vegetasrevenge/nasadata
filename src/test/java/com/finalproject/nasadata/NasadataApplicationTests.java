package com.finalproject.nasadata;

import com.finalproject.nasadata.domain.Meteorite;
import com.finalproject.nasadata.service.MeteoriteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.finalproject.nasadata.common.MeteoriteUtils;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NasadataApplicationTests {

	@Autowired
	private MeteoriteService meteoriteService;

	@Transactional
	@Test
	public void getByIdTest() {

		Meteorite meteorite = meteoriteService.getById(1);


//		List<Meteorite> meteoriteList = meteoriteService.getAll();


		Assert.assertNotNull("The test passes and has received: ", meteorite.getName());
	}

}
