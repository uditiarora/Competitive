class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
    HashMap<String,Integer> map1 = new HashMap();
    
    int k = 0;
    for(String item : list1){
            map1.put(item,k++);
    }
    
    List<String> minSumRestuarents = new ArrayList();
    int sum = 0;
    int tempSum = 0;
    for(int i=0; i < list2.length; i++){
          if(map1.containsKey(list2[i])){
               tempSum = i + map1.get(list2[i]);
               if(tempSum == sum || minSumRestuarents.isEmpty()){
                   minSumRestuarents.add(list2[i]);
                   sum = tempSum;

               }
               else if(tempSum < sum)
               {
                   minSumRestuarents = new ArrayList();
                   minSumRestuarents.add(list2[i]);
                    sum = tempSum;
               }
          }       
    }
    String[] array = new String[minSumRestuarents.size()];
    
    
    int f = 0;
    for(String item : minSumRestuarents){
        array[f++] = item;
    }
        
    
    return array;
}
}