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
	public void addTest() {

		Meteorite meteorite = MeteoriteUtils.createTestMeteorite();
		Meteorite meteorite1 = MeteoriteUtils.createTestMeteorite();

		meteoriteService.add(meteorite);
		meteoriteService.add(meteorite1);

		List<Meteorite> meteoriteList = meteoriteService.getAll();

		Meteorite meteorite2 = MeteoriteUtils.findInList(meteoriteList, meteorite.getName());

		Assert.assertNotNull("The test passes and has recieved: ", meteorite2.getName());
	}

}
