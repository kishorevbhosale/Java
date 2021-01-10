package collection;

interface Permission{

}
class DataPrint {
    public void show(){
        System.out.println("I have permission to print the data");
    }
}
class Admin extends DataPrint implements Permission{
}
class Register extends DataPrint{
}

public class MarkerInterfaceDemo {
    public static void main(String[] args) {
       Register r = new Register();
       Admin a = new Admin();
       if (r instanceof Permission){
           r.show();
       }
        if (a instanceof Permission){
            a.show();
        }
    }
}
