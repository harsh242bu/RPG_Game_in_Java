// Represents gold held by the heroes, which is used to buy items from the market
public class Gold implements Cloneable{
    private int amount;

    public Gold(int money) {
        this.amount = money;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public Gold clone() {
        Gold gold = null;
        try{
            gold = (Gold) super.clone();
        }
        catch(Exception e){
            gold = new Gold(getAmount());
        }

        return gold;
    }

    @Override
    public String toString() {
        String str = "" + amount;
        return str;
    }

    public void modify(int value){
        this.amount += value;
    }
}
