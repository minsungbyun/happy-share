package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommReviewDao;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommReviewUpdateHandler implements Command {

  CommReviewDao commReviewDao;

  public CommReviewUpdateHandler(CommReviewDao commReviewDao) {
    this.commReviewDao = commReviewDao;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {

    while(true) {

      System.out.println();
      System.out.println("[  한 줄 후기 변경  ]");
      int commReviewNo = (int) request.getAttribute("commReviewNo");

      CommReviewDTO commReviewDTO = commReviewDao.findByCommReviewNo(commReviewNo);


      if (commReviewDTO == null) {
        System.out.println("[  해당 번호의 후기가 없습니다.  ]");
        return;
      }

      //        if (commReviewDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
      //          System.out.println("[  삭제 권한이 없습니다.  ]");
      //          return;
      //        }

      String content = Prompt.inputString(String.format("내용(%s)? ", commReviewDTO.getContent()));

      try {
        String input = Prompt.inputString("[  정말 변경하시겠습니까?(y/N)  ]");
        if (input.equalsIgnoreCase("n")) {
          System.out.println("[  변경을 취소하였습니다.  ]");
          return;

        } else if(input.equals("y")) {
          commReviewDTO.setContent(content);

          commReviewDao.update(commReviewDTO);

          System.out.println("[  ✔️ 변경 되었습니다. ]");
          return;
        }

        else {
          System.out.println("[ y 또는 n을 입력하세요. ]");
          continue;
        }
      } catch (Throwable e) {

      }
    }
  }
}










