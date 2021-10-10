package appium;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;

public class test1 {
    public static void main(String[] args) throws IOException {

        //Start appium sever
        Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
        URL u = new URL("http://0.0.0.0:4723/wd/hub");
        //Define desired capabilities related to device and app
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.BROWSER_NAME, "");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "10");
        dc.setCapability("appPackage", "com.vodqareactnative");
        dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
        //Launch app in device through appium server
        AndroidDriver driver;
        while (2 > 1) {
            try {
                driver = new AndroidDriver(u, dc);
                break;
            } catch (Exception ex) {
            }
        }

        //Test automation
        try {
            Thread.sleep(10000);
            System.out.println(driver.getCurrentPackage());
            System.out.println(driver.currentActivity());
            //work with other app
            if (driver.isAppInstalled("com.soumyasethy.smstoast")) {
                System.out.println("smstoast app is ready");
                driver.activateApp("com.soumyasethy.smstoast");
            } else {
                driver.installApp("C:\\Users\\vallu\\app\\mytoast.apk");
                System.out.println("smstoast app is ready");
                driver.activateApp("com.soumyasethy.smstoast");
            }
            Thread.sleep(10000);
            //Get status of other launched app
            ApplicationState as = driver.queryAppState("com.soumyasethy.smstoast");
            System.out.println(as.toString());
            //Get other launched app details
            System.out.println(driver.getCurrentPackage());
            System.out.println(driver.currentActivity());
            //Close that other launched app
            driver.terminateApp("com.soumyasethy.smstoast");
            //back to work with app specified in desired capabilities
            driver.launchApp();
            Thread.sleep(5000);
            driver.runAppInBackground(Duration.ofSeconds(10));
            Thread.sleep(5000);
            driver.resetApp();
            Thread.sleep(10000);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //Close App
        driver.closeApp();
        //Stop appium server
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
    }
}

