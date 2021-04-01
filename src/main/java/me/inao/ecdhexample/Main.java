package me.inao.ecdhexample;

import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        new Main().starter();
    }
    public void starter(){
        Security.addProvider(new BouncyCastleProvider());
        Connection conn = new Connection();
        conn.init();
        Session session = new Session();
        session.getKeyexchange().initKeys();
        String pubKeyServer = conn.read();
        conn.write(new String(Base64.getEncoder().encode(((ECPublicKey)session.getKeyexchange().getPair().getPublic()).getQ().getEncoded(true))));
        session.setSecret(session.getKeyexchange().calculateKey(Base64.getDecoder().decode(pubKeyServer)));
        System.out.println(Base64.getEncoder().encodeToString(session.getSecret()));
        try{
            conn.getConn().close();
        }catch(Exception e1){
            e1.printStackTrace();
        }
    }
}
