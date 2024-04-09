package inlike.qr.kiarelemb.window;

import inlike.qr.kiarelemb.component.ExitButton;
import inlike.qr.kiarelemb.component.InputTextArea;
import inlike.qr.kiarelemb.component.TextArea;
import method.qr.kiarelemb.utils.QRFileUtils;
import method.qr.kiarelemb.utils.QRPropertiesUtils;
import method.qr.kiarelemb.utils.QRSystemUtils;
import swing.qr.kiarelemb.QRSwing;
import swing.qr.kiarelemb.component.basic.QRLabel;
import swing.qr.kiarelemb.component.basic.QRPanel;
import swing.qr.kiarelemb.theme.QRColorsAndFonts;
import swing.qr.kiarelemb.window.basic.QREmptyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

/**
 * @author Kiarelemb
 * @projectName QR_InputLike
 * @className MainWindow
 * @description TODO
 * @create 2024/4/9 21:06
 */
public class MainWindow extends QREmptyDialog {
    public static final MainWindow INSTANCE = new MainWindow();

    private final int width = 160;
    private final int height = 45;
    private final Properties prop;

    private final QRPanel mainPanel;
    private MainWindow() {
        super(null, false);

        QRFileUtils.fileCreate(QRSwing.WINDOW_PROP_PATH);
        this.prop = QRPropertiesUtils.loadProp(QRSwing.WINDOW_PROP_PATH);
        //region 加载资源
        final int[] screenSize = QRSystemUtils.getScreenSize();
        int locationX = QRPropertiesUtils.getPropInInteger(prop, "window.start.X", screenSize[0] / 4);
        int locationY = QRPropertiesUtils.getPropInInteger(prop, "window.start.Y", screenSize[1] / 4);
        //固定窗体大小
        super.setSize(width, height);
        super.setLocation(locationX, locationY);
        //endregion

        mainPanel = new QRPanel();

        mainPanel.setLayout(new BorderLayout());
        contentPane.setLayout(new BorderLayout());
        contentPane.add(mainPanel, BorderLayout.WEST);
        mainPanel.add(InputTextArea.INPUT_TEXT_AREA, BorderLayout.CENTER);
        mainPanel.add(ExitButton.EXIT_BUTTON, BorderLayout.WEST);

        QRSwing.registerSystemExitAction(e -> {
            int x = getX();
            int y = getY();
            this.prop.setProperty("window.size.width", String.valueOf(width));
            this.prop.setProperty("window.size.height", String.valueOf(height));
            this.prop.setProperty("window.start.X", Integer.toString(x));
            this.prop.setProperty("window.start.Y", Integer.toString(y));
            //保存
            QRPropertiesUtils.storeProp(this.prop, QRSwing.WINDOW_PROP_PATH);
        });
    }
}