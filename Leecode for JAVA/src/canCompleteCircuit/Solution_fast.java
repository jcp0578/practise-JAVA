package canCompleteCircuit;


/*
 * so good
 * 
 */
public class Solution_fast {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		/*
		 * 车从i站能开到i+1。且所有站里的油总量要>=车子的总耗油量。
		 * 假设从编号为0站开始，一直到k站都正常，在开往k+1站时车子没油了。这时，应该将起点设置为k+1站。
		 * 因为k->k+1站耗油太大，0->k站剩余油量都是不为负的，每减少一站，就少了一些剩余油量。所以如果从k前面的站点作为起始站，剩余油量不可能冲过k+1站。
		 * 说明从k到k-1消耗太大，尽量把它排在后面，因为越往后能攒的油量越多
		 */
		int rest = 0, run = 0, start = 0;
		for (int i = 0; i < gas.length; i++) {
			run += (gas[i] - cost[i]);
			if (run < 0) { // 从i跑不到i+1了
				start = i + 1; // 就从i+1开始跑
				run = 0; // 重新来
			}
			rest += (gas[i] - cost[i]); // 雷打不动，就是算能不能剩下。不剩下根本没得玩
		}
		return rest < 0 ? -1 : start; // 判断剩
	}
}
