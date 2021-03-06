package com.share.ftp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.ApproveOrgDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.domain.personal.MyProfileDTO;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.domain.personal.OrgRequestDTO;
import com.share.ftp.domain.personal.PersonalRequestApplyDTO;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.domain.personal.PersonalRequestRejectDTO;
import com.share.ftp.domain.personal.VolListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.admin.AdminChallengeDeleteHandler;
import com.share.ftp.handler.admin.AdminChallengeDetailHandler;
import com.share.ftp.handler.admin.AdminChallengeListHandler;
import com.share.ftp.handler.admin.AdminChallengeUpdateHandler;
import com.share.ftp.handler.admin.AdminMemberDeleteHandler;
import com.share.ftp.handler.admin.AdminMemberListHandler;
import com.share.ftp.handler.admin.AdminNoticeAddHandler;
import com.share.ftp.handler.admin.AdminNoticeDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeDetailHandler;
import com.share.ftp.handler.admin.AdminNoticeListHandler;
import com.share.ftp.handler.admin.AdminNoticeUpdateHandler;
import com.share.ftp.handler.admin.AdminQuestionAddHandler;
import com.share.ftp.handler.admin.AdminQuestionDeleteHandler;
import com.share.ftp.handler.admin.AdminQuestionDetailHandler;
import com.share.ftp.handler.admin.AdminQuestionHandler;
import com.share.ftp.handler.admin.AdminQuestionListHandler;
import com.share.ftp.handler.admin.AdminQuestionUpdateHandler;
import com.share.ftp.handler.join.AuthChangeUserInfoHandler;
import com.share.ftp.handler.join.AuthDisplayUserInfoHandler;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.ftp.handler.join.AuthLogoutHandler;
import com.share.ftp.handler.join.JoinAddHandler;
import com.share.ftp.handler.join.JoinDetailHandler;
import com.share.ftp.handler.join.JoinListHandler;
import com.share.ftp.handler.join.JoinSearchIdHandler;
import com.share.ftp.handler.join.JoinSearchPasswordHandler;
import com.share.ftp.handler.join.MyPageDelete;
import com.share.ftp.handler.join.MyPageInfoHandler;
import com.share.ftp.handler.personal.challenge.ChallengeBoardHandler;
import com.share.ftp.handler.personal.challenge.ChallengeListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionSearchHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewSearchHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewUpdateHandler;
import com.share.ftp.handler.personal.challenge.RankingHandler;
import com.share.ftp.handler.personal.community.CommBoardAddHandler;
import com.share.ftp.handler.personal.community.CommBoardDeleteHandler;
import com.share.ftp.handler.personal.community.CommBoardDetailHandler;
import com.share.ftp.handler.personal.community.CommBoardListHandler;
import com.share.ftp.handler.personal.community.CommBoardUpdateHandler;
import com.share.ftp.handler.personal.community.CommReviewAddHandler;
import com.share.ftp.handler.personal.community.CommReviewDeleteHandler;
import com.share.ftp.handler.personal.community.CommReviewListHandler;
import com.share.ftp.handler.personal.community.CommReviewUpdateHandler;
import com.share.ftp.handler.personal.donation.DonationBoardHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterHandler;
import com.share.ftp.handler.personal.mypage.MyBoardUpdateHandler;
import com.share.ftp.handler.personal.mypage.MyDonationHandler;
import com.share.ftp.handler.personal.mypage.MyPointHandler;
import com.share.ftp.handler.personal.mypage.MyProfileHandler;
import com.share.ftp.handler.personal.mypage.WithdrawMemberHandler;
import com.share.ftp.handler.personal.support.AbstractNoticeHandler;
import com.share.ftp.handler.personal.support.QuestionAddHandler;
import com.share.ftp.handler.personal.support.QuestionDeleteHandler;
import com.share.ftp.handler.personal.support.QuestionDetailHandler;
import com.share.ftp.handler.personal.support.QuestionListHandler;
import com.share.ftp.handler.personal.support.QuestionUpdateHandler;
import com.share.ftp.handler.personal.volunteer.ApproveOrgHandler;
import com.share.ftp.handler.personal.volunteer.OrgVolRequestHandler;
import com.share.ftp.handler.personal.volunteer.PersonalVolRequestHandler;
import com.share.ftp.handler.personal.volunteer.VolApprovedHandler;
import com.share.ftp.handler.personal.volunteer.VolListHandler;
import com.share.menu.Menu;
import com.share.menu.MenuGroup;
import com.share.util.Prompt;

