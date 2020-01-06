class Solution {
    double r;
    double x0;
    double y0;
    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x0 = x_center;
        y0 = y_center;
    }
    
    public double[] randPoint() {
        double x = 0,y=0;
        do{
            x = -r + 2*r*Math.random();
            y = -r + 2*r*Math.random();
        }while(x*x + y*y > r*r);
        return new double[]{x0+x,y0+y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */