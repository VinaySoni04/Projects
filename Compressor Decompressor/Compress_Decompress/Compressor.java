package Compress_Decompress;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static void method(File file) throws IOException{
        String parentDirectory=file.getParent();
        FileInputStream fin=new FileInputStream(file);
        FileOutputStream fout=new FileOutputStream(parentDirectory+"/CompressedFile.gz");
        GZIPOutputStream gzip=new GZIPOutputStream(fout); // Converts file into gzip format

        byte[] buffer=new byte[1024]; // Files are in the form of bytes
        int len;
        while((len=fin.read(buffer))!=-1){  // It reads input until the end of file
            gzip.write(buffer,0,len);
        }
        gzip.close();
        fout.close();
        fin.close();
    }

    public static void main(String[] args) throws IOException {
        File path=new File("C:\\Users\\Vinay\\Desktop");
        method(path);
    }
}