public class CopyApp {

  // ???????????? ?????????(???)
  List<JoinDTO> joinDTOList = new ArrayList<>();

  // ???????????? ?????????(???)
  List<VolListDTO> volListDTOList = new ArrayList<>();
  List<PersonalRequestApplyDTO> personalRequestApplyDTOList = new ArrayList<>();
  List<PersonalRequestDTO> personalRequestDTOList = new ArrayList<>();
  List<PersonalRequestRejectDTO> personalRequestRejectDTOList = new ArrayList<>();

  List<ApproveOrgDTO> approveOrgDTOList = new ArrayList<>();

  // ???????????? ?????????(???)
  List<CommBoardDTO> commBoardDTOList = new ArrayList<>();
  List<CommReviewDTO> commReviewDTOList = new ArrayList<>();

  // ????????? ?????????(???)

  List<ChallengeQuestionDTO> myChallengeQuestionDTOList = new ArrayList<>();
  List<ChallengeReviewDTO> myChallengeReviewDTOList = new ArrayList<>();

  // ?????? ?????????(???)
  List<DonationBoardDTO> donationBoardDTOList = new ArrayList<>();
  List<DonationRegisterDTO> donationRegisterDTOList = new ArrayList<>();

  // ??????????????? ?????????(???)
  List<MyProfileDTO> myProfileDTOList = new ArrayList<>();
  List<QuestionListDTO> myQuestionListDTOList = new ArrayList<>();
  List<OrgRequestDTO> orgRequestDTOList = new ArrayList<>();

  // ????????? ?????????(???)
  List<ChallengeDTO> challengeDTOList = new ArrayList<>();
  List<NoticeDTO> noticeDTOList = new ArrayList<>();
  List<QuestionDTO> questionDTOList = new ArrayList<>();


  HashMap<String,Command> commands = new HashMap<>();

  class MenuItem extends Menu {

    String menuId;

    public MenuItem(String title, String menuId) {
      this(title, Menu.ENABLE_ALL, menuId);
      this.menuId = menuId;
    }

    public MenuItem(String title, int enableState, String menuId) {
      super(title, enableState);
      this.menuId = menuId;
    }

    @Override
    public void execute() {
      Command command = commands.get(menuId);
      command.execute();
    }
  }


  // ???????????? ?????????(??????)
  OrgVolRequestHandler orgVolRequestHandler = new OrgVolRequestHandler(); // ?????? List ?????? ??????
  PersonalVolRequestHandler personalVolRequestHandler = new PersonalVolRequestHandler(orgVolRequestHandler); // ?????? List ?????? ??????
  VolApprovedHandler volApprovedHandler = new VolApprovedHandler();
  VolListHandler volListHandler = new VolListHandler(personalVolRequestHandler,orgVolRequestHandler);


  // ???????????? ?????????(??????)


  //  CommBoardAddHandler commBoardAddHandler = new CommBoardAddHandler(commBoardDTOList);
  //  CommBoardListHandler commBoardListHandler = new CommBoardListHandler(commBoardDTOList);
  //  CommBoardDetailHandler commBoardDetailHandler = new CommBoardDetailHandler(commBoardDTOList);
  //  CommBoardUpdateHandler commBoardUpdateHandler = new CommBoardUpdateHandler(commBoardDTOList);
  //  CommBoardDeleteHandler commBoardDeleteHandler = new CommBoardDeleteHandler(commBoardDTOList);

  //  CommReviewAddHandler commReviewAddHandler = new CommReviewAddHandler(commReviewDTOList);
  //  CommReviewListHandler commReviewListHandler = new CommReviewListHandler(commReviewDTOList);
  //  CommReviewUpdateHandler commReviewUpdateHandler = new CommReviewUpdateHandler(commReviewDTOList);
  //  CommReviewDeleteHandler commReviewDeleteHandler = new CommReviewDeleteHandler(commReviewDTOList);
  CommReviewAddHandler commReviewAddHandler = new CommReviewAddHandler(commReviewDTOList);
  CommReviewListHandler commReviewListHandler = new CommReviewListHandler(commReviewDTOList);
  CommReviewUpdateHandler commReviewUpdateHandler = new CommReviewUpdateHandler(commReviewDTOList);
  CommReviewDeleteHandler commReviewDeleteHandler = new CommReviewDeleteHandler(commReviewDTOList);

