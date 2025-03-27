package com.dhivya.eshop.rest.api.service;

import com.dhivya.eshop.rest.api.payload.LoginDto;
import com.dhivya.eshop.rest.api.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
