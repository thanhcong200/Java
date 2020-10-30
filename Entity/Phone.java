package Entity;

import java.util.Comparator;

public class Phone implements Viet{
    private int mv;
    private int sdt;

    public Phone(){}

    public Phone(int mv, int sdt) {
        this.mv = mv;
        this.sdt = sdt;
    }

    public int getMv() {
        return mv;
    }

    public void setMv(int mv) {
        this.mv = mv;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    @Override
    public void vietSDT() {
        System.out.println("0" + mv + "-" + sdt);
    }
}
