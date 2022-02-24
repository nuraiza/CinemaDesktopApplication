package s19241.mas.project.cinemaapp;


import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import s19241.mas.project.cinemaapp.model.*;
import s19241.mas.project.cinemaapp.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Component
@RequiredArgsConstructor
public class DataInitializer {

  /*  private final CustomerSupportRepository customerSupportRepository;
    private final CustomerSupportRepresentativeRepository customerSupportRepresentativeRepository;
    private final FilmRepository filmRepository;
    private final HallRepository hallRepository;
    private final SeatRepository seatRepository;
    private final CinemaRepository cinemaRepository;
    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

*/
    @EventListener
    public void atStart(ContextRefreshedEvent event) {

 /*       LocalDate release_date = LocalDate.of(2021, 9,6);
        List<String> cats= new ArrayList<>();
        cats.add("Thriller"); cats.add("Hot");
        List<String> actors= new ArrayList<>();
        actors.add("Mary Klinton"); actors.add("Emma Watson");
        Film film = new Film("The war",
                release_date,
                "Fine thriller and excited",
                cats,
                actors,
                "Derek Jonathan");
        LocalDate release_date2 = LocalDate.of(2021, 8,6);
        List<String> cats2= new ArrayList<>();
        cats2.add("Horror"); cats2.add("New");
        List<String> actors2= new ArrayList<>();
        actors2.add("Anna Midzak"); actors2.add("Edward Kalen");
        Film film2 = new Film("Attack of titans",
                release_date2,
                "Not recommended for children",
                cats2,
                actors2,
                null);

        LocalDate release_date3 = LocalDate.of(2021, 2,3);
        List<String> cats3= new ArrayList<>();
        cats3.add("Fantasy"); cats3.add("Old");
        List<String> actors3= new ArrayList<>();
        actors3.add("Joanna Jonson"); actors3.add("Katherine Moris");
        Film film3 = new Film("Harry Potter",
                release_date3,
                "Exciting fantasy",
                cats3,
                actors3,
                null);

        LocalDate release_date4 = LocalDate.of(2021, 3,14);
        List<String> cats4= new ArrayList<>();
        cats4.add("Comedy"); cats4.add("New");
        List<String> actors4= new ArrayList<>();
        actors4.add("Ann Hataway"); actors4.add("Anjelina Joli");
        Film film4 = new Film("The mask",
                release_date4,
                "Not recommended for children",
                cats4,
                actors4,
                null);


        LocalDate release_date5 = LocalDate.of(2021, 4,25);
        List<String> cats5= new ArrayList<>();
        cats5.add("Romantic"); cats5.add("New");
        List<String> actors5= new ArrayList<>();
        actors5.add("Anna Midzak"); actors5.add("Edward Kalen");
        Film film5 = new Film("Letters to Juliet",
                release_date5,
                "Not recommended for children",
                cats5,
                actors5,
                null);


        LocalDate release_date6 = LocalDate.of(2021, 3,12);
        List<String> cats6= new ArrayList<>();
        cats6.add("Romantic"); cats6.add("New");
        List<String> actors6= new ArrayList<>();
        actors6.add("Anna Midzak"); actors6.add("Edward Kalen");
        Film film6 = new Film("The kissing booth 2",
                release_date6,
                "Not recommended for children",
                cats6,
                actors6,
                null);

        LocalDate release_date7 = LocalDate.of(2021, 5,2);
        List<String> cats7= new ArrayList<>();
        cats7.add("Horror"); cats7.add("New");
        List<String> actors7= new ArrayList<>();
        actors7.add("Anna Midzak"); actors7.add("Edward Kalen");
        Film film7 = new Film("ZombieLand",
                release_date7,
                "Not recommended for children",
                cats7,
                actors7,
                null);

        LocalDate release_date8 = LocalDate.of(2021, 8,6);
        List<String> cats8= new ArrayList<>();
        cats8.add("Horror"); cats8.add("New");
        List<String> actors8= new ArrayList<>();
        actors8.add("Emma Watson"); actors8.add("Edward Kalen");
        Film film8 = new Film("The Babysitter: Killer Queen",
                release_date8,
                "Not recommended for children",
                cats8,
                actors8,
                null);

        LocalDate release_date9 = LocalDate.of(2021, 8,6);
        List<String> cats9= new ArrayList<>();
        cats9.add("Adventure"); cats9.add("Action");
        List<String> actors9= new ArrayList<>();
        actors9.add("Emma Watson"); actors9.add("Edward Kalen");
        Film film9 = new Film("Jumanji: Welcome to the Jungle",
                release_date9,
                "Funny and interesting movie",
                cats9,
                actors9,
                null);

        filmRepository.save(film);
        filmRepository.save(film2);
        filmRepository.save(film3);
        filmRepository.save(film4);
        filmRepository.save(film5);
        filmRepository.save(film6);
        filmRepository.save(film7);
        filmRepository.save(film8);
        filmRepository.save(film9);

        Cinema cinema1 = new Cinema("Multikino", "Zloty 69");
        Cinema cinema2 = new Cinema("Multikino", "Shkolnaya 74/2");


        Hall hall1 = new Hall("Red", 10, cinema1);
        Hall hall2 = new Hall("Green", 10, cinema1);
        Hall hall3 = new Hall("Blue", 25, cinema1);

        Hall hall4 = new Hall("BigDuck", 15, cinema2);
        Hall hall5 = new Hall("BigMouse", 25, cinema2);
        Hall hall6 = new Hall("BigCat", 25, cinema2);

        Seat s11 = new Seat(hall1, 10, 15.0);
        Seat s12 = new Seat(hall1, 12, 15.0);
        Seat s13 = new Seat(hall1, 13, 15.0);
        Seat s14 = new Seat(hall1, 16, 15.0);
        Seat s15 = new Seat(hall1, 17, 15.0);
        Seat s16 = new Seat(hall1, 18, 15.0);
        Seat s17 = new Seat(hall1, 19, 15.0);
        Seat s18 = new Seat(hall1, 20, 15.0);
        Seat s19 = new Seat(hall1, 21, 15.0);
        Seat s110 = new Seat(hall1, 22, 15.0);

        Seat s21 = new Seat(hall2, 10, 15.0);
        Seat s22= new Seat(hall2, 12, 15.0);
        Seat s23= new Seat(hall2, 13, 15.0);
        Seat s24= new Seat(hall2, 16, 15.0);
        Seat s25= new Seat(hall2, 17, 15.0);
        Seat s26= new Seat(hall2, 18, 15.0);
        Seat s27= new Seat(hall2, 19, 15.0);
        Seat s28= new Seat(hall2, 20, 15.0);
        Seat s29= new Seat(hall2, 21, 15.0);
        Seat s210 = new Seat(hall2, 22, 15.0);

        Seat s31 = new Seat(hall3, 44,23.0);
        Seat s32 = new Seat(hall3, 45,23.0);
        Seat s33 = new Seat(hall3, 46,23.0);
        Seat s34 = new Seat(hall3, 47,23.0);
        Seat s35 = new Seat(hall3, 48,23.0);
        Seat s36 = new Seat(hall3, 49,23.0);
        Seat s37 = new Seat(hall3, 50,23.0);
        Seat s38 = new Seat(hall3, 43,23.0);
        Seat s39 = new Seat(hall3, 42,23.0);
        Seat s310 = new Seat(hall3, 41,23.0);

        Seat s41 = new Seat(hall4, 50, 18.0);
        Seat s42 = new Seat(hall4, 51, 18.0);
        Seat s43 = new Seat(hall4, 52, 18.0);
        Seat s44 = new Seat(hall4, 53, 18.0);
        Seat s45 = new Seat(hall4, 54, 18.0);
        Seat s46 = new Seat(hall4, 55, 18.0);
        Seat s47 = new Seat(hall4, 56, 18.0);
        Seat s48 = new Seat(hall4, 57, 18.0);
        Seat s49 = new Seat(hall4, 58, 18.0);
        Seat s410 = new Seat(hall4, 90, 18.0);
        Seat s411 = new Seat(hall4, 59, 18.0);



        Seat s51= new Seat(hall5, 60, 31.0);
        Seat s52= new Seat(hall5, 61, 31.0);
        Seat s53= new Seat(hall5, 62, 31.0);
        Seat s54= new Seat(hall5, 63, 31.0);
        Seat s55= new Seat(hall5, 64, 31.0);
        Seat s56= new Seat(hall5, 65, 31.0);
        Seat s57= new Seat(hall5, 66, 31.0);
        Seat s58= new Seat(hall5, 67, 31.0);
        Seat s59= new Seat(hall5, 68, 31.0);


        Seat s61 = new Seat(hall6, 70, 12.5);
        Seat s62 = new Seat(hall6, 71, 12.5);
        Seat s63 = new Seat(hall6, 72, 12.5);
        Seat s64 = new Seat(hall6, 73, 12.5);
        Seat s65 = new Seat(hall6, 74, 12.5);
        Seat s66 = new Seat(hall6, 75, 12.5);
        Seat s67 = new Seat(hall6, 76, 12.5);
        Seat s68 = new Seat(hall6, 77, 12.5);
        Seat s69 = new Seat(hall6, 78, 12.5);
        Seat s610 = new Seat(hall6, 79, 12.5);

        cinemaRepository.save(cinema1);
        cinemaRepository.save(cinema2);
        hallRepository.save(hall1);
        hallRepository.save(hall2);
        hallRepository.save(hall3);
        hallRepository.save(hall4);
        hallRepository.save(hall5);
        hallRepository.save(hall6);

        Session sess1= new Session(LocalDateTime.of(2021, 10, 2, 10, 30), LocalDateTime.of(2021, 10, 2, 12, 30));
        sess1.setFilm(film); sess1.setHall(hall1);
        Session sess2= new Session(LocalDateTime.of(2021, 10, 2, 13, 30), LocalDateTime.of(2021, 10, 2, 16, 30));
        sess2.setFilm(film); sess2.setHall(hall1);
        Session sess3= new Session(LocalDateTime.of(2021, 10, 2, 18, 30), LocalDateTime.of(2021, 10, 2, 21, 30));
        sess3.setFilm(film); sess3.setHall(hall1);
        Session sess4= new Session(LocalDateTime.of(2021, 10, 2, 22, 30), LocalDateTime.of(2021, 10, 2, 1, 00));
        sess4.setFilm(film); sess4.setHall(hall1);


        Session sess5= new Session(LocalDateTime.of(2021, 10, 2, 10, 30), LocalDateTime.of(2021, 10, 2, 12, 30));
        sess5.setFilm(film2); sess5.setHall(hall5);
        Session sess6= new Session(LocalDateTime.of(2021, 10, 2, 13, 30), LocalDateTime.of(2021, 10, 2, 16, 30));
        sess6.setFilm(film2); sess6.setHall(hall5);
        Session sess7= new Session(LocalDateTime.of(2021, 10, 2, 18, 30), LocalDateTime.of(2021, 10, 2, 21, 30));
        sess7.setFilm(film2); sess7.setHall(hall5);
        Session sess8= new Session(LocalDateTime.of(2021, 10, 2, 23, 15), LocalDateTime.of(2021, 10, 2, 2, 15));
        sess8.setFilm(film2); sess8.setHall(hall5);

        Session sess9= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess9.setFilm(film3); sess9.setHall(hall2);
        Session sess10= new Session(LocalDateTime.of(2021, 7, 28, 12, 15), LocalDateTime.of(2021, 7, 28, 14, 15));
        sess10.setFilm(film3); sess10.setHall(hall2);
        Session sess11= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess11.setFilm(film3); sess11.setHall(hall3);
        Session sess12= new Session(LocalDateTime.of(2021, 7, 28, 15, 15), LocalDateTime.of(2021, 7, 28, 17, 15));
        sess12.setFilm(film3); sess12.setHall(hall2);
        Session sess13= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess13.setFilm(film3); sess13.setHall(hall4);
        Session sess14= new Session(LocalDateTime.of(2021, 7, 28, 22, 15), LocalDateTime.of(2021, 7, 28, 1, 15));
        sess14.setFilm(film3); sess14.setHall(hall5);

        Session sess15= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess15.setFilm(film4); sess15.setHall(hall2);
        Session sess16= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess16.setFilm(film4); sess16.setHall(hall3);
        Session sess17= new Session(LocalDateTime.of(2021, 7, 28, 15, 45), LocalDateTime.of(2021, 7, 28, 17, 15));
        sess17.setFilm(film4); sess17.setHall(hall2);
        Session sess18= new Session(LocalDateTime.of(2021, 7, 28, 17, 45), LocalDateTime.of(2021, 7, 28, 19, 15));
        sess18.setFilm(film4); sess18.setHall(hall3);
        Session sess19= new Session(LocalDateTime.of(2021, 7, 28, 21, 45), LocalDateTime.of(2021, 7, 28, 23, 15));
        sess19.setFilm(film4); sess19.setHall(hall4);


        Session sess20= new Session(LocalDateTime.of(2021, 7, 28, 15, 45), LocalDateTime.of(2021, 7, 28, 17, 15));
        sess20.setFilm(film5); sess20.setHall(hall5);
        Session sess21= new Session(LocalDateTime.of(2021, 7, 28, 15, 45), LocalDateTime.of(2021, 7, 28, 17, 15));
        sess21.setFilm(film5); sess21.setHall(hall6);
        Session sess22= new Session(LocalDateTime.of(2021, 7, 28, 22, 45), LocalDateTime.of(2021, 7, 28, 1, 15));
        sess22.setFilm(film5); sess22.setHall(hall5);
        Session sess23= new Session(LocalDateTime.of(2021, 7, 28, 20, 30), LocalDateTime.of(2021, 7, 28, 22, 15));
        sess23.setFilm(film5); sess23.setHall(hall6);
        Session sess24= new Session(LocalDateTime.of(2021, 7, 28, 15, 45), LocalDateTime.of(2021, 7, 28, 17, 15));
        sess24.setFilm(film5); sess24.setHall(hall3);
        Session sess25= new Session(LocalDateTime.of(2021, 7, 28, 14, 45), LocalDateTime.of(2021, 7, 28, 16, 15));
        sess25.setFilm(film5); sess25.setHall(hall4);

        Session sess26= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess26.setFilm(film6); sess26.setHall(hall2);
        Session sess27= new Session(LocalDateTime.of(2021, 7, 28, 12, 15), LocalDateTime.of(2021, 7, 28, 14, 15));
        sess27.setFilm(film6); sess27.setHall(hall2);
        Session sess28= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess28.setFilm(film6); sess28.setHall(hall3);
        Session sess29= new Session(LocalDateTime.of(2021, 7, 28, 15, 15), LocalDateTime.of(2021, 7, 28, 17, 15));
        sess29.setFilm(film6); sess29.setHall(hall2);
        Session sess30= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess30.setFilm(film6); sess30.setHall(hall4);
        Session sess31= new Session(LocalDateTime.of(2021, 7, 28, 22, 15), LocalDateTime.of(2021, 7, 28, 1, 15));
        sess31.setFilm(film6); sess31.setHall(hall5);

        Session sess32= new Session(LocalDateTime.of(2021, 10, 2, 10, 30), LocalDateTime.of(2021, 10, 2, 12, 30));
        sess32.setFilm(film7); sess32.setHall(hall1);
        Session sess33= new Session(LocalDateTime.of(2021, 10, 2, 13, 30), LocalDateTime.of(2021, 10, 2, 16, 30));
        sess33.setFilm(film7); sess33.setHall(hall1);
        Session sess34= new Session(LocalDateTime.of(2021, 10, 2, 18, 30), LocalDateTime.of(2021, 10, 2, 21, 30));
        sess34.setFilm(film7); sess34.setHall(hall1);
        Session sess35= new Session(LocalDateTime.of(2021, 10, 2, 22, 30), LocalDateTime.of(2021, 10, 2, 1, 00));
        sess35.setFilm(film7); sess35.setHall(hall1);

        Session sess36= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess36.setFilm(film8); sess36.setHall(hall2);
        Session sess37= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess37.setFilm(film8); sess37.setHall(hall3);
        Session sess38= new Session(LocalDateTime.of(2021, 7, 28, 15, 45), LocalDateTime.of(2021, 7, 28, 17, 15));
        sess38.setFilm(film8); sess38.setHall(hall2);
        Session sess39= new Session(LocalDateTime.of(2021, 7, 28, 17, 45), LocalDateTime.of(2021, 7, 28, 19, 15));
        sess39.setFilm(film8); sess39.setHall(hall3);
        Session sess40= new Session(LocalDateTime.of(2021, 7, 28, 21, 45), LocalDateTime.of(2021, 7, 28, 23, 15));
        sess40.setFilm(film8); sess40.setHall(hall4);

        Session sess41= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess41.setFilm(film9); sess41.setHall(hall2);
        Session sess42= new Session(LocalDateTime.of(2021, 7, 28, 12, 15), LocalDateTime.of(2021, 7, 28, 14, 15));
        sess42.setFilm(film9); sess42.setHall(hall2);
        Session sess43= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess43.setFilm(film9); sess43.setHall(hall3);
        Session sess44= new Session(LocalDateTime.of(2021, 7, 28, 15, 15), LocalDateTime.of(2021, 7, 28, 17, 15));
        sess44.setFilm(film9); sess44.setHall(hall2);
        Session sess45= new Session(LocalDateTime.of(2021, 7, 28, 9, 15), LocalDateTime.of(2021, 7, 28, 11, 15));
        sess45.setFilm(film9); sess45.setHall(hall4);
        Session sess46= new Session(LocalDateTime.of(2021, 7, 28, 22, 15), LocalDateTime.of(2021, 7, 28, 1, 15));
        sess46.setFilm(film9); sess46.setHall(hall5);



        sessionRepository.save(sess1);
        sessionRepository.save(sess2);
        sessionRepository.save(sess3);
        sessionRepository.save(sess4);
        sessionRepository.save(sess5);
        sessionRepository.save(sess6);
        sessionRepository.save(sess7);
        sessionRepository.save(sess8);
        sessionRepository.save(sess9);
        sessionRepository.save(sess10);
        sessionRepository.save(sess11);
        sessionRepository.save(sess12);
        sessionRepository.save(sess13);
        sessionRepository.save(sess14);
        sessionRepository.save(sess15);
        sessionRepository.save(sess16);
        sessionRepository.save(sess17);
        sessionRepository.save(sess18);
        sessionRepository.save(sess19);
        sessionRepository.save(sess20);
        sessionRepository.save(sess21);
        sessionRepository.save(sess22);
        sessionRepository.save(sess23);
        sessionRepository.save(sess24);
        sessionRepository.save(sess25);
        sessionRepository.save(sess26);
        sessionRepository.save(sess27);
        sessionRepository.save(sess28);
        sessionRepository.save(sess29);
        sessionRepository.save(sess30);
        sessionRepository.save(sess31);
        sessionRepository.save(sess32);
        sessionRepository.save(sess33);
        sessionRepository.save(sess34);
        sessionRepository.save(sess35);
        sessionRepository.save(sess36);
        sessionRepository.save(sess37);
        sessionRepository.save(sess38);
        sessionRepository.save(sess39);
        sessionRepository.save(sess40);
        sessionRepository.save(sess41);
        sessionRepository.save(sess42);
        sessionRepository.save(sess43);
        sessionRepository.save(sess44);
        sessionRepository.save(sess45);
        sessionRepository.save(sess46);



        Status status= new Status("student",40);
        Status status2= new Status("retired",60);
        Status status3= new Status("child",20);
        Status status4= new Status("regular",0);

        User u = new User("Maria Kalen","726786544","maria@gmail.com","maria@gmail.com","moonlight911",status4,UserType.NONMEMBER,null);
   userRepository.save(u);

  // Ticket t = new Ticket(sess1,u, s11);
  // ticketRepository.save(t);
*/

     /*   CustomerSupport c = new CustomerSupport("223445", "cinema-customer-support@cinema.cicuit.com");
        List<String> lang = new ArrayList<>();
        lang.add("English"); lang.add("Spanish"); lang.add("German");
        CustomerSupportRepresentative r = new CustomerSupportRepresentative("Angeline Kalnska", "755344299", "angeline@gmail.com", lang,true);
        r.setCustomerSupport(c);
        List<String> lang2 = new ArrayList<>();
        lang2.add("English"); lang2.add("Korean"); lang2.add("French");
        CustomerSupportRepresentative r2 = new CustomerSupportRepresentative("Eliseu Rosa","899655321","eliseu@gmail.com",lang2,true);
        r2.setCustomerSupport(c);
        customerSupportRepository.save(c);
        customerSupportRepresentativeRepository.save(r);
        customerSupportRepresentativeRepository.save(r2);*/
    }
}

