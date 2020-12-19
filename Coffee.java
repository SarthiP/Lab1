public class Coffee extends Beverage{
        private boolean EXTRAShot;
        private boolean EXTRASyrup;
        private final double shot_COST = .5;
        private final double syrup_COST = .5;
        
      
        public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
                super(n, TYPE.COFFEE, s);
                EXTRAShot = shot;
                EXTRASyrup = syrup;
        }
        
        /** Utility */
        public String toString() {
                String s = getBevName() +", " +getSize();
                
                if (EXTRAShot) {
                        s += " Extra shot";
                }
                if (EXTRASyrup) {
                        s += " Extra syrup";
                }
                
                s += ", $" +calcPrice();
                
                return s;
        }
        public double calcPrice() {
                double price = super.getBasePrice();
                
                if (super.getSize() == SIZE.MEDIUM) {
                        price += super.getSizePrice();
                }
                else if (super.getSize() == SIZE.LARGE) {
                        price += 2 * super.getSizePrice();
                }
                
                if (EXTRAShot) {
                        price += shot_COST;
                }
                if (EXTRASyrup) {
                        price += syrup_COST;
                }
                
                return price;
        }
        public boolean equals(Coffee c) {
                if (super.equals(c) && EXTRAShot==c.getExtraShot() && EXTRASyrup==c.getExtraSyrup()) {
                        return true;
                }
                else {
                        return false;
                }
        }
        
        
        public boolean getExtraShot() {
                return EXTRAShot;
        }
        public boolean getExtraSyrup() {
                return EXTRASyrup;
        }
        public double getShotCost() {
                return shot_COST;
        }
        public double getSyrupCost() {
                return syrup_COST;
        }
        
        
        public void setExtraShot(boolean shot) {
                EXTRAShot = shot;
        }
        public void setExtraSyrup(boolean syrup) {
                EXTRASyrup = syrup;
        }
}