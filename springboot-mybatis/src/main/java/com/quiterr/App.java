package com.quiterr;

import com.quiterr.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Huangchen on 2017/5/4.
 */
@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private DeviceMapper deviceMapper;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.deviceMapper.findByPosition("机房"));
    }
}
