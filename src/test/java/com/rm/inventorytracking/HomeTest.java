package com.rm.inventorytracking;

import com.rm.inventorytracking.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Home Contoller'ın boş olup olmadığını kontrol ediyoruz.
 * Home Controller, sitemizin anasayfasını oluşturuyor.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeTest {

    @Autowired
    private HomeController homeController;

    @Test
    public void homeContentLoads() throws Exception {
        assertThat(homeController).isNotNull();
    }
}
