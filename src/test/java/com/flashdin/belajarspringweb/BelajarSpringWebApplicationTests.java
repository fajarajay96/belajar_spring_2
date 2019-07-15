package com.flashdin.belajarspringweb;

import com.flashdin.belajarspringweb.entity.Mahasiswa;
import com.flashdin.belajarspringweb.service.MahasiswaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BelajarSpringWebApplicationTests {
    @Autowired
    MahasiswaService mahasiswaService;

         @Test
	public void contextLoads() {
            for (Mahasiswa l:mahasiswaService.findAll())
            {
                System.out.println(l.getNama());
            }
	}

}
