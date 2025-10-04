/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly;
import static com.mycompany.monopoly.MONOPOLY.gioca;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author samsung
 */
public class Giocatore implements ActionListener{
    private int id;
    private int casa;
    private int alberghi;
    private int prigione;
    private String colore;
    private String nome;
    private int soldi;
    private int casella;
    protected boolean risposta = false;
    
    boolean eliminato = false;
    
    private JPanel pannello = new JPanel();
    private JPanel LColore = new JPanel();
    protected JPanel panelloDomanda = new JPanel();
    private JLabel LNome = new JLabel();
    private JLabel LDomanda = new JLabel();
    private JLabel LSoldi = new JLabel();
    protected JButton bottoneSì = new JButton();
    protected JButton bottoneNo = new JButton();
   
    
    protected ArrayList<Integer> proprieta = new ArrayList<>();
    
    public Giocatore(int id, String nome, String colore){
        this.id = id;
        this.colore = colore;
        this.nome = nome;
        soldi = 1500;
        this.casella = 0;
        pannello.setLayout(new GridLayout(6,2));
        
        prigione = -1;
        casa = 0;
        alberghi = 0;
        
        
        
        
        
        
        panelloDomanda.setLayout(new GridLayout(1, 3));
        panelloDomanda.add(LDomanda);
        panelloDomanda.add(bottoneSì);
        panelloDomanda.add(bottoneNo);
        panelloDomanda.setVisible(false);
        
        
        bottoneSì.addActionListener(this);
        bottoneNo.addActionListener(this);
        
        pannello.setBackground(Color.decode("#cde7ce"));
        LColore.setBackground(Color.decode(this.colore));
        LColore.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        LNome.setText(Integer.toString(this.id)+"-"+ this.nome);
        LSoldi.setText(Integer.toString(soldi));
        pannello.add(LColore);
        pannello.add(LNome);
        pannello.add(LSoldi);
        pannello.add(panelloDomanda);
        
        
    }
    public void setTestoDomanda(String domanda)
    {
        LDomanda.setText(domanda);
        bottoneSì.setText("Sì");
        bottoneNo.setText("No");
        panelloDomanda.setVisible(true);
    }
    public void setSoldi(int soldi)
    {
        this.soldi = soldi;
        LSoldi.setText(Integer.toString(soldi));
    }
    public int getCasella()
    {
        return casella;
    }
    public int getSoldi()
    {
        return Integer.parseInt(LSoldi.getText());
    }
    public void setCasella(int casella)
    {
        this.casella = casella; 
    }
    public int getCasa()
    {
        return casa;
    }
    public void setCasa(int casa)
    {
        this.casa = casa;
    }
    public int getAlberghi()
    {
        return casa;
    }
    public void setAlberghi(int alberghi)
    {
        this.alberghi = alberghi;
    }
    public JPanel getPannello(){
        return pannello;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == bottoneSì)
        {
            risposta = true;
            panelloDomanda.setVisible(false);
            MONOPOLY.gioca.setEnabled(true);
        }
        if(e.getSource() == bottoneNo)
        {
            risposta = false;
            MONOPOLY.gioca.setEnabled(true);
            panelloDomanda.setVisible(false);
        }
      
    }
    public void aggiungiProprieta(int cella)
    {
         proprieta.add(cella);
    }
    public int getPrigione()
    {
        return prigione;
    }
    public void setPrigione(int prigione)
    {
        this.prigione = prigione;
    }
    public boolean getRisposta()
    {
        return risposta;
    }
    public void setRisposta(boolean risposta)
    {
        this.risposta = risposta;
    }
    public void setEliminato(boolean eliminato)
    {
        this.eliminato = eliminato;
    }
    public boolean getEliminato()
    {
        return eliminato;
    }
}
