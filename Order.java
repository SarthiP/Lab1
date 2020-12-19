import java.util.ArrayList;
import java.util.Random;


public class Order implements OrderInterface, Comparable<Order> {
        private int ORDERNo;
        private int ORDERTime;
        private DAY ORDERDay;
        private Customer customer;
        private ArrayList<Beverage> beverages;
        
        
        public Order(int ot, DAY od, Customer c) {
                ORDERNo = genOrderNum();
                ORDERTime = ot;
                ORDERDay = od;
                customer = c;
                beverages = new ArrayList<>();
        }
        
        
        public int genOrderNum() {
                Random rand = new Random();
                
                int randInt = rand.nextInt(90_000-10_000)+10_000;
                return randInt;
        }
        public String toString() {
                String s = "__________________________________"
                                   +ORDERDay.toString() +", " +ORDERTime
                                   +"\n" +customer.toString() +" Order Num: " +ORDERNo;
                
                for (Beverage b : beverages) {
                        s += "\n" +b.toString();
                }
                s += "\n Order Total: " +calcOrderTotal();
                
                return s;
        }
        public boolean isWeekend() {
                if (ORDERDay == DAY.SATURDAY || ORDERDay == DAY.SUNDAY) {
                        return true;
                }
                return false;
        }
        public Beverage getBeverage(int itemNum) {
                return beverages.get(itemNum);
        }
        public int compareTo(Order o) {
                if (ORDERNo == o.getOrderNo()) {
                        return 0;
                }
                else if (ORDERNo > o.getOrderNo()) {
                        return 1;
                }
                else {
                        return -1;
                }
        }
        public double calcOrderTotal() {
                double orderTotal = 0;
                
                for (Beverage b : beverages) {
                        orderTotal += b.calcPrice();
                }
                
                return orderTotal;
        }
        public int findNumOfBeveType(TYPE type) {
                int count = 0;
                
                for (Beverage b : beverages) {
                        if (b.getType() == type) {
                                count++;
                        }
                }
                
                return count;
        }
        public int getTotalItems() {
                return beverages.size();
        }
        
        //BEVERAGES
        public void addNewBeverage(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
                Coffee c = new Coffee(name, size, extraShot, extraSyrup);
                beverages.add(c);
        }
        public void addNewBeverage(String name, SIZE size, int numOfFruits, boolean proteinPowder) {
                Smoothie s = new Smoothie(name, size, numOfFruits, proteinPowder);
                beverages.add(s);
        }
        public void addNewBeverage(String name, SIZE size) {
                boolean isWeekend = false;
                if (ORDERDay == DAY.SATURDAY || ORDERDay == DAY.SUNDAY) {
                        isWeekend = true;
                }
                Alcohol a = new Alcohol(name, size, isWeekend);
                beverages.add(a);
        }
        
        
        public int getOrderNo() {
                return ORDERNo;
        }
        public int getOrderTime() {
                return ORDERTime;
        }
        public DAY getOrderDay() {
                return ORDERDay;
        }
        public Customer getCustomer() {
                return new Customer(customer);
        }
        public ArrayList<Beverage> getBeverages() {
                return beverages;
        }
        
        
        public void setOrderNum(int on) {
                ORDERNo = on;
        }
        public void setOrderTime(int ot) {
                ORDERTime = ot;
        }
        public void setOrderDay(DAY od) {
                ORDERDay = od;
        }
        public void setCustomer(Customer c) {
                customer = c;
        }
}
