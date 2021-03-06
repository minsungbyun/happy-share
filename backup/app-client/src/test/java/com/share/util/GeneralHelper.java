package com.share.util;

import java.util.ArrayList;
import java.util.List;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.Status;
import com.share.ftp.domain.volunteer.VolunteerAttachedFile;

public class GeneralHelper {

  GeneralDao generalDao;

  public GeneralHelper(GeneralDao generalDao) {
    this.generalDao = generalDao;
  }

  public static String getRemainTime(long millis) {

    long sec =  millis / 1000;
    long min = sec / 60;
    long hour = min / 60;
    long day = (millis / 1000) / (24 * 60 * 60);

    hour = hour % 24; 
    sec = sec % 60;
    min = min % 60;

    return String.format("남은시간 ▶ %d일 %d시간 %d분 %d초 남았습니다\n", day, hour, min, sec);
  }

  public Category promptCategory() throws Exception {

    List<Category> categoryList = generalDao.findAllCategory();

    System.out.println(" ▶ 카테고리 유형 ");
    System.out.println();

    while (true) {
      for (int i = 0; i < categoryList.size(); i++) {
        Category category = categoryList.get(i);
        System.out.printf("%d ▶ %s\n", i + 1, category.getTitle());
      }

      int input = Prompt.inputInt("유형 ▶ ");

      if (0 < input && input < categoryList.size()) {
        return categoryList.get(input - 1);
      }
      System.out.println("올바른 번호를 입력해주세요");

    }
  }

  public Status promptStatus() throws Exception {

    List<Status> statusList = generalDao.findAllStatus();

    System.out.println(" ▶ 신청상태 ");
    System.out.println();

    while (true) {
      for (int i = 0; i < statusList.size(); i++) {
        Status status = statusList.get(i);
        System.out.printf("%d ▶ %s\n", i + 1, status.getTitle());
      }

      int input = Prompt.inputInt("상태 ▶ ");

      if (0 < input && input < statusList.size()) {
        return statusList.get(input - 1);
      }
      System.out.println("올바른 번호를 입력해주세요");
    }
  }

  public VolunteerAttachedFile promptFileUpload() {

    System.out.println();

    List<VolunteerAttachedFile> fileList = new ArrayList<>();

    while(true) {
      for (VolunteerAttachedFile filepath : fileList) {

        Prompt.inputString(" ▶ 첨부파일 (enter입력 시 종료)\n");
        System.out.println(" ▶ 첨부파일 (enter입력 시 종료)\n");

      }
    }



  }


}
