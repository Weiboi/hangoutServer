package com.hangout.entity;


public class Whisper {

  private long id;//悄悄话id
  private long fromId;//发送者id
  private long toId;//接收者id
  private String content;//内容


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getFromId() {
    return fromId;
  }

  public void setFromId(long fromId) {
    this.fromId = fromId;
  }


  public long getToId() {
    return toId;
  }

  public void setToId(long toId) {
    this.toId = toId;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
