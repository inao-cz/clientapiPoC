package me.inao.ecdhexample;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
public class Session {
    public Session() {
        this.keyexchange = new KeyExchange();
    }

    @Setter
    private String identifier;

    @Setter
    private Date validity;

    @Setter
    private String token;

    @Setter
    private byte[] secret;
    private final KeyExchange keyexchange;
}
