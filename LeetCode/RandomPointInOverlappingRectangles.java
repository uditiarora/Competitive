class Solution {

   int[] bst;
    int[][] rects;
    int sum = 0;
    Random rand = new Random();
    
    public Solution(int[][] rects) {
        bst = new int[rects.length];
        this.rects = rects;
        
        for(int i = 0; i < rects.length; i++){
            bst[i] = sum;
            int x1 = rects[i][0], y1 = rects[i][1], x2 = rects[i][2], y2 = rects[i][3];
            sum += (x2 - x1 + 1) * (y2 - y1 + 1);                
        }
    }
    
    public int[] pick() {
        int r = rand.nextInt(sum);
        int index = Arrays.binarySearch(bst, r);
        
        if(index < 0){
            index = -index - 1;
            if(index > 0)
                index--;
        }
        
        int x1 = rects[index][0], y1 = rects[index][1], x2 = rects[index][2], y2 = rects[index][3];
        int x = rand.nextInt(x2 - x1 + 1) + x1, y = rand.nextInt(y2 - y1 + 1) + y1;
        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */