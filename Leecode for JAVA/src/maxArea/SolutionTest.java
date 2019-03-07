package maxArea;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class SolutionTest {
	private static Solution2 Solution_t = new Solution2();
	
	@DisplayName("testMaxArea TEST")
	@Test
	void testMaxArea() {
		int[] test_t= {1,8,6,2,5,4,8,3,7};
		assertEquals(49, Solution_t.maxArea(test_t));
	}

}
