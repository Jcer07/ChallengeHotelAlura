package com.hotelalura.miscomponentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyTextField extends JTextField {

	public Icon getPrefixIcon() {
        return prefixIcon;
    }

    public void setPrefixIcon(Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
        initBorder();
    }

    private Icon prefixIcon;

    public MyTextField() {
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintIcon(g);
        
        g.setColor(new Color(142, 142, 142));
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        g.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
        
    }

    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (prefixIcon != null) {
            Image prefix = ((ImageIcon) prefixIcon).getImage();
            int y = (getHeight() - prefixIcon.getIconHeight()) / 2;
            g2.drawImage(prefix, 3, y, this);
        }
    }

    private void initBorder() {
        int left = 5;
        int right = 5;
        //  5 is default
        if (prefixIcon != null) {
            //  prefix is left
            left = prefixIcon.getIconWidth() + 5;
        }
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, left, 5, right));
    }
}
