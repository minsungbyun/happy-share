package com.share.ftp.handler.personal.donation;

import java.util.Collection;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.util.Prompt;

public class DonationAdminPrompt {

  DonationBoardDao donationBoardDao;

  public DonationAdminPrompt(DonationBoardDao donationBoardDao) {
    this.donationBoardDao = donationBoardDao;
  }

  public DonationBoardDTO promptDonation() throws Exception {
    System.out.println();
    System.out.println("모금함목록:");

    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAllWait();

    for (DonationBoardDTO donationBoardDTO : donationBoardList) {
      System.out.println();
      System.out.printf("  [ %d. %s ]\n", donationBoardDTO.getNo(), donationBoardDTO.getTitle());
    }


    while (true) {
      try {


        System.out.println();
        int donationBoardNo = Prompt.inputInt("모금함 번호 선택? (취소: 0) ");
        if (donationBoardNo == 0) {
          return null;
        }

        //      for (DonationBoardDTO donationBoardDTO : donationBoardDTOList) {
        //        if (donationBoardNo == donationBoardDTO.getNo()) {
        //          donationRegisterDTO.setNo(donationBoardDTO.getNo());
        //        } 
        //      }
        DonationBoardDTO selectedDonation = findByNo(donationBoardNo, donationBoardList);
        if (selectedDonation != null) {
          return selectedDonation;
        } 

      } catch (NumberFormatException e) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("올바른 숫자를 입력하세요");
        System.out.println("--------------------------------------------------------------");
        continue; // 나중에 설정할거

      } catch (Exception e) {
        System.out.println("--------------------------------------------------------------");
        //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
        System.out.println("다시 입력 바랍니다.");
        System.out.println("--------------------------------------------------------------");
        continue;
      }



      System.out.println("모금함 번호가 옳지 않습니다.");
    }
  }

  protected DonationBoardDTO findByNo(int no, Collection<DonationBoardDTO> donationBoardList) throws Exception {
    for (DonationBoardDTO donationBoardDTO : donationBoardList) {
      if (donationBoardDTO.getNo() == no) {
        return donationBoardDTO;
      }
    }
    return null;
  }
}
