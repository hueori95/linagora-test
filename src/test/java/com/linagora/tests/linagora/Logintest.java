package com.linagora.tests.linagora;

import com.linagora.page.test.LoginPage;
import com.linagora.tests.AbstractTest;
import com.linagora.tests.linagora.model.LoginTestData;
import com.linagora.util.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Logintest extends AbstractTest {
    private LoginPage loginPage;
    private LoginTestData testData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setPageObject(String testDataPath) {
        loginPage = new LoginPage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, LoginTestData.class);
    }
    @Test
    public void logintest(){
        loginPage.goTo("https://sso.linagora.com/");
        Assert.assertTrue(loginPage.isAt());
        loginPage.login(testData.getUsername(),testData.getPassword());
    }

    @Test(dependsOnMethods = "logintest")
    public void verifyLogin(){
        Assert.assertTrue(loginPage.verifyWrongCredentials());
    }


}
