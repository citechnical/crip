/******************************************************************************
 * Copyright (c) 2014,2015 CITechnical.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License.
 *
 * Contributors:
 *    dlwhitehurst - David L. Whitehurst
 *
 *******************************************************************************
 */

package org.citechnical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
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
        ImageIcon iconLock = fetchImageIcon("/Lock.png", this.getClass());
        ImageIcon iconKey = fetchImageIcon("/Key.png",this.getClass());

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

    private static ImageIcon fetchImageIcon(String aImageId, Class<?> aClass){
      URL imageURL = aClass.getResource(aImageId);
      if ( imageURL != null ) {
        return new ImageIcon(imageURL);
      }
      else {
        throw new IllegalArgumentException("Cannot retrieve image using id: " + aImageId);
      }
    }

}