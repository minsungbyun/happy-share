package com.share.ftp.domain.admin;

import java.sql.Date;
import java.util.Objects;

public class ChallengeDTO {

  private int no;
  private String adminId;
  private String title;
  private String content;
  private String fileUpload;
  private Date registeredDate;
  private int viewCount;

  @Override
  public int hashCode() {
    return Objects.hash(adminId, content, fileUpload, no, registeredDate, title, viewCount);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ChallengeDTO other = (ChallengeDTO) obj;
    return Objects.equals(adminId, other.adminId) && Objects.equals(content, other.content)
        && Objects.equals(fileUpload, other.fileUpload) && no == other.no
        && Objects.equals(registeredDate, other.registeredDate)
        && Objects.equals(title, other.title) && viewCount == other.viewCount;
  }

  @Override
  public String toString() {
    return "ChallengeDTO [no=" + no + ", adminId=" + adminId + ", title=" + title + ", content="
        + content + ", fileUpload=" + fileUpload + ", registeredDate=" + registeredDate
        + ", viewCount=" + viewCount + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getAdminId() {
    return adminId;
  }
  public void setAdminId(String adminId) {
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
  public String getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(String fileUpload) {
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


}
