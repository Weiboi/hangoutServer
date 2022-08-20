package com.hangout.entity;


public class Takes {

  private int id;//id
  private String userId;//用户id
  private int teamId;//队伍id
  private String labour;//分工

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public int getTeamId() {
    return teamId;
  }

  public void setTeamId(int teamId) {
    this.teamId = teamId;
  }

  public String getLabour() {
    return labour;
  }

  public void setLabour(String labour) {
    this.labour = labour;
  }
}
