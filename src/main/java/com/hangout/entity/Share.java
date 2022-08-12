package com.hangout.entity;


public class Share {

  private String code;//分享码
  private long journeyId;//对应行程id


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public long getJourneyId() {
    return journeyId;
  }

  public void setJourneyId(long journeyId) {
    this.journeyId = journeyId;
  }

}
