package com.fancystore.behavioural.memento.texteditor;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextEditorExample extends JFrame implements ActionListener {
    JTextArea t;
    JFrame f;

    private JMenu setFileMenu() {
        JMenu m1 = new JMenu("File");
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi9 = new JMenuItem("Print");
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi9.addActionListener(this);
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi9);
        return  m1;
    }

    private JMenu setEditMenu() {
        JMenu m1 = new JMenu("Edit");
        m1.add(new JMenu("Cut"));
        m1.add(new JMenu("copy"));
        m1.add(new JMenu("paste"));
        return  m1;
    }

    private void setKeyListener(JFrame frame) {
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
                    System.out.println("ctl + z pressed");
                }
            }
        });
    }

    private void setupTextEditor() {
        f = new JFrame("editor");
        try {
            // Set metal look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

            // Set theme to ocean
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }
        catch (Exception e) {}
        t = new JTextArea();
        t.setLineWrap(true);
        JMenuBar mb = new JMenuBar();
        mb.add(this.setFileMenu());
        mb.add(this.setEditMenu());
        JMenuItem mc = new JMenuItem("close");
        mc.addActionListener(this);
        mb.add(mc);
        setKeyListener(f);
        f.setJMenuBar(mb);
        f.add(t);
        f.setSize(500, 500);
        f.show();
    }

    public TextEditorExample() throws HeadlessException {
        this.setupTextEditor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        TextEditorExample textEditorExample = new TextEditorExample();
    }
}
