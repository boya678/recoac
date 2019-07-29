package com.astoudcommerce.task3.support;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class JavaRobot
{
  Robot robot = new Robot();


  public static JavaRobot robot() {
	  try {
		return new JavaRobot();
	} catch (AWTException e) {
		return null;
	}
  }
  
  public JavaRobot() throws AWTException
  {
	  robot.delay(200);
  }
  
  public void leftClick()
  {
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.delay(200);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);
    robot.delay(200);
  }
  
  public void type(int i)
  {
    robot.delay(40);
    robot.keyPress(i);
    robot.keyRelease(i);
  }

  public void type(String s)
  {
    byte[] bytes = s.getBytes();
    for (byte b : bytes)
    {
      int code = b;
      if (code > 96 && code < 123) code = code - 32;
      robot.delay(40);
      robot.keyPress(code);
      robot.keyRelease(code);
    }
  }
}