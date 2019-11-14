class Solution {
    public List<Integer> lexicalOrder(int n) {
         List<Integer> list = new ArrayList();
      if(n<=9){
          for(int i = 1; i <= n; i++){
              list.add(i);
          }
      }else{
          for(int i = 1;i <= 9; i++){
              list.add(i);
              helper(list,i,n);
          }
      }
        return list;
    }
    
    
    public void  helper(List<Integer> list, int num,int n){
        for(int i = num * 10; i<num*10+10;i++){
            if(i>n)break;
            list.add(i);
            helper(list,i,n);
        }
    } 
}