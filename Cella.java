/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;


/**
 *
 * @author samsung
 */
public class Cella {
    private String nome;
    private String colore;
    private int prezzo;
    private String stato;
    private int x,y;
    private boolean acquistabile,edificabile;
    private int idGiocatore = 0;
    private ImageIcon logo;
    private String s;
    
    private JPanel LColore = new JPanel();
    private JLabel LNome = new JLabel ();
    private JLabel LPrezzo = new JLabel ();
    protected JLabel LStato = new JLabel ();
    private JPanel pannello = new JPanel ();
    private JLabel LLogo;
    
    protected JPanel casa1 = createEdificio(1);
    protected JPanel casa2 = createEdificio(1);
    protected JPanel casa3 = createEdificio(1);
    protected JPanel casa4 = createEdificio(1);
    protected JPanel albergo = createEdificio(2);
    protected JButton affitti = new JButton("?");
    private int diGiocatore;
    private int prezzoRendita;
    private int prezzoCasa1;
    private int prezzoCasa2;
    private int prezzoCasa3;
    private int prezzoCasa4;
    private int prezzoAlbergo;
    private int prezzoCase;
    
    
    private int numeroCase;
    boolean acquistataDaGiocatore;
    
    public Cella (String nome, String colore, int prezzo, int x, int y, boolean acquistabile, boolean edificabile,int prezzoRendita,int prezzoCasa1,int prezzoCasa2,int prezzoCasa3,int prezzoCasa4,int prezzoAlbergo,int numeroCase,int prezzoCase,boolean acquistataDaGiocatore){
        this.nome = nome;
        this.colore = colore;
        this.prezzo = prezzo;
        this.stato = "libero";
        this.x = x;
        this.y = y;
        this.acquistabile = acquistabile;
        this.edificabile = edificabile;
        pannello.setLayout(new GridLayout(4,1));
        pannello.add(LColore);
        pannello.add(LNome);
        pannello.add(LPrezzo);
        pannello.add(LStato);
        pannello.setBackground(Color.decode("#cde7ce"));
        LColore.setBackground(Color.decode(this.colore));
        LColore.add(affitti);
        LColore.add(casa1);
        affitti.setPreferredSize(new Dimension(20,15));
        
        
        
        
        this.prezzoRendita = prezzoRendita;
        this.prezzoCasa1 = prezzoCasa1;
        this.prezzoCasa2 = prezzoCasa2;
        this.prezzoCasa3 = prezzoCasa3;
        this.prezzoCasa4 = prezzoCasa4;
        this.prezzoAlbergo = prezzoAlbergo;
        
        this.prezzoCase = prezzoCase;
        this.numeroCase = numeroCase;
        
        
        
        this.acquistataDaGiocatore = acquistataDaGiocatore;
        
        diGiocatore = -1;
        
        casa1.setVisible(false);
        LColore.add(casa2);
        casa2.setVisible(false);
        LColore.add(casa3);
        casa3.setVisible(false);
        LColore.add(casa4);
        casa4.setVisible(false);
        LColore.add(albergo);
        albergo.setVisible(false);
        LNome.setText(nome);
        LNome.setHorizontalAlignment(JLabel.CENTER);
        LPrezzo.setText(Integer.toString(prezzo));
        LPrezzo.setHorizontalAlignment(JLabel.CENTER);
        LStato.setText(stato);
        LStato.setHorizontalAlignment(JLabel.CENTER);
        pannello.setMinimumSize(new Dimension(100,60));
        pannello.setPreferredSize(new Dimension(100,60));
        pannello.setMaximumSize(new Dimension(150,80));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        pannello.setBorder(border);

    }
    public Cella (String nome, ImageIcon logo, int prezzo, int x, int y, boolean acquistabile, boolean edificabile){
        this.nome = nome;
        this.logo = logo;
        this.prezzo = prezzo;
        this.stato = "libero";
        this.x = x;
        this.y = y;
        this.acquistabile = acquistabile;
        this.edificabile = edificabile;
        pannello.setLayout(new GridLayout(5,1));
        LLogo = new JLabel(this.logo);
        LLogo.setMinimumSize(new Dimension(30, 30));  
        LLogo.setPreferredSize(new Dimension(30, 30));
        LLogo.setMaximumSize(new Dimension(30, 30));
        pannello.add(LNome);
        pannello.add(LLogo);
        pannello.add(LPrezzo);
        pannello.add(LStato);
        pannello.add(affitti);
        affitti.setPreferredSize(new Dimension(20,15));
        pannello.setBackground(Color.decode("#cde7ce"));
        LNome.setText(nome);
        LNome.setHorizontalAlignment(JLabel.CENTER);
        LPrezzo.setText(Integer.toString(prezzo));
        LPrezzo.setHorizontalAlignment(JLabel.CENTER);
        LStato.setText(stato);
        LStato.setHorizontalAlignment(JLabel.CENTER);
        pannello.setMinimumSize(new Dimension(100,60));
        pannello.setPreferredSize(new Dimension(100,60));
        pannello.setMaximumSize(new Dimension(150,80));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        pannello.setBorder(border);
        
        
        diGiocatore = -1;

    }
    
