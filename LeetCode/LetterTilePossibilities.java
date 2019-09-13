class Solution {
    public int numTilePossibilities(String tiles) {
        int[] characterCount = new int[26];
        for(int i = 0; i < tiles.length(); i++){
            characterCount[tiles.charAt(i) - 'A']++;
        }
        return countPossibleSequences(characterCount);
    }
    
    private int countPossibleSequences(int[] count){
        int result = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                count[i]--;
                result += 1 + countPossibleSequences(count);
                count[i]++;
            }
        }
        return result;
    }
}