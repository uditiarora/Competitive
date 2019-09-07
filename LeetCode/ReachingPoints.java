class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return util(sx,sy,tx,ty);
    }
    public boolean util(int sx,int sy, int tx, int ty){
        if(sx == tx && sy == ty){
            return true;
        }
        if(sx>tx || sy>ty){
            return false;
        }
        if(tx>ty){
            int temp = (tx-sx)/ty;
            int move = 0;
            if(temp!=0){
                move = tx - temp * ty;
            }
            else{
                move = tx-ty;
            }
            return util(sx,sy,move,ty);
        }
        int temp = (ty-sy)/tx;
        int move = 0;
        if(temp!=0){
            move = ty - temp*tx;
            
        }
        else{
            move = ty - tx;
        }
        return util(sx,sy,tx,move);
    }
}