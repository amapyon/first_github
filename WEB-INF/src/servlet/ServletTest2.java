package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Roman;

public class ServletTest2 extends HttpServlet {
	private final String REQUEST_STRING = "requestJs";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		String parameter = req.getParameter(REQUEST_STRING);
		int inputNumber = 0;

		try {
			inputNumber = Integer.parseInt(parameter);

		} catch (NumberFormatException nfe) {
			try {
				reternMessage("数値を入力してください。。", res);
			} catch (IOException ioe) {
				throw new ServletException(ioe);
			}
			return;
		}

		String message = Roman.convertFromArabic(inputNumber);
		try {
			reternMessage(message, res);
		} catch (IOException ioe) {
			throw new ServletException(ioe);
		}
		return;
	}

	/*
	 * メッセージをクライアントに返します。
	 */
	private void reternMessage(String message, HttpServletResponse res) throws IOException {
		String responseJson = "{\"responseMessage\" : \"" + message + "\"}";
		res.setContentType("application/json;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print(responseJson);
	}
}
