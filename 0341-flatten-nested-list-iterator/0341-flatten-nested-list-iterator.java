/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
Stack<NestedInteger> st;
    public NestedIterator(List<NestedInteger> nestedList) {
        st=new Stack<>();
        for(int i=nestedList.size()-1; i>=0; i--){
            st.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        int num=st.peek().getInteger();
         st.pop();
         return num;
    }

    @Override
    public boolean hasNext() {
        while(!st.isEmpty()){
           NestedInteger obj=st.peek();
           if(obj.isInteger()){
            return true;
           }

           st.pop();
           List<NestedInteger>List=obj.getList();
           for(int i=List.size()-1; i>=0; i--){
             st.push(List.get(i));
           }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */