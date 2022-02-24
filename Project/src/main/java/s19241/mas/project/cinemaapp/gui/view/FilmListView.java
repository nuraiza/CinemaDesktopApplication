package s19241.mas.project.cinemaapp.gui.view;

import lombok.Data;
import org.springframework.stereotype.Component;
import s19241.mas.project.cinemaapp.model.Film;

import javax.swing.*;

@Component
@Data
public class FilmListView {
    private JPanel mainPanel;
    private JList filmList;
    private JLabel selectedFilm;
    private JButton next;

    private void createUIComponents() {
        filmList = new JList<Film>();
        filmList.setCellRenderer(new FilmListCellRenderer());
        filmList.setModel(new DefaultListModel<Film>());

    }

    private class FilmListCellRenderer extends JLabel implements ListCellRenderer<Film> {

        public FilmListCellRenderer() {
            setOpaque(true);
        }

        @Override
        public java.awt.Component getListCellRendererComponent(JList<? extends Film> list, Film value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.getName());
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