  //  CommBestHandler commBestHandler = new CommBestHandler(commBoardHandler);
  //  CommReviewHandler commReviewHandler = new CommReviewHandler(commReviewDTOList);


  //  // ????????? ?????????(??????)
  //  ChallengeHandler challengeHandler = new ChallengeHandler();
  //  ShowChallengeHandler showChallengeHandler = new ShowChallengeHandler();


  // ????????? ?????????(??????)
  ChallengeListHandler challengeListHandler = new ChallengeListHandler();
  ChallengeBoardHandler challengeBoardHandler = new ChallengeBoardHandler();
  RankingHandler rankingHandler = new RankingHandler();
  //  ChallengeReviewHandler challengeReviewHandler = new ChallengeReviewHandler(myChallengeReviewDTOList);


  // ????????? ?????? ?????????(??????)
  DonationRegisterHandler donationRegisterHandler = new DonationRegisterHandler(donationRegisterDTOList);
  //  DonationDetailHandler donationDetailHandler = new DonationDetailHandler(donationRegisterHandler);
  DonationBoardHandler donationBoardHandler = new DonationBoardHandler(donationBoardDTOList);


  // ?????? ????????? ?????????(??????)
  // MyPageHandler myVolHandler = new MyPageHandler();
  //QuestionHandler questionHandler = new QuestionHandler(myQuestionListDTOList);
  AbstractNoticeHandler noticeListHandler = new AbstractNoticeHandler();
  MyProfileHandler myProfileHandler = new MyProfileHandler(myProfileDTOList);
  MyBoardUpdateHandler myBoardListHandler = new MyBoardUpdateHandler();
  MyPointHandler myPointHandler = new MyPointHandler();
  MyDonationHandler myDonationHandler = new MyDonationHandler();
  ApproveOrgHandler approveOrgHandler = new ApproveOrgHandler(approveOrgDTOList);
  WithdrawMemberHandler withdrawMemberHandler = new WithdrawMemberHandler();



  // ???????????? ?????????(??????)

  AdminQuestionHandler showQuestionHandler = new AdminQuestionHandler(questionDTOList);
  // SupportHandler supportHandler = new SupportHandler(questionHandler, noticeListHandler);
  //  SupportHandler supportHandler = new SupportHandler(questionHandler, noticeListHandler);




  // ????????? ????????? ?????????(??????)
  //  ShowVolHandler showVolHandler = new ShowVolHandler(personalVolRequestHandler,orgVolRequestHandler);
  //  ShowMemberHandler showMemberHandler = new ShowMemberHandler();
  //  ShowChallengeHandler showChallengeHandler = new ShowChallengeHandler(); // ?????? List ?????? ??????
  //  ShowOrgApproveHandler showOrgApproveHandler = new ShowOrgApproveHandler();
  //  ShowDonationHandler showDonationHandler = new ShowDonationHandler(donationBoardHandler);
  //  AdminMemberListHandler showMemberHandler = new AdminMemberListHandler();
  //  AdminChallengeHandler showChallengeHandler = new AdminChallengeHandler(); // ?????? List ?????? ??????
  //  AdminOrgApproveAddHandler showOrgApproveHandler = new AdminOrgApproveAddHandler();
  //  MyProfileHandler myProfileHandler = new MyProfileHandler(myProfileDTOList);
  //  AdminPageHandler adminPageHandler = new AdminPageHandler(personalVolRequestHandler,showVolHandler, donationBoardHandler, showDonationHandler); 


  public static void main(String[] args) {

    CopyApp app = new CopyApp(); 
    app.service();

  }

