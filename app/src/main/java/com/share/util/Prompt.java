package com.share.util;

import static com.share.util.General.level.FROM_B_TO_A ;
import static com.share.util.General.level.FROM_C_TO_B;
import static com.share.util.General.level.FROM_D_TO_C ;
import static com.share.util.General.level.FROM_E_TO_D;
import static com.share.util.General.level.LEVEL_A;
import static com.share.util.General.level.LEVEL_B;
import static com.share.util.General.level.LEVEL_C;
import static com.share.util.General.level.LEVEL_D;
import static com.share.util.General.level.LEVEL_E;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.share.ftp.domain.join.JoinComparator;
import com.share.ftp.domain.join.JoinDTO;

public class Prompt {

  static Scanner keyboardScan = new Scanner(System.in);

  // 메서드의 접근 범위를 설정하지 않으면 
  // 기본 접근 범위는 같은 패키지 및 하위 클래스 만이 접근할 수 있다.
  // => 다른 패키지에서도 접근할 수 있도록 하려면 public 으로 공개해야 한다.
  public static String inputString(String title) {
    System.out.print(title);

    return keyboardScan.nextLine();
  }

  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  public static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }

  public static Boolean inputBool(String title) {
    return Boolean.valueOf(inputString(title));
  }


  public static void close() {
    keyboardScan.close();
  }

  public static int getUserPoint(JoinDTO loginUser) {

    return loginUser.getPoint();
  }


  public static String getUserLevel(JoinDTO loginUser) {

    int userPoint = loginUser.getPoint();
    //    
    if (userPoint < 0) {
      return "오류가 발생했습니다! 존재하지 않는 포인트입니다.";

    } else if (0 <= userPoint && userPoint < 1000) {
      loginUser.setLevel(LEVEL_E);

    } else if (1000 <= userPoint && userPoint < 2000) {
      loginUser.setLevel(LEVEL_D);

    } else if (2000 <= userPoint && userPoint < 3000) {
      loginUser.setLevel(LEVEL_C);

    } else if (3000 <= userPoint && userPoint < 4000) {
      loginUser.setLevel(LEVEL_B);

    } else if (userPoint >= 4000) {
      loginUser.setLevel(LEVEL_A);
    }

    return loginUser.getLevel();
  }

  public static int getUserRemainPoint(JoinDTO loginUser) {

    int needPoint = 0;
    int userPoint = loginUser.getPoint();

    if (userPoint < 0) {
      return -1;

    } else if (0 <= userPoint && userPoint < 1000) {
      needPoint = FROM_E_TO_D - userPoint;

    } else if (1000 <= userPoint && userPoint < 2000) {
      needPoint = FROM_D_TO_C - userPoint;

    } else if (2000 <= userPoint && userPoint < 3000) {
      needPoint = FROM_C_TO_B - userPoint;

    } else if (3000 <= userPoint && userPoint < 4000) {
      needPoint = FROM_B_TO_A - userPoint;

    } 
    return needPoint;
  }




  // 현재 로그인 한 회원의 포인트를 비교해서 나열함
  public static void getUserRank(List<JoinDTO> allUser) {

    JoinComparator comp = new JoinComparator();

    for(JoinDTO loginUser : allUser) {
      System.out.printf("포인트 : %d , 유저 이름 : %s\n",loginUser.getPoint(), loginUser.getName());
    }

    Collections.sort(allUser, comp);

    System.out.println("-----------------------------------------------------------------");
    for(JoinDTO loginUser : allUser) {
      System.out.printf("포인트 : %d , 유저 이름 : %s\n",loginUser.getPoint(), loginUser.getName());
    }


    //    List<Integer> point = new ArrayList<>();
    //
    //    for (JoinDTO loginUser : allUser) {
    //      point.add(loginUser.getPoint());
    //    }
    //
    //
    //        System.out.println("정렬 전");
    //        for (JoinDTO loginUser : allUser) {
    //          System.out.printf("포인트 : %d , 유저 이름 : %s\n ",loginUser.getPoint(), loginUser.getName());
    //          // 포인트 비교
    //        }
    //
    //    System.out.println("정렬 전");
    //    for (Integer loginUser : point) {
    //      System.out.printf("포인트 : %d \n", loginUser);
    //      // 포인트 비교
    //    }
    //
    //    Collections.sort(point);
    //    Collections.reverse(point);
    //
    //    System.out.println();
    //
    //    System.out.println("정렬 후");
    //    for (Integer loginUser : point) {
    //      System.out.printf("포인트 : %d \n", loginUser);
    //      // 포인트 비교
    //    }
    //
    //        System.out.println("정렬 후");
    //        for (JoinDTO loginUser : allUser) {
    //          // 포인트 비교
    //          System.out.printf("포인트 : %d , 유저 이름 : %s\n ",loginUser.getPoint(), loginUser.getName());
    //        }

  }

}







