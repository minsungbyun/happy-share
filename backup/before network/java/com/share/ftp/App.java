package com.share.ftp;

import static com.share.menu.Menu.ACCESS_ADMIN;
import static com.share.menu.Menu.ACCESS_LOGOUT;
import static com.share.menu.Menu.ACCESS_MEMBER;
import static com.share.menu.Menu.ACCESS_MEMBER_ADMIN;
import static com.share.menu.Menu.ACCESS_ORG;
import static com.share.menu.Menu.ACCESS_PERSONAL;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.ApproveOrgDTO;
import com.share.ftp.domain.personal.ChallengeJoinDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.domain.personal.MyProfileDTO;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.domain.personal.VolListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AdminChallengeAddHandler;
import com.share.ftp.handler.admin.AdminChallengeDeleteHandler;
import com.share.ftp.handler.admin.AdminChallengeDetailHandler;
import com.share.ftp.handler.admin.AdminChallengeListHandler;
import com.share.ftp.handler.admin.AdminChallengeUpdateHandler;
import com.share.ftp.handler.admin.AdminMemberDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeAddHandler;
import com.share.ftp.handler.admin.AdminNoticeDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeDetailHandler;
import com.share.ftp.handler.admin.AdminNoticeListHandler;
import com.share.ftp.handler.admin.AdminNoticeSearchHandler;
import com.share.ftp.handler.admin.AdminNoticeUpdateHandler;
import com.share.ftp.handler.admin.AdminQuestionAddHandler;
import com.share.ftp.handler.join.AuthChangeUserInfoHandler;
import com.share.ftp.handler.join.AuthDisplayUserInfoHandler;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.ftp.handler.join.AuthLogoutHandler;
import com.share.ftp.handler.join.JoinAddHandler;
import com.share.ftp.handler.join.JoinDetailHandler;
import com.share.ftp.handler.join.JoinListHandler;
import com.share.ftp.handler.join.JoinSearchEmailIdHandler;
import com.share.ftp.handler.join.JoinSearchPasswordHandler;
import com.share.ftp.handler.join.JoinSearchTelIdHandler;
import com.share.ftp.handler.join.MyPageDelete;
import com.share.ftp.handler.join.MyPageInfoHandler;
import com.share.ftp.handler.org.MyVolApplyListHandler;
import com.share.ftp.handler.org.MyVolApproveListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeLikeHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionConnectHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionSearchHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewConnectHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewDeleteHandler;
//import com.share.ftp.handler.personal.challenge.ChallengeReviewDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewSearchHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeWishHandler;
import com.share.ftp.handler.personal.challenge.MyChallengeDetailHandler;
import com.share.ftp.handler.personal.challenge.MyChallengeListHandler;
import com.share.ftp.handler.personal.challenge.MyChallengeWishHandler;
import com.share.ftp.handler.personal.challenge.MyRankingHandler;
import com.share.ftp.handler.personal.challenge.RankingHandler;
import com.share.ftp.handler.personal.community.CommBestDetailHandler;
import com.share.ftp.handler.personal.community.CommBestListHandler;
import com.share.ftp.handler.personal.community.CommBoardAddHandler;
import com.share.ftp.handler.personal.community.CommBoardDeleteHandler;
import com.share.ftp.handler.personal.community.CommBoardDetailHandler;
import com.share.ftp.handler.personal.community.CommBoardLikeHandler;
import com.share.ftp.handler.personal.community.CommBoardListHandler;
import com.share.ftp.handler.personal.community.CommBoardReplyConnectHandler;
import com.share.ftp.handler.personal.community.CommBoardSearchHandler;
import com.share.ftp.handler.personal.community.CommBoardUpdateHandler;
import com.share.ftp.handler.personal.community.CommReviewAddHandler;
import com.share.ftp.handler.personal.community.CommReviewDeleteHandler;
import com.share.ftp.handler.personal.community.CommReviewListHandler;
import com.share.ftp.handler.personal.community.CommReviewUpdateHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAcceptApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAdminApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAppliedListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyCompleteListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectedListHandler;
import com.share.ftp.handler.personal.donation.DonationPrompt;
import com.share.ftp.handler.personal.donation.DonationRegisterAddHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterMyListHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterParticipationHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterTotalMoneyHandler;
import com.share.ftp.handler.personal.mypage.MyBoardDeleteHandler;
import com.share.ftp.handler.personal.mypage.MyBoardDetailHandler;
import com.share.ftp.handler.personal.mypage.MyBoardListHandler;
import com.share.ftp.handler.personal.mypage.MyBoardUpdateHandler;
import com.share.ftp.handler.personal.mypage.MyDonationHandler;
import com.share.ftp.handler.personal.mypage.MyPointListHandler;
import com.share.ftp.handler.personal.support.QuestionAddHandler;
import com.share.ftp.handler.personal.support.QuestionDeleteHandler;
import com.share.ftp.handler.personal.support.QuestionDetailHandler;
import com.share.ftp.handler.personal.support.QuestionListHandler;
import com.share.ftp.handler.personal.support.QuestionSearchHandler;
import com.share.ftp.handler.personal.support.QuestionUpdateHandler;
import com.share.ftp.handler.personal.volunteer.MyAppliedVolDetailHandler;
import com.share.ftp.handler.personal.volunteer.MyAppliedVolHandler;
import com.share.ftp.handler.personal.volunteer.MyRejectedVolHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralDoJoinListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestAcceptHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestAppliedListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyCompleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestApplyListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestBookmarkHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestDeleteHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestRejectHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralRequestRejectedListHandler;
import com.share.ftp.handler.personal.volunteer.VolGeneralTotalApprovedListHandler;
import com.share.ftp.handler.personal.volunteer.VolOrgRequestAppliedListHandler;
import com.share.ftp.handler.personal.volunteer.VolOrgRequestApplyListHandler;
import com.share.ftp.handler.personal.volunteer.VolPersonalRequestAppliedListHandler;
import com.share.ftp.handler.personal.volunteer.VolPersonalRequestApplyListHandler;
import com.share.menu.Menu;
import com.share.menu.MenuGroup;
import com.share.util.Prompt;

public class App {

  // ???????????? ?????????(???)
  List<JoinDTO> joinDTOList = new ArrayList<>();
  //  List<JoinDTO> members = new ArrayList<>();
  // ???????????? ?????????(???)
  List<VolListDTO> volListDTOList = new ArrayList<>();

  // ??????, ?????? ?????? ?????????
  List<GeneralRequestDTO> generalRequestDTOList = new ArrayList<>();
  List<GeneralRequestDTO> generalRequestApplyDTOList = new ArrayList<>();
  List<GeneralRequestDTO> generalRequestRejectDTOList = new ArrayList<>();

