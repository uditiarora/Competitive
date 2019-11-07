class Solution {
   public boolean canMeasureWater(int x, int y, int z) {
        if(x==0 && y==0)
        { 
            if(z==0)
            return true;
            else
                return false;
        }
         int g=gcd(x,y);
        if(z%g==0 && z<=(x+y))
            return true;
        else
            return false;
    }
		int gcd(int a,int b)
		{
			if(b==0)
				return a;
			else
				return gcd(b,a%b);
		}
	
}