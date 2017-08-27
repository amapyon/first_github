package junit;
import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JunitTest_ServletTest2 {

	@Test
	public void test() throws ServletException, IOException {

		String answer = getAnswer(3);
		assertEquals( "Ⅲ" ,answer);

		answer = getAnswer(10);
		assertEquals( "Ⅹ" ,answer);
	}


	private String getAnswer(int inputNum) throws ServletException, IOException {

		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse res = new MockHttpServletResponse();

		req.setParameter( "requestJs", String.valueOf(inputNum));

		servlet.ServletTest2 servlet2 = new servlet.ServletTest2();
		servlet2.doGet(req, res);
	    String responseMessage = res.getContentAsString();
	    ObjectMapper mapper = new ObjectMapper();
	    ResponseJson responseJson = mapper.readValue(responseMessage, ResponseJson.class);
		return responseJson.getResponseMessage();

	}

}
