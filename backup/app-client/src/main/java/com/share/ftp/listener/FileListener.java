package com.share.ftp.listener;

//public class FileListener implements ApplicationContextListener {
//
//  @SuppressWarnings("unchecked")
//  @Override
//  public void contextInitialized(Map<String, Object> params) {
//
//    List<JoinDTO> joinDTOList = (List<JoinDTO>) params.get("joinDTOList");
//
//    //    List<VolListDTO> volListDTOList = (List<VolListDTO>) params.get("volListDTOList");
//
//    List<GeneralRequestDTO> generalRequestDTOList = (List<GeneralRequestDTO>) params.get("generalRequestDTOList");
//    List<GeneralRequestDTO> generalRequestApplyDTOList = (List<GeneralRequestDTO>) params.get("generalRequestApplyDTOList");
//    List<GeneralRequestDTO> generalRequestRejectDTOList = (List<GeneralRequestDTO>) params.get("generalRequestRejectDTOList");
//
//    List<CommBoardDTO> commBoardDTOList = (List<CommBoardDTO>) params.get("commBoardDTOList");
//    List<CommReviewDTO> commReviewDTOList = (List<CommReviewDTO>) params.get("commReviewDTOList");
//    List<CommBoardReplyDTO> commBoardReplyDTOList = (List<CommBoardReplyDTO>) params.get("commBoardReplyDTOList");
//
//    List<ChallengeJoinDTO> challengeJoinDTOList = (List<ChallengeJoinDTO>) params.get("challengeJoinDTOList");
//    List<ChallengeQuestionDTO> challengeQuestionDTOList = (List<ChallengeQuestionDTO>) params.get("challengeQuestionDTOList");
//    List<ChallengeReviewDTO> challengeReviewDTOList = (List<ChallengeReviewDTO>) params.get("challengeReviewDTOList");
//
//    List<DonationBoardDTO> donationBoardDTOList = (List<DonationBoardDTO>) params.get("donationBoardDTOList");
//    List<DonationBoardDTO> donationBoardApplyDTOList = (List<DonationBoardDTO>) params.get("donationBoardApplyDTOList");
//    List<DonationBoardDTO> donationBoardRejectDTOList = (List<DonationBoardDTO>) params.get("donationBoardRejectDTOList");
//    List<DonationRegisterDTO> donationRegisterDTOList = (List<DonationRegisterDTO>) params.get("donationRegisterDTOList");
//
//    List<MyProfileDTO> myProfileDTOList = (List<MyProfileDTO>) params.get("myProfileDTOList");
//    List<QuestionListDTO> myQuestionListDTOList = (List<QuestionListDTO>) params.get("myQuestionListDTOList");
//
//    List<ChallengeDTO> challengeDTOList = (List<ChallengeDTO>) params.get("challengeDTOList");
//    List<NoticeDTO> noticeDTOList = (List<NoticeDTO>) params.get("noticeDTOList");
//    //    List<QuestionDTO> questionDTOList = (List<QuestionDTO>) params.get("questionDTOList");
//    //    List<ApproveOrgDTO> approveOrgDTOList = (List<ApproveOrgDTO>) params.get("approveOrgDTOList");
//
//
//    loadObjects("joinDTO.json", joinDTOList, JoinDTO.class);
//    //    loadObjects("noticeDTO.json", noticeDTOList, NoticeDTO.class);
//    loadObjects("questionListDTO.json", myQuestionListDTOList, QuestionListDTO.class);
//
//    //    loadObjects("generalRequest.json", generalRequestDTOList, GeneralRequestDTO.class);
//    //    loadObjects("generalRequestApply.json", generalRequestApplyDTOList, GeneralRequestDTO.class);
//    //    loadObjects("generalRequestReject.json", generalRequestRejectDTOList, GeneralRequestDTO.class);
//
//    //    loadJoins();
//
//    //    loadGeneralRequest();
//    //    loadGeneralRequestApply();
//    //    loadGeneralRequestReject();
//    //
//
//    //    loadPersonalRequest();
//    //    loadPersonalRequestApply();
//    //    loadPersonalRequestReject();
//    //
//    //    loadOrgRequest();
//    //    loadOrgRequestApply();
//    //    loadOrgRequestReject();
//    //
//    //    loadCommBoard();
//    loadObjects("commBoardDTO.json", commBoardDTOList, CommBoardDTO.class);
//    loadObjects("commReviewDTO.json", commReviewDTOList, CommReviewDTO.class);
//    loadObjects("commBoardReplyDTO.json", commBoardReplyDTOList, CommBoardReplyDTO.class);
//    //
//    loadObjects("challengeDTO.json", challengeDTOList, ChallengeDTO.class);
//    //
//    loadObjects("challengeReviewDTO.json", challengeReviewDTOList, ChallengeReviewDTO.class);
//    loadObjects("challengeQuestionDTO.json", challengeQuestionDTOList, ChallengeQuestionDTO.class);
//
//
//    loadObjects("donationBoardDTO.json", donationBoardDTOList, DonationBoardDTO.class);
//    loadObjects("donationRegisterDTO.json", donationRegisterDTOList, DonationRegisterDTO.class);
//  }
//
//  @SuppressWarnings("unchecked")
//  @Override
//  public void contextDestroyed(Map<String, Object> params) {
//
//    List<JoinDTO> joinDTOList = (List<JoinDTO>) params.get("joinDTOList");
//
//    //    List<VolListDTO> volListDTOList = (List<VolListDTO>) params.get("volListDTOList");
//
//    List<GeneralRequestDTO> generalRequestDTOList = (List<GeneralRequestDTO>) params.get("generalRequestDTOList");
//    List<GeneralRequestDTO> generalRequestApplyDTOList = (List<GeneralRequestDTO>) params.get("generalRequestApplyDTOList");
//    List<GeneralRequestDTO> generalRequestRejectDTOList = (List<GeneralRequestDTO>) params.get("generalRequestRejectDTOList");
//
//    List<CommBoardDTO> commBoardDTOList = (List<CommBoardDTO>) params.get("commBoardDTOList");
//    List<CommReviewDTO> commReviewDTOList = (List<CommReviewDTO>) params.get("commReviewDTOList");
//    List<CommBoardReplyDTO> commBoardReplyDTOList = (List<CommBoardReplyDTO>) params.get("commBoardReplyDTOList");
//
//    List<ChallengeJoinDTO> challengeJoinDTOList = (List<ChallengeJoinDTO>) params.get("challengeJoinDTOList");
//    List<ChallengeQuestionDTO> challengeQuestionDTOList = (List<ChallengeQuestionDTO>) params.get("challengeQuestionDTOList");
//    List<ChallengeReviewDTO> challengeReviewDTOList = (List<ChallengeReviewDTO>) params.get("challengeReviewDTOList");
//
//    List<DonationBoardDTO> donationBoardDTOList = (List<DonationBoardDTO>) params.get("donationBoardDTOList");
//    List<DonationBoardDTO> donationBoardApplyDTOList = (List<DonationBoardDTO>) params.get("donationBoardApplyDTOList");
//    List<DonationBoardDTO> donationBoardRejectDTOList = (List<DonationBoardDTO>) params.get("donationBoardRejectDTOList");
//    List<DonationRegisterDTO> donationRegisterDTOList = (List<DonationRegisterDTO>) params.get("donationRegisterDTOList");
//
//    List<MyProfileDTO> myProfileDTOList = (List<MyProfileDTO>) params.get("myProfileDTOList");
//    List<QuestionListDTO> myQuestionListDTOList = (List<QuestionListDTO>) params.get("myQuestionListDTOList");
//
//    List<ChallengeDTO> challengeDTOList = (List<ChallengeDTO>) params.get("challengeDTOList");
//    List<NoticeDTO> noticeDTOList = (List<NoticeDTO>) params.get("noticeDTOList");
//    //    List<QuestionDTO> questionDTOList = (List<QuestionDTO>) params.get("questionDTOList");
//    //    List<ApproveOrgDTO> approveOrgDTOList = (List<ApproveOrgDTO>) params.get("approveOrgDTOList");
//
//
//    saveObjects("joinDTO.json", joinDTOList);
//    saveObjects("noticeDTO.json", noticeDTOList);
//    saveObjects("questionListDTO.json", myQuestionListDTOList);
//
//    saveObjects("generalRequest.json", generalRequestDTOList);
//    saveObjects("generalRequestApply.json", generalRequestApplyDTOList);
//    saveObjects("generalRequestReject.json", generalRequestRejectDTOList);
//
//    //    saveJoins();
//    //
//    //    saveGeneralRequest();
//    //    saveGeneralRequestApply();
//    //    saveGeneralRequestReject();
//
//    //    savePersonalRequest();
//    //    savePersonalRequestApply();
//    //    savePersonalRequestReject();
//
//    //    saveOrgRequest();
//    //    saveOrgRequestApply();
//    //    saveOrgRequestReject();
//
//    //    saveCommBoard();
//    //    saveCommReview();
//    //
//    //
//    //    saveAdminChellengeAdd();
//
//    saveObjects("commBoardDTO.json", commBoardDTOList);
//    saveObjects("commReviewDTO.json", commReviewDTOList);
//    saveObjects("commBoardReplyDTO.json", commBoardReplyDTOList);
//
//
//    saveObjects("challengeDTO.json", challengeDTOList);
//    saveObjects("challengeReviewDTO.json", challengeReviewDTOList);
//    saveObjects("challengeQuestionDTO.json", challengeQuestionDTOList);
//
//
//    saveObjects("donationBoardDTO.json", donationBoardDTOList);
//    saveObjects("donationRegisterDTO.json", donationRegisterDTOList);
//  }
//
//  private <E> void loadObjects(
//      String filepath, // ???????????? ?????? ??? ?????? ??????
//      List<E> list, // ????????? ???????????? ????????? ?????? ??? ????????? ??????
//      Class<E> domainType // ????????? ????????? ????????????
//      ) {
//
//    // CSV ???????????? ????????? ????????? ???????????? ???????????? ?????? ????????? ?????????.
//    try (BufferedReader in = new BufferedReader(
//        new FileReader(filepath, Charset.forName("UTF-8")))) {
//
//      StringBuilder strBuilder = new StringBuilder();
//      String str;
//      while((str = in.readLine()) != null) { // ?????? ????????? ?????????.
//        strBuilder.append(str);
//      }
//
//      // StringBuilder??? ?????? ??? JSON ???????????? ????????? ?????????.
//      Type type = TypeToken.getParameterized(Collection.class, domainType).getType();
//      Collection<E> collection = new Gson().fromJson(strBuilder.toString(), type);
//
//      // JSON ???????????? ????????? ????????? ??????????????? ?????? List ??? ????????????.
//      list.addAll(collection);
//
//
//
//
//      System.out.printf("%s ????????? ?????? ??????!\n", filepath);
//
//    } catch (Exception e) {
//      System.out.printf("%s ????????? ?????? ??????!\n", filepath);
//    }
//  }
//
//  //????????? JSON ???????????? ????????????.
//  private void saveObjects(String filepath, List<?> list) {
//    try (PrintWriter out = new PrintWriter(
//        new BufferedWriter(
//            new FileWriter(filepath, Charset.forName("UTF-8"))))) {
//
//      out.print(new Gson().toJson(list));
//
//      System.out.printf("%s ????????? ?????? ??????!\n", filepath);
//
//    } catch (Exception e) {
//      System.out.printf("%s ????????? ?????? ??????!\n", filepath);
//      e.printStackTrace();
//    }
//  }
//
//  @Override
//  public void contextInitialized() {
//    // TODO Auto-generated method stub
//    
//  }
//
//  @Override
//  public void contextDestroyed() {
//    // TODO Auto-generated method stub
//    
//  }
//}
