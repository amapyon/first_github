package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanTest {

	@Test
	public void testGenMessage() {

		assertEquals("1はⅠに変換", "Ⅰ", Roman.convertFromArabic(1));
		assertEquals("Ⅴ", Roman.convertFromArabic(5));
		assertEquals("Ⅵ", Roman.convertFromArabic(6));
		assertEquals("Ⅹ", Roman.convertFromArabic(10));
		assertEquals("ⅩⅠ", Roman.convertFromArabic(11));
		assertEquals("ⅩⅤ", Roman.convertFromArabic(15));
		assertEquals("ⅩⅥ", Roman.convertFromArabic(16));
		assertEquals("ⅩⅩ", Roman.convertFromArabic(20));

	}

	@Test
	public void testGenMessageOutOfRange() {
		assertEquals("負の数は変換できない", "変換できません", Roman.convertFromArabic(-10000));
		assertEquals("負の数は変換できない", "変換できません", Roman.convertFromArabic(-1));

		assertEquals("0は変換できない", "変換できません", Roman.convertFromArabic(0));

		assertEquals("21以上は変換できない", "変換できません", Roman.convertFromArabic(21));
		assertEquals("21以上は変換できない", "変換できません", Roman.convertFromArabic(10050));
	}

}
