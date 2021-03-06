package com.share.ftp.domain.admin;

import java.util.Objects;

public class QuestionDTO {

  private int no;
  private int adminId;
  private String title;
  private String content;


  @Override
  public int hashCode() {
    return Objects.hash(adminId, content, no, title);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    QuestionDTO other = (QuestionDTO) obj;
    return adminId == other.adminId && Objects.equals(content, other.content) && no == other.no
        && Objects.equals(title, other.title);
  }

  @Override
  public String toString() {
    return "QuestionDTO [no=" + no + ", adminId=" + adminId + ", title=" + title + ", content="
        + content + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getAdminId() {
    return adminId;
  }
  public void setAdminId(int adminId) {
    this.adminId = adminId;
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



}
