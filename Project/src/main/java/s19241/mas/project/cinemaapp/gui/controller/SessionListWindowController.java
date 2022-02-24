package s19241.mas.project.cinemaapp.gui.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import s19241.mas.project.cinemaapp.gui.view.SessionListView;
import s19241.mas.project.cinemaapp.model.Session;
import s19241.mas.project.cinemaapp.service.SessionService;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SessionListWindowController {
    private final SessionListView view;
    private final SessionService sessionService;


    public void showGUI(MainWindowController mainController, Long film_id) {
        updateSessionsFromDB(film_id);
        mainController.showView(view.getPanel1());
    }

    private void updateSessionsFromDB(Long film_id) {
        List<Session> sessions = sessionService.getSessionsByFilmId(film_id);
        DefaultListModel<Session> model = (DefaultListModel<Session>) view.getSessionList().getModel();
        model.removeAllElements();
        sessions.forEach(model::addElement);
    }

    @PostConstruct
    public void initListeners() {
        view.getSessionList().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Session selectedValue = (Session) view.getSessionList().getSelectedValue();
                System.out.println("Session selected: " + selectedValue.getStartingDateTime().toString());

            }
        });
    }
}
