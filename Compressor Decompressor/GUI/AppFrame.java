package GUI;

import Compress_Decompress.Compressor;
import Compress_Decompress.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

// ActionListener provides some functionalities
public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        // Creating the buttons
        compressButton=new JButton("Select file to compress");
        compressButton.setBounds(200,100,200,30);
        compressButton.addActionListener(this); // Adding action listener for compressor

        decompressButton=new JButton("Select file to decompress");
        decompressButton.setBounds(500,100,200,30);
        decompressButton.addActionListener(this); // Adding action listener for decompressor


        // Adding the buttons
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000,300); // Setting the size of Jframe window
        this.getContentPane().setBackground(Color.black); // This sets background colors
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Compressor working
        if(e.getSource()==compressButton){
            JFileChooser fileChooser=new JFileChooser(); // By this, a window is popped out for choosing a file
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compressor.method(file);
                }
                catch (Exception e1){
                    JOptionPane.showMessageDialog(null,e1.toString());
                }
            }
        }

        // Decompressor working
        if(e.getSource()==decompressButton){
            JFileChooser fileChooser=new JFileChooser(); // By this, a window is popped out for choosing a file
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Decompressor.method(file);
                }
                catch (Exception e1){
                    JOptionPane.showMessageDialog(null,e1.toString());
                }
            }
        }
    }
}
