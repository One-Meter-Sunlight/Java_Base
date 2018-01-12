package com.base.rsa;

import sun.misc.BASE64Encoder;

import java.security.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CK
 * @describe：RSA加密
 * @date 2017/10/20 16:59
 */
public class Keys {

    public static final String KEY_ALGORITHM = "RSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    public static void main(String[] args) {
        // 生成
        Map<String, Object> map = null;
        try {
            map = initKey();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String publicKey = getPublicKey(map);
        System.out.println("公钥：" + publicKey);

        System.out.println("=====================================");

        String privateKey = getPrivateKey(map);
        System.out.println("私钥：" + privateKey);
    }

    private static String getPrivateKey(Map<String, Object> map) {
        Key privateKey = (Key) map.get(PRIVATE_KEY);
        byte[] bt = privateKey.getEncoded();
        return new BASE64Encoder().encode(bt); // 加密私钥
    }

    private static String getPublicKey(Map<String, Object> map) {
        Key publicKey = (Key) map.get(PUBLIC_KEY);
        byte[] bt = publicKey.getEncoded();
        return new BASE64Encoder().encode(bt); // 加密公钥
    }

    private static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        Map<String, Object> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }

}
