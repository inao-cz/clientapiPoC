package me.inao.ecdhexample;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import java.security.Security;

public class Main {
    public static void main(String[] args) {
        new Main().starter();
    }
    public void starter(){
        Security.addProvider(new BouncyCastleProvider());
        Connection conn = new Connection();
        KeyExchange exchange = new KeyExchange();
        conn.init();
        String pubKeyServer = conn.read();
        exchange.doKeyExchange(pubKeyServer);
        conn.write(exchange.getEncodedPublicKey());
        System.out.println(new String(Base64.encode(exchange.getSharedVal())));
    }
}
