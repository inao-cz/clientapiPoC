package me.inao.ecdhexample;

import lombok.Getter;
import org.bouncycastle.pqc.crypto.ExchangePair;
import org.bouncycastle.pqc.crypto.newhope.NHExchangePairGenerator;
import org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.bouncycastle.util.encoders.Base64;

import java.security.SecureRandom;

public class KeyExchange {
    ExchangePair pair;
    @Getter
    private byte[] sharedVal = null;
    public void doKeyExchange(String encodedPublicKeyServer) {
        NHPublicKeyParameters params = new NHPublicKeyParameters(Base64.decode(encodedPublicKeyServer));
        pair = new NHExchangePairGenerator(new SecureRandom()).generateExchange(params);
        sharedVal = pair.getSharedValue();
    }

    public String getEncodedPublicKey() {
        return new String(Base64.encode(((NHPublicKeyParameters) pair.getPublicKey()).getPubData()));
    }
}
