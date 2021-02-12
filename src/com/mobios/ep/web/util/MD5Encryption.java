package com.mobios.ep.web.util;

import java.security.MessageDigest;

public class MD5Encryption {
	public String getMD5EncryptedValue(String otp) {
        final byte[] defaultBytes = otp.getBytes();
        try {
            final MessageDigest md5MsgDigest = MessageDigest.getInstance("MD5");
            md5MsgDigest.reset();
            md5MsgDigest.update(defaultBytes);
            final byte messageDigest[] = md5MsgDigest.digest();
            final StringBuffer hexString = new StringBuffer();
            for (final byte element : messageDigest) {
                final String hex = Integer.toHexString(0xFF & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            otp = hexString + "";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return otp.substring(0, 8);
    }
}