    public Cella (String nome, ImageIcon logo, int x, int y, boolean acquistabile, boolean edificabile){
        this.nome = nome;
        this.logo = logo;
        this.x = x;
        this.y = y;
        this.acquistabile = acquistabile;
        this.edificabile = edificabile;
        pannello.setLayout(new GridLayout(2,1));
        LLogo = new JLabel(this.logo);
        LLogo.setMinimumSize(new Dimension(30, 30));  
        LLogo.setPreferredSize(new Dimension(30, 30));
        LLogo.setMaximumSize(new Dimension(30, 30));
        pannello.add(LNome);
        pannello.add(LLogo);
        pannello.setBackground(Color.decode("#cde7ce"));
        LNome.setText(nome);
        LNome.setHorizontalAlignment(JLabel.CENTER);
        pannello.setMinimumSize(new Dimension(100,60));
        pannello.setPreferredSize(new Dimension(100,60));
        pannello.setMaximumSize(new Dimension(150,80));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        pannello.setBorder(border);
        

    }
    
    public Cella(ImageIcon logo, int x, int y, String nome, String s){
        this.nome = nome;
        this.logo = logo;
        this.x = x;
        this.y = y;
        pannello.setLayout(new GridLayout(2,1));
        LLogo = new JLabel(this.logo);
        LLogo.setMinimumSize(new Dimension(50, 50));  
        LLogo.setPreferredSize(new Dimension(50, 50));
        LLogo.setMaximumSize(new Dimension(50, 50));
        LNome.setText(nome);
        LNome.setHorizontalAlignment(JLabel.CENTER);
        pannello.add(LNome);
        pannello.add(LLogo);
        pannello.setBackground(Color.decode("#ff8c00"));
        pannello.setMinimumSize(new Dimension(100,60));
        pannello.setPreferredSize(new Dimension(100,60));
        pannello.setMaximumSize(new Dimension(150,80));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        
        pannello.setBorder(border);
    }
    
    public Cella(ImageIcon logo, int x, int y, String nome){
        this.nome = nome;
        this.logo = logo;
        this.x = x;
        this.y = y;
        pannello.setLayout(new GridLayout(2,1));
        LLogo = new JLabel(this.logo);
        LLogo.setMinimumSize(new Dimension(50, 50));  
        LLogo.setPreferredSize(new Dimension(50, 50));
        LLogo.setMaximumSize(new Dimension(50, 50));
        LNome.setText(nome);
        LNome.setHorizontalAlignment(JLabel.CENTER);
        pannello.add(LNome);
        pannello.add(LLogo);
        pannello.setBackground(Color.decode("#00bfff"));
        pannello.setMinimumSize(new Dimension(100,60));
        pannello.setPreferredSize(new Dimension(100,60));
        pannello.setMaximumSize(new Dimension(150,80));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        pannello.setBorder(border);
    }
    
    private JPanel createEdificio(int tipo){
        JPanel edificio = new JPanel();
        if(tipo == 1){
            edificio.setBackground(Color.decode("#8DFF33"));
            edificio.setPreferredSize(new Dimension(15,15));
        }
        else if(tipo == 2){
            edificio.setBackground(Color.decode("#FF0000"));
            edificio.setPreferredSize(new Dimension(25,15));
        }
        edificio.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        return edificio;
    }
    
    public void setAcquistataDaGiocatore(boolean acquistataDaGiocatore)
    {
        this.acquistataDaGiocatore = acquistataDaGiocatore;
    }
    public boolean getAcquistataDaGiocatore()
    {
        return acquistataDaGiocatore;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getPrezzoRendita()
    {
        return prezzoRendita;
    }
    public int getPrezzoCasa1()
    {
        return prezzoCasa1;
    }
    public int getPrezzoCasa2()
    {
        return prezzoCasa2;
    }
    public int getPrezzoCasa3()
    {
        return prezzoCasa3;
    }
    public int getPrezzoCasa4()
    {
        return prezzoCasa4;
    }
    public int getPrezzoAlbergo()
    {
        return prezzoAlbergo;
    }
    
    public void setNumeroCase(int numeroCase)
    {
        this.numeroCase = numeroCase;
    }
    public int getNumeroCase()
    {
        return numeroCase;
    }
    public void setColore(String colore){
        pannello.setBackground(Color.decode(colore));
    }

    public void setPrezzo(int prezzo){
        this.prezzo = prezzo;
    }

    public void setStato(String stato){
        this.stato = stato;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void setAcquistabile(boolean acquistabile){
        this.acquistabile = acquistabile;
    }
    
    public void setEdificabile(boolean edificabile){
        this.edificabile = edificabile;
    }
    
    public void setIdGiocatore(int idGiocatore){
        this.idGiocatore = idGiocatore;
    }
    
    public String getNome(){
        return nome;
    }

    public String getColore(){
        return colore;
    }

    public int getPrezzo(){
        return prezzo;
    }

    public String getStato(){
        return stato;
    }

    public JPanel getPanel(){
        return pannello;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean getAcquistabile(){
        return acquistabile;
    }
    
    public boolean getEdificabile(){
        return edificabile;
    }
    
    public int getIdGiocatore(){
        return idGiocatore;
    }
    public void setDiGiocatore(int diGiocatore)
    {
        this.diGiocatore = diGiocatore;
    }
    public int getDiGiocatore()
    {
        return diGiocatore;
    }
}
