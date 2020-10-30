import Model.PhoneBook;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PhoneBook phoneBooks = new PhoneBook();
        while(true){
            System.out.println("0. Thoat!");
            System.out.println("1. Nhap sdt noi hat.");
            System.out.println("2. Nhap sdt quoc te.");
            System.out.println("3. Viet danh sach dien thoai.");
            System.out.println("4. Tim kiem sdt khi nhap vao sdt.");
            System.out.println("5. Sap xep danh sach dien thoai co 3 so cuoi nhap vao.");
            System.out.println("6. Dua ra sdt theo tung tinh thanh.");
            System.out.print("Nhap lua chon: ");
            int choose = -1;
            choose = in.nextInt();
            if(choose == 0) break;
            else if(choose == 1) phoneBooks.nhapNH();
            else if(choose == 2) phoneBooks.nhapQG();
            else if(choose == 3) phoneBooks.vietDS();
            else if(choose == 4) phoneBooks.timKiemSDT();
            else if(choose == 5) phoneBooks.sapXep();
            else if(choose == 6) phoneBooks.tongSDT();
        }
    }
}

