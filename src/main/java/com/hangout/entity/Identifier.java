package com.hangout.entity;

public class Identifier {
    private String openId;
    private String session_key;

    public Identifier() {
    }

    public Identifier(String openId, String session_key) {
        this.openId = openId;
        this.session_key = session_key;
    }

    public String getOpenId() {
        return openId;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    @Override
    public String toString() {
        return "Identifier{" +
                "openId='" + openId + '\'' +
                ", session_key='" + session_key + '\'' +
                '}';
    }
}
