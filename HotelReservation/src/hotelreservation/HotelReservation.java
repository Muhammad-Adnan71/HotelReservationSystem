package hotelreservation;

import java.io.*;
import javax.swing.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class Rooms {

    String name, category;
    int room_no, price;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    public void set_name(String n) {
        this.name = n;
    }

    public String get_name() {
        return name;
    }

    public void setcategory(String c) {
        this.category = c;
    }

    public String getcategory() {
        return category;
    }

    public void setroom_no(int rno) {
        this.room_no = rno;
    }

    public int getroom_no() {
        return room_no;
    }

    public void set_price(int p) {
        this.price = p;
    }

    public int get_price_no() {
        return price;
    }

    void display() {
        JOptionPane.showMessageDialog(null, "Name : " + name + "\n" + "Cateogry : " + category + "\n" + "Room no :" + room_no + "\n" + "Price : " + price + "\n" + "Booked on : " + date);
    }

    void dis() {
        JOptionPane.showMessageDialog(null, "Cateogry : " + category + "\n" + "Room no :" + room_no + "\n" + "Price : " + price);
    }
}

class Single_Room extends Rooms {

    Single_Room() {
        price = 1000;
        category = "Single Bed";
        room_no = 01;

    }

}

class Double_Room extends Rooms {

    Double_Room() {
        price = 2000;
        category = "Double bed";
        room_no = 05;
    }

}

class penthouse_suiteRoom extends Rooms {

    penthouse_suiteRoom() {
        price = 4000;
        category = "Penthouse Suite BedRoom";
        room_no = 10;
    }

}

class Large_kingsizeRoom extends Rooms {

    Large_kingsizeRoom() {
        price = 6000;
        category = "Large Kingsize BedRoom";
        room_no = 15;
    }

}

class payment_method {

    String customer_name, payment_method;

    public String getcustomer_name() {
        return customer_name;
    }

    public void setcustomer_name(String name) {
        this.customer_name = name;
    }

    void display_payment() {
        JOptionPane.showMessageDialog(null, "Customer name :" + customer_name + "\n" + "Payment method :" + payment_method + "\n");

    }
}

class online_payment extends payment_method {

    online_payment() {
        payment_method = "Online Payment";
    }
    int debit_cardNo, debit_password;

    public int dcard_no() {
        return debit_cardNo;
    }

    public void setdcars_no(int dno) {
        this.debit_cardNo = dno;
    }

    public void setpassword(int pno) {
        this.debit_password = pno;
    }

}

class hardcash_payment extends payment_method {

    hardcash_payment() {
        payment_method = "Cash Payment";
    }

    String bank_name;
    int bank_accountNo;

    public String getbank_name() {
        return bank_name;
    }

    public void setbank_name(String bname) {
        this.bank_name = bname;
    }

    public int getbank_accno() {
        return bank_accountNo;
    }

    public void setbank_name(int ano) {
        this.bank_accountNo = ano;
    }
}

class hotel {

    ArrayList rooms;

    hotel() {
        rooms = new ArrayList();

    }
    int a = 10;
    int b = 10;
    int c = 10;
    int d = 10;

    void Booking_room() {
        String paymentm;

        String name = JOptionPane.showInputDialog("Enter Your name");

        String cat = JOptionPane.showInputDialog("Select Type of Room" + "\n" + "1-Single Bedroom" + "\n" + "2-Double Bedroom" + "\n" + "3-PentHouse suite" + "\n" + "4-Large King size");

        switch (cat) {

            case "1":
                Single_Room sr = new Single_Room();
                sr.set_name(name);
                rooms.add(sr);
                a = a - 1;
              //  sr.set_price(1000);
                // sr.setroom_no(01);
                // sr.setcategory("Single BedRoom");

                //  sr.display();
                break;

            case "2":
                Double_Room dr = new Double_Room();
                dr.set_name(name);

                b = b - 1;
                //  dr.set_price(2000);
                //  dr.setroom_no(05);
                // dr.setcategory("Double BedRoom");
                //   dr.display();
                rooms.add(dr);
                break;

            case "3":
                penthouse_suiteRoom pr = new penthouse_suiteRoom();
                pr.set_name(name);
                rooms.add(pr);
                c = c - 1;
                // pr.set_price(5000);
                //  pr.setroom_no(01);
                //  pr.setcategory("Penthouse suitRoom");
                // pr.display();
                break;
            case "4":
                Large_kingsizeRoom lr = new Large_kingsizeRoom();
                lr.set_name(name);
                rooms.add(lr);
                d = d - 1;
                //   lr.set_price(10000);
                //  lr.setroom_no(01);
                //  lr.setcategory("Large kingsize Room");
                //   lr.display();
                break;

        }

        paymentm = JOptionPane.showInputDialog("Enter payment method : " + "\n" + "1- Online payment " + "\n" + "2- Cash payment");

        switch (paymentm) {
            case "1":
                online_payment op = new online_payment();
                op.setcustomer_name(name);
                String dc = JOptionPane.showInputDialog("Enter debit card no : ");
                int d = Integer.parseInt(dc);
                if (d < 0) {
                    throw new NumberFormatException("not valid");
                }
                String dp = JOptionPane.showInputDialog("Enter your card password : ");
                int dd = Integer.parseInt(dp);
                op.setdcars_no(d);
                op.setpassword(dd);
                JOptionPane.showMessageDialog(null, "Room Booked Sucessfully..!" + "\nCustomer Name : " + name + "\n" + "Room Type :" + "\nDebit card no :");
                break;

            case "2":
                hardcash_payment hp = new hardcash_payment();

                hp.setcustomer_name(name);
                String bankn = JOptionPane.showInputDialog("Enter Bank name : ");
                String aacntn = JOptionPane.showInputDialog("Enter account number : ");
                int acn = Integer.parseInt(aacntn);
                if (acn < 0) {
                    throw new NumberFormatException("not valid");
                }
                hp.setbank_name(bankn);
                hp.setbank_name(acn);

                JOptionPane.showMessageDialog(null, "Room Booked Sucessfully..!" + "\n" + "Customer Name : " + name + "\n" + "\n" + "Bank name : " + bankn + "\n" + "Account number : " + acn);
                break;
        }

    }

