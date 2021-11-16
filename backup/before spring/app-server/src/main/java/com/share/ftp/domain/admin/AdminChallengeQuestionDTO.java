package com.share.ftp.domain.admin;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class AdminChallengeQuestionDTO implements Serializable {
  private int no;
  private int questionNo;
  private String title;
  private String content;
  private Date registeredDate;
  private JoinDTO owner;

  @Override
  public String toString() {
    return "ChallengeQuestionDTO [no=" + no + ", questionNo=" + questionNo + ", title=" + title
        + ", content=" + content + ", registeredDate=" + registeredDate + ", owner=" + owner + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, no, owner, questionNo, registeredDate, title);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AdminChallengeQuestionDTO other = (AdminChallengeQuestionDTO) obj;
    return Objects.equals(content, other.content) && no == other.no
        && Objects.equals(owner, other.owner) && questionNo == other.questionNo
        && Objects.equals(registeredDate, other.registeredDate)
        && Objects.equals(title, other.title);
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getQuestionNo() {
    return questionNo;
  }
  public void setQuestionNo(int questionNo) {
    this.questionNo = questionNo;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public JoinDTO getOwner() {
    return owner;
  }
  public void setOwner(JoinDTO owner) {
    this.owner = owner;
  }
}
