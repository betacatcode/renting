package com.ruin.renting;

import com.ruin.renting.dao.HouseImgRepository;
import com.ruin.renting.dao.NewsRepository;
import com.ruin.renting.domain.HouseImg;
import com.ruin.renting.domain.News;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class Ch91ApplicationTests {

	@Autowired
	HouseImgRepository houseImgRepository;

	@Autowired
	NewsRepository newsRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void passwordEncode(){
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encode = bCryptPasswordEncoder.encode("ruin");
		System.out.println(encode);
	}

	@Test
	void getRandomRecords(){

		List<HouseImg> houseImgs=houseImgRepository.getRandomImages(10);
		for (HouseImg houseImg:houseImgs){
			System.out.println(houseImg);
		}
	}

	@Test
	void getAllNews(){
		List<News> allNews = newsRepository.findAll();
		for(News n:allNews)
			System.out.println(n);
	}

}