  // ???????????? ?????????(???)
  List<CommBoardDTO> commBoardDTOList = new ArrayList<>();
  List<CommReviewDTO> commReviewDTOList = new ArrayList<>();
  List<CommBoardReplyDTO> commBoardCommentDTOList = new ArrayList<>();

  // ????????? ?????????(???)
  List<ChallengeJoinDTO> challengeJoinDTOList = new ArrayList<>();
  List<ChallengeQuestionDTO> challengeQuestionDTOList = new ArrayList<>();
  List<ChallengeReviewDTO> challengeReviewDTOList = new ArrayList<>();

  // ????????? ?????? ?????? ?????? ?????????(???)
  List<DonationBoardDTO> donationBoardDTOList = new ArrayList<>();
  List<DonationBoardDTO> donationBoardApplyDTOList = new ArrayList<>();
  List<DonationBoardDTO> donationBoardRejectDTOList = new ArrayList<>();

  // ?????? ?????????(???)
  List<DonationRegisterDTO> donationRegisterDTOList = new ArrayList<>();
  List<DonationRegisterDTO> donationMyRegisterDTOList;

  // ??????????????? ?????????(???)
  List<MyProfileDTO> myProfileDTOList = new ArrayList<>();
  List<QuestionListDTO> myQuestionListDTOList = new ArrayList<>();

  // ????????? ?????????(???)
  List<ChallengeDTO> challengeDTOList = new ArrayList<>();
  List<NoticeDTO> noticeDTOList = new ArrayList<>();
  List<QuestionDTO> questionDTOList = new ArrayList<>();
  List<ApproveOrgDTO> approveOrgDTOList = new ArrayList<>();

  //?????? ?????????
  //  List<CommentDTO> commentDTOList = new ArrayList<>();

  // HashMap
  HashMap<String,Command> challengeReviewMap = new HashMap<>();

  // ?????? ?????? ?????????(Map)
  HashMap<String,Command> commands = new HashMap<>();

  class MenuItem extends Menu {

    String menuId;

