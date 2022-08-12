package com.hangout.entity;


public class Journey {

  private long id;//id
  private String name;//行程名
  private String destination;//目标地
  private String shareCode;//分享码
  private long teamId;//队伍id


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }


  public String getShareCode() {
    return shareCode;
  }

  public void setShareCode(String shareCode) {
    this.shareCode = shareCode;
  }


  public long getTeamId() {
    return teamId;
  }

  public void setTeamId(long teamId) {
    this.teamId = teamId;
  }

}
