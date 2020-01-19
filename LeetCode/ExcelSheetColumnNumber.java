class Solution {
   public int titleToNumber(String s) {
         if (s== null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        int index = 1;
        for (char c = 'A'; c <= 'Z'; c++){
            charMap.put(c,index++);
        }
        int sum = 0;
        int power = 0;
        for (int i = s.length()-1; i >=0; i--){
            sum += charMap.get(s.charAt(i)) * Math.pow(26,power);
            power++;
        }
        return sum;

    }
}