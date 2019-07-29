package com.astoudcommerce.task1.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.astoudcommerce.task1.engine.JsonGetter;
import com.astoudcommerce.task1.model.Task;

public class JsonTest {

	@Test
	public void printAllUncompletedTitleTaskUser9() {
		List<Task> taskList=JsonGetter.use().getList();
		for (Task task : taskList) {
			if(!task.isCompleted() && (task.getUserId()==9)) {
				System.out.println(task.getTitle());
			}
		}
	}
	
	@Test(description = "countId1OnlyHas5UncompletedTask desc")
	public void countId1OnlyHas5UncompletedTask() {
		int countTask=0;
		List<Task> taskList=JsonGetter.use().getList();
		for (Task task : taskList) {
			if((task.getId()==1) & (!task.isCompleted())){
				countTask++;
			}
		}
		Assert.assertTrue(countTask<=5);
	}
	
	
}
