class Node{
    Node left, right;
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        int ans =0;
        insert(root,nums[0]);
        for(int i=1;i<nums.length;i++){
            //insert(root,nums[i]);
            ans = Math.max(ans, returnMax(root,nums[i]));
            insert(root,nums[i]);
        }
        return ans;
    }
    
    public void insert(Node root, int x){
        int a = 0;
        Node temp = root;
        for(int i=31;i>=0;i--){
            a = (x>>i)&1;
            if(a==0){
                if(temp.left==null){
                    temp.left = new Node();
                }
                temp = temp.left;
            }
            else{
                if(temp.right==null){
                    temp.right = new Node();
                }
                temp = temp.right;
            }
        }
        
    }
    
    public int returnMax(Node root, int pre){
       
        int res=0;
        Node temp = root;
        for(int i=31;i>=0;i--){
          int b = (pre>>i)&1;
          if(b==0){
            if(temp.right==null){
              temp = temp.left;
            }
            else{
              temp = temp.right;
              res += Math.pow(2,i);
            }
          }
          else{
            if(temp.left==null){
              temp = temp.right;
            }
            else{
              temp = temp.left;
              res += Math.pow(2,i);
            }
          }
        }
        return res;
    }
    
    
}
