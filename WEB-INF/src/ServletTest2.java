

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest2 extends HttpServlet {
	private final String REQUEST_STRING = "requestJs";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String parameter = req.getParameter(REQUEST_STRING);
		int inputNumber = 0;

		try {
			inputNumber = Integer.parseInt(parameter);

		}catch (Exception e) {
			reternMessage("数値を入力してください。。", res);
			return;
		}

		String message = genMessage(inputNumber);
		reternMessage(message, res);
		return;
	}

	/*
	 * 返却メッセージを生成します。
	 */
	private String genMessage(int inputNumber){

		if(inputNumber > 20){
			return "数値が大きすぎます。。20イカの数値を入力してください。";
		}

		if(inputNumber < 1){
			return "1以上の数値を入力してください。。。";
		}

		String message = "";

		if (inputNumber < 11){
			message = toRoman(inputNumber);
		}else{
			message = "Ⅹ" + toRoman(inputNumber-10);
		}
		return message;
	}

	/*
	 * 1〜10までの数値をローマ字に変換します。
	 */
	private String toRoman(int inputNumber){

		if (inputNumber < 6){
			switch (inputNumber){
				case 1 : return "Ⅰ";
				case 2 : return "Ⅱ";
				case 3 : return "Ⅲ";
				case 4 : return "Ⅳ";
				case 5 : return "Ⅴ";
			}
		}else{
			switch (inputNumber){
				case 6 : return "Ⅵ";
				case 7 : return "Ⅶ";
				case 8 : return "Ⅷ";
				case 9 : return "Ⅸ";
				case 10 : return "Ⅹ";
			}
		}
		return "";
	}

	/*
	*	メッセージをクライアントに返します。
	*/
	private void reternMessage(String message, HttpServletResponse res) throws IOException{
		String responseJson = "{\"responseMessage\" : \"" + message + "\"}";
		res.setContentType("application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print(responseJson);
	}
}
