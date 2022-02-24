package s19241.mas.project.cinemaapp.gui.view;

import lombok.Data;
import org.springframework.stereotype.Component;
import s19241.mas.project.cinemaapp.model.Film;
import s19241.mas.project.cinemaapp.model.Seat;
import s19241.mas.project.cinemaapp.model.Session;

import javax.swing.*;

@Component
@Data
public class SeatListView {
    private JPanel panel1;
    private JList seatList;
    private JButton next;

    private void createUIComponents() {
        seatList = new JList<Seat>();
        seatList.setCellRenderer(new SeatListView.SeatListCellRenderer());
        seatList.setModel(new DefaultListModel<Seat>());
    }

    private class SeatListCellRenderer extends JLabel implements ListCellRenderer<Seat> {

        public SeatListCellRenderer() {
            setOpaque(true);
        }

        @Override
        public java.awt.Component getListCellRendererComponent(JList<? extends Seat> list, Seat value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(Integer.toString(value.getSeatNumber()));
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
