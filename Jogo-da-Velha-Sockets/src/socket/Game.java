/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Mastery
 */
public class Game extends JFrame {

    //variaveis
    Font fontText = new Font("Book Antiqua", Font.PLAIN, 30);
    Font fontButtons = new Font("Book Antiqua", Font.PLAIN, 18);

    private ServerSocket serverSocket = null;
    private Socket sockets = null;
    private ObjectInputStream entrada = null;
    private ObjectOutputStream saida = null;
    //jogo
    private String jogo[] = {"", "", "", "", "", "", "", "", ""};
    //server é o X e o cliente O
    private String xo = "";
    //nick1 o Server e o nick2 Cliente
    private String nick1, nick2, msg;
    //controle de fluxo
    private boolean sinal;
    private boolean pararSinal = true;
    //numero de jogadas e de partidas
    private int numPartidas = 0;
    private int numJogadas = 0;
    //conexao segura com servidor :D
    private String criptografia = "!jonathan!#$%&/()!";

    public Game() {
        initComponents();
        setSize(520, 600);
        setTitle("Jogo da Velha - Jonathan");
        setResizable(false);
        setLocationRelativeTo(this);
        inicia();
        setIconImage(new ImageIcon(getClass().getResource("icone.png")).getImage());
        //criar evento para a janela
        addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent event) {
                try {
                    InetAddress thisIp = InetAddress.getLocalHost();
                    ip.setText(thisIp.getHostAddress());
                } catch (Exception e) {
                    ip.setText("127.0.0.1");
                }
            }

