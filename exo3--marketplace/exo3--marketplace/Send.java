public class Send extends Marketplace {
    private float amountToSend;

    public Send(float amountToSend, String name, String id, float currentBalance) {
        super(name, id, currentBalance);
        this.amountToSend = amountToSend;
    }

    public float getAmountToSend() {
        return amountToSend;
    }

    public void setAmountToSend(float amountToSend) {
        this.amountToSend = amountToSend;
    }

    @Override
    public void transaction(Marketplace target) {
        if (amountToSend <= getCurrentBalance()) {
            setCurrentBalance(getCurrentBalance() - amountToSend);
            System.out.println("Sent " + amountToSend + " to " + target.getId());
        } else {
            System.out.println("Insufficient balance to send " + amountToSend);
        }
    }
}