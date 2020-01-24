package com.company;
import java.io.*;

public class Main {
/*
By using CharacterStream, please discover the secret message from the given "secret.txt" file considering the following instructions:
- Take into consideration only capital letters from the input text
- Consider capital X as space between words
- The secret message need to be readed from a file
 */
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        String finalString="";
        try{
            inputStream = new FileReader("secret.txt");
            int i;
            while (( i = inputStream.read()) != -1){
                ByteArrayOutputStream newByteArrayStr = new ByteArrayOutputStream();
                newByteArrayStr.write(i);
                String newStringStr = newByteArrayStr.toString();

                for (int j=0; j<newStringStr.length();j++){
                    if (Character.isUpperCase(newStringStr.charAt(j))){
                        finalString = finalString + newStringStr.charAt(j);
                    }
                }
            }
        } finally{
            if (inputStream != null){
                inputStream.close();
            }
        }
        finalString = finalString.replace("X"," ");
        System.out.println(finalString);
    }
}
