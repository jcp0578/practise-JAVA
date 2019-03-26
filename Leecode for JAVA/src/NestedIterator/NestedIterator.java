package NestedIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 扁平化嵌套列表迭代器
 * AC
 * 
 */

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
public class NestedIterator implements Iterator<Integer> {
	private List<Integer> data;
	private int index=0;

	public NestedIterator(List<NestedInteger> nestedList) {
		this.data = new ArrayList<>();
		nestedListtoInteger(nestedList);
	}

	private void nestedListtoInteger(List<NestedInteger> list) {
		for (NestedInteger t : list) {
			if (t.isInteger())
				this.data.add(t.getInteger());
			else {
				nestedListtoInteger(t.getList());
			}
		}
	}

	@Override
	public Integer next() {
		return this.data.get(this.index++);
	}

	@Override
	public boolean hasNext() {
		return (this.index < this.data.size());
	}
}

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */