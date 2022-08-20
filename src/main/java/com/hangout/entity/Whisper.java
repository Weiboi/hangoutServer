package com.hangout.entity;


public class Whisper {

  private int id;//悄悄话id
  private String fromId;//发送者id
  private String toId;//接收者id
  private String content;//内容

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFromId() {
    return fromId;
  }

  public void setFromId(String fromId) {
    this.fromId = fromId;
  }

  public String getToId() {
    return toId;
  }

  public void setToId(String toId) {
    this.toId = toId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
