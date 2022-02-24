package s19241.mas.project.cinemaapp.gui.view;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@Data
public class ConfirmationPageView {
    private JPanel panel1;
    private JButton Cancel;
    private JButton Confirm;
    private JLabel text;
}
