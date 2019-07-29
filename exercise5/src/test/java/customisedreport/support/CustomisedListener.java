package customisedreport.support;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.gson.Gson;

import customisedreport.model.Suite;
import customisedreport.model.Test;

public class CustomisedListener implements ITestListener {

	private static String start_time;
	private static List<Test> tests=new ArrayList<Test>();
	private static Test test;
	
	public void onTestStart(ITestResult result) {
		test=new Test();
		test.setName(result.getName());
		test.setDescription(result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		test.setStatus("Passed");
		tests.add(test);
	}

	public void onTestFailure(ITestResult result) {
		test.setStatus("Fail");
		test.setException(String.valueOf(result.getThrowable()));
		tests.add(test);
	}

	public void onTestSkipped(ITestResult result) {
		test.setStatus("Skipped");
		tests.add(test);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		test.setStatus("PassedWithErrors");
		test.setException(String.valueOf(result.getThrowable()));
		tests.add(test);
	}

	public void onStart(ITestContext context) {
		start_time=context.getStartDate().toString();
	}

	public void onFinish(ITestContext context) {
		Suite suite=new Suite(start_time, tests);
		Gson gson = new Gson();  
		System.out.println(gson.toJson(suite));  
		try {
			PrintWriter out = new PrintWriter(Paths.get("").toAbsolutePath().toString() + "\\result.json");
			out.print(gson.toJson(suite));
			out.close();
		} catch (Exception e) {
			
		}
	}

}
