//package convertidorjavahtml;

import java.awt.Color;
import java.awt.FontMetrics;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.PlainDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

/**
 *
 * @author kirk
 */

public class Menu extends javax.swing.JFrame {
    Analizador analizador;
    StyleContext sc;
    DefaultStyledDocument doc;
    DefaultStyledDocument doc2;
    
    public Menu() {
        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        analizador = new Analizador();
        
        sc = new StyleContext();
        doc = new DefaultStyledDocument(sc);
        doc2 = new DefaultStyledDocument(sc);
        doc.putProperty(PlainDocument.tabSizeAttribute, 2);
        
        editor.setDocument(doc);
        
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontSize(attribs, 14);
        StyleConstants.setFontFamily(attribs, "Microsoft JhengHei Light");
        StyleConstants.setForeground(attribs, Color.white);
        //StyleConstants.setBold(attribs, true);
        listaLineas.setDocument(doc2);
        
        listaLineas.setParagraphAttributes(attribs,true);
        // # Funciones para el editor
        editor.requestFocus();
        scrollLineas.setVisible(false);
        listaLineas.setText("1");
        setTabs(editor, 3);
        editor.setText("//hola");
        //editor.setCaretPosition(editor.getText().length());
        
    }
    
    int rows = 1, linePos = 1, line;
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaLineas = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        editor = new javax.swing.JTextPane();
        scrollEditor = new javax.swing.JScrollBar();
        scrollLineas = new javax.swing.JScrollBar();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        editor1 = new javax.swing.JTextPane();
        scrollEditor1 = new javax.swing.JScrollBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 10));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel11.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 41, 35)));
        jScrollPane2.setForeground(new java.awt.Color(40, 41, 35));
        jScrollPane2.setHorizontalScrollBar(null);
        jScrollPane2.setVerticalScrollBar(scrollLineas);

        listaLineas.setEditable(false);
        listaLineas.setBackground(new java.awt.Color(40, 41, 35));
        listaLineas.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        listaLineas.setForeground(new java.awt.Color(255, 255, 255));
        listaLineas.setPreferredSize(new java.awt.Dimension(35, 6));
        listaLineas.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(listaLineas);

        jPanel11.add(jScrollPane2, java.awt.BorderLayout.WEST);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 41, 35)));
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane5.setHorizontalScrollBar(null);
        jScrollPane5.setVerticalScrollBar(scrollEditor);

        editor.setBackground(new java.awt.Color(40, 41, 35));
        editor.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        editor.setForeground(new java.awt.Color(255, 255, 255));
        editor.setCaretColor(new java.awt.Color(255, 255, 255));
        editor.setSelectionColor(new java.awt.Color(153, 153, 153));
        editor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                editorCaretUpdate(evt);
            }
        });
        editor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                editorPropertyChange(evt);
            }
        });
        editor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editorKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editorKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(editor);

        jPanel11.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        scrollEditor.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                scrollEditorAdjustmentValueChanged(evt);
            }
        });
        jPanel11.add(scrollEditor, java.awt.BorderLayout.LINE_END);

        scrollLineas.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        scrollLineas.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                scrollLineasAdjustmentValueChanged(evt);
            }
        });
        jPanel11.add(scrollLineas, java.awt.BorderLayout.PAGE_END);

        jPanel4.add(jPanel11);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.add(jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 10));

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jPanel12.setLayout(new java.awt.BorderLayout());

        jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 41, 35)));
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane6.setHorizontalScrollBar(null);
        jScrollPane6.setVerticalScrollBar(scrollEditor1);

        editor1.setBackground(new java.awt.Color(40, 41, 35));
        editor1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 14)); // NOI18N
        editor1.setForeground(new java.awt.Color(255, 255, 255));
        editor1.setCaretColor(new java.awt.Color(255, 255, 255));
        editor1.setSelectionColor(new java.awt.Color(153, 153, 153));
        editor1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                editor1CaretUpdate(evt);
            }
        });
        editor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editor1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editor1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editor1KeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(editor1);

        jPanel12.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        scrollEditor1.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                scrollEditor1AdjustmentValueChanged(evt);
            }
        });
        jPanel12.add(scrollEditor1, java.awt.BorderLayout.LINE_END);

        jPanel5.add(jPanel12);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_editorCaretUpdate
        int len = editor.getText().length();
        int cont = 1;
        for (int i = 0; i < len; i++) {
            if (editor.getText().charAt(i) == '\n') {
                cont++;
            }
        }
        refreshList2(cont);
    }//GEN-LAST:event_editorCaretUpdate

    private void editorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editorKeyPressed
        //System.out.println(evt.getKeyCode());
        String tmp = analizador.analizar(editor.getText());
        editor1.setText(tmp);
        
    }//GEN-LAST:event_editorKeyPressed

    private void editorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editorKeyReleased
        //control.compilar(editor.getText());
        //pintarTodo();
        //pintarErrores();
    }//GEN-LAST:event_editorKeyReleased

    private void editorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editorKeyTyped
        //pintarTodo();
        //pintarErrores();
    }//GEN-LAST:event_editorKeyTyped

    private void scrollEditorAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_scrollEditorAdjustmentValueChanged
        scrollLineas.setValue(evt.getValue());
    }//GEN-LAST:event_scrollEditorAdjustmentValueChanged

    private void scrollLineasAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_scrollLineasAdjustmentValueChanged
        scrollLineas.setValue(scrollEditor.getValue());
    }//GEN-LAST:event_scrollLineasAdjustmentValueChanged

    private void editor1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_editor1CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_editor1CaretUpdate

    private void editor1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editor1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_editor1KeyPressed

    private void editor1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editor1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_editor1KeyReleased

    private void editor1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editor1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_editor1KeyTyped

    private void scrollEditor1AdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_scrollEditor1AdjustmentValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_scrollEditor1AdjustmentValueChanged

    private void editorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_editorPropertyChange
        System.out.println("El valor a cambiado: "+evt.getPropertyName());
    }//GEN-LAST:event_editorPropertyChange

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        editor.setText(analizador.abrirArchivo());
        int len = editor.getText().length();
        int cont = 1;
        for (int i = 0; i < len; i++) {
            if (editor.getText().charAt(i) == '\n') {
                cont++;
            }
        }
        //this.setTitle("Compilador  - "+control.getNameFile());
        refreshList2(cont);
        //pintarTodo();
        editor.requestFocus();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    public void refreshList2(int num){
        String tmp = "";
        if (num > rows) {
            rows = num;
            for (int i = 0; i < num; i++) {
                if (i+1 == num) {
                    tmp += i+1; 
                }else{
                    tmp += (i+1)+"\n";
                }
            }
            listaLineas.setText(tmp);
        }else{
            if (num < rows) {
                rows = num;
                for (int i = 0; i < num; i++) {
                    if (i+1 == num) {
                        tmp += i+1; 
                    }else{
                        tmp += (i+1)+"\n";
                    }
                }
                listaLineas.setText(tmp);
            }
        }
        /*
        // Informacion de linea y columna en el editors
        linePos = editor.getCaretPosition();
        try {
            line = editor.getLineOfOffset(linePos);
            labelLineas.setText("Linea: "+(line+1));
            int colum = linePos - editor.getLineStartOffset(line);
            labelColumna.setText("Columna: "+(colum+1));
        } catch (BadLocationException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
    
    public void setTabs(JTextPane textPane, int charactersPerTab){
        FontMetrics fm = textPane.getFontMetrics( textPane.getFont() );
        //System.out.println("Font: "+fm.getFont());
        int charWidth = fm.charWidth( 'w' );
        int tabWidth = charWidth * charactersPerTab;
        
        TabStop[] tabs = new TabStop[10];

        for (int j = 0; j < tabs.length; j++){
             int tab = j + 1;
             tabs[j] = new TabStop( tab * tabWidth );
        }
        TabSet tabSet = new TabSet(tabs);
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setTabSet(attributes, tabSet);
        StyleConstants.setFontSize(attributes, 14);
        StyleConstants.setForeground(attributes, Color.white);
        StyleConstants.setFontFamily(attributes, "Microsoft JhengHei Light");
        
        int length = textPane.getDocument().getLength();
        textPane.getStyledDocument().setParagraphAttributes(0, length, attributes, true);
     }
    
    
    
    
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane editor;
    private javax.swing.JTextPane editor1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane listaLineas;
    private javax.swing.JScrollBar scrollEditor;
    private javax.swing.JScrollBar scrollEditor1;
    private javax.swing.JScrollBar scrollLineas;
    // End of variables declaration//GEN-END:variables
}