    public MenuItem(String title, String menuId) {
      super(title);
      this.menuId = menuId;
    }

    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
    }
    @Override
    public void execute() {
      Command command = commands.get(menuId);
      try {
        command.execute(new CommandRequest(commands));
      } catch(Exception e) {
        System.out.printf("%s ????????? ???????????? ??? ?????? ??????!\n", menuId);
        e.printStackTrace();
      }
    }
  }

  // ?????? ???????????? Handler 

  VolGeneralRequestAppliedListHandler volGeneralRequestAppliedListHandler = 
      new VolGeneralRequestAppliedListHandler
      (generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  //  VolRequestOrgAppliedListHandler volRequestOrgAppliedListHandler = 
  //      new VolRequestOrgAppliedListHandler
  //      (orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList);

  GeneralRequestDTO personalRequestDTO = new GeneralRequestDTO();

  VolGeneralDoJoinHandler volRequestPersonalAppliedListDetailHandler =
      new VolGeneralDoJoinHandler
      (generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  //  VolRequestOrgAppliedListDetailHandler volRequestOrgAppliedListDetailHandler =
  //      new VolRequestOrgAppliedListDetailHandler
  //      (orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList);

  // ???????????? ?????? ???????????? Handler

  VolPersonalRequestAppliedListHandler volPersonalRequestAppliedListHandler = new VolPersonalRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);
  VolOrgRequestAppliedListHandler volOrgRequestAppliedListHandler = new VolOrgRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);

  //?????????????????????
  VolGeneralDoJoinListHandler volDoJoinHandler = 
      new VolGeneralDoJoinListHandler
      (generalRequestApplyDTOList, volRequestPersonalAppliedListDetailHandler);

  DonationRegisterDTO donationRegisterDTO = new DonationRegisterDTO();

  // ????????? ????????? ??????
  ChallengeJoinHandler challengeJoinHandler =
      new ChallengeJoinHandler
      (challengeDTOList);

  // ????????? ?????? ????????? ?????? Handler
  DonationBoardAppliedListHandler donationBoardAppliedListHandler =
      new DonationBoardAppliedListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList);

  DonationPrompt donationPrompt = new DonationPrompt(donationBoardDTOList, donationRegisterDTOList);


  //  DonationRegisterParticipationListHandler donationRegisterParticipationListHandler = new DonationRegisterParticipationListHandler(donationRegisterDTOList, donationBoardDTOList);

  public static void main(String[] args) {
    App app = new App(); 
    app.service();
  }

  public App() {
    //?????????, ????????????
    commands.put("/auth/login", new AuthLoginHandler(joinDTOList)); // ?????????
    commands.put("/auth/logout", new AuthLogoutHandler()); // ????????????
    commands.put("/auth/changeUserInfo", new AuthChangeUserInfoHandler()); // ??????????????? ????????????
    commands.put("/auth/displayUserInfo", new AuthDisplayUserInfoHandler()); // ??????????????? ??????????????????

    //????????????
    commands.put("/join/add", new JoinAddHandler(joinDTOList)); // ????????????
    commands.put("/join/searchTelId", new JoinSearchTelIdHandler(joinDTOList)); // ???????????? ????????? ??????
    commands.put("/join/searchEmailId", new JoinSearchEmailIdHandler(joinDTOList)); // ???????????? ????????? ??????
    commands.put("/join/searchPassword", new JoinSearchPasswordHandler(joinDTOList)); // ???????????? ??????

    commands.put("/volGeneralRequest/apply", new VolGeneralRequestApplyHandler(generalRequestDTOList,joinDTOList));
    commands.put("/volGeneralRequest/applyList", new VolGeneralRequestApplyListHandler(generalRequestDTOList));
    commands.put("/volPersonalRequest/applyList", new VolPersonalRequestApplyListHandler(generalRequestDTOList));
    commands.put("/volOrgRequest/applyList", new VolOrgRequestApplyListHandler(generalRequestDTOList));
    commands.put("/volGeneralRequest/applyCompleteList", new VolGeneralRequestApplyCompleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/acceptApply", new VolGeneralRequestAcceptHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/rejectApply", new VolGeneralRequestRejectHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/appliedList", new VolGeneralRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volPersonalRequest/appliedList", new VolPersonalRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volOrgRequest/appliedList", new VolOrgRequestAppliedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/rejectedList", new VolGeneralRequestRejectedListHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/delete", new VolGeneralRequestDeleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/bookmark", new VolGeneralRequestBookmarkHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralRequest/totalApprovedList", new VolGeneralTotalApprovedListHandler(volPersonalRequestAppliedListHandler,volOrgRequestAppliedListHandler));
    commands.put("/volGeneralDoJoin/add", new VolGeneralDoJoinHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/volGeneralDoJoin/list", new VolGeneralDoJoinListHandler(generalRequestApplyDTOList, volRequestPersonalAppliedListDetailHandler));
    commands.put("/volGeneralDoJoin/delete", new VolGeneralDoJoinDeleteHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));

    //???????????? (??????) + ???????????????
    //    commands.put("/volRequestOrg/apply", new VolRequestOrgApplyHandler(orgRequestDTOList,joinDTOList));
    //    commands.put("/volRequestOrg/applyList", new VolRequestOrgApplyListHandler(orgRequestDTOList));
    //    commands.put("/volRequestOrg/applyCompleteList", new VolRequestOrgApplyCompleteListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/acceptApply", new VolRequestOrgAcceptApplyHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/rejectApply", new VolRequestOrgRejectApplyHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/appliedList", new VolRequestOrgAppliedListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    //    commands.put("/volRequestOrg/rejectedList", new VolRequestOrgRejectedListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));

    // ???????????? ???????????????
    commands.put("/commBoard/add", new CommBoardAddHandler(commBoardDTOList, commBoardCommentDTOList));
    commands.put("/commBoard/list", new CommBoardListHandler(commBoardDTOList, commBoardCommentDTOList));
    commands.put("/commBoard/detail", new CommBoardDetailHandler(commBoardDTOList, commBoardCommentDTOList));
    commands.put("/commBoard/update", new CommBoardUpdateHandler(commBoardDTOList, commBoardCommentDTOList));
    commands.put("/commBoard/delete", new CommBoardDeleteHandler(commBoardDTOList, commBoardCommentDTOList));
    commands.put("/commBoard/search", new CommBoardSearchHandler(commBoardDTOList, commBoardCommentDTOList));
    commands.put("/commBoard/like", new CommBoardLikeHandler(commBoardDTOList, commBoardCommentDTOList)); 
    commands.put("/commBoard/connect", new CommBoardReplyConnectHandler());

    // ???????????? ??????????????? BEST
    commands.put("/commBest/list", new CommBestListHandler(commBoardDTOList));
    commands.put("/commBest/detail", new CommBestDetailHandler(commBoardDTOList));

    // ???????????? ????????????
    commands.put("/commReview/add", new CommReviewAddHandler(commReviewDTOList));
    commands.put("/commReview/list", new CommReviewListHandler(commReviewDTOList));
    commands.put("/commReview/update", new CommReviewUpdateHandler(commReviewDTOList));
    commands.put("/commReview/delete", new CommReviewDeleteHandler(commReviewDTOList));

    // ?????????
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(challengeDTOList));  // ????????? ??????
    commands.put("/adminChallenge/detail", new AdminChallengeDetailHandler(challengeDTOList));  // ????????? ????????????
    commands.put("/challengeJoin/join", new ChallengeJoinHandler(challengeDTOList));  // ????????????(?????????..)
    commands.put("/challengeJoin/list", new ChallengeJoinListHandler(challengeDTOList, challengeJoinHandler));  // ???????????????(?????????..)
    commands.put("/challengeDetail/like", new ChallengeLikeHandler(challengeDTOList));  // ???????????????(?????????..)
    commands.put("/challengeDetail/wish", new ChallengeWishHandler(challengeDTOList));  // ???????????????(?????????..)

    // ????????? ????????????&??????
    commands.put("/challengeReview/add", new ChallengeReviewAddHandler(challengeReviewDTOList, challengeDTOList));
    commands.put("/challengeReview/list", new ChallengeReviewListHandler(challengeReviewDTOList, challengeDTOList));
    commands.put("/challengeReview/detail", new ChallengeDetailHandler(challengeDTOList));
    commands.put("/challengeReview/update", new ChallengeReviewUpdateHandler(challengeReviewDTOList, challengeDTOList));
    commands.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(challengeReviewDTOList, challengeDTOList));
    commands.put("/challengeReview/search", new ChallengeReviewSearchHandler(challengeReviewDTOList, challengeDTOList));
    commands.put("/challengeReview/connect", new ChallengeReviewConnectHandler());

    // ????????? ????????????
    commands.put("/challengeQuestion/add", new ChallengeQuestionAddHandler(challengeQuestionDTOList, challengeDTOList));
    commands.put("/challengeQuestion/list", new ChallengeQuestionListHandler(challengeQuestionDTOList, challengeDTOList));
    commands.put("/challengeQuestion/detail", new ChallengeQuestionDetailHandler(challengeQuestionDTOList, challengeDTOList));
    commands.put("/challengeQuestion/update", new ChallengeQuestionUpdateHandler(challengeQuestionDTOList, challengeDTOList));
    commands.put("/challengeQuestion/delete", new ChallengeQuestionDeleteHandler(challengeQuestionDTOList, challengeDTOList));
    commands.put("/challengeQuestion/search", new ChallengeQuestionSearchHandler(challengeQuestionDTOList, challengeDTOList));
    commands.put("/challengeQuestion/connect", new ChallengeQuestionConnectHandler());

    // ????????? ??????
    commands.put("/ranking/list", new RankingHandler());  //????????????(????????????)
    commands.put("/myRanking/list", new MyRankingHandler()); //????????????(????????????)

    // ????????? (??????????????????, ????????????, ??????, ??????)
    commands.put("/donationBoard/list", new DonationBoardListHandler(donationBoardDTOList));
    commands.put("/donationBoard/apply", new DonationBoardApplyHandler(donationBoardDTOList, joinDTOList));
    commands.put("/donationBoard/applyList", new DonationBoardApplyListHandler(donationBoardDTOList));
    commands.put("/donationBoard/appliedList", new DonationBoardAppliedListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/acceptApply", new DonationBoardAcceptApplyHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/rejectApply", new DonationBoardRejectApplyHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/rejectedList", new DonationBoardRejectedListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/applyDetail", new DonationBoardApplyDetailHandler(donationBoardDTOList, donationRegisterDTOList, donationPrompt));
    commands.put("/adminDonationBoard/applyDetail", new DonationBoardAdminApplyDetailHandler(donationBoardDTOList, donationRegisterDTOList, donationPrompt));

    // ????????? (????????????)
    commands.put("/donationRegister/add", new DonationRegisterAddHandler(donationRegisterDTOList, joinDTOList, donationBoardDTOList));
    commands.put("/donationRegister/participation", new DonationRegisterParticipationHandler(donationRegisterDTOList));
    commands.put("/donationRegister/totalMoney", new DonationRegisterTotalMoneyHandler(donationRegisterDTOList));

    // ???????????? ????????????
    commands.put("/question/add", new QuestionAddHandler(myQuestionListDTOList));
    commands.put("/question/list", new QuestionListHandler(myQuestionListDTOList));
    commands.put("/question/detail", new QuestionDetailHandler(myQuestionListDTOList));
    commands.put("/question/update", new QuestionUpdateHandler(myQuestionListDTOList));
    commands.put("/question/delete", new QuestionDeleteHandler(myQuestionListDTOList));
    commands.put("/question/search", new QuestionSearchHandler(myQuestionListDTOList));

    // ???????????????
    commands.put("/myPage/info", new MyPageInfoHandler(joinDTOList)); // ????????? ??????
    commands.put("/myPage/delete", new MyPageDelete(joinDTOList)); // ????????????

    commands.put("/myVol/applied", new MyAppliedVolHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/myVol/appliedDetail", new MyAppliedVolDetailHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));
    commands.put("/myVol/rejected", new MyRejectedVolHandler(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList));

    commands.put("/myChallenge/list", new MyChallengeListHandler(challengeDTOList));
    commands.put("/myChallenge/detail", new MyChallengeDetailHandler(challengeDTOList));
    commands.put("/myChallenge/wish", new MyChallengeWishHandler(challengeDTOList));


    commands.put("/myBoard/list", new MyBoardListHandler()); // ??????????????? ??????
    commands.put("/myBoard/detail", new MyBoardDetailHandler()); // ??????????????? ??????
    commands.put("/myBoard/update", new MyBoardUpdateHandler()); // ??????????????? ??????
    commands.put("/myBoard/delete", new MyBoardDeleteHandler()); // ??????????????? ??????

    commands.put("myPoint/list", new MyPointListHandler()); // ??????????????? 

    commands.put("/orgMyVol/apply", new MyVolApplyListHandler()); // ?????? ??????????????? ???????????? 
    commands.put("/orgMyVol/approve", new MyVolApproveListHandler()); // ?????? ??????????????? ????????????
    commands.put("/myDonation/list", new MyDonationHandler()); // ?????????
    commands.put("/myDonation/registerlist", new DonationRegisterMyListHandler(donationRegisterDTOList, donationMyRegisterDTOList)); // ?????????
    commands.put("/myDonation//applyCompleteList", new DonationBoardApplyCompleteListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));

    // ?????????

    // ????????? ???????????? ??????
    commands.put("/join/list", new JoinListHandler(joinDTOList)); // ???????????? ?????? ????????? ??????
    commands.put("/join/detail", new JoinDetailHandler(joinDTOList)); // ???????????? ???????????? (???????????????)
    commands.put("/join/delete", new AdminMemberDeleteHandler());

    // ????????? ???????????? (?????? + ?????????)
    commands.put("/adminNotice/add", new AdminNoticeAddHandler(noticeDTOList));
    commands.put("/adminNotice/list", new AdminNoticeListHandler(noticeDTOList));
    commands.put("/adminNotice/detail", new AdminNoticeDetailHandler(noticeDTOList));
    commands.put("/adminNotice/update", new AdminNoticeUpdateHandler(noticeDTOList));
    commands.put("/adminNotice/delete", new AdminNoticeDeleteHandler(noticeDTOList));
    commands.put("/adminNotice/search", new AdminNoticeSearchHandler(noticeDTOList));

    // ????????? ????????????
    commands.put("/adminAsk/add", new AdminQuestionAddHandler(questionDTOList));
    //        commands.put("/adminAsk/list", new AdminQuestionListHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/detail", new AdminQuestionDetailHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/update", new AdminQuestionUpdateHandler(myQuestionListDTOList));
    //        commands.put("/adminAsk/delete", new AdminQuestionDeleteHandler(myQuestionListDTOList));

    // ????????? ?????????
    commands.put("/adminChallenge/add", new AdminChallengeAddHandler(challengeDTOList));
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(challengeDTOList));
    commands.put("/adminChallenge/detail", new AdminChallengeDetailHandler(challengeDTOList));
    commands.put("/adminChallenge/update", new AdminChallengeUpdateHandler(challengeDTOList));
    commands.put("/adminChallenge/delete", new AdminChallengeDeleteHandler(challengeDTOList));

    // ????????? ????????????

    challengeReviewMap.put("/challengeReview/add", new ChallengeReviewAddHandler(challengeReviewDTOList, challengeDTOList));
    challengeReviewMap.put("/challengeReview/list", new ChallengeReviewListHandler(challengeReviewDTOList, challengeDTOList));
    //    challengeReviewMap.put("/challengeReview/detail", new ChallengeReviewDetailHandler(myChallengeReviewDTOList));
    challengeReviewMap.put("/challengeReview/update", new ChallengeReviewUpdateHandler(challengeReviewDTOList, challengeDTOList));
    challengeReviewMap.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(challengeReviewDTOList, challengeDTOList));
    challengeReviewMap.put("/challengeReview/search", new ChallengeReviewSearchHandler(challengeReviewDTOList, challengeDTOList));
  }

  void service() {

    loadObjects("joinDTO.json", joinDTOList, JoinDTO.class);
    //    loadObjects("noticeDTO.json", noticeDTOList, NoticeDTO.class);
    //    loadObjects("questionListDTO.json", myQuestionListDTOList, QuestionListDTO.class);

    //    loadObjects("generalRequest.json", generalRequestDTOList, GeneralRequestDTO.class);
    //    loadObjects("generalRequestApply.json", generalRequestApplyDTOList, GeneralRequestDTO.class);
    //    loadObjects("generalRequestReject.json", generalRequestRejectDTOList, GeneralRequestDTO.class);

    //    loadJoins();

    //    loadGeneralRequest();
    //    loadGeneralRequestApply();
    //    loadGeneralRequestReject();
    //

    //    loadPersonalRequest();
    //    loadPersonalRequestApply();
    //    loadPersonalRequestReject();
    //
    //    loadOrgRequest();
    //    loadOrgRequestApply();
    //    loadOrgRequestReject();
    //
    //    loadCommBoard();
    loadObjects("commBoardDTO.json", commBoardDTOList, CommBoardDTO.class);
    loadObjects("commReviewDTO.json", commReviewDTOList, CommReviewDTO.class);
    //    loadCommReview();
    //
    loadObjects("challengeDTO.json", challengeDTOList, ChallengeDTO.class);
    //
    loadObjects("challengeReviewDTO.json", challengeReviewDTOList, ChallengeReviewDTO.class);
    loadObjects("challengeQuestionDTO.json", challengeQuestionDTOList, ChallengeQuestionDTO.class);


    loadObjects("donationBoardDTO.json", donationBoardDTOList, DonationBoardDTO.class);
    loadObjects("donationRegisterDTO.json", donationRegisterDTOList, DonationRegisterDTO.class);


    System.out.println("oooo                                                    \r\n"
        + "`888                                                    \r\n"
        + " 888 .oo.    .oooo.   oo.ooooo.  oo.ooooo.  oooo    ooo \r\n"
        + " 888P\"Y88b  `P  )88b   888' `88b  888' `88b  `88.  .8'  \r\n"
        + " 888   888   .oP\"888   888   888  888   888   `88..8'   \r\n"
        + " 888   888  d8(  888   888   888  888   888    `888'    \r\n"
        + "o888o o888o `Y888\"\"8o  888bod8P'  888bod8P'     .8'     \r\n"
        + "                       888        888       .o..P'      \r\n"
        + "                      o888o      o888o      `Y8P'       \r\n"
        + "                                                        ");
    System.out.println();
    System.out.println("     .d8888. db   db  .d8b.  d8888b. d88888b \r\n"
        + "     88'  YP 88   88 d8' `8b 88  `8D 88'     \r\n"
        + "     `8bo.   88ooo88 88ooo88 88oobY' 88ooooo \r\n"
        + "       `Y8b. 88~~~88 88~~~88 88`8b   88~~~~~ \r\n"
        + "     db   8D 88   88 88   88 88 `88. 88.     \r\n"
        + "     `8888Y' YP   YP YP   YP 88   YD Y88888P ");

    System.out.println();


    System.out.println();



    createMenu().execute();
    Prompt.close();



    saveObjects("joinDTO.json", joinDTOList);
    saveObjects("noticeDTO.json", noticeDTOList);
    saveObjects("questionListDTO.json", myQuestionListDTOList);

    saveObjects("generalRequest.json", generalRequestDTOList);
    saveObjects("generalRequestApply.json", generalRequestApplyDTOList);
    saveObjects("generalRequestReject.json", generalRequestRejectDTOList);

    //    saveJoins();
    //
    //    saveGeneralRequest();
    //    saveGeneralRequestApply();
    //    saveGeneralRequestReject();

    //    savePersonalRequest();
    //    savePersonalRequestApply();
    //    savePersonalRequestReject();

    //    saveOrgRequest();
    //    saveOrgRequestApply();
    //    saveOrgRequestReject();

    //    saveCommBoard();
    //    saveCommReview();
    //
    //
    //    saveAdminChellengeAdd();

    saveObjects("commBoardDTO.json", commBoardDTOList);
    saveObjects("commReviewDTO.json", commReviewDTOList);


    saveObjects("challengeDTO.json", challengeDTOList);
    saveObjects("challengeReviewDTO.json", challengeReviewDTOList);
    saveObjects("challengeQuestionDTO.json", challengeQuestionDTOList);


    saveObjects("donationBoardDTO.json", donationBoardDTOList);
    saveObjects("donationRegisterDTO.json", donationRegisterDTOList);

  }

  private <E> void loadObjects(
      String filepath, // ???????????? ?????? ??? ?????? ??????
      List<E> list, // ????????? ???????????? ????????? ?????? ??? ????????? ??????
      Class<E> domainType // ????????? ????????? ????????????
      ) {

    // CSV ???????????? ????????? ????????? ???????????? ???????????? ?????? ????????? ?????????.
    try (BufferedReader in = new BufferedReader(
        new FileReader(filepath, Charset.forName("UTF-8")))) {

      StringBuilder strBuilder = new StringBuilder();
      String str;
      while((str = in.readLine()) != null) { // ?????? ????????? ?????????.
        strBuilder.append(str);
      }

      // StringBuilder??? ?????? ??? JSON ???????????? ????????? ?????????.
      Type type = TypeToken.getParameterized(Collection.class, domainType).getType();
      Collection<E> collection = new Gson().fromJson(strBuilder.toString(), type);

      // JSON ???????????? ????????? ????????? ??????????????? ?????? List ??? ????????????.
      list.addAll(collection);




      System.out.printf("%s ????????? ?????? ??????!\n", filepath);

    } catch (Exception e) {
      System.out.printf("%s ????????? ?????? ??????!\n", filepath);
    }
  }

  // ????????? JSON ???????????? ????????????.
  private void saveObjects(String filepath, List<?> list) {
    try (PrintWriter out = new PrintWriter(
        new BufferedWriter(
            new FileWriter(filepath, Charset.forName("UTF-8"))))) {

      out.print(new Gson().toJson(list));

      System.out.printf("%s ????????? ?????? ??????!\n", filepath);

    } catch (Exception e) {
      System.out.printf("%s ????????? ?????? ??????!\n", filepath);
      e.printStackTrace();
    }
  }


  Menu createMenu() {

    MenuGroup mainMenuGroup = new MenuGroup("*?????????Share*");
    mainMenuGroup.setPrevMenuTitle("??????");

    mainMenuGroup.add(new MenuItem("?????????", ACCESS_LOGOUT, "/auth/login"));

    MenuGroup searchId = new MenuGroup("???????????????", ACCESS_LOGOUT);
    mainMenuGroup.add(searchId);
    searchId.add(new MenuItem("?????????????????????????????????", ACCESS_LOGOUT, "/join/searchTelId"));
    searchId.add(new MenuItem("???????????????????????????", ACCESS_LOGOUT, "/join/searchEmailId"));

    mainMenuGroup.add(new MenuItem("??????????????????", ACCESS_LOGOUT, "/join/searchPassword"));
    mainMenuGroup.add(new MenuItem("????????????", ACCESS_LOGOUT, "/join/add"));
    mainMenuGroup.add(new MenuItem("????????????", ACCESS_MEMBER_ADMIN, "/auth/logout"));



    // ????????????
    MenuGroup doVolMenu = new MenuGroup("????????????");
    mainMenuGroup.add(doVolMenu);


    doVolMenu.add(new MenuItem("????????????????????????", ACCESS_PERSONAL, "/volGeneralRequest/apply"));
    doVolMenu.add(new MenuItem("????????????????????????", ACCESS_ORG, "/volGeneralRequest/apply")); 
    doVolMenu.add(new MenuItem("???????????????????????????","/volGeneralRequest/appliedList")); 
    doVolMenu.add(createVolJoinMenu()); // ?????? ????????????
    doVolMenu.add(new MenuItem("?????????", ACCESS_MEMBER,"/volGeneralRequest/bookmark")); // ????????????

    // ????????????
    MenuGroup CommunityMenu = new MenuGroup("????????????");
    mainMenuGroup.add(CommunityMenu);

    CommunityMenu.add(createReviewMenu());      // ???????????????
    CommunityMenu.add(createBestReviewMenu());  // ???????????????BEST
    CommunityMenu.add(createShortReviewMenu()); // ????????????

    // ?????????
    MenuGroup challengeMenu = new MenuGroup("?????????");
    mainMenuGroup.add(challengeMenu);

    MenuGroup monthlyChallengeMenu = new MenuGroup("????????? ?????????");
    challengeMenu.add(monthlyChallengeMenu);

    //    MenuGroup challengeListMenu = new MenuGroup("????????? ??????");
    //    monthlyChallengeMenu.add(challengeListMenu);

    //    MenuGroup challengeDetailMenu = new MenuGroup("????????? ????????????");
    //    monthlyChallengeMenu.add(challengeDetailMenu); 

    //    MenuGroup showChallengeDetailHandler = new MenuGroup("????????????");  // ????????????
    //    challengeDetailMenu.add(showChallengeDetailHandler);

    monthlyChallengeMenu.add(new MenuItem("????????? ??????", "/adminChallenge/list"));

    monthlyChallengeMenu.add(new MenuItem("????????? ????????????", "/challengeReview/detail"));

    //    monthlyChallengeMenu.add(new MenuItem("????????????", ACCESS_MEMBER, "/challengeJoin/join"));
    //
    //    monthlyChallengeMenu.add(new MenuItem("????????? ??????", ACCESS_MEMBER, "/challengeJoin/list"));
    //
    //    monthlyChallengeMenu.add(createChallengeReviewMenu()); // ????????????&??????
    //    monthlyChallengeMenu.add(createChallengeQuestionMenu()); // ????????????

    challengeMenu.add(createMonthlyRankingMenu()); // ????????? ??????


    // ?????????
    mainMenuGroup.add(createDonationMenu());


    // ????????????
    MenuGroup supportMenu = new MenuGroup("????????????");
    mainMenuGroup.add(supportMenu);

    supportMenu.add(createNoticeMenu());      // ????????????
    supportMenu.add(createAskMenu());         // ????????????

    // ???????????????
    MenuGroup MyPageMenu = new MenuGroup("???????????????", ACCESS_MEMBER);
    mainMenuGroup.add(MyPageMenu);
    MyPageMenu.add(createMyProfileMenu());    // ????????????
    MyPageMenu.add(createMyVolunteerMenu());  // ????????????
    MyPageMenu.add(createMyBoardMenu());      // ???????????????
    MyPageMenu.add(createMyChallengeMenu());    // ???????????????
    MyPageMenu.add(createMyPointMenu());      // ???????????????
    MyPageMenu.add(createMyDonationMenu());   // ???????????????
    MyPageMenu.add(createOrgApprovewMenu());  // ??????????????????
    MyPageMenu.add(new MenuItem("??????", ACCESS_MEMBER, "/myPage/delete")); 

    // ?????????
    MenuGroup adminMenu = new MenuGroup("?????????", ACCESS_ADMIN);
    mainMenuGroup.add(adminMenu);

    adminMenu.add(createAdminMemberMenu());      // ????????????
    adminMenu.add(createAdminDonationMenu());    // ????????????
    adminMenu.add(createAdminVolMenu());         // ????????????
    adminMenu.add(createAdminNoticeMenu());      // ??????????????????
    adminMenu.add(createAdminAskMenu());         // ??????????????????
    adminMenu.add(createAdminChallengeMenu());   // ???????????????
    adminMenu.add(createAdminApproveInfoMenu()); // ??????????????????

    mainMenuGroup.add(new MenuItem("??????", ACCESS_MEMBER, "/myPage/delete"));

    return mainMenuGroup;



  }

  ////////////////////////////////////////////////////////////////////////////////////////////////



  private Menu createVolJoinMenu() {
    MenuGroup volJoinMenu = new MenuGroup("??????????????????");

    volJoinMenu.add(new MenuItem("??????????????????",ACCESS_PERSONAL,"/volDoJoin/add")); 
    volJoinMenu.add(new MenuItem("??????????????????",ACCESS_ORG,"/volDoJoin/add")); 
    volJoinMenu.add(new MenuItem("?????????????????????","/volDoJoin/list")); 
    volJoinMenu.add(new MenuItem("?????????", ACCESS_MEMBER,"/volGeneralRequest/bookmark")); // ????????????
    volJoinMenu.add(createVolReviewMenu());
    volJoinMenu.add(createVolQuestionMenu()); 

    return volJoinMenu;
  }


  private Menu createVolReviewMenu() {
    MenuGroup volReview = new MenuGroup("????????????&??????");
    volReview.add(new MenuItem("?????? ???????????? ??????", ACCESS_MEMBER, "/volJoinReview/add"));
    volReview.add(new MenuItem("?????? ???????????? ??????", "/volJoinReview/list"));
    volReview.add(new MenuItem("?????? ???????????? ??????", ACCESS_MEMBER,"/volJoinReview/update"));
    volReview.add(new MenuItem("?????? ???????????? ??????", ACCESS_MEMBER,"/volJoinReview/delete"));
    volReview.add(new MenuItem("?????? ???????????? ??????", "/volJoinReview/search"));

    return volReview;
  }


  private Menu createVolQuestionMenu() {
    MenuGroup VolQuestion = new MenuGroup("????????????");

    VolQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/volQuestion/add"));
    VolQuestion.add(new MenuItem("?????? ??????",  "/volQuestion/list"));
    VolQuestion.add(new MenuItem("?????? ????????????", ACCESS_MEMBER,"/volQuestion/detail"));
    VolQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/volQuestion/update"));
    VolQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/volQuestion/delete"));
    VolQuestion.add(new MenuItem("?????? ??????",  "/volQuestion/search"));

    return VolQuestion;
  }





  private Menu createReviewMenu() {
    MenuGroup reviewMenu = new MenuGroup("?????? ?????????");

    reviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/commBoard/add"));
    reviewMenu.add(new MenuItem("??????","/commBoard/list"));
    reviewMenu.add(new MenuItem("????????????","/commBoard/detail"));
    reviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN,"/commBoard/update"));
    reviewMenu.add(new MenuItem("??????",ACCESS_MEMBER_ADMIN,"/commBoard/delete"));
    reviewMenu.add(new MenuItem("??????",ACCESS_MEMBER_ADMIN,"/commBoard/search"));

    return reviewMenu;
  }

  private Menu createBestReviewMenu() {
    MenuGroup bestReviewMenu = new MenuGroup("?????? ????????? BEST");

    bestReviewMenu.add(new MenuItem("??????","/commBest/list"));
    bestReviewMenu.add(new MenuItem("????????????","/commBest/detail"));

    return bestReviewMenu;
  }

  private Menu createShortReviewMenu() {
    MenuGroup shortReviewMenu = new MenuGroup("??? ??? ??????");

    shortReviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/commReview/add"));
    shortReviewMenu.add(new MenuItem("??????", "/commReview/list")); 
    shortReviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/commReview/update")); 
    shortReviewMenu.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/commReview/delete")); 
    shortReviewMenu.add(new MenuItem("??????",ACCESS_MEMBER_ADMIN,"/commReview/search"));


    return shortReviewMenu;
  }


  public  Menu createChallengeReviewMenu() {
    MenuGroup ChallengeReview = new MenuGroup("????????????&??????");
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", ACCESS_MEMBER, "/challengeReview/add"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", "/challengeReview/list"));
    //    ChallengeReview.add(new MenuItem("????????????&?????? ????????????", ACCESS_MEMBER,"/challengeReview/detail"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", ACCESS_MEMBER,"/challengeReview/update"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", ACCESS_MEMBER,"/challengeReview/delete"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", "/challengeReview/search"));

    return ChallengeReview;
  }



  private Menu createChallengeQuestionMenu() {
    MenuGroup ChallengeQuestion = new MenuGroup("????????????");
    ChallengeQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/challengeQuestion/add"));
    ChallengeQuestion.add(new MenuItem("?????? ??????",  "/challengeQuestion/list"));
    ChallengeQuestion.add(new MenuItem("?????? ????????????", ACCESS_MEMBER,"/challengeQuestion/detail"));
    ChallengeQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/challengeQuestion/update"));
    ChallengeQuestion.add(new MenuItem("?????? ??????", ACCESS_MEMBER, "/challengeQuestion/delete"));
    ChallengeQuestion.add(new MenuItem("?????? ??????",  "/challengeQuestion/search"));

    return ChallengeQuestion;
  }



  private Menu createMonthlyRankingMenu() {
    MenuGroup monthlyRankingMenu = new MenuGroup("????????? ??????");
    monthlyRankingMenu.add(new MenuItem("????????? ????????????", "/ranking/list"));  //????????????(????????????)
    monthlyRankingMenu.add(new MenuItem("?????? ????????????", ACCESS_MEMBER, "/myRanking/list"));  //????????????(????????????)

    return monthlyRankingMenu;
  }

  private Menu createDonationMenu() {
    MenuGroup donationMenu = new MenuGroup("?????????");

    donationMenu.add(new MenuItem("?????? ????????? ??????", "/donationRegister/totalMoney"));
    donationMenu.add(new MenuItem("????????? ????????????", ACCESS_ORG, "/donationBoard/apply"));
    donationMenu.add(new MenuItem("???????????????","/donationBoard/list"));
    donationMenu.add(new MenuItem("????????? ????????????", "/donationBoard/applyDetail"));
    donationMenu.add(new MenuItem("????????????", ACCESS_MEMBER, "/donationRegister/add"));
    donationMenu.add(new MenuItem("?????? ????????????", "/donationRegister/participation"));

    return donationMenu;
  }


  private Menu createNoticeMenu() {
    MenuGroup noticeMenu = new MenuGroup("????????????");

    noticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/add"));
    noticeMenu.add(new MenuItem("???????????? ??????","/adminNotice/list"));
    noticeMenu.add(new MenuItem("???????????? ????????????","/adminNotice/detail"));
    noticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/update"));
    noticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/delete"));
    noticeMenu.add(new MenuItem("???????????? ??????","/adminNotice/search"));

    return noticeMenu;
  }

  private Menu createAskMenu() {
    MenuGroup ask = new MenuGroup("????????????");
    ask.add(new MenuItem("??????", ACCESS_MEMBER,"/question/add"));
    ask.add(new MenuItem("??????", ACCESS_MEMBER_ADMIN, "/question/list"));
    ask.add(new MenuItem("????????????", ACCESS_MEMBER_ADMIN, "/question/detail"));
    ask.add(new MenuItem("??????", ACCESS_MEMBER,"/question/update"));
    ask.add(new MenuItem("??????", ACCESS_MEMBER, "/question/delete"));
    ask.add(new MenuItem("??????", "/question/search"));

    return ask;
  }


  // ???????????????

  private Menu createMyProfileMenu() {
    MenuGroup myProfile = new MenuGroup("????????????", ACCESS_MEMBER);
    myProfile.add(new MenuItem("??? ??????", "/auth/displayUserInfo"));
    myProfile.add(new MenuItem("??? ?????? ??????", "/auth/changeUserInfo"));

    return myProfile;
  }

  private Menu createMyVolunteerMenu() {
    MenuGroup myVolunteer = new MenuGroup("?????? ??????");

    myVolunteer.add(new MenuItem("?????? ??????????????? ??????",ACCESS_PERSONAL,"/myVol/appliedDetail")); 
    myVolunteer.add(new MenuItem("?????? ??????????????? ??????",ACCESS_ORG,"/myVol/appliedDetail")); // ????????????
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_PERSONAL,"/myVol/applied"));    
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_ORG,"/myVol/applied"));    
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_PERSONAL,"/myVol/rejected"));    
    myVolunteer.add(new MenuItem("????????? ????????????",ACCESS_ORG,"/myVol/rejected"));    
    myVolunteer.add(new MenuItem("???????????? ??????",ACCESS_PERSONAL,"/volGeneralRequest/delete"));    
    myVolunteer.add(new MenuItem("???????????? ??????",ACCESS_ORG,"/volGeneralRequest/delete"));    
    myVolunteer.add(new MenuItem("??????????????? ????????????",ACCESS_MEMBER,"/volGeneralDoJoin/delete"));    
    myVolunteer.add(new MenuItem("????????????",ACCESS_MEMBER,"/volGeneralRequest/bookmark")); // ????????????

    return myVolunteer;
  }

  private Menu createMyBoardMenu() {

    MenuGroup myBoard = new MenuGroup("?????? ?????????"); // ????????????
    myBoard.add(new MenuItem("??????????????? ??????","/myBoard/list"));
    myBoard.add(new MenuItem("??????????????? ????????????","/myBoard/detail"));
    myBoard.add(new MenuItem("??????????????? ??????","/myBoard/update"));
    myBoard.add(new MenuItem("??????????????? ??????","/myBoard/delete"));

    return myBoard;
  }
  private Menu createMyChallengeMenu() {

    MenuGroup myChallenge = new MenuGroup("?????? ?????????"); // ????????????
    myChallenge.add(new MenuItem("??????????????? ??????","/myChallenge/list"));
    myChallenge.add(new MenuItem("??????????????? ????????????","/myChallenge/detail"));
    myChallenge.add(new MenuItem("??????????????? ????????????","/myChallenge/wish"));

    return myChallenge;
  }


  private Menu createMyDonationMenu() {
    MenuGroup myDonation = new MenuGroup("?????? ?????????"); 
    myDonation.add(new MenuItem("?????? ????????? ??????????????? ??????", ACCESS_ORG, "/myDonation//applyCompleteList")); 
    myDonation.add(new MenuItem("?????? ????????????", ACCESS_MEMBER, "/myDonation/registerlist"));
    myDonation.add(new MenuItem("????????? ????????? ????????????",ACCESS_ORG,"/donationBoard/appliedList")); 
    myDonation.add(new MenuItem("????????? ????????? ????????????", ACCESS_ORG,"/donationBoard/rejectedList"));  

    return myDonation;
  }

  private Menu createMyPointMenu() {
    MenuGroup myPoint = new MenuGroup("?????? ?????????"); // ????????????
    myPoint.add(new MenuItem("?????????????????????","myPoint/list"));

    return myPoint;
  }


  private Menu createOrgApprovewMenu() {
    MenuGroup orgpprove = new MenuGroup("?????? ?????? ??????");

    orgpprove.add(new MenuItem("?????? ????????????","/orgMyVol/apply"));
    orgpprove.add(new MenuItem("?????? ????????????","/orgMyVol/approve"));

    return orgpprove;
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////    

  // ?????????

  private Menu createAdminMemberMenu() {
    MenuGroup adminMemberMenu = new MenuGroup("???????????? ??????", ACCESS_ADMIN);

    adminMemberMenu.add(new MenuItem("????????????", "/join/list"));
    adminMemberMenu.add(new MenuItem("???????????? ????????????", "/join/detail"));
    adminMemberMenu.add(new MenuItem("????????????","/adminMember/list"));

    return adminMemberMenu;
  }

  private Menu createAdminDonationMenu() {
    MenuGroup adminDonationMenu = new MenuGroup("????????? ??????" ,ACCESS_ADMIN);

    adminDonationMenu.add(new MenuItem("????????? ?????? ???????????? ??????", "/donationBoard/applyList"));
    adminDonationMenu.add(new MenuItem("????????? ?????? ???????????? ????????????", "/adminDonationBoard/applyDetail"));
    //    adminDonationMenu.add(new MenuItem("????????? ?????? ????????????", "/donationBoard/acceptApply"));
    //    adminDonationMenu.add(new MenuItem("????????? ?????? ????????????", "/donationBoard/rejectApply"));

    return adminDonationMenu;
  }

  private Menu createAdminVolMenu() {
    MenuGroup adminVolMenu = new MenuGroup("???????????? ??????", ACCESS_ADMIN);

    adminVolMenu.add(new MenuItem("????????????????????????","/volPersonalRequest/applyList"));
    adminVolMenu.add(new MenuItem("????????????????????????","/volOrgRequest/applyList")); // ????????????
    adminVolMenu.add(new MenuItem("????????????????????????","/volGeneralRequest/acceptApply"));
    adminVolMenu.add(new MenuItem("????????????????????????","/volGeneralRequest/acceptApply")); // ????????????
    adminVolMenu.add(new MenuItem("????????????????????????","/volGeneralRequest/rejectApply"));
    adminVolMenu.add(new MenuItem("????????????????????????","/volGeneralRequest/rejectApply")); // ????????????
    adminVolMenu.add(new MenuItem("????????????????????????","/volGeneralRequest/delete"));

    return adminVolMenu;
  }

  private Menu createAdminNoticeMenu() {
    MenuGroup adminNoticeMenu = new MenuGroup("???????????? ??????");

    adminNoticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/add"));
    adminNoticeMenu.add(new MenuItem("???????????? ??????","/adminNotice/list"));
    adminNoticeMenu.add(new MenuItem("???????????? ????????????","/adminNotice/detail"));
    //    adminNoticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/update"));
    //    adminNoticeMenu.add(new MenuItem("???????????? ??????",ACCESS_ADMIN,"/adminNotice/delete"));
    adminNoticeMenu.add(new MenuItem("???????????? ??????","/adminNotice/search"));

    return adminNoticeMenu;
  }

  private Menu createAdminAskMenu() {
    MenuGroup adminAskInfo = new MenuGroup("???????????? ??????", ACCESS_ADMIN);

    adminAskInfo.add(new MenuItem("???????????? ??????","/adminAsk/add"));
    //    adminAskInfo.add(new MenuItem("???????????? ??????","/question/list"));
    //    adminAskInfo.add(new MenuItem("???????????? ????????????","/question/detail"));
    //    adminAskInfo.add(new MenuItem("???????????? ??????","/question/update"));
    //    adminAskInfo.add(new MenuItem("???????????? ??????","/question/delete"));
    //    adminAskInfo.add(new MenuItem("???????????? ??????","/question/search"));

    return adminAskInfo;
  }

  private Menu createAdminChallengeMenu() {
    MenuGroup adminChallengeInfo = new MenuGroup("????????? ??????");

    adminChallengeInfo.add(new MenuItem("????????? ??????",ACCESS_ADMIN,"/adminChallenge/add"));
    adminChallengeInfo.add(new MenuItem("????????? ??????","/adminChallenge/list"));
    adminChallengeInfo.add(new MenuItem("????????? ????????????","/adminChallenge/detail"));
    //    adminChallengeInfo.add(new MenuItem("????????? ??????","/adminChallenge/update"));
    //    adminChallengeInfo.add(new MenuItem("????????? ??????","/adminChallenge/delete"));

    return adminChallengeInfo;
  }

  private Menu createAdminApproveInfoMenu() {
    MenuGroup adminApproveInfo = new MenuGroup("?????? ??????", ACCESS_ADMIN);

    adminApproveInfo.add(new MenuItem("?????????????????? ??????","/adminChallenge/list"));
    adminApproveInfo.add(new MenuItem("?????????????????? ??????","/adminChallenge/detail"));
    adminApproveInfo.add(new MenuItem("?????????????????? ??????","/adminChallenge/update"));
    adminApproveInfo.add(new MenuItem("?????????????????? ??????","/adminChallenge/delete"));

    return adminApproveInfo;
  }

}


