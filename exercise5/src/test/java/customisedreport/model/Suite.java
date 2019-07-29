package customisedreport.model;

import java.util.ArrayList;
import java.util.List;

public class Suite {

	private String start_time;

	private List<Test> tests;

	public Suite(String start_time) {
		this.start_time = start_time;
		tests = new ArrayList<Test>();
	}

	public Suite(String start_time, List<Test> tests) {
		super();
		this.start_time = start_time;
		this.tests = tests;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

}
