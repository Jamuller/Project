import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//jack muller making a test change
public class emailExtractor
{
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_17);
		HtmlPage first = (HtmlPage)webClient.getPage("https://directory.amherst.edu/index.php?searchType=stu_adv&PHPSESSID=cfe3560594567a6ae1f2b91ef531c824");
		HtmlPage login = (HtmlPage)webClient.getPage("https://directory.amherst.edu/login.php");

		HtmlForm loginForm = login.getFormByName("frmLogin");

		HtmlTextInput username = (HtmlTextInput)loginForm.getInputByName("txtUser");
		HtmlPasswordInput password = (HtmlPasswordInput)loginForm.getInputByName("txtPass");
		HtmlSubmitInput loginButton = loginForm.getInputByValue("Login");

		username.setValueAttribute("fterry16");
		password.setValueAttribute("password");

		HtmlPage loggedIn = loginButton.click();

		System.out.println(loggedIn);

		HtmlPage HtmlPage1 = (HtmlPage)webClient.getPage("https://directory.amherst.edu/stu_search.php?outputType=facebook&searchHeader=&searchType=stu_adv&txtStuFirst=&txtStuMiddle=&txtStuLast=&txtStuEmail=&txtStuYear=2017&txtStuCampAddr=&txtStuCampFloor=&txtStuPhone=&txtStuPOBox=&txtStuHomeCity=&txtStuHomeState=&txtStuHomeCountry=&x=-1693&y=-611");
		HtmlTable table = (HtmlTable)HtmlPage1.getFirstByXPath("//table");
		List rows = table.getRows();
		String xPath1 = "/html/body/table/tbody/tr[";
		String xPath2 = "]/td[1]/p/a[2]";
		String xPath3 = "]/td[2]/p/a[2]";
		String xPath4 = "]/td[3]/p/a[2]";

		for (Double i = Double.valueOf(2.0D); i.doubleValue() < rows.size() + 1; i = Double.valueOf(i.doubleValue() + 1.0D)) {
			BufferedWriter out = null;
			try {
				out = new BufferedWriter(new FileWriter("2017.txt", true));
			}
			catch (Exception localException) {
			}
			String xPathFinal =  xPath1 + i.toString() + xPath2;
			HtmlAnchor email1 = (HtmlAnchor)HtmlPage1.getFirstByXPath(xPathFinal);
			String finalEmail1 = email1.toString();
			String[] finalEmail4 = finalEmail1.split("\"");
			String finalEmail7 = finalEmail4[1];
			finalEmail7 = finalEmail7.substring(7);
			System.out.println(finalEmail7);
			try {
				out.append(finalEmail7);
				out.newLine();
			}
			catch (Exception localException1)
			{
			}

			xPathFinal = xPath1 + i.toString() + xPath3;
			HtmlAnchor email2 = (HtmlAnchor)HtmlPage1.getFirstByXPath(xPathFinal);
			String finalEmail2 = "";
			try {
				finalEmail2 = email2.toString();
				String[] finalEmail5 = finalEmail2.split("\"");
				String finalEmail8 = finalEmail5[1];
				finalEmail8 = finalEmail8.substring(7);
				System.out.println(finalEmail8);
				out.append(finalEmail8);
				out.newLine();
			}
			catch (Exception localException2)
			{
			}

			xPathFinal = xPath1 + i.toString() + xPath4;
			HtmlAnchor email3 = (HtmlAnchor)HtmlPage1.getFirstByXPath(xPathFinal);
			String finalEmail3 = "";
			try {
				finalEmail3 = email3.toString();
				String[] finalEmail6 = finalEmail3.split("\"");
				String finalEmail9 = finalEmail6[1];
				finalEmail9 = finalEmail9.substring(7);
				System.out.println(finalEmail9);
				out.append(finalEmail9);
				out.newLine();
			} catch (NullPointerException localNullPointerException) {
			}
			out.close();
		}
		HtmlPage HtmlPage2 = (HtmlPage)webClient.getPage("https://directory.amherst.edu/stu_search.php?outputType=facebook&searchHeader=&searchType=stu_adv&txtStuFirst=&txtStuMiddle=&txtStuLast=&txtStuEmail=&txtStuYear=2018&txtStuCampAddr=&txtStuCampFloor=&txtStuPhone=&txtStuPOBox=&txtStuHomeCity=&txtStuHomeState=&txtStuHomeCountry=&x=-1693&y=-611");
		for (Double i = Double.valueOf(2.0D); i.doubleValue() < rows.size() + 1; i = Double.valueOf(i.doubleValue() + 1.0D)) {
			try { 
				BufferedWriter out2 = null;
				try {
					out2 = new BufferedWriter(new FileWriter("2018.txt", true));
				}
				catch (Exception localException) {
				}
				String xPathFinal =  xPath1 + i.toString() + xPath2;
				HtmlAnchor email1 = (HtmlAnchor)HtmlPage2.getFirstByXPath(xPathFinal);
				String finalEmail1 = email1.toString();
				String[] finalEmail4 = finalEmail1.split("\"");
				String finalEmail7 = finalEmail4[1];
				finalEmail7 = finalEmail7.substring(7);
				System.out.println(finalEmail7);
				try {
					out2.append(finalEmail7);
					out2.newLine();
				}
				catch (Exception localException1)
				{
				}

				xPathFinal = xPath1 + i.toString() + xPath3;
				HtmlAnchor email2 = (HtmlAnchor)HtmlPage2.getFirstByXPath(xPathFinal);
				String finalEmail2 = "";
				try {
					finalEmail2 = email2.toString();
					String[] finalEmail5 = finalEmail2.split("\"");
					String finalEmail8 = finalEmail5[1];
					finalEmail8 = finalEmail8.substring(7);
					System.out.println(finalEmail8);
					out2.append(finalEmail8);
					out2.newLine();
				}
				catch (Exception localException2)
				{
				}

				xPathFinal = xPath1 + i.toString() + xPath4;
				HtmlAnchor email3 = (HtmlAnchor)HtmlPage2.getFirstByXPath(xPathFinal);
				String finalEmail3 = "";
				try {
					finalEmail3 = email3.toString();
					String[] finalEmail6 = finalEmail3.split("\"");
					String finalEmail9 = finalEmail6[1];
					finalEmail9 = finalEmail9.substring(7);
					System.out.println(finalEmail9);
					out2.append(finalEmail9);
					out2.newLine();
				} catch (NullPointerException localNullPointerException) {
				}
				out2.close();
			} catch (NullPointerException e) {
			}
		}

		HtmlPage HtmlPage3 = (HtmlPage)webClient.getPage("https://directory.amherst.edu/stu_search.php?outputType=facebook&searchHeader=&searchType=stu_adv&txtStuFirst=&txtStuMiddle=&txtStuLast=&txtStuEmail=&txtStuYear=2015&txtStuCampAddr=&txtStuCampFloor=&txtStuPhone=&txtStuPOBox=&txtStuHomeCity=&txtStuHomeState=&txtStuHomeCountry=&x=-1693&y=-611");
		for (Double i = Double.valueOf(2.0D); i.doubleValue() < rows.size() + 1; i = Double.valueOf(i.doubleValue() + 1.0D)) {
			try {
				BufferedWriter out3 = null;
				try {
					out3 = new BufferedWriter(new FileWriter("2015.txt", true));
				}
				catch (Exception localException) {
				}
				String xPathFinal =  xPath1 + i.toString() + xPath2;
				HtmlAnchor email1 = (HtmlAnchor)HtmlPage3.getFirstByXPath(xPathFinal);
				String finalEmail1 = email1.toString();
				String[] finalEmail4 = finalEmail1.split("\"");
				String finalEmail7 = finalEmail4[1];
				finalEmail7 = finalEmail7.substring(7);
				System.out.println(finalEmail7);
				try {
					out3.append(finalEmail7);
					out3.newLine();
				}
				catch (Exception localException1)
				{
				}

				xPathFinal = xPath1 + i.toString() + xPath3;
				HtmlAnchor email2 = (HtmlAnchor)HtmlPage3.getFirstByXPath(xPathFinal);
				String finalEmail2 = "";
				try {
					finalEmail2 = email2.toString();
					String[] finalEmail5 = finalEmail2.split("\"");
					String finalEmail8 = finalEmail5[1];
					finalEmail8 = finalEmail8.substring(7);
					System.out.println(finalEmail8);
					out3.append(finalEmail8);
					out3.newLine();
				}
				catch (Exception localException2)
				{
				}

				xPathFinal = xPath1 + i.toString() + xPath4;
				HtmlAnchor email3 = (HtmlAnchor)HtmlPage3.getFirstByXPath(xPathFinal);
				String finalEmail3 = "";
				try {
					finalEmail3 = email3.toString();
					String[] finalEmail6 = finalEmail3.split("\"");
					String finalEmail9 = finalEmail6[1];
					finalEmail9 = finalEmail9.substring(7);
					System.out.println(finalEmail9);
					out3.append(finalEmail9);
					out3.newLine();
				} catch (NullPointerException localNullPointerException) {
				}
				out3.close();
			} catch (NullPointerException e) {
			}
		}
		HtmlPage HtmlPage4 = (HtmlPage)webClient.getPage("https://directory.amherst.edu/stu_search.php?outputType=facebook&searchHeader=&searchType=stu_adv&txtStuFirst=&txtStuMiddle=&txtStuLast=&txtStuEmail=&txtStuYear=2016&txtStuCampAddr=&txtStuCampFloor=&txtStuPhone=&txtStuPOBox=&txtStuHomeCity=&txtStuHomeState=&txtStuHomeCountry=&x=-1693&y=-611");
		for (Double i = Double.valueOf(2.0D); i.doubleValue() < rows.size() + 1; i = Double.valueOf(i.doubleValue() + 1.0D)) {
			try {
				BufferedWriter out4 = null;
				try {
					out4 = new BufferedWriter(new FileWriter("2016.txt", true));
				}
				catch (Exception localException) {
				}
				String xPathFinal =  xPath1 + i.toString() + xPath2;
				HtmlAnchor email1 = (HtmlAnchor)HtmlPage4.getFirstByXPath(xPathFinal);
				String finalEmail1 = email1.toString();
				String[] finalEmail4 = finalEmail1.split("\"");
				String finalEmail7 = finalEmail4[1];
				finalEmail7 = finalEmail7.substring(7);
				System.out.println(finalEmail7);
				try {
					out4.append(finalEmail7);
					out4.newLine();
				}
				catch (Exception localException1)
				{
				}

				xPathFinal = xPath1 + i.toString() + xPath3;
				HtmlAnchor email2 = (HtmlAnchor)HtmlPage4.getFirstByXPath(xPathFinal);
				String finalEmail2 = "";
				try {
					finalEmail2 = email2.toString();
					String[] finalEmail5 = finalEmail2.split("\"");
					String finalEmail8 = finalEmail5[1];
					finalEmail8 = finalEmail8.substring(7);
					System.out.println(finalEmail8);
					out4.append(finalEmail8);
					out4.newLine();
				}
				catch (Exception localException2)
				{
				}

				xPathFinal = xPath1 + i.toString() + xPath4;
				HtmlAnchor email3 = (HtmlAnchor)HtmlPage4.getFirstByXPath(xPathFinal);
				String finalEmail3 = "";
				try {
					finalEmail3 = email3.toString();
					String[] finalEmail6 = finalEmail3.split("\"");
					String finalEmail9 = finalEmail6[1];
					finalEmail9 = finalEmail9.substring(7);
					System.out.println(finalEmail9);
					out4.append(finalEmail9);
					out4.newLine();
				} catch (NullPointerException localNullPointerException) {
				}
				out4.close();
			} catch (NullPointerException e) {
			}
		}
	}
}