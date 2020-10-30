package Model;

import Entity.IntPhone;
import Entity.Phone;

import java.util.*;

public class PhoneBook implements ChucNang{
    private List<Phone> phones;
    private Scanner in;

    public PhoneBook(){
        in = new Scanner(System.in);
        phones = new ArrayList<>();
        phones.add(new Phone(24, 12345678));
        phones.add(new Phone(14, 12823490));
        phones.add(new IntPhone(84, 12, 12345678));
        phones.add(new IntPhone(84, 22, 12005678));

    }

    private int lenSo(int n){
        int so=0;
        while(n>0){
            n/=10;
            so +=1;
        }
        return so;
    }
    private boolean kiemTraSDT(int mqg, int mv, int sdt){
        if(mqg == 0){
            for (Phone a: phones) {
                if(a.getMv() == mv && a.getSdt() == sdt){
                    return false;
                }
            }
        }
        else {
            for (Phone a: phones) {
                if(a instanceof  IntPhone){
                    if(((IntPhone)a).getMqg() == mqg &&  a.getMv() == mv && a.getSdt() == sdt){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void nhapNH() {
        int mv=0;
        int sdt =0;
        while(true){
            System.out.printf("Nhap ma vung gom 2 hoac 3 so: ");
            mv = Integer.parseInt(in.nextLine());
            int so = mv;
            int len = lenSo(so);
            if(len >= 2 && len <= 3){
                break;
            }
        }

        while(true){
            System.out.printf("Nhap so dien thoai gom 8 so: ");
            sdt = Integer.parseInt(in.nextLine());
            int so = sdt;
            int len = lenSo(so);
            if(len ==8){
                break;
            }
        }

        if(!kiemTraSDT(0, mv, sdt)) return;
        phones.add(new Phone(mv, sdt));
    }

    @Override
    public void nhapQG() {
        int mqg = 0;
        int mv=0;
        int sdt =0;
        while(true){
            System.out.printf("Nhap ma quoc gia tu 1 den 4 so: ");
            mqg = Integer.parseInt(in.nextLine());
            int so = mqg;
            int len = lenSo(so);
            if(len >= 1 && len <= 4){
                break;
            }
        }
        while(true){
            System.out.printf("Nhap ma vung gom 2 hoac 3 so: ");
            mv = Integer.parseInt(in.nextLine());
            int so = mv;
            int len = lenSo(so);
            if(len >= 2 && len <= 3){
                break;
            }
        }

        while(true){
            System.out.printf("Nhap so dien thoai gom 8 so: ");
            sdt = Integer.parseInt(in.nextLine());
            int so = sdt;
            int len = lenSo(so);
            if(len == 8){
                break;
            }
        }

        if(!kiemTraSDT(mqg, mv, sdt)) return;

        phones.add(new IntPhone(mqg, mv, sdt));
    }

    @Override
    public void vietDS() {
        System.out.println("Danh sach so dien thoai:");
        for (Phone phone: phones) {
            if(phone instanceof IntPhone){
                IntPhone intPhone = (IntPhone)phone;
                intPhone.vietSDT();
            }
            else {
                phone.vietSDT();
            }
        }

        System.out.println(phones.size());
    }

    @Override
    public void timKiemSDT() {
        System.out.print("Nhap so dien thoai can tim: ");
        int sdt = Integer.parseInt(in.nextLine());
        System.out.println("Danh sach cac so dien thoai can tim la:");
        for (Phone phone: phones) {
            if(phone.getSdt() == sdt){
                if(phone instanceof IntPhone){
                    IntPhone intPhone = (IntPhone)phone;
                    intPhone.vietSDT();
                }
                else {
                    phone.vietSDT();
                }
            }
        }
    }

    @Override
    public void sapXep() {
        System.out.print("Nhap 3 so cuoi can tim: ");
        String so = in.nextLine();
        List<Phone> dsSDT = new ArrayList<>();
        for (Phone phone: phones) {
            int sdt = phone.getSdt();
            int a = sdt%10; sdt/=10;
            int b= sdt%10; sdt/=10;
            int c = sdt%10;
            if(a == so.charAt(2)-'0' && b == so.charAt(1)-'0' && c == so.charAt(0) - '0'){
                dsSDT.add(phone);
            }
        }

        Collections.sort(dsSDT, new ShortBySDT());
        if(dsSDT.size() <=0 ) {
            System.out.println("Khong co danh sach dien thoai can tim!");
            return;

        }
        System.out.println("Danh sach sdt co 3 so cuoi la " + so + ": ");
        for (Phone phone: dsSDT) {
            if(phone instanceof IntPhone){
                IntPhone intPhone = (IntPhone)phone;
                intPhone.vietSDT();
            }
            else {
                phone.vietSDT();
            }
        }
    }

    @Override
    public void tongSDT() {
        List dsMV = new ArrayList<>();
        for (Phone phone: phones) {
            if(dsMV.indexOf(phone.getMv()) == -1){
                dsMV.add(phone.getMv());
                int so=0;
                for (Phone a: phones) {
                    if(a.getMv() == phone.getMv()){
                        so+=1;
                    }
                }
                System.out.println("    Tong so dien thoai co ma vung " + phone.getMv() + ": " + so);
            }
        }
    }

}


class ShortBySDT implements  Comparator<Phone> {
    @Override
    public int compare(Phone o1, Phone o2) {
        if(o1.getMv() < o2.getMv())
            return 1;
        if(o1.getMv() == o2.getMv() && o1.getSdt() < o2.getMv())
            return 1;
        return -1;
    }

}


