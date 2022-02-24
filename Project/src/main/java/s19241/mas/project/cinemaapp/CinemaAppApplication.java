package s19241.mas.project.cinemaapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import s19241.mas.project.cinemaapp.gui.controller.MainWindowController;

import javax.swing.*;

@SpringBootApplication
public class CinemaAppApplication {

    public static void main(String[] args) {
        //SpringApplication.run(CinemaAppApplication.class, args);

        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(CinemaAppApplication.class).headless(false)
                .run(args);

        SwingUtilities.invokeLater(() -> {
            ctx.getBean(MainWindowController.class).showGUI();
        });
    }

}
