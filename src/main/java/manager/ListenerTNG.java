package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

public class ListenerTNG implements ITestListener, ISuiteListener {
    Logger logger = LoggerFactory.getLogger(ListenerTNG.class);

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("OnTestStart " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("OnTestSuccess " + result.getName());//успешные сценарии
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info("OnTestFailure " + result.getName());// ууупавшие тесты
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info("OnTestSkipped " + result.getName());//пропущеные ттестты оонни не готовы нначаться
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        logger.info("OnTestFailedButWithinSuccessPercentage " + result.getName());//не хватоло времени
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        logger.info("onTestFailedWithTimeout " + result.getName());// вызывается каждый раз, когда
        //тест завершается сбоем из-за истечения времени ожидания.

    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);//сттартовал тест
        logger.info("onStart " + context.getName());
    }


    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        logger.info("onFinish " + context.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
    }
}
