package com.fty1.example.log.task;

import com.fty1.example.log.entity.User;
import com.fty1.example.log.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shardingsphere.driver.jdbc.core.datasource.ShardingSphereDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Component
@Slf4j
public class LogMockTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private UserRepository userRepository;
    @Scheduled(fixedRate = 1000L,initialDelay = 10000L)
    public void mockLog() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        User user = new User();
        user.setRealName("王七");
        user.setIdCardNo(RandomStringUtils.randomNumeric(18));
        userRepository.save(user);
        Optional<User> userOptional = userRepository.findById(user.getUserId());
        User data = userOptional.orElse(new User());
        log.info("新增、修改新数据-User:{}", data);
    }
}
