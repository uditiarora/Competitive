class Solution {
     public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<>();
        for (String time : timePoints) {
            int hr = Integer.valueOf(time.substring(0, 2));
            int min = Integer.valueOf(time.substring(3));
            times.add(60 * hr + min);
        }
        Collections.sort(times);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < times.size(); i++) {
            int diff = times.get(i) - times.get(i - 1);
            min = Math.min(min, diff);
        }
        min = Math.min(min, 60 * 24 + times.get(0) - times.get(times.size() - 1));
        return min;
    }
}