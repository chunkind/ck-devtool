package com.ck.pr.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DevToolGUI extends JFrame{
    public DevToolGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("개발 도구");
        setLayout(new FlowLayout());
        
        JPanel mainPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel midlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        
        topPanel.setBackground(Color.blue);
        midlePanel.setBackground(Color.cyan);
        bottomPanel.setBackground(Color.green);
        
        mainPanel.add(topPanel);
        mainPanel.add(midlePanel);
        mainPanel.add(bottomPanel);
        
        setSize(1400, 800);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new DevToolGUI();
    }
}
