public static String renderPageWithSetupsAndTeardowns(PageData pageData, boolean isSuite) throws Exception {
  boolean isTestPage = pageData.hasAttribute("Test");
  if (isTestPage) {
    WikiPage testPage = pageData.getWikiPage();
    StringBuffer newPageContent = new StringBuffer();
    includeSuiteSetup(testPage, newPageContent, isSuite);
    newPageContent.append(pageData.getContent);
    includeTeardownPages(testPage, newPageContent, isSuite);
    pageData.setContent(newPageContent.toString());
  }
  return pageData.getHtml();
}

public static void includeSuiteSetup(Wikipage testPage, StringBuffer newPageContent, boolean isSuite) {
  if (isSuite) {
    WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(
      SuiteResponder.SUITE_SETUP_NAME, testPage
    );
    if (suiteSetup != null) {
      WikiPagePath pagePath =
        suiteSetup.getPageCrawler().getFullPath(suiteSetup);
      String pagePathName = PathParser.render(pagePath);
      newPageContent.append("!include -setup .")
            .append(pagePathName)
            .append("\n");
    }
  }
  WikiPage setup = PageCrawlerImpl.getInheritedPage("SetUp", testPage);
  if (setup != null) {
    WikiPagePath setupPath = testPage.getPageCrawler().getFullPath(setup);
    String setupPathName = PathParser.render(setupPath);
    newPageContent.append("!include -setup .")
          .append(setupPathName)
          .append("\n");
  }
}

public static void includeTeardownPages(Wikipage testPage, StringBuffer newPageContent, boolean isSuite) {
  WikiPage teardown = PageCrawlerImpl.getInheritedPage("TearDown", testPage);
  if (teardown != null) {
    WikiPagePath tearDownPath = testPage.getPageCrawler().getFullPath(tearedown);
    String tearDownPathName = PathParser.render(tearDownPath);
    newPageContent.append("\n")
          .append("!include -teardown .")
          .append(tearDownPathName)
          .append("\n");
  }
  if (isSuite) {
    WikiPage suiteTeardown =
      PageCrawlerImpl.getInheritedPage(
        SuiteResponder.SUITE_TEARDOWN_NAME,
        testPage
      );
    if (suiteTeardown != null) {
      WikiPagePath pagePath = suiteTeardown.getPageCrawler().getFullPath(suiteTeardown);
      String pagePathName = PathParser.render(pagePath);
      newPageContent.append("!include -teardown .")
            .append(pagePathName)
            .append("\n");
    }
  }
}