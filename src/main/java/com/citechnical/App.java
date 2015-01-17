package com.citechnical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;


public class App extends JFrame {

    public App() {

        initUI();
    }

    private void initUI() {

        JMenuBar menubar = new JMenuBar();
        ImageIcon iconNew = new ImageIcon("new.png");
        ImageIcon iconOpen = new ImageIcon("open.png");
        ImageIcon iconSave = new ImageIcon("save.png");
        ImageIcon iconExit = new ImageIcon("exit.png");
        ImageIcon iconLock = new ImageIcon("images/Lock.png");
        ImageIcon iconKey = new ImageIcon("images/Key.png");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenu imp = new JMenu("Passwords");
        imp.setMnemonic(KeyEvent.VK_M);

        JMenuItem encrypt = new JMenuItem("Encrypt Password...", iconLock);
        encrypt.setMnemonic(KeyEvent.VK_E);
        encrypt.setToolTipText("Encrypt Password");
        encrypt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
                ActionEvent.CTRL_MASK));

        encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Selected Encrypt Password");
                //System.exit(0);
                EncryptDialog dialog = new EncryptDialog();
            }
        });



        JMenuItem decrypt = new JMenuItem("Decrypt Password...", iconKey);
        decrypt.setMnemonic(KeyEvent.VK_D);
        decrypt.setToolTipText("Encrypt Password");
        decrypt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
                ActionEvent.CTRL_MASK));

        decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Selected Decrypt Password");
                DecryptDialog dialog = new DecryptDialog();
            }
        });


        imp.add(encrypt);
        imp.add(decrypt);

        JMenuItem fileNew = new JMenuItem("New", iconNew);
        fileNew.setMnemonic(KeyEvent.VK_N);

        JMenuItem fileOpen = new JMenuItem("Open", iconOpen);
        fileNew.setMnemonic(KeyEvent.VK_O);

        JMenuItem fileSave = new JMenuItem("Save", iconSave);
        fileSave.setMnemonic(KeyEvent.VK_S);

        JMenuItem fileExit = new JMenuItem("Exit", iconExit);
        fileExit.setMnemonic(KeyEvent.VK_C);
        fileExit.setToolTipText("Exit application");
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
            ActionEvent.CTRL_MASK));

        fileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        file.add(fileNew);
        file.add(fileOpen);
        file.add(fileSave);
        file.addSeparator();
        file.add(imp);
        file.addSeparator();
        file.add(fileExit);

        menubar.add(file);

        setJMenuBar(menubar);

        setTitle("Cyptography WorkCenter");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                App ex = new App();
                ex.setVisible(true);
            }
        });
    }
}