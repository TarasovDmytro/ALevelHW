package ua.tarasov.hw6;

public class Task1 {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();
        phone1.number = 670001112;
        phone1.model = "Samsung A31";
        phone1.weight = 185.0;
        phone2.number = 671112223;
        phone2.model = "Nokia One";
        phone2.weight = 131.0;
        phone3.number = 662223334;
        phone3.model = "Iphone 12 pro";
        phone3.weight = 189.0;
        phone1.printParameterValues();
        phone2.printParameterValues();
        phone3.printParameterValues();
        phone1.receiveCall(phone1.model);
        System.out.println("Phone number - " + phone1.getNumber());
        phone2.receiveCall(phone2.model);
        System.out.println("Phone number - " + phone2.getNumber());
        phone3.receiveCall(phone3.model);
        System.out.println("Phone number - " + phone3.getNumber());
    }
}
