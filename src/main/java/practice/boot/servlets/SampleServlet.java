package practice.boot.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * When using an embedded container, automatic registration
 * of @WebServlet, @WebFilter, and @WebListener annotated classes can be enabled
 * using @ServletComponentScan. @ServletComponentScan should be annotated in any
 * of the configuration class.
 * 
 * For testing hit the below url.
 * 
 * http://localhost:8080/testservlet
 *
 */
@WebServlet(urlPatterns = "/testservlet")
public class SampleServlet extends HttpServlet {

	private static final long serialVersionUID = 3861185246703724692L;

	@Autowired
	private ServletContext servletContext;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// saveFile("dummy.txt");
		resp.getOutputStream().println("Testing servlets");
	}

	private String saveFile(String fileName) throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get("E:\\for reference\\java9.txt"));
		String imagePath = new String(this.servletContext.getRealPath("/myApp/src/web/images") + "/" + fileName);
		Path path = Paths.get(imagePath);
		Files.write(path, bytes);
		return imagePath;
	}

	public static void main1(String[] args) {
		String[] arr = { "2018-01-01", "2018-01-07", "2018-01-30", "2018-01-22", "2018-01-25" };
		for (String str : arr) {
			LocalDate ld = LocalDate.parse(str);
			ld = ld.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
			int res = (ld.getDayOfMonth() / 7) + (Integer.min(1, ld.getDayOfMonth() % 7));
			System.out.printf("%s  => %d\n", str, res);
		}
	}

	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
		System.out.println(LocalDate.parse("01/05/18", formatter));
	}

}
