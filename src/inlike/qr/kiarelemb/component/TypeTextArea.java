package inlike.qr.kiarelemb.component;

import method.qr.kiarelemb.utils.QRFontUtils;
import swing.qr.kiarelemb.component.basic.QRTextArea;
import swing.qr.kiarelemb.component.basic.QRTextPane;

import java.awt.*;

/**
 * @author Kiarelemb
 * @projectName QR_InputLike
 * @className TypeTextArea
 * @description TODO
 * @create 2024/4/9 21:19
 */
public class TypeTextArea extends QRTextArea {

    public static final Font FONT = QRFontUtils.getFont("Consolas", 18);
    public static final TypeTextArea TYPE_TEXT_AREA = new TypeTextArea();

    private TypeTextArea() {
        setMargin(new Insets(8, QRTextPane.INSECT, 5, QRTextPane.INSECT));
        setPreferredSize(new Dimension(85, 45));
    }

    @Override
    public void componentFresh() {
        super.componentFresh();
        setFont(FONT);
    }
}