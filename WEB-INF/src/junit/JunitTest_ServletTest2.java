package junit;
import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.*;

public class JunitTest_ServletTest2 {

	@Test
	public void test() {
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse res = new MockHttpServletResponse();

		req.setParameter( "requestJs", "3" );

		servlet.ServletTest2 servlet2 = new servlet.ServletTest2();

		try {
			servlet2.doGet(req, res);
			assertEquals( "Ⅲ" ,req.getParameter("responseMessage"));
			res.toString();
		} catch (ServletException | IOException e) {
			e.printStackTrace();
			fail("エラー");
		}
	}

}
