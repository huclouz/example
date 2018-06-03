package com.huttchang.example.modules;

import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/**
 * Mysql Password encode용으로 사용되는 Class
 */
@Service
public class MySqlPasswordEncoder {

    public String encode(CharSequence rawPassword) {
        if (rawPassword == null) {
            throw new NullPointerException();
        }

        byte[] bpara = new byte[rawPassword.length()];

        byte[] rethash;
        int i;
        for (i = 0; i < rawPassword.length(); i++)
            bpara[i] = (byte) (rawPassword.charAt(i) & 0xff);
        try {
            MessageDigest sha1er = MessageDigest.getInstance("SHA1");
            rethash = sha1er.digest(bpara); // stage1
            rethash = sha1er.digest(rethash); // stage2
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
        StringBuffer r = new StringBuffer(41);
        r.append("*");
        for (i = 0; i < rethash.length; i++) {
            String x = Integer.toHexString(rethash[i] & 0xff).toUpperCase();
            if (x.length() < 2)
                r.append("0");
            r.append(x);
        }

        return r.toString();
    }


}

