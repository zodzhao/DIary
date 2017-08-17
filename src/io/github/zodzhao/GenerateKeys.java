package io.github.zodzhao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

class GenerateKeys {
    private KeyPairGenerator keyGen;
    private KeyPair pair;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    GenerateKeys(int keylength) throws NoSuchAlgorithmException, NoSuchProviderException {
        this.keyGen = KeyPairGenerator.getInstance("RSA");
        this.keyGen.initialize(keylength);
    }

    void createKeys() {
        this.pair = this.keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    PublicKey getPublicKey() {
        return this.publicKey;
    }

    void writeToFile(String path, byte[] key) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }
}
