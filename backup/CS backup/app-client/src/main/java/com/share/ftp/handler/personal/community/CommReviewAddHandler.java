package com.share.ftp.handler.personal.community;

import java.sql.Date;
import com.share.ftp.dao.CommReviewDao;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommReviewAddHandler implements Command {

  CommReviewDao commReviewDao;

  public CommReviewAddHandler(CommReviewDao commReviewDao) {
    this.commReviewDao = commReviewDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  한줄후기 등록  ]");

    CommReviewDTO commReviewDTO = new CommReviewDTO();

    commReviewDTO.setCommReviewNo(commReviewDao.getNextNum());
    commReviewDTO.setContent(Prompt.inputString("내용  ▶ "));
    commReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    commReviewDTO.setOwner(AuthLoginHandler.getLoginUser());

    commReviewDao.insert(commReviewDTO);

    System.out.println();
    System.out.println("[  ✔️ 후기가 등록 되었습니다. ]");
  }
}










