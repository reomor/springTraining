package com.github.reomor.appws.service.impl;

import com.github.reomor.appws.common.Utils;
import com.github.reomor.appws.model.request.UserDetailsRequestModel;
import com.github.reomor.appws.model.response.WebUserModel;
import com.github.reomor.appws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public WebUserModel createUser(UserDetailsRequestModel userDetails) {
        WebUserModel webUserModel = new WebUserModel();
        final UUID userId = utils.generateUserId();
        webUserModel.setUserId(userId);
        webUserModel.setEmail(userDetails.getEmail());
        webUserModel.setFirstName(userDetails.getFirstName());
        webUserModel.setLastName(userDetails.getLastName());
        return webUserModel;
    }
}