    void search_room(String t) {
        for (int i = 0; i < rooms.size(); i++) {
            Rooms v = (Rooms) rooms.get(i);
            if (t.equals(v.name)) {
                v.display();

            }
        }
    }

    void room_details() {
        String g = JOptionPane.showInputDialog("Select Room ..!" + "\n" + "1-Single Bed" + "\n" + "2-Double Bed" + "\n" + "3-Penthouse Suite BedRoom" + "\n" + "4-Large Kingsize BedRoom");
        switch (g) {
            case "1":
                Single_Room sr = new Single_Room();
                sr.dis();
                break;
            case "2":
                Double_Room dr = new Double_Room();
                dr.dis();
                break;
            case "3":
                penthouse_suiteRoom pr = new penthouse_suiteRoom();
                pr.dis();
                break;
            case "4":
                Large_kingsizeRoom lr = new Large_kingsizeRoom();
                lr.dis();
                break;
        }

    }

    void check_availibilty() {
        JOptionPane.showMessageDialog(null, "Single Room Available : " + a + "\n" + "Double BedRoom Available : " + b + "\n" + "Penthouse suiteRoom Available : " + c + "\n" + "King Size Large Room Available : " + d);
    }

    void list_alltypeRoom() {
        JOptionPane.showMessageDialog(null, "1-Single Bed" + "\n" + "2-Double Bed" + "\n" + "3-Penthouse Suite BedRoom" + "\n" + "4-Large Kingsize BedRoom");
    }

    public void save_details() {
        try {
            Rooms p;
            String line;
            FileWriter fw = new FileWriter("C:\\Users\\Qazi wahaj\\Desktop\\roominfo.txt");

//FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < rooms.size(); i++) {
                p = (Rooms) rooms.get(i);
                line = p.name + "," + p.category + "," + p.room_no + "," + p.price + "," + p.date;

                pw.println(line);
            }
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ioEx) {
            System.out.println(ioEx);
        }
    }

    void remove_user(String n) {

        for (int i = 0; i < rooms.size(); i++) {
            Rooms p = (Rooms) rooms.get(i);

            if (n.equals(p.name)) {
                rooms.remove(i);
                JOptionPane.showMessageDialog(null, "User Details deleted..!");
            }

        }
    }

    void load_details() {
        String token[] = null;
        String name, categry, rm, pc;

        int roomno, pric;
        try {
            FileReader fr = new FileReader("C:\\Users\\Qazi wahaj\\Desktop\\roominfo.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                token = line.split(",");
                name = token[0];
                categry = token[1];

                rm = token[2];
                roomno = Integer.parseInt(rm);
                pc = token[3];
                pric = Integer.parseInt(pc);

                Rooms p = new Rooms();
                p.set_name(name);
                p.setcategory(categry);
                p.setroom_no(roomno);
                p.set_price(pric);

                rooms.add(p);

                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.print(e);
        }

    }

}

public class HotelReservation {

    public static void main(String[] args) {
        // TODO code application logic here
        hotel h = new hotel();

        h.load_details();
        while (true) {

            String c = JOptionPane.showInputDialog(null, "1-Book Room" + "\n2-Search Room By Customer name" + "\n3-Search Room Details" + "\n4-List Of all types of Rooms" + "\n5- Check Availabity" + "\n6-Remove user" + "\n7-Exit ");

            switch (c) {

                case "1":
                    try {
                        h.Booking_room();
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "Pls enter valid one..");
                    }

                    break;
                case "2":
                    String d = JOptionPane.showInputDialog("Enter Name to search");
                    try {
                        h.search_room(d);
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "Pls enter valid one..");
                    }
                    break;

                case "3":
                    try {
                        h.room_details();
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "Pls enter valid one..");
                    }
                    break;
                case "4":
                    h.list_alltypeRoom();
                    break;
                case "5":
                    h.check_availibilty();
                    break;
                case "6":
                    String n = JOptionPane.showInputDialog("Enter username to remove");
                    try {
                        h.remove_user(n);
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "The username you enter isn't in the list..");
                    }
                    break;
                case "7":
                    h.save_details();
                    System.exit(0);

            }
        }
    }

}
