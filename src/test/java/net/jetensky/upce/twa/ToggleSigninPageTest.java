package net.jetensky.upce.twa;

import net.jetensky.upce.twa.testframework.pages.SigninPage;
import net.jetensky.upce.twa.testframework.pages.Site;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ToggleSigninPageTest extends SeleniumTestCase {
 
 @Autowired
 private Site site;
 
 @Test
 public void test() {
  site.gotoSigninPage()
          .email("pavel.jetensky@seznam.cz")
          .password("stromlze").submit();
 }


}