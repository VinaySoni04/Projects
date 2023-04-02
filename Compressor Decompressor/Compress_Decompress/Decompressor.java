package Compress_Decompress;

import java.io.*;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressor {
    public static void method(File file) throws IOException{
        String parentDirectory=file.getParent();
        FileInputStream fin=new FileInputStream(file);
        GZIPInputStream gzip=new GZIPInputStream(fin);
        FileOutputStream fout=new FileOutputStream(parentDirectory+"/DecompressedFile");

        byte[] buffer=new byte[1024];
        int len;
        while((len=gzip.read(buffer))!=-1){
            fout.write(buffer,0,len);
        }
        gzip.close();
        fout.close();
        fin.close();
    }

    public static void main(String[] args){
        File path=new File("");
    }
}
