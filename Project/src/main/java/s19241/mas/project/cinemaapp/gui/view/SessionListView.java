package s19241.mas.project.cinemaapp.gui.view;

import lombok.Data;
import org.springframework.stereotype.Component;
import s19241.mas.project.cinemaapp.model.Film;
import s19241.mas.project.cinemaapp.model.Session;

import javax.swing.*;
import java.time.LocalDate;


@Component
@Data
public class SessionListView {
    private JPanel panel1;
    private JList sessionList;
    private JButton next;

    private void createUIComponents() {
        sessionList = new JList<Film>();
        sessionList.setCellRenderer(new SessionListView.SessionListCellRenderer());
        sessionList.setModel(new DefaultListModel<Session>());

    }


    private class SessionListCellRenderer extends JLabel implements ListCellRenderer<Session> {

        public SessionListCellRenderer() {
            setOpaque(true);
        }

        @Override
        public java.awt.Component getListCellRendererComponent(JList<? extends Session> list, Session value, int index, boolean isSelected, boolean cellHasFocus) {
            String date = value.getStartingDateTime().getYear() + "-" + value.getStartingDateTime().getMonth() + "-" + value.getStartingDateTime().getDayOfMonth();
            String time = value.getStartingDateTime().getHour() + ":" + value.getStartingDateTime().getMinute();
            setText("Cinema: " + value.getHall().getCinema().getName() + "  Address: " + value.getHall().getCinema().getAddress() + "    Hall: " + value.getHall().getName() + "   Date: " +
                    date + "   Time: " + time);
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            return this;
        }
    }
}
