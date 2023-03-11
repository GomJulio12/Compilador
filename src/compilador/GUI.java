package compilador;
import java.awt.Color;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

public class GUI extends javax.swing.JFrame {

    public GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LÍNEA " + cont + "\t\tSÍMBOLO\n";
        while (true) {
            Token token = lexer.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case LINEA -> {
                    cont++;
                    resultado += "LÍNEA " + cont + "\n";
                }
                case LLAVEAPERTURA -> resultado += "  <LLave de apertura>\t\t" + lexer.lexeme + "\n";
                case LLAVECIERRE -> resultado += "  <Llave de cierre\t" + lexer.lexeme + "\n";
                case PARENTESISAPERTURA -> resultado += "  <Paréntesis de apertura>\t" + lexer.lexeme + "\n";
                case PARENTESISCIERRE -> resultado += "  <Paréntesis de cierre>\t" + lexer.lexeme + "\n";
                case CORCHETEAPERTURA -> resultado += "  <Corchete de apertura>\t" + lexer.lexeme + "\n";
                case CORCHETECIERRE -> resultado += "  <Corchete de cierre>\t" + lexer.lexeme + "\n";
                case COMILLAS -> resultado += "  <Comillas>\t" + lexer.lexeme + "\n";
                case PUNTOYCOMA -> resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
                case DOSPUNTOS -> resultado += "  <Dos puntos>\t" + lexer.lexeme + "\n";
                case PUNTO -> resultado += "  <Punto>\t" + lexer.lexeme + "\n";
                case IDENTIFICADOR -> resultado += "  <Identificador>\t" + lexer.lexeme + "\n";
                case OPERADOR_INCREMENTO -> resultado += "  <Incremento>\t" + lexer.lexeme + "\n";
                case OPERADOR_POSITIVO -> resultado += "  <Suma>\t" + lexer.lexeme + "\n";
                case OPERADOR_IGUAL -> resultado += "  <Igual>\t" + lexer.lexeme + "\n";
                case OPERADOR_RELACIONAL -> resultado += "  <Operador relacional>\t" + lexer.lexeme + "\n";
                case TIPO_DATO -> resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                case RESERVADA -> resultado += "  <Palabra reservada>\t" + lexer.lexeme + "\n";
                case VARIABLE -> resultado += "  <Variable>\t" + lexer.lexeme + "\n";
                case NUMERO -> resultado += "  <Número>\t" + lexer.lexeme + "\n";
                case ERROR -> resultado += "  <Error>\n";
                default -> resultado += "  < " + lexer.lexeme + " >\n";
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnAnalizarLex = new javax.swing.JButton();
        btnAnalizarSin = new javax.swing.JButton();
        btnLimpiarSin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        btnLimpiarLex = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtResultado.setColumns(20);
        txtResultado.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 350, 240));

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 390, 240));

        btnAnalizarLex.setBackground(new java.awt.Color(16, 161, 157));
        btnAnalizarLex.setFont(new java.awt.Font("MKOCR", 1, 12)); // NOI18N
        btnAnalizarLex.setForeground(new java.awt.Color(255, 255, 255));
        btnAnalizarLex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/analisisSintactico.png"))); // NOI18N
        btnAnalizarLex.setText("Analizar");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnalizarLex, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 120, 30));

        btnAnalizarSin.setBackground(new java.awt.Color(251, 194, 82));
        btnAnalizarSin.setFont(new java.awt.Font("MKOCR", 1, 12)); // NOI18N
        btnAnalizarSin.setForeground(new java.awt.Color(0, 0, 0));
        btnAnalizarSin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/analisisLexico.png"))); // NOI18N
        btnAnalizarSin.setText("Analizar");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnalizarSin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 120, 30));

        btnLimpiarSin.setBackground(new java.awt.Color(238, 238, 238));
        btnLimpiarSin.setFont(new java.awt.Font("MKOCR", 1, 12)); // NOI18N
        btnLimpiarSin.setForeground(new java.awt.Color(51, 51, 51));
        btnLimpiarSin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar (1).png"))); // NOI18N
        btnLimpiarSin.setText("Limpiar");
        btnLimpiarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSinActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiarSin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 120, 30));

        jLabel1.setFont(new java.awt.Font("MKOCR", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Analizador Léxico");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 780, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("MKOCR", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Analizador Sintático");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 340, 780, -1));

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 610, 120));

        btnLimpiarLex.setBackground(new java.awt.Color(238, 238, 238));
        btnLimpiarLex.setFont(new java.awt.Font("MKOCR", 1, 12)); // NOI18N
        btnLimpiarLex.setForeground(new java.awt.Color(51, 51, 51));
        btnLimpiarLex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar (1).png"))); // NOI18N
        btnLimpiarLex.setText("Limpiar");
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarLex, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 130, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed

        txtAnalizarLex.setText(null);
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    private void btnLimpiarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSinActionPerformed
        // TODO add your handling code here:
        txtAnalizarSin.setText(null);
    }//GEN-LAST:event_btnLimpiarSinActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
         // TODO add your handling code here:
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new compilador.LexerCup(new StringReader(ST)));
        
        try {
            s.parse  ();
               txtAnalizarSin.setText("Análisis totalmente correcto");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error Sintactico - Línea: " + (sym.right + 1) + " , Columna: " + (sym.left + 1) + ". Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton btnLimpiarSin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
