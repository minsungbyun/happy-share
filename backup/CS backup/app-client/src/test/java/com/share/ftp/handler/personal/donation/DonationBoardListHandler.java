package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Applied;
import java.text.DecimalFormat;
import java.util.List;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.CommandRequest;

public class DonationBoardListHandler extends AbstractDonationBoardHandler {


  public DonationBoardListHandler(
      List<DonationBoardDTO> donationBoardDTOList) {

    super(donationBoardDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    DecimalFormat formatter = new DecimalFormat("###,###,###");


    System.out.println();
    System.out.println("[모금함 승인 목록]");

    if (donationBoardDTOList.isEmpty()) {
      System.out.println("[ 현재 승인된 모금함 개설목록이 없습니다. ]");
      return;
    }

    for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
      if (donationBoardDTO.getIsSigned().equals(Applied)) {
        System.out.printf("개설번호: %d\n모금함 분류: %s\n제목: %s\n주최자: %s\n"
            + "개설기간: %s ~ %s\n목표금액: %s원\n승인여부: %s\n",
            donationBoardDTO.getNo(), 
            donationBoardDTO.getSort(), 
            donationBoardDTO.getTitle(), 
            donationBoardDTO.getLeader(),
            donationBoardDTO.getRegisteredStartDate(),
            donationBoardDTO.getRegisteredEndDate(),
            formatter.format(donationBoardDTO.getMoneyTarget()),
            donationBoardDTO.getIsSigned());
        System.out.printf("모금함 기부 기간 ▶ %d일\n",  ((((donationBoardDTO.getRegisteredEndDate().getTime() - donationBoardDTO.getRegisteredStartDate().getTime()) / 1000)) / (24*60*60)));
        System.out.printf(getRemainTime(donationBoardDTO.getRegisteredEndDate().getTime() - System.currentTimeMillis()));
        System.out.println("--------------------------------------------------------------");
      } 
    }
    //    else {
    //      System.out.println();
    //      System.out.println("[  현재 승인된 모금함 개설목록이 없습니다. ]");
    //      return;
    //    }
  }
}



















































