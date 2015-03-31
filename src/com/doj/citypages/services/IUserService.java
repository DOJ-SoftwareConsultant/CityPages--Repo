package com.doj.citypages.services;

import com.doj.citypages.entities.CpuserAccount;
import com.doj.citypages.entities.VerificationToken;
import com.doj.citypages.validation.EmailExistsException;

public interface IUserService {

    CpuserAccount registerNewUserAccount(UserDto accountDto) throws EmailExistsException;

    CpuserAccount getUser(String verificationToken);

    void saveRegisteredUser(CpuserAccount user);

    void deleteUser(CpuserAccount user);

    void createVerificationTokenForUser(CpuserAccount user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

}
