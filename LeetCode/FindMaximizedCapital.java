class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital)    {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new ArrayComparator());
        for(int i = 0; i < Profits.length; i++)        {
            pq.offer(new int[] {Profits[i], Capital[i]});
        }
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < k; i++){
            while(!pq.isEmpty()){
                int[] temp = pq.poll();
                if(temp[1] <= W){
                    W += temp[0];
                    break;
                }
                stack.push(temp);
            }
            while(!stack.isEmpty()){
                pq.offer(stack.pop());
            }
        }
        return W;
    }
    
    private class ArrayComparator implements Comparator<int[]> {
        public int compare(int[] array1, int[] array2)
        {
            return array2[0] - array1[0];
        }
    }
}