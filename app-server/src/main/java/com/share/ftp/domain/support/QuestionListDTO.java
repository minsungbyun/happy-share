package com.share.ftp.domain.support;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;


public class QuestionListDTO {

  private int no;
  private String title;
  private String qnaPassword;
  private QuestionCategory qnaType;
  private String content;
  private String reply;
  private List<QuestionAttachedFile> fileUpload;
  private Date registeredDate;
  private int viewCount;
  private int status;
  private JoinDTO owner;



  @Override
  public String toString() {
    return "QuestionListDTO [no=" + no + ", title=" + title + ", qnaPassword=" + qnaPassword
        + ", qnaType=" + qnaType + ", content=" + content + ", reply=" + reply + ", fileUpload="
        + fileUpload + ", registeredDate=" + registeredDate + ", viewCount=" + viewCount
        + ", status=" + status + ", owner=" + owner + "]";
  }



  public String getQnaPassword() {
    return qnaPassword;
  }



  public void setQnaPassword(String qnaPassword) {
    this.qnaPassword = qnaPassword;
  }



  public String getReply() {
    return reply;
  }
  public void setReply(String reply) {
    this.reply = reply;
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public QuestionCategory getQnaType() {
    return qnaType;
  }
  public void setQnaType(QuestionCategory qnaType) {
    this.qnaType = qnaType;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public List<QuestionAttachedFile> getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(List<QuestionAttachedFile> fileUpload) {
    this.fileUpload = fileUpload;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public JoinDTO getOwner() {
    return owner;
  }
  public void setOwner(JoinDTO owner) {
    this.owner = owner;
  }



}