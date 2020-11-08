package com.opencart.repository;

import com.opencart.datamodel.RegisterModel;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RegisterModelRepository {
    private RegisterModelRepository (){ }

    public static RegisterModel getRegisterModel () {
        String password = RandomStringUtils.randomAlphabetic(7);
        return RegisterModel.builder()
                .firstName(RandomStringUtils.randomAlphabetic(5))
                .lastName(RandomStringUtils.randomAlphabetic(5))
                .email (RandomStringUtils.randomAlphabetic(5)+"@gmail.com")
                .telephone (RandomStringUtils.randomNumeric(10))
                .password (password)
                .passwordConfirm(password)
                .build();
    }
}
