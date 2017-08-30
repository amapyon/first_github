package model;

public class Roman {
	/*
	 * 返却メッセージを生成します。
	 */
	public static String convertFromArabic(int inputNumber){

		if(inputNumber > 20){
			return "変換できません";
		}

		if(inputNumber < 1){
			return "変換できません";
		}

		if (inputNumber < 11){
			return toRoman(inputNumber);
		}
		return "Ⅹ" + toRoman(inputNumber-10);
	}

	/*
	 * 1〜10までの数値をローマ字に変換します。
	 */
	private static String toRoman(int inputNumber){

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
}
