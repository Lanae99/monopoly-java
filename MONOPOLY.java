/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.monopoly;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;


public class MONOPOLY implements ActionListener {
    private JFrame frame;
    
    static public  JButton gioca;
    private int turno, pesca;
    private String probabilita[]; 
    private String imprevisti[];
    private int eliminati = 0;
    
    boolean risposta = false;
    private  Cella[] celle = {
            new Cella("VIA", new javax.swing.ImageIcon(getClass().getResource("/images/via.png")), 10, 10,false,false),      
            new Cella("Vicolo Corto", "#824e29", 40, 9, 10,true, true,2,10,30,90,160,250,0,50,false),    
            new Cella("PROBABILITA'",new javax.swing.ImageIcon(getClass().getResource("/images/probabilita.png")), 8, 10,false,false),  
            new Cella("Vicolo Stretto", "#824e29", 60, 7, 10, true, true,4,20,60,180,320,450,0,50,false),    
            new Cella("TASSA PATRIMONIALE", new javax.swing.ImageIcon(getClass().getResource("/images/soldi.png")), 200, 6,10,false,false),   
            new Cella("STAZIONE SUD", new javax.swing.ImageIcon(getClass().getResource("/images/treno.png")), 200, 5,10,true,false),    
            new Cella("Bastioni Gran Sasso", "#accee7", 100, 4,10,true, true,6,30,90,270,400,550,0,50,false),  
            new Cella("IMPREVISTI",  new javax.swing.ImageIcon(getClass().getResource("/images/imprevisti.png")),3,10,false,false),   
            new Cella("Viale Monterosa", "#accee7", 100,2,10,true, true,6,30,90,270,400,550,0,50,false),     
            new Cella("Viale Vesuvio", "#accee7", 120,1,10,true, true,8,40,100,300,450,600,0,50,false),  
            new Cella("TRANSITO", new javax.swing.ImageIcon(getClass().getResource("/images/transito.png")),0,10,false,false), 
            new Cella("Via Accademia", "#c9367a", 140,0,9,true, true,10,50,150,450,625,750,0,100,false), 
            new Cella("SOCIETA' ELETTRICA", new javax.swing.ImageIcon(getClass().getResource("/images/lampadina.png")), 13,0,8,true,false),  
            new Cella("Corso Ateneo", "#c9367a", 140,0,7,true, true,10,50,150,450,625,750,0,100,false),   
            new Cella("Piazza Universita' ", "#c9367a", 160,0,6,true, true,12,60,180,500,700,900,0,100,false),  
            new Cella("STAZIONE OVEST", new javax.swing.ImageIcon(getClass().getResource("/images/treno.png")), 200,0,5,true,false), 
            new Cella("Via Verdi", "#e8922f", 180,0,4,true, true,14,70,200,550,750,950,0,100,false),    
            new Cella("PROBABILITA'",new javax.swing.ImageIcon(getClass().getResource("/images/probabilita.png")),0,3,false,false),   
            new Cella("Corso Raffaello", "#e8922f", 180,0,2,true, true,14,70,200,550,750,950,0,100,false),  
            new Cella("Piazza Dante", "#e8922f", 200,0,1,true, true,16,80,220,600,800,100,0,100,false),   
            new Cella("PARCHEGGIO GARTUITO",new javax.swing.ImageIcon(getClass().getResource("/images/parcheggio.png")),0,0,false,false),   
            new Cella("Via Marco Polo", "#d73332", 220,1,0,true, true,18,90,250,700,875,1050,0,150,false),  
            new Cella("IMPREVISTI", new javax.swing.ImageIcon(getClass().getResource("/images/imprevisti.png")),2,0,false,false),   
            new Cella("Corso Magellano", "#d73332", 220,3,0,true, true,18,90,250,700,875,1050,0,150,false),   
            new Cella("Largo Colombo", "#d73332", 240,4,0,true, true,20,100,300,750,925,1100,0,150,false),  
            new Cella("STAZIONE NORD", new javax.swing.ImageIcon(getClass().getResource("/images/treno.png")), 200,5,0,true,false), 
            new Cella("Viale Costantino", "#e0e13e", 260,6,0,true, true,22,110,330,800,975,1150,0,150,false),  
            new Cella("Viale Traiano", "#e0e13e", 260,7,0,true, true,22,110,330,800,975,1150,0,150,false), 
            new Cella("SOCIETA' ACQUA POTABILE", new javax.swing.ImageIcon(getClass().getResource("/images/acqua.png")), 29,8,0,true,false), 
            new Cella("Piazza Giulio Cesare", "#e0e13e", 280,9,0,true, true,24,120,360,850,1025,1200,0,150,false),  
            new Cella("PRIGIONE", new javax.swing.ImageIcon(getClass().getResource("/images/prigione.png")),10,0,false,false),   
            new Cella("Via Roma", "#2ea144", 300,10,1,true, true,26,130,390,900,1100,1275,0,200,false),    
            new Cella("Corso Impero", "#2ea144", 300,10,2,true, true,26,130,390,900,1100,1275,0,200,false),   
            new Cella("PROBABILITA' ", new javax.swing.ImageIcon(getClass().getResource("/images/probabilita.png")),10,3,false,false),   
            new Cella("Largo Augusto", "#2ea144", 320,10,4,true, true,28,150,450,1000,1200,1400,0,200,false),   
            new Cella("STAZIONE EST", new javax.swing.ImageIcon(getClass().getResource("/images/treno.png")), 200,10,5,true,false),   
            new Cella("IMPREVISTI", new javax.swing.ImageIcon(getClass().getResource("/images/imprevisti.png")),10,6,false,false),   
            new Cella("Viale dei Giardini", "#595f9b", 380,10,7,true, true,35,175,500,1100,1300,1500,0,200,false),    
            new Cella("TASSA DI LUSSO", new javax.swing.ImageIcon(getClass().getResource("/images/anello.png")), 350,10,8,false,false),
            new Cella("Parco della Vittoria", "#595f9b", 400,10,9,true, true,50,200,600,1400,1700,2000,0,200,false),  
            new Cella(new javax.swing.ImageIcon(getClass().getResource("/images/imprevisti.png")), 5, 3, "IMPREVISTI", ""),
            new Cella(new javax.swing.ImageIcon(getClass().getResource("/images/probabilita.png")), 5, 5, "PROBABILITA'")
    };
   
    
    private Giocatore[] giocatori = {
        new Giocatore(1,"Marco", "#72A839"),
        new Giocatore(2,"Luca", "#ae2f0f"),
        new Giocatore(3,"Francesco", "#ffd80a"),
        new Giocatore(4,"Carlo", "#45cafa")
    };
    
    
    public MONOPOLY() {
        //dichiarazione probabilita:
    probabilita = new String [] {
    "Vinci un torneo di bellezza. Riscuoti 10$.",
    "Tua zia ti fa un regalo. Riscuoti 20$.",
    "Vai direttamente alla casella START. Riscuoti 200$.",
    "Vai alla Prigione. Non passa dal Via. Non riscuoti 200$.",
    "Hai vinto un premio letterario. Riscuoti 50$.",
    "Restituisci un libro alla biblioteca. Riscuoti 15$.",
    "Avanza fino a Viale della Vittoria. Se passi dal Via, riscuoti 200$.",
    "Hai vinto una gara di ballo. Riscuoti 25$.",
    "Vai alla Stazione sud. Se passi dal Via, riscuoti 200$.",
    "Hai vinto il secondo premio in un concorso di bellezza. Riscuoti 15$.",
    "Fai riparare il tuo yacht. Paga 25$ per ogni casa e 100$ per ogni albergo che possiedi.",
    "Vai alla Casella Partenza. Riscuoti 200$.",
    "Fai una gita alle Ferrovie nord. Se passi dal Via, riscuoti 200$.",
    "Hai ereditato 100$.",
    "Vai alla Prigione. Non passa dal Via. Non riscuoti 200$.",
    "Hai vinto una gara di scienza. Riscuoti 50$.",
    "Restituisci una polizza assicurativa. Riscuoti 100$.",
    "Hai vinto il jackpot alla lotteria. Riscuoti 100$.",
    "Vai alla Via. Riscuoti 200$.",
    "Hai perso una scommessa. Paga 50$.",
    "Fai una donazione per la costruzione di un ospedale. Paga 100$.",
    "Vai alla Casella Partenza. Riscuoti 200$.",
    "Ricevi un rimborso delle tasse. Riscuoti 20$.",
    "Vai alla Stazione est. Se passi dal Via, riscuoti 200$.",
    "Paga le spese del medico. Paga 50$.",
    "Rimborso fiscale. Riscuoti 20$.",
    "Vai alla Prigione. Non passa dal Via. Non riscuoti 200$.",
    "Hai vinto il premio per il miglior orto. Riscuoti 75$.",
    "Vai a Viale Traiano. Se passi dal Via, riscuoti 200$."
    };
    //dichiarazione imprevisti
    imprevisti = new String [] {
    "Sei stato multato per eccesso di velocità. Paga 15$.",
    "Hai vinto un premio di bellezza. Riscuoti 10$.",
    "Hai perso la tua borsa. Vai alla Stazione della Polizia.",
    "Hai trovato un portafoglio per strada. Riscuoti 20$.",
    "Il tuo vicino ti ha invitato a cena. Avanza di 3 caselle.",
    "Scavi in giardino e trovi un tesoro. Riscuoti 50$.",
    "Devi pagare le tasse sul reddito. Paga 200$.",
    "Hai vinto un concorso di talento. Riscuoti 25$.",
    "Hai dimenticato il tuo portafoglio. Vai alla Banca e paga una penale di 10$.",
    "La tua auto è fuori uso. Vai alla casella Parcheggio.",
    "Hai vinto un premio alla lotteria. Riscuoti 100$.",
    "Hai ricevuto una multa per parcheggio vietato. Paga 20$.",
    "Hai venduto delle azioni. Riscuoti 50$.",
    "Hai organizzato una festa di compleanno. Ogni giocatore ti regala 5$.",
    "Il tuo gatto ha distrutto la tua cucina. Paga 30$ per i danni.",
    "Hai trovato un passaggio segreto. Vai direttamente alla Casella START.",
    "Il tuo amico ti deve dei soldi. Riscuoti 15$.",
    "Ti sei fatto male giocando a calcio. Paga 25$ per le cure mediche.",
    "Hai vinto un torneo di scacchi. Riscuoti 30$.",
    "Hai ricevuto un rimborso delle tasse. Riscuoti 50$."
    };
        
        turno = 0;
        frame = new JFrame("Monopoli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel pannello = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        pannello.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        pannello.setBackground(Color.decode("#cde7ce"));
        pannello.setSize(400, 400);
        
        celle[1].affitti.addActionListener(this);
        celle[3].affitti.addActionListener(this);
        celle[4].affitti.addActionListener(this);
        celle[5].affitti.addActionListener(this);
        celle[6].affitti.addActionListener(this);
        celle[8].affitti.addActionListener(this);
        celle[9].affitti.addActionListener(this);
        celle[11].affitti.addActionListener(this);
        celle[12].affitti.addActionListener(this);
        celle[13].affitti.addActionListener(this);
        celle[14].affitti.addActionListener(this);
        celle[15].affitti.addActionListener(this);
        celle[16].affitti.addActionListener(this);
        celle[18].affitti.addActionListener(this);
        celle[19].affitti.addActionListener(this);
        celle[21].affitti.addActionListener(this);
        celle[23].affitti.addActionListener(this);
        celle[24].affitti.addActionListener(this);
        celle[25].affitti.addActionListener(this);
        celle[26].affitti.addActionListener(this);
        celle[27].affitti.addActionListener(this);
        celle[28].affitti.addActionListener(this);
        celle[29].affitti.addActionListener(this);
        celle[31].affitti.addActionListener(this);
        celle[32].affitti.addActionListener(this);
        celle[34].affitti.addActionListener(this);
        celle[35].affitti.addActionListener(this);
        celle[37].affitti.addActionListener(this);
        celle[38].affitti.addActionListener(this);
        celle[39].affitti.addActionListener(this);
        
        giocatori[0].bottoneSì.addActionListener(this);
        giocatori[1].bottoneSì.addActionListener(this);
        giocatori[2].bottoneSì.addActionListener(this);
        giocatori[3].bottoneSì.addActionListener(this);
        giocatori[0].bottoneNo.addActionListener(this);
        giocatori[1].bottoneNo.addActionListener(this);
        giocatori[2].bottoneNo.addActionListener(this);
        giocatori[3].bottoneNo.addActionListener(this);
        
        
        
        
        for(int i = 0; i<celle.length ; i++){
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = celle[i].getX();
            gbc.gridy = celle[i].getY();
            gbc.weightx = 1.0; // Peso orizzontale
            gbc.weighty = 1.0; // Peso verticale
            pannello.add(celle[i].getPanel(), gbc);
        }
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        pannello.add(giocatori[0].getPannello(),gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        pannello.add(giocatori[1].getPannello(),gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        pannello.add(giocatori[2].getPannello(),gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        pannello.add(giocatori[3].getPannello(),gbc);
        
        gioca = new JButton("Gioca giocatore: "+(turno+1));
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        pannello.add(gioca, gbc);
        gioca.addActionListener(this);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 5;
        pannello.add(createMonopolyPanel(), gbc);
        pesca = 6;
        frame.add(pannello);
    };
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == gioca)
        {
            if(eliminati == 3)
            {
                JOptionPane.showMessageDialog(null,"Hai vinto giocatore "+turno);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            if(turno != 0)
            {
                if(giocatori[turno - 1].getRisposta())
                {
                    celle[giocatori[turno - 1].getCasella()].LStato.setText("Comprata");
                    giocatori[turno - 1].setRisposta(false);
                    celle[giocatori[turno - 1].getCasella()].setAcquistabile(false);
                    giocatori[turno - 1].aggiungiProprieta(giocatori[turno - 1].getCasella());
                    celle[giocatori[turno - 1].getCasella()].setDiGiocatore(turno - 1);
                    celle[giocatori[turno - 1].getCasella()].setAcquistataDaGiocatore(true);
                    giocatori[turno - 1].setSoldi(giocatori[turno - 1].getSoldi() - celle[giocatori[turno - 1].getCasella()].getPrezzo());
                }
                
            }
            else if(giocatori[3].getRisposta())
            {
                celle[giocatori[3].getCasella()].LStato.setText("Comprata");
                giocatori[3].setRisposta(false);
                celle[giocatori[3].getCasella()].setAcquistabile(false);
                giocatori[3].aggiungiProprieta(giocatori[3].getCasella());
                celle[giocatori[3].getCasella()].setDiGiocatore(3);
                celle[giocatori[3].getCasella()].setAcquistataDaGiocatore(true);
                giocatori[3].setSoldi(giocatori[3].getSoldi() - celle[giocatori[3].getCasella()].getPrezzo());
            }
            int dado = tiraDadi();
            int avanzamento = 0;
            if(giocatori[turno].getEliminato())
            {
                if(turno != 3)
                {
                    turno += 1;
                }
                else
                {
                    turno = 0;
                }
            }
            else
            {
            if(giocatori[turno].getPrigione() >= 0 && giocatori[turno].getPrigione() != 2)
            {
                giocatori[turno].setPrigione(giocatori[turno].getPrigione() + 1);
            }
            else if(giocatori[turno].getPrigione() == 2)
            {
                giocatori[turno].setPrigione(-1);
            }
            else
            {
            celle[giocatori[turno].getCasella()].setColore("#cde7ce");
            if(giocatori[turno].getCasella()+dado >= 40)
            {
                giocatori[turno].setCasella(dado+giocatori[turno].getCasella()-40);
                giocatori[turno].setSoldi(200+giocatori[turno].getSoldi());
            }
            else
            {
                avanzamento = giocatori[turno].getCasella() + dado;   
                giocatori[turno].setCasella(avanzamento);
            }
            coloreCasella();
            controlloCasella();
            if(giocatori[turno].getCasella() == 2 || giocatori[turno].getCasella() == 17 || giocatori[turno].getCasella() == 33)
            {
                JOptionPane.showMessageDialog(null,pescaProbabilita(),"Probabilità",INFORMATION_MESSAGE);
                if(pesca == 0) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+10);
                else if(pesca == 1) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+20);
                else if (pesca == 2)
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi()+200);
                    giocatori[turno].setCasella(0);
                    coloreCasella();
                }
                else if(pesca == 3)
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setCasella(10);
                    coloreCasella();
                    giocatori[turno].setPrigione(0);
                    
                }
                else if(pesca == 4) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+50);
                else if (pesca == 5) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+15);
                else if (pesca == 6)
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setCasella(39);
                    coloreCasella();
                    controlloCasella();
                }
                else if (pesca == 7) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+25);
                else if (pesca == 8)
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    if(giocatori[turno].getCasella() != 2 )
                    {
                        giocatori[turno].setSoldi(giocatori[turno].getSoldi()+200);
                    }
                    giocatori[turno].setCasella(5);
                    coloreCasella();
                    controlloCasella();
                }
                else if(pesca == 9) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+15);
                else if(pesca == 10)
                {
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi()-giocatori[turno].getCasa()*25-giocatori[turno].getAlberghi()*100);
                    
                }
                else if (pesca == 11)
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi()+200);
                    giocatori[turno].setCasella(0);
                    coloreCasella();
                }
                else if(pesca == 12)
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    if(giocatori[turno].getCasella() != 2 || giocatori[turno].getCasella() != 17)
                    {
                        giocatori[turno].setSoldi(giocatori[turno].getSoldi()+200);
                    }
                    giocatori[turno].setCasella(25);
                    coloreCasella();
                    controlloCasella();
                }
                else if(pesca == 13) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+100);
                else if(pesca == 14) 
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setCasella(10);
                    coloreCasella();
                    giocatori[turno].setPrigione(0);
                }
                else if(pesca == 15)  giocatori[turno].setSoldi(giocatori[turno].getSoldi()+50);
                else if(pesca == 16) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+100);
                else if(pesca == 17) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+100);
                else if(pesca == 18)
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi()+200);
                    giocatori[turno].setCasella(0);
                    coloreCasella();
                }
                else if(pesca == 19) giocatori[turno].setSoldi(giocatori[turno].getSoldi()-50);
                else if(pesca == 20) giocatori[turno].setSoldi(giocatori[turno].getSoldi()-100);
                else if(pesca == 21)
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi()+200);
                    giocatori[turno].setCasella(0);
                    coloreCasella();
                }
                else if(pesca == 22) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+20);
                else if(pesca == 23)
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setCasella(35);
                    coloreCasella();
                    controlloCasella();
                }
                else if(pesca == 24) giocatori[turno].setSoldi(giocatori[turno].getSoldi()-50);
                else if(pesca == 25) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+20);
                else if(pesca == 26) 
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setCasella(10);
                    coloreCasella();
                    giocatori[turno].setPrigione(0);
                }
                else if(pesca == 27) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+75);
                else if(pesca == 28) 
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setCasella(27);
                    if(giocatori[turno].getCasella() == 33)
                    {
                        giocatori[turno].setSoldi(giocatori[turno].getSoldi()+200);
                    }
                    coloreCasella();
                    controlloCasella();
                }
                
               
                
                
                
            }}
            if(giocatori[turno].getCasella() == 7 || giocatori[turno].getCasella() == 22 || giocatori[turno].getCasella() == 36)
            {
                JOptionPane.showMessageDialog(null,pescaImprevisti(),"Imprevisti",INFORMATION_MESSAGE);
                if(pesca == 0) giocatori[turno].setSoldi(giocatori[turno].getSoldi()-15);
                else if (pesca == 1) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+10);
                else if(pesca == 2) 
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setCasella(10);
                    coloreCasella();
                }
                else if(pesca == 3) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+20);
                else if(pesca == 4)
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setCasella(giocatori[turno].getCasella()+3);
                    coloreCasella();
                    controlloCasella();
                }
                else if(pesca == 5) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+50);
                else if(pesca == 6) giocatori[turno].setSoldi(giocatori[turno].getSoldi()-200);
                else if(pesca == 7) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+25);
                else if(pesca == 8) giocatori[turno].setSoldi(giocatori[turno].getSoldi()-10);
                else if(pesca == 9)
                {
                   celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                   giocatori[turno].setCasella(20);
                   coloreCasella();
                }
                else if(pesca == 10) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+100);
                else if(pesca == 11) giocatori[turno].setSoldi(giocatori[turno].getSoldi()-20);
                else if(pesca == 12) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+50);
                else if(pesca == 13) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+5*giocatori.length);
                else if(pesca == 14) giocatori[turno].setSoldi(giocatori[turno].getSoldi()-30);
                else if(pesca == 15)
                {
                    celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi()+200);
                    giocatori[turno].setCasella(0);
                    coloreCasella();
                }
                else if(pesca == 16) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+15);
                else if(pesca == 17) giocatori[turno].setSoldi(giocatori[turno].getSoldi()-25);
                else if(pesca == 18) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+30);
                else if(pesca == 19) giocatori[turno].setSoldi(giocatori[turno].getSoldi()+50);
                
            }
            
            if(giocatori[turno].getCasella() == 4)
            {
                giocatori[turno].setSoldi(giocatori[turno].getSoldi()-200);
            }
            if(giocatori[turno].getCasella() == 38)
            {
                giocatori[turno].setSoldi(giocatori[turno].getSoldi()-350);
            }
            if(giocatori[turno].getCasella() == 30)
            {
                celle[giocatori[turno].getCasella()].setColore("#cde7ce");
                giocatori[turno].setCasella(10);
                coloreCasella();
                giocatori[turno].setPrigione(0);
            }
            if(giocatori[turno].getSoldi() < 0)
           {
               eliminati++;
               for(int i = 0; i < giocatori[turno].proprieta.size(); i++)
               {
                   celle[giocatori[turno].proprieta.get(i)].setAcquistabile(true);
                   celle[giocatori[turno].getCasella()].LStato.setText("Libera");
                   giocatori[turno].setEliminato(true);
                   if(giocatori[turno].proprieta.get(i) != 5 || giocatori[turno].proprieta.get(i) != 15 || giocatori[turno].proprieta.get(i) != 25 || giocatori[turno].proprieta.get(i) != 35 || giocatori[turno].proprieta.get(i) != 12 || giocatori[turno].proprieta.get(i) != 28)
                   {
                       celle[giocatori[turno].proprieta.get(i)].setNumeroCase(0);
                       celle[giocatori[turno].proprieta.get(i)].casa1.setVisible(false);
                       celle[giocatori[turno].proprieta.get(i)].casa2.setVisible(false);
                       celle[giocatori[turno].proprieta.get(i)].casa3.setVisible(false);
                       celle[giocatori[turno].proprieta.get(i)].casa4.setVisible(false);
                       celle[giocatori[turno].proprieta.get(i)].albergo.setVisible(false);
                       celle[giocatori[turno].proprieta.get(i)].setEdificabile(true);
                   }
               }
           }
            }
            if(turno + 1 == 4)
            {
                turno = 0;
            }
            else 
            {
                turno += 1;
            }
            gioca.setText("Gioca giocatore: "+(turno+1));
            
            
           
            
            
           
        }
        else if(e.getSource() == celle[1].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 2$\nCon 1 casa: 10$\nCon 2 case: 30$\nCon 3 case: 90$\nCon 4 case: 160$\nCon Albergo: 250$\nCosto di ogni casa: 50$","Vicolo Corto",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[3].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 4$\nCon 1 casa: 20$\nCon 2 case: 60$\nCon 3 case: 180$\nCon 4 case: 320$\nCon Albergo: 450$\nCosto di ogni casa: 50$","Vicolo Corto",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[4].affitti)
        {
            JOptionPane.showMessageDialog(null,"Paga: 200$","Tassa Patrimoniale",ERROR_MESSAGE);
        }
        else if(e.getSource() == celle[5].affitti || e.getSource() == celle[15].affitti || e.getSource() == celle[25].affitti || e.getSource() == celle[35].affitti)
        {
            JOptionPane.showMessageDialog(null,"Rendita: 25$\nSe si possiedono 2 stazioni: 50$\nSe si possiedono 3 stazioni: 100$\nSe si possiedono 4 stazioni: 200$","Stazione",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[6].affitti || e.getSource() == celle[8].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 6$\nCon 1 casa: 30$\nCon 2 case: 90$\nCon 3 case: 270$\nCon 4 case: 400$\nCon Albergo: 550$\nCosto di ogni casa: 50$","Bastioni Gran Sasso e Viale Monterosa",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[9].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 8$\nCon 1 casa: 40$\nCon 2 case: 100$\nCon 3 case: 300$\nCon 4 case: 450$\nCon Albergo: 600$\nCosto di ogni casa: 50$","Viale Vesuvio",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[11].affitti || e.getSource() == celle[13].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 10$\nCon 1 casa: 50$\nCon 2 case: 150$\nCon 3 case: 450$\nCon 4 case: 625$\nCon Albergo: 750$\nCosto di ogni casa: 100$","Via Accademia e Corso Ateneo",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[14].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 12$\nCon 1 casa: 60$\nCon 2 case: 180$\nCon 3 case: 500$\nCon 4 case: 700$\nCon Albergo: 900$\nCosto di ogni casa: 100$","Piazza Universita'",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[16].affitti || e.getSource() == celle[18].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 14$\nCon 1 casa: 70$\nCon 2 case: 200$\nCon 3 case: 550$\nCon 4 case: 750$\nCon Albergo: 950$\nCosto di ogni casa: 100$","Via Verdi e Corso Raffaello",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[19].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 16$\nCon 1 casa: 80$\nCon 2 case: 220$\nCon 3 case: 600$\nCon 4 case: 800$\nCon Albergo: 1000$\nCosto di ogni casa: 100$","Piazza Dante",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[21].affitti || e.getSource() == celle[23].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 18$\nCon 1 casa: 90$\nCon 2 case: 250$\nCon 3 case: 700$\nCon 4 case: 875$\nCon Albergo: 1050$\nCosto di ogni casa: 150$","Via Marco Paolo e Corso Magellano",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[24].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 20$\nCon 1 casa: 100$\nCon 2 case: 300$\nCon 3 case: 750$\nCon 4 case: 925$\nCon Albergo: 1100$\nCosto di ogni casa: 150$","Largo Colombo",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[26].affitti || e.getSource() == celle[27].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 22$\nCon 1 casa:110$\nCon 2 case: 330$\nCon 3 case: 800$\nCon 4 case: 9750$\nCon Albergo: 1150$\nCosto di ogni casa: 150$","Viale Costantino e Viale Traiano",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[29].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 24$\nCon 1 casa: 120$\nCon 2 case: 360$\nCon 3 case: 850$\nCon 4 case: 1025$\nCon Albergo: 1200$\nCosto di ogni casa: 150$","Piazza Giulio Cesare",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[31].affitti || e.getSource() == celle[32].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 26$\nCon 1 casa: 130$\nCon 2 case: 390$\nCon 3 case: 900$\nCon 4 case: 1100$\nCon Albergo: 1275$\nCosto di ogni casa: 200$","Via Roma e Corso Impero",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[34].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 28$\nCon 1 casa: 150$\nCon 2 case: 450$\nCon 3 case: 1000$\nCon 4 case: 1200$\nCon Albergo: 1400$\nCosto di ogni casa: 200$","Largo Augusto",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[37].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 35$\nCon 1 casa: 175$\nCon 2 case: 500$\nCon 3 case: 1100$\nCon 4 case: 1300$\nCon Albergo: 1500$\nCosto di ogni casa: 200$","Viale Dei Giardini",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[38].affitti)
        {
            JOptionPane.showMessageDialog(null,"Paga: 350$","Tassa Di Lusso",ERROR_MESSAGE);
        }
        else if(e.getSource() == celle[39].affitti)
        {
            JOptionPane.showMessageDialog(null,"Affitti: \nRendita solo terreno: 24$\nCon 1 casa: 120$\nCon 2 case: 360$\nCon 3 case: 850$\nCon 4 case: 1025$\nCon Albergo: 1200$\nCosto di ogni casa: 150$","Piazza Giulio Cesare",INFORMATION_MESSAGE);
        }
        else if(e.getSource() == celle[12].affitti || e.getSource() == celle[28].affitti)
        {
            JOptionPane.showMessageDialog(null,"Se si possiede una sola Società,la rendita è 4 volte il totale uscito sui dadi\nSe si posseggono entrambe le Società, la rendita è 10 volte il totale uscito sui dadi","Società Acqua Potabile e Società Elettrica",INFORMATION_MESSAGE);
        }
        
       
        
             
        
    }
    public void controlloCasella()
    {
        if(celle[giocatori[turno].getCasella()].getAcquistabile() == true)
        {
            gioca.setEnabled(false);
            faiDomanda();     
        }
        else if(celle[giocatori[turno].getCasella()].getAcquistataDaGiocatore() && turno != celle[giocatori[turno].getCasella()].getDiGiocatore())
        {
            if(giocatori[turno].getCasella() == 5 || giocatori[turno].getCasella() == 15 || giocatori[turno].getCasella() == 25 || giocatori[turno].getCasella() == 35 )
            {
                int numeroStazioni = 0;
                int diGiocatore = celle[giocatori[turno].getCasella()].getDiGiocatore();
                for(int i = 0; i < giocatori[diGiocatore].proprieta.size(); i++)
                {
                    if(giocatori[diGiocatore].proprieta.get(i) == 5 || giocatori[diGiocatore].proprieta.get(i) == 15 || giocatori[diGiocatore].proprieta.get(i) == 25 || giocatori[diGiocatore].proprieta.get(i) == 35)
                    {
                        numeroStazioni += 1;
                    }
                }
                if(numeroStazioni == 1)
                {
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - 25);   
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + 25);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato 25 al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                }
                if(numeroStazioni == 2)
                {
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - 50); 
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + 50);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato 50 al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                }
                if(numeroStazioni == 3)
                {
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - 100); 
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + 100);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato 100 al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                }
                if(numeroStazioni == 4)
                {
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - 200);   
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + 200);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato 200 al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                }
            }
            else if(giocatori[turno].getCasella() == 12 || giocatori[turno].getCasella() == 28)
            {
                int numeroSocieta = 0;
                int diGiocatore = celle[giocatori[turno].getCasella()].getDiGiocatore();
                for(int i = 0; i < giocatori[diGiocatore].proprieta.size(); i++)
                {
                    if(giocatori[diGiocatore].proprieta.get(i) == 12 || giocatori[diGiocatore].proprieta.get(i) == 28)
                    {
                        numeroSocieta += 1;
                    }
                }
                if(numeroSocieta == 1)
                {
                    int uscitaDadi = tiraDadi();
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - uscitaDadi * 4);
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + uscitaDadi * 4);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato "+uscitaDadi * 4+" al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                    
                }
                else
                {
                    int uscitaDadi = tiraDadi();
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - uscitaDadi * 10);
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + uscitaDadi * 10);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato "+uscitaDadi * 10+" al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                    
                }    
            }
            else
            {
                
                if(celle[giocatori[turno].getCasella()].getNumeroCase() == 0)
                {
                    int daPagare = celle[giocatori[turno].getCasella()].getPrezzoRendita();
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - daPagare);
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + daPagare);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato "+celle[giocatori[turno].getCasella()].getPrezzoRendita()+" al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                    
                }
                else if(celle[giocatori[turno].getCasella()].getNumeroCase() == 1)
                {
                    JOptionPane.showMessageDialog(null,""+celle[giocatori[turno].getCasella()].getNumeroCase());
                    int daPagare = celle[giocatori[turno].getCasella()].getPrezzoCasa1();
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - daPagare);
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + daPagare);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato "+daPagare+" al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                    
                }
                else if(celle[giocatori[turno].getCasella()].getNumeroCase() == 2)
                {
                    int daPagare = celle[giocatori[turno].getCasella()].getPrezzoCasa2();
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - daPagare);
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + daPagare);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato "+celle[giocatori[turno].getCasella()].getPrezzoCasa2()+" al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                    
                }
                else if(celle[giocatori[turno].getCasella()].getNumeroCase() == 3)
                {
                    int daPagare = celle[giocatori[turno].getCasella()].getPrezzoCasa3();
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - daPagare);
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + daPagare);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato "+celle[giocatori[turno].getCasella()].getPrezzoCasa3()+" al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                    
                }
                else if(celle[giocatori[turno].getCasella()].getNumeroCase() == 4)
                {
                    int daPagare = celle[giocatori[turno].getCasella()].getPrezzoCasa4();
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - daPagare);
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + daPagare);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato "+celle[giocatori[turno].getCasella()].getPrezzoCasa4()+" al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                    
                }
                else if(celle[giocatori[turno].getCasella()].getNumeroCase() == 5)
                {
                    int daPagare = celle[giocatori[turno].getCasella()].getPrezzoAlbergo();
                    giocatori[turno].setSoldi(giocatori[turno].getSoldi() - daPagare);
                    celle[giocatori[turno].getCasella()].setEdificabile(false);
                    giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].setSoldi(giocatori[celle[giocatori[turno].getCasella()].getDiGiocatore()].getSoldi() + daPagare);
                    JOptionPane.showMessageDialog(null,"Giocatore: "+(turno+1)+" hai pagato "+celle[giocatori[turno].getCasella()].getPrezzoAlbergo()+" al giocatore: "+(celle[giocatori[turno].getCasella()].getDiGiocatore()+1),"Pagamento",INFORMATION_MESSAGE);
                }
            }
        }
        else if(celle[giocatori[turno].getCasella()].getDiGiocatore() == turno && celle[giocatori[turno].getCasella()].getEdificabile())
        {
            
            faiDomandaCase();
        }
        
    }
    public void coloreCasella()
    {
        if(turno == 0) celle[giocatori[turno].getCasella()].setColore("#72A839");
        else if (turno == 1) celle[giocatori[turno].getCasella()].setColore("#ae2f0f");
        else if (turno == 2) celle[giocatori[turno].getCasella()].setColore("#ffd80a");
        else celle[giocatori[turno].getCasella()].setColore("#45cafa");
    }
    public boolean faiDomanda()
    {
        boolean acquisto = false;
        
        giocatori[turno].setTestoDomanda("vuoi acquistare la proprieta'?");
        
        return acquisto;
    }
    public void faiDomandaCase()
    {
        String[] options = {"Sì","No"};
        var scelta = JOptionPane.showOptionDialog(null,"Vuoi comprare una casa per "+celle[giocatori[turno].getCasella()].getPrezzo()+"?","Casa",0,2,null,options,options[0]);
        if(scelta == 0)
        {
            giocatori[turno].setSoldi(giocatori[turno].getSoldi() - celle[giocatori[turno].getCasella()].getPrezzo());
            celle[giocatori[turno].getCasella()].setNumeroCase(celle[giocatori[turno].getCasella()].getNumeroCase() + 1);
            if(celle[giocatori[turno].getCasella()].getNumeroCase() == 1)
            {
                celle[giocatori[turno].getCasella()].casa1.setVisible(true);
            }
            if(celle[giocatori[turno].getCasella()].getNumeroCase() == 2)
            {
                celle[giocatori[turno].getCasella()].casa2.setVisible(true);
            }
            if(celle[giocatori[turno].getCasella()].getNumeroCase() == 3)
            {
                celle[giocatori[turno].getCasella()].casa3.setVisible(true);
            }
            if(celle[giocatori[turno].getCasella()].getNumeroCase() == 4)
            {
                celle[giocatori[turno].getCasella()].casa4.setVisible(true);
            }
            if(celle[giocatori[turno].getCasella()].getNumeroCase() == 5)
            {
                celle[giocatori[turno].getCasella()].albergo.setVisible(true);
            }
        }
    }
    public int tiraDadi()
    {
        return (int) ((Math.random() * (12 - 2)) + 2);
    }
    public String pescaProbabilita()
    {
        pesca = (int) ((Math.random() * (28 - 0)) + 0);
        return probabilita[pesca];
    }
    public String pescaImprevisti()
    {
        pesca = (int) ((Math.random() * (19 - 0)) + 0);
        return imprevisti[pesca];
    }
    private JPanel createMonopolyPanel() {
        
        JPanel monopolyPanel = new JPanel();
        monopolyPanel.setLayout(new GridLayout(1, 5));
        
                                        


        return monopolyPanel;
    }
    
    
    

    public static void main(String args[]) {
        new MONOPOLY();
    }
}
