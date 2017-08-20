package io.github.zodzhao;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by jiazhengzhao on 8/16/17.
 */
public class Utility {
    String PASSPATH = Eval.homeDir + "/.zdiary/res/.secure/";
    AsymmetricCryptography ac = new AsymmetricCryptography();
    PrivateKey privateKey = ac.getPrivate(PASSPATH + "KeyPair/privateKey");
    PublicKey publicKey = ac.getPublic(PASSPATH + "KeyPair/publicKey");

    public Utility() throws Exception {
    }

     String encrypt(String line) throws NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
        //TODO ADD ENCRYPTION METHOD
        String encrypted_msg = ac.encryptText(line, privateKey);

        return encrypted_msg;
    }

     String decrypt(String encryptedLine) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        //TODO: ADD DECRYPTION METHOD
         String decrypted_msg = ac.decryptText(encryptedLine, publicKey);

         return decrypted_msg;
    }
}