  public CopyApp() {
    //?????????, ????????????
    commands.put("/auth/login", new AuthLoginHandler(joinDTOList)); // ?????????
    commands.put("/auth/logout", new AuthLogoutHandler()); // ????????????
    commands.put("/auth/changeUserInfo", new AuthChangeUserInfoHandler()); // ??????????????? ????????????
    commands.put("/auth/displayUserInfo", new AuthDisplayUserInfoHandler()); // ??????????????? ??????????????????


    //????????????
    commands.put("/join/add", new JoinAddHandler(joinDTOList)); // ????????????
    commands.put("/join/searchId", new JoinSearchIdHandler(joinDTOList)); // ????????? ??????
    commands.put("/join/searchPassword", new JoinSearchPasswordHandler(joinDTOList)); // ???????????? ??????


    // ???????????? ???????????????
    commands.put("/commBoard/add", new CommBoardAddHandler(commBoardDTOList));
    commands.put("/commBoard/list", new CommBoardListHandler(commBoardDTOList));
    commands.put("/commBoard/detail", new CommBoardDetailHandler(commBoardDTOList));
    commands.put("/commBoard/update", new CommBoardUpdateHandler(commBoardDTOList));
    commands.put("/commBoard/delete", new CommBoardDeleteHandler(commBoardDTOList));

    commands.put("/commReview/add ", new CommReviewAddHandler(commReviewDTOList));
    commands.put("/commReview/list ", new CommReviewListHandler(commReviewDTOList));
    commands.put("/commReview/update ", new CommReviewUpdateHandler(commReviewDTOList));
    commands.put("/commReview/delete ", new CommReviewDeleteHandler(commReviewDTOList));

    // ????????? ????????????&??????
    commands.put("/challengeReview/add", new ChallengeReviewAddHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/list", new ChallengeReviewListHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/detail", new ChallengeReviewDetailHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/update", new ChallengeReviewUpdateHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/search", new ChallengeReviewSearchHandler(myChallengeReviewDTOList));

    // ???????????? ????????????
    commands.put("/question/add", new QuestionAddHandler(myQuestionListDTOList));
    commands.put("/question/list", new QuestionListHandler(myQuestionListDTOList));
    commands.put("/question/detail", new QuestionDetailHandler(myQuestionListDTOList));
    commands.put("/question/update", new QuestionUpdateHandler(myQuestionListDTOList));
    commands.put("/question/delete", new QuestionDeleteHandler(myQuestionListDTOList));


    // ???????????????
    commands.put("/myProfile/update", new MyProfileHandler(myProfileDTOList));

    commands.put("/MyPage/delete", new MyPageDelete(joinDTOList)); // ????????????
    commands.put("/MyPage/info", new MyPageInfoHandler(joinDTOList)); // ????????? ??????


    // ?????????
    commands.put("/join/list", new JoinListHandler(joinDTOList)); // ???????????? ?????? ????????? ??????
    commands.put("/join/detail", new JoinDetailHandler(joinDTOList)); // ???????????? ???????????? (???????????????)

    // ????????? ???????????? ??????
    commands.put("/adminMember/list", new AdminMemberListHandler());
    commands.put("/adminMember/delete", new AdminMemberDeleteHandler());

    // ????????? ????????????
    commands.put("/adminNotice/add", new AdminNoticeAddHandler(noticeDTOList));
    commands.put("/adminNotice/list", new AdminNoticeListHandler(noticeDTOList));
    commands.put("/adminNotice/detail", new AdminNoticeDetailHandler(noticeDTOList));
    commands.put("/adminNotice/update", new AdminNoticeUpdateHandler(noticeDTOList));
    commands.put("/adminNotice/delete", new AdminNoticeDeleteHandler(noticeDTOList));

    // ????????? ????????????
    commands.put("/adminQuestion/add", new AdminQuestionAddHandler(questionDTOList));
    commands.put("/adminQuestion/list", new AdminQuestionListHandler(questionDTOList));
    commands.put("/adminQuestion/detail", new AdminQuestionDetailHandler(questionDTOList));
    commands.put("/adminQuestion/update", new AdminQuestionUpdateHandler(questionDTOList));
    commands.put("/adminQuestion/delete", new AdminQuestionDeleteHandler(questionDTOList));

    // ????????? ?????????
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(challengeDTOList));
    commands.put("/adminChallenge/detail", new AdminChallengeDetailHandler(challengeDTOList));
    commands.put("/adminChallenge/update", new AdminChallengeUpdateHandler(challengeDTOList));
    commands.put("/adminChallenge/delete", new AdminChallengeDeleteHandler(challengeDTOList));

    // ???????????????
    commands.put("/myProfile/update", new MyProfileHandler(myProfileDTOList));


