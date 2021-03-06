package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminNoticeDeleteHandler extends AbstractAdminNoticeHandler {


  public AdminNoticeDeleteHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[공지사항 삭제]");
    int no = (int) request.getAttribute("no"); 

    NoticeDTO noticeDTO = findByNo(no);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 게시물이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시물 삭제를 취소하였습니다.");
      return;
    }

    noticeDTOList.remove(noticeDTO);

    System.out.println("게시물을 삭제하였습니다.");
  }


}
