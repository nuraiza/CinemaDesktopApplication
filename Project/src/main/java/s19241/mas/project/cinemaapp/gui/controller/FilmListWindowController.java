package s19241.mas.project.cinemaapp.gui.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import s19241.mas.project.cinemaapp.gui.view.FilmListView;
import s19241.mas.project.cinemaapp.model.Film;
import s19241.mas.project.cinemaapp.service.FilmService;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FilmListWindowController {
    private final FilmListView view;
    private final FilmService filmService;

    public void showGUI(MainWindowController mainController) {
        updateFilmsFromDB();
        mainController.showView(view.getMainPanel());
    }

    @PostConstruct
    public void initListeners() {
        view.getFilmList().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Film selectedValue = (Film) view.getFilmList().getSelectedValue();
                System.out.println("Film selected: " + selectedValue.getName());
                view.getSelectedFilm().setText(selectedValue.getName());
            }
        });
    }

    private void updateFilmsFromDB() {
        List<Film> films = filmService.getAllFilms();
        DefaultListModel<Film> model = (DefaultListModel<Film>) view.getFilmList().getModel();
        model.removeAllElements();
        films.forEach(model::addElement);
    }
}
