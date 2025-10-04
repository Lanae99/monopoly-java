/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author merli
 */
public class Probabilità{
    private ImageIcon logo;

    
    private JPanel pannello3 = new JPanel();
    private JLabel LLogo;
    
    public Probabilità(ImageIcon logo){
        
        
        pannello3.setLayout(new GridLayout(1,1));
        pannello3.setBackground(Color.decode("#00bfff"));
        pannello3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        LLogo = new JLabel(this.logo);
        LLogo.setMinimumSize(new Dimension(30, 30));  
        LLogo.setPreferredSize(new Dimension(30, 30));
        LLogo.setMaximumSize(new Dimension(30, 30));

    }
    
    public JPanel getPannello3(){
        return pannello3;
    }
}
