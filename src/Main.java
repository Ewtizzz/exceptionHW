public class Main {
    public static void main(String[] args) {
        boolean success = Data.validate("test","test","test");
        if(success){
            System.out.println("данные правильные");
        }else{
            System.out.println("данные неправильные");
        }
    }
}