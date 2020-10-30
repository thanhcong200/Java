package Entity;

public class IntPhone extends Phone implements Viet{
    private  int mqg;
    public IntPhone(){}
    public IntPhone(int mqg, int mv, int sdt){
        super(mv, sdt);
        this.mqg = mqg;
    }

    public int getMqg() {
        return mqg;
    }

    public void setMqg(int mqg) {
        this.mqg = mqg;
    }

    @Override
    public void vietSDT() {
        System.out.println(mqg + "-" + this.getMv() + "-" + this.getSdt());
    }
}