            @Override
            public void windowClosing(WindowEvent event) {
                if (sockets != null) {
                    enviarMensagem("Offline!");
                }
                encerrarTudo();
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ip = new javax.swing.JTextField();
        port = new javax.swing.JTextField();
        nick = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        newGame = new javax.swing.JButton();
        create = new javax.swing.JButton();
        join = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        message = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        b3 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        ip.setBackground(new java.awt.Color(0, 0, 0));
        ip.setForeground(new java.awt.Color(0, 255, 0));
        ip.setText("jTextField1");
        getContentPane().add(ip);
        ip.setBounds(40, 20, 140, 30);

        port.setBackground(new java.awt.Color(0, 0, 0));
        port.setForeground(new java.awt.Color(51, 255, 0));
        port.setText("jTextField2");
        getContentPane().add(port);
        port.setBounds(230, 20, 70, 30);

        nick.setBackground(new java.awt.Color(0, 0, 0));
        nick.setForeground(new java.awt.Color(0, 255, 0));
        nick.setText("jTextField3");
        getContentPane().add(nick);
        nick.setBounds(340, 20, 140, 30);

        jLabel1.setBackground(new java.awt.Color(51, 255, 0));
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("Nick:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 20, 30, 30);

        jLabel2.setBackground(new java.awt.Color(51, 255, 0));
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setText("IP:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 20, 14, 30);

        jLabel3.setBackground(new java.awt.Color(51, 255, 0));
        jLabel3.setForeground(new java.awt.Color(0, 255, 0));
        jLabel3.setText("Porta:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 20, 40, 30);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        newGame.setBackground(new java.awt.Color(0, 0, 0));
        newGame.setForeground(new java.awt.Color(0, 255, 0));
        newGame.setText("Recomeçar");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        jPanel1.add(newGame);
        newGame.setBounds(340, 60, 140, 30);

        create.setBackground(new java.awt.Color(0, 0, 0));
        create.setForeground(new java.awt.Color(0, 255, 0));
        create.setText("Criar");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        jPanel1.add(create);
        create.setBounds(140, 60, 90, 30);

        join.setBackground(new java.awt.Color(0, 0, 0));
        join.setForeground(new java.awt.Color(0, 255, 0));
        join.setText("Entrar");
        join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinActionPerformed(evt);
            }
        });
        jPanel1.add(join);
        join.setBounds(40, 60, 90, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 520, 100);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

        textArea.setBackground(new java.awt.Color(0, 0, 0));
        textArea.setColumns(20);
        textArea.setForeground(new java.awt.Color(51, 255, 0));
        textArea.setLineWrap(true);
        textArea.setRows(5);
        sp.setViewportView(textArea);

        jPanel2.add(sp);
        sp.setBounds(20, 30, 470, 96);

        message.setBackground(new java.awt.Color(0, 0, 0));
        message.setForeground(new java.awt.Color(51, 255, 0));
        message.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageKeyPressed(evt);
            }
        });
        jPanel2.add(message);
        message.setBounds(20, 150, 470, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 360, 520, 240);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(null);

        b3.setBackground(new java.awt.Color(0, 0, 0));
        b3.setForeground(new java.awt.Color(51, 255, 0));
        b3.setText("jButton1");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel3.add(b3);
        b3.setBounds(300, 10, 90, 80);

        b2.setBackground(new java.awt.Color(0, 0, 0));
        b2.setForeground(new java.awt.Color(51, 255, 0));
        b2.setText("jButton1");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel3.add(b2);
        b2.setBounds(210, 10, 90, 80);

        b1.setBackground(new java.awt.Color(0, 0, 0));
        b1.setForeground(new java.awt.Color(51, 255, 0));
        b1.setText("jButton1");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel3.add(b1);
        b1.setBounds(120, 10, 90, 80);

        b4.setBackground(new java.awt.Color(0, 0, 0));
        b4.setForeground(new java.awt.Color(51, 255, 0));
        b4.setText("jButton1");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        jPanel3.add(b4);
        b4.setBounds(120, 90, 90, 80);

        b7.setBackground(new java.awt.Color(0, 0, 0));
        b7.setForeground(new java.awt.Color(51, 255, 0));
        b7.setText("jButton1");
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });
        jPanel3.add(b7);
        b7.setBounds(120, 170, 90, 80);

        b8.setBackground(new java.awt.Color(0, 0, 0));
        b8.setForeground(new java.awt.Color(51, 255, 0));
        b8.setText("jButton1");
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });
        jPanel3.add(b8);
        b8.setBounds(210, 170, 90, 80);

        b9.setBackground(new java.awt.Color(0, 0, 0));
        b9.setForeground(new java.awt.Color(51, 255, 0));
        b9.setText("jButton1");
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });
        jPanel3.add(b9);
        b9.setBounds(300, 170, 90, 80);

        b6.setBackground(new java.awt.Color(0, 0, 0));
        b6.setForeground(new java.awt.Color(51, 255, 0));
        b6.setText("jButton1");
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });
        jPanel3.add(b6);
        b6.setBounds(300, 90, 90, 80);

        b5.setBackground(new java.awt.Color(0, 0, 0));
        b5.setForeground(new java.awt.Color(51, 255, 0));
        b5.setText("jButton1");
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });
        jPanel3.add(b5);
        b5.setBounds(210, 90, 90, 80);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 100, 520, 260);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        if (sinal) {
            b1.setText(xo); // set X or O button text
            enviarMensagem(xo + "1" + criptografia);
            enviarMensagem("true" + criptografia);
            sinal = false;
            b1.setEnabled(false);
            if (xo.equals("X")) {
                jogo[0] = "X";
            } else {
                jogo[0] = "O";
            }
            ++numJogadas;
            checaJogo();
        }
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        if (sinal) {
            b2.setText(xo);
            enviarMensagem(xo + "2" + criptografia);
            enviarMensagem("true" + criptografia);
            sinal = false;
            b2.setEnabled(false);
            if (xo.equals("X")) {
                jogo[1] = "X";
            } else {
                jogo[1] = "O";
            }
            ++numJogadas;
            checaJogo();
        }
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        if (sinal) {
            b3.setText(xo);
            enviarMensagem(xo + "3" + criptografia);
            enviarMensagem("true" + criptografia);
            sinal = false;
            b3.setEnabled(false);
            if (xo.equals("X")) {
                jogo[2] = "X";
            } else {
                jogo[2] = "O";
            }
            ++numJogadas;
            checaJogo();
        }
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        if (sinal) {
            b4.setText(xo);
            enviarMensagem(xo + "4" + criptografia);
            enviarMensagem("true" + criptografia);
            sinal = false;
            b4.setEnabled(false);
            if (xo.equals("X")) {
                jogo[3] = "X";
            } else {
                jogo[3] = "O";
            }
            ++numJogadas;
            checaJogo();
        }
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        if (sinal) {
            b5.setText(xo);
            enviarMensagem(xo + "5" + criptografia);
            enviarMensagem("true" + criptografia);
            sinal = false;
            b5.setEnabled(false);
            if (xo.equals("X")) {
                jogo[4] = "X";
            } else {
                jogo[4] = "O";
            }
            ++numJogadas;
            checaJogo();
        }
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        if (sinal) {
            b6.setText(xo);
            enviarMensagem(xo + "6" + criptografia);
            enviarMensagem("true" + criptografia);
            sinal = false;
            b6.setEnabled(false);
            if (xo.equals("X")) {
                jogo[5] = "X";
            } else {
                jogo[5] = "O";
            }
            ++numJogadas;
            checaJogo();
        }
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        if (sinal) {
            b7.setText(xo);
            enviarMensagem(xo + "7" + criptografia);
            enviarMensagem("true" + criptografia);
            sinal = false;
            b7.setEnabled(false);
            if (xo.equals("X")) {
                jogo[6] = "X";
            } else {
                jogo[6] = "O";
            }
            ++numJogadas;
            checaJogo();
        }
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        if (sinal) {
            b8.setText(xo);
            enviarMensagem(xo + "8" + criptografia);
            enviarMensagem("true" + criptografia);
            sinal = false;
            b8.setEnabled(false);
            if (xo.equals("X")) {
                jogo[7] = "X";
            } else {
                jogo[7] = "O";
            }
            ++numJogadas;
            checaJogo();
        }
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        if (sinal) {
            b9.setText(xo);
            enviarMensagem(xo + "9" + criptografia);
            enviarMensagem("true" + criptografia);
            sinal = false;
            b9.setEnabled(false);
            if (xo.equals("X")) {
                jogo[8] = "X";
            } else {
                jogo[8] = "O";
            }
            ++numJogadas;
            checaJogo();
        }
    }//GEN-LAST:event_b9ActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        enviarMensagem("novojogo" + criptografia); // send request to client, for new game

        ++numPartidas;

        for (int i = 0; i < jogo.length; i++) {
            jogo[i] = "";
        }

        if (numPartidas % 2 == 0) {
            sinal = true;
            textArea.append("X joga primeiro!\n");
            ScrollToBottom();
            enviarMensagem("false" + criptografia);
            enviarMensagem("X joga primeiro!");
        } else {
            sinal = false;
            enviarMensagem("true" + criptografia);
            textArea.append("O joga primeiro!\n");
            ScrollToBottom();
            enviarMensagem("O joga primeiro!");
        }

        buttonDefault();
        estadoButton(true);
        newGame.setEnabled(false);

    }//GEN-LAST:event_newGameActionPerformed

    private void joinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinActionPerformed
        try {
            if (nick.getText().equals("") || nick.getText().equals(" ")) {
                try {
                    JOptionPane.showMessageDialog(null, "Você nao colocou seu nick!");
                } catch (ExceptionInInitializerError exc) {
                }
                return;
            }

            sockets = new Socket(ip.getText(), Integer.parseInt(port.getText()));

            saida = new ObjectOutputStream(sockets.getOutputStream());
            saida.flush();
            entrada = new ObjectInputStream(sockets.getInputStream());

            msg = (String) entrada.readObject();
            textArea.append(msg + "\n");
            ScrollToBottom();

            xo = "O";
            sinal = false;

            nick2 = nick.getText();

            msg = (String) entrada.readObject(); // get nick from host
            nick1 = "" + msg;

            enviarMensagem(nick2);

            estadoButton(true);
            message.setEditable(true);

            ip.setEnabled(false);
            port.setEnabled(false);
            nick.setEnabled(false);

            textArea.append("X joga primeiro!\n");
            ScrollToBottom();

            join.setEnabled(false);
            create.setEnabled(false);
            ip.setEnabled(false);
            port.setEnabled(false);
            nick.setEnabled(false);

            new Game.recebeMensagem("Recebe"); // thread for receive data from host		
        } catch (Exception e) {
            encerrarTudo();
            executarTudo();
            try {
                JOptionPane.showMessageDialog(null, "Erro server esta offline: \n" + e);
            } catch (ExceptionInInitializerError exc) {
            }
        }

    }//GEN-LAST:event_joinActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        if (nick.getText().equals("") || nick.getText().equals(" ")) {
            try {
                JOptionPane.showMessageDialog(null, "Você nao colocou seu nick!");
            } catch (ExceptionInInitializerError exc) {
            }
            return;
        }

        new Game.criarThread("CreateButton"); // we need thread while we wait for client, because we don't want frozen frame

    }//GEN-LAST:event_createActionPerformed

    private void messageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            textArea.append(nick.getText() + ":" + message.getText() + "\n");
            ScrollToBottom();
            enviarMensagem(message.getText());
            message.setText(" ");
        }
    }//GEN-LAST:event_messageKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    //funções
    public void inicia() {
        b1.setFont(fontButtons);
        b1.setText("[ 1 ]");
        b2.setFont(fontButtons);
        b2.setText("[ 2 ]");
        b3.setFont(fontButtons);
        b3.setText("[ 3 ]");
        b4.setFont(fontButtons);
        b4.setText("[ 4 ]");
        b5.setFont(fontButtons);
        b5.setText("[ 5 ]");
        b6.setFont(fontButtons);
        b6.setText("[ 6 ]");
        b7.setFont(fontButtons);
        b7.setText("[ 7 ]");
        b8.setFont(fontButtons);
        b8.setText("[ 8 ]");
        b9.setFont(fontButtons);
        b9.setText("[ 9 ]");
        port.setText("5000");
        nick.setText("");
        textArea.append("Mais informações: facebook.com/jonathan.bencke\nDesenvolvido por Jonathan Andriel Bencke.\n");
        textArea.setEditable(false);
        estadoButton(false);

    }
    // --- CREATE BUTTON THREAD ---

    private class criarThread implements Runnable {

        public criarThread(String name) {
            new Thread(this, name).start();
        }

        public void run() {
            try {
                join.setEnabled(false);
                create.setEnabled(false);
                port.setEnabled(false);
                nick.setEnabled(false);

                serverSocket = new ServerSocket(Integer.parseInt(port.getText()));

                textArea.append("Esperando cliente...\n");
                ScrollToBottom();
                sockets = serverSocket.accept();

                saida = new ObjectOutputStream(sockets.getOutputStream());
                saida.flush();
                entrada = new ObjectInputStream(sockets.getInputStream());
                enviarMensagem(nick.getText() + ": conectado com sucesso!");
                textArea.append("Cliente conectado com sucesso!\n");
                ScrollToBottom();

                xo = "X";
                sinal = true;

                nick1 = nick.getText();

                enviarMensagem(nick1);

                msg = (String) entrada.readObject(); // pega o nick do server
                nick2 = "" + msg;

                estadoButton(true);
                message.setEditable(true);
                ip.setEnabled(false);

                textArea.append("X joga primeiro!\n");
                ScrollToBottom();
                new recebeMensagem("recebeData");
            } catch (Exception e) {
                encerrarTudo();
                executarTudo();
                try {
                    JOptionPane.showMessageDialog(null, "Erro ao criar o jogo:\n" + e);
                } catch (ExceptionInInitializerError exc) {
                }
            }
        }
    }

    // --- CHECK FIELDS --- 
    private void checaJogo() {
        // ------_X_X_X_------
        if ( //VERTICAL
                (jogo[0].equals("X") && jogo[1].equals("X") && jogo[2].equals("X"))
                || (jogo[3].equals("X") && jogo[4].equals("X") && jogo[5].equals("X"))
                || (jogo[6].equals("X") && jogo[7].equals("X") && jogo[8].equals("X"))
                || // HORIZONTAL
                (jogo[0].equals("X") && jogo[3].equals("X") && jogo[6].equals("X"))
                || (jogo[1].equals("X") && jogo[4].equals("X") && jogo[7].equals("X"))
                || (jogo[2].equals("X") && jogo[5].equals("X") && jogo[8].equals("X"))
                || //  DIAGONAL
                (jogo[0].equals("X") && jogo[4].equals("X") && jogo[8].equals("X"))
                || (jogo[2].equals("X") && jogo[4].equals("X") && jogo[6].equals("X"))) {
            numJogadas = 0;
            estadoButton(false);
            JOptionPane.showMessageDialog(null, nick1 + " ganhou!");
            if (xo.equals("X")) {
                newGame.setEnabled(true);
            }
        } // ------_O_O_O_------
        else if ( // HORIZONTAL
                (jogo[0].equals("O") && jogo[1].equals("O") && jogo[2].equals("O"))
                || (jogo[3].equals("O") && jogo[4].equals("O") && jogo[5].equals("O"))
                || (jogo[6].equals("O") && jogo[7].equals("O") && jogo[8].equals("O"))
                || //VERTICAL
                (jogo[0].equals("O") && jogo[3].equals("O") && jogo[6].equals("O"))
                || (jogo[1].equals("O") && jogo[4].equals("O") && jogo[7].equals("O"))
                || (jogo[2].equals("O") && jogo[5].equals("O") && jogo[8].equals("O"))
                || //DIAGONAL
                (jogo[0].equals("O") && jogo[4].equals("O") && jogo[8].equals("O"))
                || (jogo[2].equals("O") && jogo[4].equals("O") && jogo[6].equals("O"))) {
            numJogadas = 0;
            estadoButton(false);
            JOptionPane.showMessageDialog(null, nick2 + " ganhou!");
            if (xo.equals("X")) {
                newGame.setEnabled(true);
            }
        } else {

            if (numJogadas >= 9) {
                numJogadas = 0;
                enviarMensagem("desenha!" + criptografia);
                JOptionPane.showMessageDialog(null, "DRAW!");
                if (xo.equals("X")) {
                    newGame.setEnabled(true);
                }
            }
        }
    }

    // --- habilita e desabilita os botoes ---
    private void estadoButton(boolean b) {
        b1.setEnabled(b);
        b2.setEnabled(b);
        b3.setEnabled(b);
        b4.setEnabled(b);
        b5.setEnabled(b);
        b6.setEnabled(b);
        b7.setEnabled(b);
        b8.setEnabled(b);
        b9.setEnabled(b);
    }

    // --- volta padrao os botoes ---
    private void buttonDefault() {
        b1.setText("[ 1 ]");
        b2.setText("[ 2 ]");
        b3.setText("[ 3 ]");
        b4.setText("[ 4 ]");
        b5.setText("[ 5 ]");
        b6.setText("[ 6 ]");
        b7.setText("[ 7 ]");
        b8.setText("[ 8 ]");
        b9.setText("[ 9 ]");
    }

    // --- envia mensagens ---
    private void enviarMensagem(String p) {
        try {
            if (pararSinal) {
                saida.writeObject(p);
                saida.flush();
            }
        } catch (SocketException e) {
            if (pararSinal) {
                pararSinal = false;
                encerrarTudo();
                executarTudo();
            }
        } catch (Exception e) {
            if (pararSinal) {
                pararSinal = false;
                encerrarTudo();
                executarTudo();
                try {
                    JOptionPane.showMessageDialog(null, "Fluxo de dados desconectado:\n" + e);
                } catch (ExceptionInInitializerError exc) {
                }
            }
        }
    }

    // --- recebe messages com thread ---
    private class recebeMensagem implements Runnable {

        private boolean auxsinal;
        private String rmsg;

        public recebeMensagem(String i) {
            auxsinal = true;
            rmsg = i;
            new Thread(this, rmsg).start();
        }

        public void run() {
            while (auxsinal) {
                try {
                    msg = "";
                    msg = (String) entrada.readObject();			// recebe mensagens

                    if (rmsg.equals("Recebe")) // client recebe dados do host/server
                    {
                        if (msg.equalsIgnoreCase("true" + criptografia)) {
                            sinal = true;
                        } else if (msg.equalsIgnoreCase("false" + criptografia)) {
                            sinal = false;
                        } else if (msg.equalsIgnoreCase("desenha!" + criptografia)) {
                            JOptionPane.showMessageDialog(null, "DRAW!");
                        } else if (msg.equalsIgnoreCase("novojogo!" + criptografia)) {
                            for (int i = 0; i < jogo.length; i++) {
                                jogo[i] = "";
                            }
                            sinal = true;
                            buttonDefault();
                            estadoButton(true);
                        } else if (msg.equalsIgnoreCase("X1" + criptografia)) {
                            b1.setText("X");
                            jogo[0] = "X";
                            b1.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("X2" + criptografia)) {
                            b2.setText("X");
                            jogo[1] = "X";
                            b2.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("X3" + criptografia)) {
                            b3.setText("X");
                            jogo[2] = "X";
                            b3.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("X4" + criptografia)) {
                            b4.setText("X");
                            jogo[3] = "X";
                            b4.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("X5" + criptografia)) {
                            b5.setText("X");
                            jogo[4] = "X";
                            b5.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("X6" + criptografia)) {
                            b6.setText("X");
                            jogo[5] = "X";
                            b6.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("X7" + criptografia)) {
                            b7.setText("X");
                            jogo[6] = "X";
                            b7.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("X8" + criptografia)) {
                            b8.setText("X");
                            jogo[7] = "X";
                            b8.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("X9" + criptografia)) {
                            b9.setText("X");
                            jogo[8] = "X";
                            b9.setEnabled(false);
                            checaJogo();
                        } else {
                            if (msg.endsWith(criptografia)) {
                                msg = msg.substring(0, msg.length() - criptografia.length());
                            }
                            textArea.append(nick1 + ":" + msg + "\n");
                            ScrollToBottom();
                        }
                    } else if (rmsg.equals("recebeData")) // host/server recebe dados do client
                    {
                        if (msg.equalsIgnoreCase("true" + criptografia)) {
                            sinal = true;
                        } else if (msg.equalsIgnoreCase("O1" + criptografia)) {
                            ++numJogadas;
                            b1.setText("O");
                            jogo[0] = "O";
                            b1.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("O2" + criptografia)) {
                            ++numJogadas;
                            b2.setText("O");
                            jogo[1] = "O";
                            b2.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("O3" + criptografia)) {
                            ++numJogadas;
                            b3.setText("O");
                            jogo[2] = "O";
                            b3.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("O4" + criptografia)) {
                            ++numJogadas;
                            b4.setText("O");
                            jogo[3] = "O";
                            b4.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("O5" + criptografia)) {
                            ++numJogadas;
                            b5.setText("O");
                            jogo[4] = "O";
                            b5.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("O6" + criptografia)) {
                            ++numJogadas;
                            b6.setText("O");
                            jogo[5] = "O";
                            b6.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("O7" + criptografia)) {
                            ++numJogadas;
                            b7.setText("O");
                            jogo[6] = "O";
                            b7.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("O8" + criptografia)) {
                            ++numJogadas;
                            b8.setText("O");
                            jogo[7] = "O";
                            b8.setEnabled(false);
                            checaJogo();
                        } else if (msg.equalsIgnoreCase("O9" + criptografia)) {
                            ++numJogadas;
                            b9.setText("O");
                            jogo[8] = "O";
                            b9.setEnabled(false);
                            checaJogo();
                        } else {
                            if (msg.endsWith(criptografia)) {
                                msg = msg.substring(0, msg.length() - criptografia.length());
                            }
                            textArea.append(nick2 + ":" + msg + "\n");
                            ScrollToBottom();
                        }
                    }
                } catch (Exception e) {
                    auxsinal = false;
                    encerrarTudo();
                    executarTudo();
                    try {
                        JOptionPane.showMessageDialog(null, "Receiving Data Failed/Disconnect:\n" + e);
                    } catch (ExceptionInInitializerError exc) {
                    }
                }
            }
        }
    }

    // --- restart estado inicial ---
    private void executarTudo() {
        buttonDefault();
        estadoButton(false);

        msg = "";
        xo = "";
        pararSinal = true;
        numJogadas = 0;
        numPartidas = 0;

        for (int i = 0; i < jogo.length; i++) {
            jogo[i] = "";
        }

        ip.setEnabled(true);
        port.setEnabled(true);
        nick.setEnabled(true);
        create.setEnabled(true);
        join.setEnabled(true);

        newGame.setEnabled(false);
        message.setEditable(false);
    }

    // ---fecha todos fluxos ---
    private void encerrarTudo() {
        try {
            saida.flush();
        } catch (Exception e) {
        }
        try {
            saida.close();
        } catch (Exception e) {
        }
        try {
            entrada.close();
        } catch (Exception e) {
        }
        try {
            serverSocket.close();
        } catch (Exception e) {
        }
        try {
            sockets.close();
        } catch (Exception e) {
        }
    }

    // --- acompanha o chat ---
    public void ScrollToBottom() {
        textArea.setCaretPosition(textArea.getText().length());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton create;
    private javax.swing.JTextField ip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton join;
    private javax.swing.JTextField message;
    private javax.swing.JButton newGame;
    private javax.swing.JTextField nick;
    private javax.swing.JTextField port;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
