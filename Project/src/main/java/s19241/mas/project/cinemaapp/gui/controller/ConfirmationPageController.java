package s19241.mas.project.cinemaapp.gui.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import s19241.mas.project.cinemaapp.gui.view.ConfirmationPageView;
import s19241.mas.project.cinemaapp.gui.view.MainWindowView;
import s19241.mas.project.cinemaapp.model.Seat;
import s19241.mas.project.cinemaapp.model.Session;
import s19241.mas.project.cinemaapp.model.Ticket;
import s19241.mas.project.cinemaapp.model.User;
import s19241.mas.project.cinemaapp.service.TicketService;
import s19241.mas.project.cinemaapp.service.UserService;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ConfirmationPageController {
    private final ConfirmationPageView view;
    private final TicketService ticketService;
    private final UserService userService;
    private Seat seat;
    private Session session;
    private final MainWindowView mainWindowView;


    public void showGUI(MainWindowController mainController, Seat seat, Session session) {
        updateConfirmationPage(seat, session);
        mainController.showView(view.getPanel1());

    }

    private void updateConfirmationPage(Seat seat, Session session) {
        view.getText().setText("Film: " + session.getFilm().getName() + "  Cinema: " + session.getHall().getCinema().getAddress() + "\r\n" + "  Hall: " + session.getHall().getName() + "\r\n" +
                "  Date and time: " + session.getStartingDateTime().toString() + "\r\n   Seat number: " + Integer.toString(seat.getSeatNumber()) + "\r\n" + "  Price: " + seat.getRegularPrice());
        this.seat = seat;
        this.session = session;
    }

    @PostConstruct
    public void initListeners() {
        view.getConfirm().addActionListener(e -> {
            User user = userService.findUserById(1L);
            Ticket t = ticketService.CreateTicket(user, this.session, this.seat);
            JOptionPane.showMessageDialog(view.getPanel1(), "Thank you! Enjoy the film!");
        });

    }
}
