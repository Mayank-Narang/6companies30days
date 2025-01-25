class DataStream {

    int con = 0;
    int val,k;

    public DataStream(int value, int k) {
        
        this.val = value;
        this.k = k;

    }
    
    public boolean consec(int num) {
        
        if (num != val){
            con = 0;
        }
        else con++;

        return con >= k;

    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
