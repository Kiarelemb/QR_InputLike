package inlike.qr.kiarelemb;

import inlike.qr.kiarelemb.window.MainWindow;
import swing.qr.kiarelemb.QRSwing;

import java.awt.*;

/**
 * @author Kiarelemb
 * @projectName QR_InputLike
 * @className Enter
 * @description 入口类
 * @create 2024/4/9 20:36
 */
public class Enter {
    public static void main(String[] args) {
        Toolkit.getDefaultToolkit().sync();
        QRSwing.start("res/settings/setting.properties", "res/settings/window.properties");
        QRSwing.setWindowRound(false);
        QRSwing.windowIcon = null;
        QRSwing.setWindowTransparency(1f);
        MainWindow.INSTANCE.setVisible(true);
    }
}