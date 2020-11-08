package com.opencart.navigation;

import com.opencart.driver.DriverRepository;
import org.openqa.selenium.WebDriver;

public class Navigation {
    private WebDriver driver;

    public Navigation () {
        driver = DriverRepository.DRIVERS.get();
    }

    public void navigateToURrl (String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

}