    // ????????? ????????????
    commands.put("/challengeQuestion/add", new ChallengeQuestionAddHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/list", new ChallengeQuestionListHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/detail", new ChallengeQuestionDetailHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/update", new ChallengeQuestionUpdateHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/delete", new ChallengeQuestionDeleteHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/search", new ChallengeQuestionSearchHandler(myChallengeQuestionDTOList));


    // ???????????????
    commands.put("/MyPage/delete", new MyPageDelete(joinDTOList)); // ????????????
    commands.put("/MyPage/info", new MyPageInfoHandler(joinDTOList)); // ????????? ??????


    // ?????????
    commands.put("/join/list", new JoinListHandler(joinDTOList)); // ???????????? ?????? ????????? ??????
    commands.put("/join/detail", new JoinDetailHandler(joinDTOList)); // ???????????? ???????????? (???????????????)

  }

  void service() {
    createMenu().execute();
    Prompt.close();
  }

  Menu createMenu() {

    MenuGroup mainMenuGroup = new MenuGroup("*?????????Share*");
    mainMenuGroup.setPrevMenuTitle("??????");



    mainMenuGroup.add(new MenuItem("?????????", Menu.ENABLE_LOGOUT, "/auth/login"));
    mainMenuGroup.add(new MenuItem("???????????????", Menu.ENABLE_LOGOUT, "/join/searchId"));
    mainMenuGroup.add(new MenuItem("??????????????????", Menu.ENABLE_LOGOUT, "/join/searchPassword"));
    mainMenuGroup.add(new MenuItem("????????????", Menu.ENABLE_LOGOUT, "/join/add"));
    mainMenuGroup.add(new MenuItem("????????????", Menu.ENABLE_LOGIN, "/auth/logout"));


    MenuGroup doVolMenu = new MenuGroup("????????????");
    mainMenuGroup.add(doVolMenu);

    doVolMenu.add(new Menu("????????????????????????", Menu.ENABLE_PERSONAL) {
      @Override
      public void execute() {
        personalVolRequestHandler.apply(); 
      }});
    doVolMenu.add(new Menu("????????????????????????", Menu.ENABLE_ORG) {
      @Override
      public void execute() {
        orgVolRequestHandler.apply(); 
      }});
    doVolMenu.add(new Menu("?????????????????????(?????? ?????????)") {
      @Override
      public void execute() {
        personalVolRequestHandler.appliedList(); 
      }});
    doVolMenu.add(new Menu("????????????????????????",Menu.ENABLE_MEMBER) {
      @Override
      public void execute() {
        volApprovedHandler.approvedDetail(); 
      }});
    doVolMenu.add(new Menu("?????????",Menu.ENABLE_MEMBER) {
      @Override
      public void execute() {
        volApprovedHandler.approvedDetail(); 
      }});

    MenuGroup personalCommunityMenu = new MenuGroup("????????????");
    mainMenuGroup.add(personalCommunityMenu);

    MenuGroup reviewMenu = new MenuGroup("?????? ?????????");
    personalCommunityMenu.add(reviewMenu);

    reviewMenu.add(new MenuItem("??????", Menu.ENABLE_MEMBER, "/commBoard/add"));
    reviewMenu.add(new MenuItem("??????","/commBoard/list"));
    reviewMenu.add(new MenuItem("????????????","/commBoard/detail"));
    reviewMenu.add(new MenuItem("??????", Menu.ENABLE_MEMBER,"/commBoard/update"));
    reviewMenu.add(new MenuItem("??????",Menu.ENABLE_MEMBER,"/commBoard/delete"));

    //        MenuGroup bestReviewMenu = new MenuGroup("?????? ????????? BEST", Menu.ENABLE_ALL);
    //        personalCommunityMenu.add(bestReviewMenu);
    //    
    //            bestReviewMenu.add(new Menu("??????", Menu.ENABLE_ALL) {
    //              @Override
    //              public void execute() {
    //                commBestHandler.showList(); 
    //              }});
    //            bestReviewMenu.add(new Menu("????????????", Menu.ENABLE_ALL) {
    //              @Override
    //              public void execute() {
    //                commBestHandler.showDetail(); 
    //              }});

    MenuGroup shortReviewMenu = new MenuGroup("??? ??? ??????");
    personalCommunityMenu.add(shortReviewMenu);

    shortReviewMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/commReview/add"));
    shortReviewMenu.add(new MenuItem("??????", Menu.ENABLE_ALL, "/commReview/list")); 
    shortReviewMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/commReview/update")); 
    shortReviewMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/commReview/delete")); 


    MenuGroup personalChallengeMenu = new MenuGroup("?????????");
    mainMenuGroup.add(personalChallengeMenu);

    MenuGroup monthlyChallengeMenu = new MenuGroup("????????? ?????????");
    personalChallengeMenu.add(monthlyChallengeMenu);

    MenuGroup monthlyChallengeDetail = new MenuGroup("????????? ????????????");
    monthlyChallengeMenu.add(monthlyChallengeDetail);

    monthlyChallengeDetail.add(new Menu("????????????") {
      @Override
      public void execute() {
        challengeBoardHandler.showChallengeDetail(); 
      }});
    monthlyChallengeDetail.add(new Menu("????????????", Menu.ENABLE_PERSONAL) {
      @Override
      public void execute() {
        challengeBoardHandler.join(); 
      }});
    monthlyChallengeDetail.add(new Menu("????????? ??????", Menu.ENABLE_MEMBER) {
      @Override
      public void execute() {
        challengeBoardHandler.showMemberList(); 
      }});
    MenuGroup ChallengeReview = new MenuGroup("????????????&??????");
    monthlyChallengeDetail.add(ChallengeReview);
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", Menu.ENABLE_LOGIN, "/challengeReview/add"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", Menu.ENABLE_ALL,"/challengeReview/list"));
    ChallengeReview.add(new MenuItem("????????????&?????? ????????????", Menu.ENABLE_ALL,"/challengeReview/detail"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", Menu.ENABLE_LOGIN,"/challengeReview/update"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", Menu.ENABLE_LOGIN,"/challengeReview/delete"));
    ChallengeReview.add(new MenuItem("????????????&?????? ??????", Menu.ENABLE_LOGIN, "/challengeReview/search"));


    MenuGroup ChallengeQuestion = new MenuGroup("????????????");
    monthlyChallengeDetail.add(ChallengeQuestion);
    ChallengeQuestion.add(new MenuItem("?????? ??????", Menu.ENABLE_MEMBER, "/challengeQuestion/add"));
    ChallengeQuestion.add(new MenuItem("?????? ??????",  "/challengeQuestion/list"));
    ChallengeQuestion.add(new MenuItem("?????? ????????????",Menu.ENABLE_MEMBER,"/challengeQuestion/detail"));
    ChallengeQuestion.add(new MenuItem("?????? ??????", Menu.ENABLE_MEMBER, "/challengeQuestion/update"));
    ChallengeQuestion.add(new MenuItem("?????? ??????", Menu.ENABLE_MEMBER, "/challengeQuestion/delete"));
    ChallengeQuestion.add(new MenuItem("?????? ??????",  "/challengeQuestion/search"));


    MenuGroup monthlyRankingMenu = new MenuGroup("????????? ??????", Menu.ENABLE_ALL);
    personalChallengeMenu.add(monthlyRankingMenu);


    monthlyRankingMenu.add(new Menu("????????? ????????????", Menu.ENABLE_ALL) {
      @Override
      public void execute() {
        rankingHandler.showTotalRanking(); 
      }});

    monthlyRankingMenu.add(new Menu("?????? ????????????", Menu.ENABLE_PERSONAL) {
      @Override
      public void execute() {
        rankingHandler.showMyRanking(); 
      }});

    MenuGroup personalDonationMenu = new MenuGroup("?????????");
    mainMenuGroup.add(personalDonationMenu);

    MenuGroup donationList = new MenuGroup("????????? ??????");
    personalDonationMenu.add(donationList);

    MenuGroup donation = new MenuGroup("????????? ????????????");
    donationList.add(donation);

    donation.add(new Menu("????????????", Menu.ENABLE_MEMBER) {
      @Override
      public void execute() {
        donationRegisterHandler.add(); 
      }});
    donation.add(new Menu("????????????") {
      @Override
      public void execute() {
        donationRegisterHandler.participationDonation(); 
      }});

    MenuGroup donationTotal = new MenuGroup("?????? ?????????");
    personalDonationMenu.add(donationTotal);

    donationTotal.add(new Menu("??? ????????????") {
      @Override
      public void execute() {
        donationRegisterHandler.totalDonationMoney(); 
      }});

    MenuGroup applyDonation = new MenuGroup("????????? ????????????", Menu.ENABLE_ORG);
    personalDonationMenu.add(applyDonation);

    applyDonation.add(new Menu("????????????") {
      @Override
      public void execute() {
        donationBoardHandler.applyDonation(); 
      }});

    MenuGroup support = new MenuGroup("????????????");
    mainMenuGroup.add(support);

    MenuGroup notice = new MenuGroup("????????????");
    support.add(notice);

    notice.add(new Menu("??????") {
      @Override
      public void execute() {
        noticeListHandler.noticeList(); 
      }});
    notice.add(new Menu("????????????") {
      @Override
      public void execute() {
        noticeListHandler.noticeDetail(); 
      }});

    //    MenuGroup faQ = new MenuGroup("FAQ");
    //    support.add(faQ);
    //
    //    faQ.add(new Menu("??????") {
    //      @Override
    //      public void execute() {
    //        boardHandler.list(); 
    //      }});
    //    faQ.add(new Menu("????????????") {
    //      @Override
    //      public void execute() {
    //        boardHandler.detail(); 
    //      }});

    MenuGroup ask = new MenuGroup("????????????");
    support.add(ask);

    ask.add(new MenuItem("??????", Menu.ENABLE_MEMBER,"/question/add"));
    ask.add(new MenuItem("??????", "/question/list"));
    ask.add(new MenuItem("????????????", "/question/detail"));
    ask.add(new MenuItem("??????",Menu.ENABLE_MEMBER,"/question/update"));
    ask.add(new MenuItem("??????",Menu.ENABLE_MEMBER, "/question/delete"));

    MenuGroup personalMyPage = new MenuGroup("???????????????", Menu.ENABLE_MEMBER);
    mainMenuGroup.add(personalMyPage);

    MenuGroup myProfile = new MenuGroup("????????????");
    personalMyPage.add(myProfile);

    myProfile.add(new MenuItem("??? ??????", "/auth/displayUserInfo"));
    myProfile.add(new MenuItem("??? ?????? ??????", "/auth/changeUserInfo"));

    MenuGroup myVolunteer = new MenuGroup("?????? ??????",Menu.ENABLE_MEMBER);
    personalMyPage.add(myVolunteer);
    //
    myVolunteer.add(new Menu("?????? ??????????????? ??????") {
      @Override
      public void execute() {
        personalVolRequestHandler.applyList(); 
      }});
    myVolunteer.add(new Menu("????????? ????????????") {
      @Override
      public void execute() {
        personalVolRequestHandler.appliedList(); 
      }});    
    myVolunteer.add(new Menu("????????????") {
      @Override
      public void execute() {
        //        personalVolRequestHandler.showVolBookmark(); 
      }});    
    //
    //        MenuGroup myBoard = new MenuGroup("?????? ?????????");
    //        personalMyPage.add(myBoard);
    //    
    //        MenuGroup myBoardList = new MenuGroup("??????");
    //        myBoard.add(myBoardList);
    //    
    //        MenuGroup myBoardDetail = new MenuGroup("????????????");
    //        myBoard.add(myBoardDetail);
    //    
    //        myBoardDetail.add(new Menu("??????") {
    //          @Override
    //          public void execute() {
    //            boardHandler.checkUpdate(); 
    //          }});
    //        myBoardDetail.add(new Menu("??????") {
    //          @Override
    //          public void execute() {
    //            boardHandler.checkDelete(); 
    //          }});    
    //
    //    MenuGroup myPoint = new MenuGroup("?????? ?????????");
    //    personalMyPage.add(myPoint);
    //    //
    //    myPoint.add(new Menu("1. ?????????????????????") {
    //      @Override
    //      public void execute() {
    //        myPointHandler.showMyPointList(); 
    //      }});    
    //    //
    //    MenuGroup myDonation = new MenuGroup("?????? ?????????");
    //    personalMyPage.add(myDonation);
    //    //
    //    myDonation.add(new Menu("1. ??????????????????") {
    //      @Override
    //      public void execute() {
    //        myDonationHandler.showMyTotalDonation(); 
    //      }});    
    //    //
    //    MenuGroup organizationApprove = new MenuGroup("?????? ?????? ??????");
    //    personalMyPage.add(organizationApprove);

    //    organizationApprove.add(new Menu("?????? ????????????") {
    //      @Override
    //      public void execute() {
    //        boardHandler.okSubmit(); 
    //      }});  
    //
    //    organizationApprove.add(new Menu("?????? ????????????") {
    //      @Override
    //      public void execute() {
    //        boardHandler.detail(); 
    //      }});   
    //
    personalMyPage.add(new MenuItem("??????", Menu.ENABLE_MEMBER, "/MyPage/delete"));
    //
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////    

    MenuGroup adminMenu = new MenuGroup("?????????",  Menu.ENABLE_ADMIN);
    mainMenuGroup.add(adminMenu);

    MenuGroup memberMenu = new MenuGroup("???????????? ??????");
    adminMenu.add(memberMenu);
    //
    memberMenu.add(new MenuItem("????????????", "/join/list"));
    memberMenu.add(new MenuItem("???????????? ????????????", "/join/detail"));
    memberMenu.add(new MenuItem("????????????","/adminMember/list"));

    MenuGroup donationMenu = new MenuGroup("????????? ??????");
    adminMenu.add(donationMenu);

    donationMenu.add(new Menu("????????? ?????? ???????????? ??????") {
      @Override
      public void execute() {
        donationBoardHandler.applyDonationList(); 
      }});
    donationMenu.add(new Menu("????????? ?????? ???????????? ????????????") {
      @Override
      public void execute() {
        donationBoardHandler.applyDonationdetail(); 
      }});


    MenuGroup volunteerMenu = new MenuGroup("???????????? ??????");
    adminMenu.add(volunteerMenu);

    volunteerMenu.add(new Menu("????????????????????????") {
      @Override
      public void execute() {
        personalVolRequestHandler.applyList(); 
      }});
    volunteerMenu.add(new Menu("????????????????????????") {
      @Override
      public void execute() {
        orgVolRequestHandler.applyList(); 
      }});
    volunteerMenu.add(new Menu("????????????????????????") {
      @Override
      public void execute() {
        personalVolRequestHandler.acceptApply(); 
      }});
    volunteerMenu.add(new Menu("????????????????????????") {
      @Override
      public void execute() {
        orgVolRequestHandler.acceptApply(); 
      }});
    volunteerMenu.add(new Menu("????????????????????????") {
      @Override
      public void execute() {
        personalVolRequestHandler.rejectApply(); 
      }});
    volunteerMenu.add(new Menu("????????????????????????") {
      @Override
      public void execute() {
        orgVolRequestHandler.rejectApply(); 
      }});

    MenuGroup noticeMenu = new MenuGroup("???????????? ??????");
    adminMenu.add(noticeMenu);

    noticeMenu.add(new MenuItem("???????????? ??????","/adminNotice/add"));
    noticeMenu.add(new MenuItem("???????????? ??????","/adminNotice/list"));
    noticeMenu.add(new MenuItem("???????????? ????????????","/adminNotice/detail"));
    noticeMenu.add(new MenuItem("???????????? ??????","/adminNotice/update"));
    noticeMenu.add(new MenuItem("???????????? ??????","/adminNotice/delete"));

    MenuGroup askInfo = new MenuGroup("???????????? ??????");
    adminMenu.add(askInfo);

    askInfo.add(new MenuItem("???????????? ??????","/adminQuestion/add"));
    askInfo.add(new MenuItem("???????????? ??????","/adminQuestion/add"));
    askInfo.add(new MenuItem("???????????? ????????????","/adminQuestion/add"));
    askInfo.add(new MenuItem("???????????? ??????","/adminQuestion/add"));
    askInfo.add(new MenuItem("???????????? ??????","/adminQuestion/add"));

    MenuGroup challengeInfo = new MenuGroup("????????? ??????");
    adminMenu.add(challengeInfo);

    challengeInfo.add(new MenuItem("????????? ??????","/adminChallenge/add"));
    challengeInfo.add(new MenuItem("????????? ??????","/adminChallenge/add"));
    challengeInfo.add(new MenuItem("????????? ????????????","/adminChallenge/add"));
    challengeInfo.add(new MenuItem("????????? ??????","/adminChallenge/add"));
    challengeInfo.add(new MenuItem("????????? ??????","/adminChallenge/add"));

    MenuGroup approveInfo = new MenuGroup("?????? ??????");
    adminMenu.add(approveInfo);

    approveInfo.add(new MenuItem("?????????????????? ??????","/adminChallenge/list"));
    approveInfo.add(new MenuItem("?????????????????? ??????","/adminChallenge/detail"));
    approveInfo.add(new MenuItem("?????????????????? ??????","/adminChallenge/update"));
    approveInfo.add(new MenuItem("?????????????????? ??????","/adminChallenge/delete"));

    return mainMenuGroup;
  }
}



