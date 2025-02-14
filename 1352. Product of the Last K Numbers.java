class ProductOfNumbers {

    // The main concept is to empty the prefix array with multipliaction value to empty 
    // Upon encountering a zero value.

    ArrayList<Integer> prod;

    public ProductOfNumbers() {
        prod = new ArrayList();
    }
    
    public void add(int num) {
        if(num == 0){
            prod.clear();
        }
        else if(prod.size() == 0){
            prod.add(num);
        }
        else{
            int prev = prod.get(prod.size() - 1);

            int prodWithPrevValue = prev * num;
            prod.add(prodWithPrevValue);
                       
        }
    }
    
    public int getProduct(int k) {
        if(k > prod.size())return 0;
        else{
            
            // Using prefix array to find multiplication of last 
            if(k == prod.size()){
                return prod.get(prod.size() - 1);
            }
            else{
                int ans = prod.get(prod.size() - 1) / prod.get(prod.size() - k - 1);
                return ans;
            }
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
