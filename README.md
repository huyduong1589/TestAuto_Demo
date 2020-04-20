"# TestAuto_Demo" 
1. Download the framework and import into Eclipse.
2. Import "DEMO_001.launch" as "Run/Debug> Launch Configurations".
3. Run as "Maven Build > DEMO_001".
4. Report can be found under: target/surefire-reports/emailable-report.html or index.html.
5. Log is under: logs/testlog3.log.

Details:
- Framework: TestNG.
- Build Tool: Maven.
- All xPath: po/selectors/GobearSelector.java.
- Page Object: po/pages.
- Testscript: po/testcases.
- Test Suite: suites/DEMO.xml.

Note: 
- Please update chromedriver under /drivers/chromedriver.exe to make sure it supports your chrome version.
