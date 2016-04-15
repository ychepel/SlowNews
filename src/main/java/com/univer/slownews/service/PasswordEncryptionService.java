package com.univer.slownews.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptionService {

    public String getEncryptedPassword(String original) throws ServiceException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(original.getBytes("UTF-8"));
            return new String(messageDigest.digest(), "UTF-8");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new ServiceException("Can't encrypt password", e);
        }
    }
}
