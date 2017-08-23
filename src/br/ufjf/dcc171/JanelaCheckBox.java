package br.ufjf.dcc171;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

class JanelaCheckBox extends JFrame {
    
    private final JCheckBox checkNegrito = new JCheckBox("Negrito");
    private final JCheckBox checkItalico = new JCheckBox("Itálico");
    private final JTextField txt = new JTextField(15);
    
    public JanelaCheckBox() throws HeadlessException {
        super("Check Box");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        txt.setText("Olá");
        txt.setFont(new Font(Font.SERIF, Font.PLAIN, 14));
        
        add(txt);
        add(checkNegrito);
        add(checkItalico);
        
        TrocaFonte trocaFonte = new TrocaFonte();
        
        checkNegrito.addItemListener(trocaFonte);
        checkItalico.addItemListener(trocaFonte);
    }
    
    private class TrocaFonte implements ItemListener {
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            Font font = null;
            if (checkNegrito.isSelected() && checkItalico.isSelected()) {
                font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 14);
            } else if (checkNegrito.isSelected()) {
                font = new Font(Font.SERIF, Font.BOLD, 14);
            } else if (checkItalico.isSelected()) {
                font = new Font(Font.SERIF, Font.ITALIC, 14);
            } else {
                font = new Font(Font.SERIF, Font.PLAIN, 14);
            }
            txt.setFont(font);
        }
        
    }
}
