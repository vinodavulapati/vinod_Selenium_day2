package work_day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day2 extends factory {

	@Test
	public void invalidRegistration() throws InterruptedException

	{
		Thread.sleep(5400);
		
		// ***********************  FIRST EXAMPLE SO PRESENTING ALL LOCATORS *********
		// xpath
		 getDriver().findElement(By.id("u_0_1")).sendKeys("vinod kumar");
		
		 // custom xpath
		//getDriver().findElement(By.xpath(".//input[@class='inputtext _58mg _5dba _2ph-' and @name='firstname']")).sendKeys("vinod kumar");
		
		 // cssSelector
		getDriver().findElement(By.cssSelector("#u_0_3")).sendKeys("avulapati");
		// by ID
		getDriver().findElement(By.id("u_0_5")).sendKeys("1234567890");
		// by Name
		getDriver().findElement(By.name("reg_email_confirmation__")).sendKeys("1234567890");
		
		//getDriver().findElement(By.className("inputtext _58mg _5dba _2ph-")).sendKeys("de12sde34rfse3sa");
		//Here if we use class name this class name is looking like a compound class name so its giving a failure state after running by xpath
		
		getDriver().findElement(By.xpath(".//*[@id='u_0_a']")).sendKeys("assaasasasasasasasasasaas");

		// by linkText
		// getDriver().findElement(By.linkText("Forgot account?"));
		//by partialLinkText
		// getDriver().findElement(By.partialLinkText("Forgot"));

				// ********** DROP DOWN ******************
		Select dropdown = new Select(getDriver().findElement(By.id("month")));
		dropdown.selectByVisibleText("Jul");
		// dropdown.selectByIndex(7);
		// dropdown.selectByValue("11");

		Select dropdown2 = new Select(getDriver().findElement(By.id("day")));
		dropdown2.selectByVisibleText("31");

		Select dropdown3 = new Select(getDriver().findElement(By.id("year")));
		dropdown3.selectByVisibleText("1992");

		getDriver().findElement(By.id("u_0_i")).click();
		getDriver().findElement(By.cssSelector("#u_0_e")).click();
		String S = "";
		List<WebElement> e = getDriver().findElements(By.xpath(".//div[starts-with(@id,'js') and contains(@class,'_5633')]"));
		for (int i = 0; i < e.size(); i++) {
			S = e.get(0).getText();
		}
		Assert.assertEquals(S, "Please enter a valid mobile number or email address.");
	}

	@Test
	public void duplicateTest() {
		WebElement dropdown = getDriver().findElement(By.xpath(".//*[@id='month']"));
		dropdownDuplicates(dropdown);
	}

	@Test
	public void radioSelectionCheck() {
		getDriver().findElement(By.id("u_0_i")).click();
		boolean isMaleSelected = getDriver().findElement(By.id("u_0_i")).isSelected();
		if ((isMaleSelected == true)) {
			System.out.println("Male Button Selection is Working good: ");
		} else {
			System.out.println("Radio Button Selection not working: ");
			Assert.fail("Buttons should not be selected both at same time; ");
		}
		getDriver().findElement(By.id("u_0_h")).click();
		boolean isFemaleSelected = getDriver().findElement(By.id("u_0_h")).isSelected();
		if ((isFemaleSelected == true)) {
			System.out.println("Female Button Selection is Working good: ");
		} else {
			System.out.println("Radio Button Selection not working: ");
			Assert.fail("Buttons should not be selected both at same time; ");
		}
	}

	@Test
	public void radioButton() {
		getDriver().findElement(By.id("u_0_h")).click();

		getDriver().findElement(By.id("u_0_i")).click();

		boolean isMaleSelected = getDriver().findElement(By.id("u_0_i")).isSelected();

		boolean isFemaleSelected = getDriver().findElement(By.id("u_0_h")).isSelected();

		if ((isMaleSelected == true) && (isFemaleSelected == true)) {
			System.out.println("Two Radio Buttons are Selected: ");
			Assert.fail("Buttons should not be selected both at same time; ");
		} else {
			System.out.println("Radio Buttons Working Good;");

		}
	}
}
