package com.booking.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import java.lang.reflect.Method;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int maxRetryCount = 3; 

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;

            try {
                Object testInstance = result.getInstance();
                
                
                Method driverField = testInstance.getClass().getSuperclass().getDeclaredMethod("tearDown");
                driverField.invoke(testInstance);

                Method beforeClass = testInstance.getClass().getMethod("setUp");
                beforeClass.invoke(testInstance);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;
        }
        return false;
    }
}