
class Customer {
    private final int index;
    private final double arrTime;


    public Customer(int x, double y) {
        this.index = x;
        this.arrTime = y;

        //System.out.println("customer " + index);
    }

    boolean canBeServed(double time) {
        return arrTime >= time;
    }
    
    double serveTill(double serviceTime) {
        return arrTime + serviceTime;
    
    }

    @Override
    public String toString() {
        return "customer " + index;
    }
   
}


