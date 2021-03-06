package com.share.ftp.handler.personal;

import com.share.util.Prompt;

public class DonationDetailHandler { // 모금함 정보를 상세보기 하는 곳

  DonationRegisterHandler donationRegisterHandler;

  public DonationDetailHandler(DonationRegisterHandler donationRegisterHandler) {
    this.donationRegisterHandler = donationRegisterHandler;
  }


  // 모금함 정보 상세보기
  public void detailDonationInfo() {
    System.out.println("[모금함 정보 상세보기]");
  }

  // 모금함 기부하기
  public void joinDonationList() {
    while (true) {
      try {
        System.out.println("1. 기부하기");
        System.out.println("0. 이전메뉴");

        int menuNo = Prompt.inputInt("기부하기> ");
        switch (menuNo) {
          case 1: donationRegisterHandler.add(); break;
          case 0: return;
          default:
            System.out.println("무효한 메뉴 번호입니다.");
        }
        System.out.println();
      } catch (Throwable e) {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("오류 발생: %s\n", e.getClass().getName());
        System.out.println("--------------------------------------------------------------");
      }
    }
  }
}
