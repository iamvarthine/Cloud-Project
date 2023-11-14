import java.util.ArrayList;
import Jama.Matrix;
import java.io.FileWriter;
public class AppClient {
    public static void main(String[] args) throws Exception {
        Receiver r=new Receiver();
        Matrix d=r.receiveKey();
        Encryption decrypt=new Encryption(d);
        StringTransformer st=new StringTransformer();
        
        ArrayList<Matrix> cipherText=st.readEncrypted("Z:/Miniproject/efg.txt");
        ArrayList<Matrix>decryptedText=new ArrayList<>();
        for(Matrix m:cipherText){
            Matrix ct=decrypt.encryptMessage(m);
            decryptedText.add(ct);
        }
        String s=st.matrixToString(decryptedText);
        StringBuilder sb=new StringBuilder();
        for(char c: s.toCharArray()){
            if(c=='▼'){
                
                sb.append(' ');
            }
            else{
                sb.append(c);
            }
        }
        String ops=sb.toString();
        System.out.println(ops);
        FileWriter wf=new FileWriter("C:/Users/sweat/OneDrive/Desktop/MINI PROJECT/miniproject-main/miniProject/src/op.txt");
        wf.write(ops, 0, 0);
        wf.close();
        System.exit(0);
    }
}
