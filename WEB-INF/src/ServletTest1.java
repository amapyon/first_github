

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest1 extends HttpServlet {
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


	//*
	//1〜入力数値までの数字を順に出力し、文字列として返却します。
	//3の倍数の数字は△、4の倍数の数字は□、3と4の公倍数の数字は◆に変換します。
	//*
	private String genMessage(int inputNumber){

		if(inputNumber > 1000){
			return "数値が大きすぎます。。1000イカの数値を入力してください。";
		}

		if(inputNumber < 1){
			return "1以上の数値を入力してください。。。";
		}

		String message = "";
		for(int num = 1 ; num < inputNumber + 1;  num++){

			if(num % 12 == 0){
				 message +=  "◆ ";
			}
			else if(num % 3 == 0){
				 message +=  "△ ";
			}
			else if(num % 4 == 0){
				 message +=  "□ ";
			}
			else{
				message += num + " ";
			}
		}
		return message;
	}


//*
//	メッセージをクライアントに返します。
//*
	private void reternMessage(String message, HttpServletResponse res) throws IOException{
		String responseJson = "{\"responseMessage\" : \"" + message + "\"}";
		res.setContentType("application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print(responseJson);
	}
}
