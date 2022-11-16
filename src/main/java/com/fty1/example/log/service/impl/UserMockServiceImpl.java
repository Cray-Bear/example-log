package com.fty1.example.log.service.impl;

import com.fty1.example.log.entity.User;
import com.fty1.example.log.repository.UserRepository;
import com.fty1.example.log.service.UserMockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UserMockServiceImpl implements UserMockService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public void mock() {

        // 1.查询id=1的数据
        {
            Optional<User> userOptional = userRepository.findById(1L);
            log.info("查询id=1的数据-User:{}", userOptional.orElse(new User()));
        }


        // 2.新增、修改新数据

        {

            User user = new User();
            user.setUserId(32L);
            user.setRealName("王七");
            user.setIdCardNo("220727202211133033");
            userRepository.save(user);

            Optional<User> userOptional = userRepository.findById(user.getUserId());
            User data = userOptional.orElse(new User());
            log.info("新增、修改新数据-User:{}", data);
            data.setRealName("王七-3");
            userRepository.save(data);
            Optional<User> dataOptional = userRepository.findById(data.getUserId());
            User item = dataOptional.orElse(new User());
            log.info("新增、修改新数据-User:{}", item);
        }

    }
}
