import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String choice="";
        ArrayList<fileencrypter> list=new ArrayList<fileencrypter>();
        do { 
            System.out.println("Do you want to encrypt or decrypt a file (e/d/exit): ");
            choice=sc.nextLine();
            if(choice.equalsIgnoreCase("e")) {
                fileencrypter fe=new fileencrypter();
                System.out.println("Enter name of file to be encrypted: ");
                fe.filename_base=sc.nextLine();
                System.out.println("Enter name of file to be written: ");
                fe.filename_en=sc.nextLine();
                list.add(fe);
                fe.encryptFile(fe.filename_base,fe.filename_en);
                System.out.println("File encrypted successfully");
            } else if(choice.equalsIgnoreCase("d")) {
                if(list.size()==0){
                    System.out.println("No files to decrypt");
                } else{
                    fileencrypter fe=new fileencrypter();
                    System.out.println("Enter name of file to be decrypted: ");
                    fe.filename_en=sc.nextLine();
                    boolean exists=false;
                    for(fileencrypter i: list){
                        if(i.filename_en.equals(fe.filename_en)){
                            exists=true;
                            fe=i;
                            break;
                        }
                    }   
                    if(exists){ 
                        System.out.println("Enter name of file to be written: ");
                        fe.filename_de=sc.nextLine();                        
                        fe.decryptFile(fe.filename_en,fe.filename_de);
                        System.out.println("File decrypted successfully");
                    }else{
                        System.out.println("File does not exist");
                    }
                }
            } else if(choice.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program...");
            } else{
                System.out.println("Invalid choice");
            }
        } while(!choice.equals("exit")); 
    }
}
