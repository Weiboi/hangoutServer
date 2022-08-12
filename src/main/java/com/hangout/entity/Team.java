package com.hangout.entity;


public class Team {

  private long id;//id
  private long leaderId;//队长id
  private long journeyId;//对应行程id


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getLeaderId() {
    return leaderId;
  }

  public void setLeaderId(long leaderId) {
    this.leaderId = leaderId;
  }


  public long getJourneyId() {
    return journeyId;
  }

  public void setJourneyId(long journeyId) {
    this.journeyId = journeyId;
  }

}
