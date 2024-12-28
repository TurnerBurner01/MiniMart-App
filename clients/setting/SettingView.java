package clients.setting;

import middle.MiddleFactory;

import javax.swing.*;
import java.awt.*;

public class SettingView {

    private static final int H = 300;
    private static final int W = 400;

    public SettingView(RootPaneContainer rpc, MiddleFactory mf, int x, int y) {

        Container cp         = rpc.getContentPane();
        Container rootWindow = (Container) rpc;
        cp.setLayout(null);

        rootWindow.setSize( W, H );
        rootWindow.setLocation( x, y );

    }
}
