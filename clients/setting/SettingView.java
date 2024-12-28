package clients.setting;

import middle.MiddleFactory;
import javax.swing.*;
import java.awt.*;

public class SettingView {

    private static final int H = 300;
    private static final int W = 400;

    private final JLabel        pageTitle = new JLabel();

    public SettingView(RootPaneContainer rpc, MiddleFactory mf, int x, int y) {

        Container cp         = rpc.getContentPane();
        Container rootWindow = (Container) rpc;
        cp.setLayout(null);

        rootWindow.setSize( W, H );
        rootWindow.setLocation( x, y );

        // Add the page title
        pageTitle.setBounds(150, 0, 270, 20);
        pageTitle.setText("Settings Page");
        cp.add(pageTitle);
    }
}
