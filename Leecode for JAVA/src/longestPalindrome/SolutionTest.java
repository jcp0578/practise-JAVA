package longestPalindrome;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class SolutionTest {
	
	@DisplayName("NULL String TEST")
	@Test
	void testNULL() {
		String test_t= "";
		assertEquals("", Solution.longestPalindrome(test_t));
	}
	@DisplayName("single String TEST")
	@Test
	void testsingle() {
		String test_t= "a";
		assertEquals("a", Solution.longestPalindrome(test_t));
	}
	@DisplayName("String-adav TEST")
	@Test
	void testString1() {
		String test_t= "adav";
		assertEquals("ada", Solution.longestPalindrome(test_t));
	}
	@DisplayName("String-abbd TEST")
	@Test
	void testString2() {
		String test_t= "abbd";
		assertEquals("bb", Solution.longestPalindrome(test_t));
	}
	@DisplayName("String-abba TEST")
	@Test
	void testString3() {
		String test_t= "abba";
		assertEquals("abba", Solution.longestPalindrome(test_t));
	}
	@DisplayName("String-abbd TEST")
	@Test
	void testString4() {
		String test_t= "adcpasbdsad";
		assertEquals("a", Solution.longestPalindrome(test_t));
	}
}
