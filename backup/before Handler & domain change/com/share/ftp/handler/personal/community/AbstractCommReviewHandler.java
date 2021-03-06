package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractCommReviewHandler implements Command {

  protected List<CommReviewDTO> commReviewDTOList;

  public AbstractCommReviewHandler(List<CommReviewDTO> commReviewDTOList) {
    this.commReviewDTOList = commReviewDTOList;
  }

  protected CommReviewDTO findByNo(int no) {
    for(CommReviewDTO commReviewDTO : commReviewDTOList) {
      if(commReviewDTO.getNo() == no) {
        return commReviewDTO;
      }
    }
    return null;
  }
}










