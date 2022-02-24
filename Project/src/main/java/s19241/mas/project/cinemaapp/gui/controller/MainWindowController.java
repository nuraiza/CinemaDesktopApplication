package s19241.mas.project.cinemaapp.gui.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import s19241.mas.project.cinemaapp.gui.view.*;
import s19241.mas.project.cinemaapp.model.Film;
import s19241.mas.project.cinemaapp.model.Seat;
import s19241.mas.project.cinemaapp.model.Session;
import s19241.mas.project.cinemaapp.model.User;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Controller
@RequiredArgsConstructor
public class MainWindowController {
    private final MainWindowView view;
    private final FilmListWindowController filmListWindowController;
    private final FilmListView filmListView;
    private final SessionListWindowController sessionListWindowController;
    private final SessionListView sessionListView;
    private final SeatListWindowController seatListWindowController;
    private final SeatListView seatListView;
    private final ConfirmationPageController confirmationPageController;
    private final ConfirmationPageView confirmationPageView;


    public void showGUI() {
        view.setVisible(true);
    }

    @PostConstruct
    private void initPanelListeners() {
        view.getBuyATicket().addActionListener(e -> {
            filmListWindowController.showGUI(this);
        });
        filmListView.getNext().addActionListener(e -> {
            Film f = (Film) filmListView.getFilmList().getSelectedValue();
            sessionListWindowController.showGUI(this, f.getId());
        });
        sessionListView.getNext().addActionListener(e -> {
            Session s = (Session) sessionListView.getSessionList().getSelectedValue();
            seatListWindowController.showGUI(this, s.getId(), s.getHall().getId());
        });
        seatListView.getNext().addActionListener(e -> {
            Seat seat = (Seat) seatListView.getSeatList().getSelectedValue();
            Session session = (Session) sessionListView.getSessionList().getSelectedValue();
            confirmationPageController.showGUI(this, seat, session);
        });
        confirmationPageView.getCancel().addActionListener(e -> {
            showView(view.getMainPanel());
        });

    }


    public void showView(JPanel viewToShow) {
        view.getContentPane().removeAll();
        view.setContentPane(viewToShow);
        view.revalidate();
    }


}

