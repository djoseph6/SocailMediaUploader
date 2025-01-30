package pageobjectmodels;
import org.springframework.stereotype.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	
@Component // Marks this as a Spring-managed component
public class YoutubePOM {
		
	  private final WebDriver driver;

	    @FindBy(name = "search")
	    private WebElement searchBox;

	    

	    public void searchVideo(String query) {
	        searchBox.sendKeys(query);
	        searchBox.submit();
	    }
	    
	    public YoutubePOM(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
}
