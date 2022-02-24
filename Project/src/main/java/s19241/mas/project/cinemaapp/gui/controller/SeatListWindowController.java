package s19241.mas.project.cinemaapp.gui.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import s19241.mas.project.cinemaapp.gui.view.SeatListView;
import s19241.mas.project.cinemaapp.model.Seat;
import s19241.mas.project.cinemaapp.model.Session;
import s19241.mas.project.cinemaapp.service.SeatService;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SeatListWindowController {
    private final SeatListView view;
    private final SeatService seatService;


    public void showGUI(MainWindowController mainController, Long session_id, Long hall_id) {
        updateSeatsFromDB(session_id, hall_id);
        mainController.showView(view.getPanel1());
    }

    private void updateSeatsFromDB(Long session_id, Long hall_id) {
        List<Seat> seats = seatService.getAvailableSeatBySessionId(session_id, hall_id);
        if (seats.size() == 0) {
            JOptionPane.showMessageDialog(view.getPanel1(), "No available seats for selected session!");
        }
        DefaultListModel<Seat> model = (DefaultListModel<Seat>) view.getSeatList().getModel();
        model.removeAllElements();
        seats.forEach(model::addElement);
    }

    @PostConstruct
    public void initListeners() {
        view.getSeatList().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Seat selectedValue = (Seat) view.getSeatList().getSelectedValue();
                System.out.println("Seat selected: " + Integer.toString(selectedValue.getSeatNumber()));

            }
        });
    }

}
