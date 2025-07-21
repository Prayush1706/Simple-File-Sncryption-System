import java.io.*;
public class fileencrypter {
    //ArrayList<fileencrypter> list=new ArrayList<fileencrypter>();
    public String filename_base="";
    public String filename_en="";
    public String filename_de="";
    public int[] key;
    char encrypt(char c,int shiftKey){
        char replaceVal='\0';
        replaceVal=(char) ((char)((int)c+shiftKey)%255);
        return replaceVal;
    }
    void encryptFile(String filename_base,String filename_en) throws IOException{
        BufferedReader br=new BufferedReader(new FileReader(filename_base));
        BufferedWriter bw=new BufferedWriter(new FileWriter(filename_en));
        String s=br.readLine();
        key=new int[s.length()];
        while(s!=null){
            char[] ch=s.toCharArray();
            for(int i=0;i<ch.length;i++){
                key[i]=(int)(Math.random()*256);
                //System.out.println("key for "+ch[i]+" is "+key[i]);
                ch[i]=encrypt(ch[i], key[i]);
            }
            s=new String(ch);
            bw.write(s);
            bw.newLine();
            s=br.readLine();
        }
        br.close();
        bw.close();
    }
    char decrypt(char c,int shiftKey){
        char replaceVal;
        if(((int)c-shiftKey)<0){
            replaceVal=(char) ((char)(((int)c-shiftKey)%255)+255);
        }
        else{
            replaceVal=(char) ((char)((int)c-shiftKey)%255);
        }
        return replaceVal;
    }
    void decryptFile(String filename_en,String filename_de) throws IOException{
        BufferedReader br=new BufferedReader(new FileReader(filename_en));
        BufferedWriter bw=new BufferedWriter(new FileWriter(filename_de));
        String s=br.readLine();
        while(s!=null){
            char[] ch=s.toCharArray();
            for(int i=0;i<ch.length;i++){
                //System.out.println("key for "+ch[i]+" is "+key[i]);
                ch[i]=decrypt(ch[i], key[i]);
            }
            s=new String(ch);
            bw.write(s);
            bw.newLine();
            s=br.readLine();
        }
        br.close();
        bw.close();
    }
}
