package junit;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JunitTest_ServletTest2 {

	@Test
	public void testNumber() throws ServletException, IOException {

		assertEquals("負の数は変換できない", "変換できません", getAnswer(-10000));
		assertEquals("負の数は変換できない", "変換できません", getAnswer(-1));

		assertEquals("0は変換できない", "変換できません", getAnswer(0));

		assertEquals("21以上は変換できない", "変換できません", getAnswer(21));
		assertEquals("21以上は変換できない", "変換できません", getAnswer(10050));

		assertEquals("1はⅠに変換", "Ⅰ", getAnswer(1));
		assertEquals("Ⅴ", getAnswer(5));
		assertEquals("Ⅵ", getAnswer(6));
		assertEquals("Ⅹ", getAnswer(10));
		assertEquals("ⅩⅠ", getAnswer(11));
		assertEquals("ⅩⅤ", getAnswer(15));
		assertEquals("ⅩⅥ", getAnswer(16));
		assertEquals("ⅩⅩ", getAnswer(20));
	}

	@Test
	public void testString() throws ServletException, IOException {
		assertEquals("文字列は変換できない", "数値を入力してください。。", getAnswer("あ"));
	}

	//数値から回答を取得します。
	private String getAnswer(int inputNum) throws ServletException, IOException {

		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse res = new MockHttpServletResponse();

		req.setParameter("requestJs", String.valueOf(inputNum));
		return execServlet(req, res);
	}

	//文字列から回答を取得します。
	private String getAnswer(String inputString) throws ServletException, IOException {

		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse res = new MockHttpServletResponse();

		req.setParameter("requestJs", inputString);
		return execServlet(req, res);

	}

	//テスト対象サーブレットのdoGetメソッドを実行し、回答を取得します。
	private String execServlet(MockHttpServletRequest req, MockHttpServletResponse res)
			throws ServletException, IOException {
		servlet.ServletTest2 servlet2 = new servlet.ServletTest2();
		servlet2.doGet(req, res);

		String responseMessage = res.getContentAsString();
		return getJsonValue(responseMessage);
	}

	//JSONテキストから、回答文字列を取得します。
	private String getJsonValue(String jsonText) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ResponseJson jsonObject = mapper.readValue(jsonText, ResponseJson.class);
		return jsonObject.getResponseMessage();
	}
}
