package Deepak.tests;

import org.testng.annotations.*;

public class TestNGTutorial {

    @AfterTest
    public void LastExecution(){
        System.out.println("I will execute last");
    }
    @Test
    public void Demo (){
        System.out.println("hello");
    }

    @Test
    public void SecondTest(){
        System.out.println("bye");
    }

    @BeforeSuite
    public void firstsuite(){
        System.out.println("I am number 1");
    }

    @Test
    public void Weblogin(){
        System.out.println("weblogin");
    }

    @AfterSuite
    public void afsuite(){
        System.out.println("I am number last");
    }

    @Test
    public void MobileLogincarLoad(){
        System.out.println("mobilelogin");
    }

    @Test
    public void MobileSignincarLoad(){
        System.out.println("mobilelogin");
    }

    @Test
    public void MobileSignoutcarLoad(){
        System.out.println("mobilelogin");
    }

    @Test
    public void LoginAPIcarload(){
        System.out.println("loginapi");
    }

    @BeforeTest
    public void prerequisite(){
        System.out.println("I will execute first");
    }
}
