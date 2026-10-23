public class Receive extends Marketplace {
    private float amountToReceive;

    public Receive(float amountToReceive, String name, String id, float currentBalance) {
        super(name, id, currentBalance);
        this.amountToReceive = amountToReceive;
    }

    public float getAmountToReceive() {
        return amountToReceive;
    }

    public void setAmountToReceive(float amountToReceive) {
        this.amountToReceive = amountToReceive;
    }

    @Override
    public void transaction(Marketplace target) {
        setCurrentBalance(getCurrentBalance() + amountToReceive);
        System.out.println("Received " + amountToReceive + " from " + target.getId());
    }
}
