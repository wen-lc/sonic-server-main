package org.cloud.sonic.common.tools;



import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author lxk
 * @date 2021/3/17 14:24
 */
@Slf4j
public class RSAUtils {

    private static final String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAqMP/vMj2rpNstVblB2ntGbQL++E+euYj6ktFIx0kwtprMO8jw4CHsFHhFcfGy1qEDQKBkCco2oLDdv20dY1msQIDAQABAkBTFWrpfeYzu9Bg1g6av8NCTCk6L4Ga74Hu7m9zAf3/Dsu/he2W5Nb02aFYoZsBSuylwiMya33GBfteaoPa3NoBAiEA1xF0h7qEGTAxXMN0rvXVdlhpIt8+KG7kE4B4v1V2JokCIQDI4peDnzcZz0b/cpxQ4FO/sAnXpAjtvw+6RlNtj4y06QIgJNK7RgX8WiezO/PHRbGXs+SdU7gvd1LNQD2N7wyd5ykCIQCYt+LV9pGuNm1UQC5kMdaZcNxaquL603jCdTpxnWMsGQIhAJuYBx8aLNKZFcHDA0+ExG3LTqDRwzMXzgvx26gjn3IA";
    private static final String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKjD/7zI9q6TbLVW5Qdp7Rm0C/vhPnrmI+pLRSMdJMLaazDvI8OAh7BR4RXHxstahA0CgZAnKNqCw3b9tHWNZrECAwEAAQ==";
    private static Map<Integer, String> keyMap = new HashMap<>();  //用于封装随机产生的公钥与私钥

    public static String encrypt(String str) throws Exception {
        return encrypt(str,publicKey);
    }

    /**
     * RSA公钥加密
     *
     * @param str
     *            加密字符串
     * @param publicKey
     *            公钥
     * @return 密文
     * @throws Exception
     *             加密过程中的异常信息
     */
    public static String encrypt( String str, String publicKey ) throws Exception{
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     *
     * @param input 输入密码
     * @param db 数据库中存储密码
     * @return
     */
    public static boolean sign(String input, String db){
        try {
            input = decrypt(input);
            db = decrypt(db);
            return input.equals(db);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    /**
     * RSA私钥解密
     *
     * @param str
     *            加密字符串
     * @return 铭文
     *             解密过程中的异常信息
     */
    public static String decrypt(String str) {
        if (StringUtils.isEmpty(str)) return "";
        System.out.println("str:"+str);
        try {
            //64位解码加密后的字符串
            byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
            //base64编码的私钥
            byte[] decoded = Base64.decodeBase64(privateKey);
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
            //RSA解密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            return  new String(cipher.doFinal(inputByte));
        }catch (Exception e){
            throw new MOneTestException(I18NConstants.SYS_ERROR_005);
        }
    }

    private static String getPublicKeyLicenseStr() throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = RSAUtils.class.getClassLoader().getResourceAsStream("public_key_license.pem");
        BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));
        String line = "";
        while ((line = br.readLine()) != null) {
            if (line.charAt(0) == '-') {
                continue;
            }
            sb.append(line);
        }
        return sb.toString();
    }

    /**
     * 公钥解密
     *
     * @param fileContext 解密内容
     * @return
     */
    public static String decryptLicense(String fileContext) {
        try {
            String publicKeyUrl = getPublicKeyLicenseStr();
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(java.util.Base64.getDecoder().decode(publicKeyUrl.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Key privateK = keyFactory.generatePublic(x509KeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateK);
            byte[] bytes = null;
            if (fileContext.contains("\r\n")) {
                bytes = java.util.Base64.getDecoder().decode(fileContext.replace("\r\n", ""));
            } else {
                bytes = java.util.Base64.getDecoder().decode(fileContext.replace("\n", ""));
            }
            int inputLen = bytes.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > 512) {
                    cache = cipher.doFinal(bytes, offSet, 512);
                } else {
                    cache = cipher.doFinal(bytes, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * 512;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return new String(decryptedData, StandardCharsets.UTF_8);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new MOneTestException(I18NConstants.SYS_ERROR_005);
        }
    }
}


