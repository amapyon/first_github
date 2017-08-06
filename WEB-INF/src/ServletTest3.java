

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest3 extends HttpServlet {
	private final String REQUEST_STRING = "requestJs";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String parameter = req.getParameter(REQUEST_STRING);
		String message = genMessage(parameter);
		reternMessage(message, res);
		return;
	}

	/*
	 * 返却メッセージを生成します。
	 */
	private String genMessage(String inputString){

		String message = "";
		inputString = inputString.toLowerCase();
		inputString = inputString.replaceAll("\\.|,|:|;|\n|\r\n|\t", " ");
		inputString = inputString.replaceAll("  ", " ");

		String[] wordList = inputString.split(" ");
		HashMap<String,Integer> wordMap = new HashMap<String,Integer>();

		for (String word : wordList){
			if(wordMap.containsKey(word)){
				wordMap.put(word, wordMap.get(word)+1);
			}else{
				wordMap.put(word, 1);
			}
		}

		//出現回数降順にソート
		List<Entry<String, Integer>> sortedList = new ArrayList<Entry<String, Integer>>(wordMap.entrySet());
		Collections.sort(sortedList, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2)
			{
				return entry2.getValue().compareTo(entry1.getValue());
			}
		});

		for (Entry<String, Integer> wordCount : sortedList) {
			message += wordCount.getKey() + " : " + wordCount.getValue() + "<br>";
		}

		return message;
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
