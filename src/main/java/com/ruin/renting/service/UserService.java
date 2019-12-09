package com.ruin.renting.service;

/**
 * @author ruin
 * @date 2019/12/9-20:22
 */
public interface UserService {
    public Integer findUserByUsername(String username);

    public void doRegister(String phone,String email,String username,
                           String password);
}
