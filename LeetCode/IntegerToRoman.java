class Solution {
    public String intToRoman(int num) {
        
        StringBuilder res = new StringBuilder();
        
        while(num >= 1000) {
            num = num - 1000;
            res.append("M");
        }
        if(num >= 900) {
            num = num - 900;
            res.append("CM");
        }
        while(num >= 500) {
            num = num - 500;
            res.append("D");
        }
        if(num >= 400) {
            num = num - 400;
            res.append("CD");
        }
        while(num >= 100) {
            num = num - 100;
            res.append("C");
        }
        if(num >= 90) {
            num = num - 90;
            res.append("XC");
        }
        while(num >= 50) {
            num = num - 50;
            res.append("L");
        }
        if(num >= 40) {
            num = num - 40;
            res.append("XL");
        }
        while(num >= 10) {
            num = num - 10;
            res.append("X");
        }
        if(num >= 9) {
            num = num - 9;
            res.append("IX");
        }
        while(num >= 5) {
            num = num - 5;
            res.append("V");
        }
        if(num >= 4) {
            num = num - 4;
            res.append("IV");
        }
        while(num >= 1) {
            num = num - 1;
            res.append("I");
        }
        
        return res.toString();
    }
}