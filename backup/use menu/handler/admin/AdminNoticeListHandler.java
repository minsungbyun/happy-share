package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;

public class AdminNoticeListHandler extends AbstractAdminNoticeHandler {


  public AdminNoticeListHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }



  public void execute() {
    System.out.println("[회원 목록]");

    for (NoticeDTO noticeDTO : noticeDTOList) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          noticeDTO.getNo(), 
          noticeDTO.getAdminId(), 
          noticeDTO.getTitle(), 
          noticeDTO.getContent(), 
          noticeDTO.getFileUpload(), 
          noticeDTO.getRegisteredDate());
    }
  }



}
