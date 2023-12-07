/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cct.rteplayer;

import com.cct.rteplayer.controllers.MenuController;
import com.cct.rteplayer.controllers.UserController;
import com.cct.rteplayer.models.Movie;
import com.cct.rteplayer.models.Ride;
import com.cct.rteplayer.models.User;
import com.cct.rteplayer.services.RideService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author ChrisCMota
 */
public class RTEPlayer {
    
    private static Map<String, User> users;
    private static User loggedUser;
    private static List<Movie> movies;
    private static List<Ride> ridedMovies;
    private static UserController userController;
    private static MenuController menuController;
    private static RideService rideService;
    
    public static void main(String[] args) {
        users = new HashMap<>();
        ridedMovies = new ArrayList<>();
        userController = new UserController(); 
        menuController = new MenuController();
        rideService = new RideService();
        movies = rideService.chargeMovies();
        createFirstUser();
        loggedUser = makeLogin();
        while(true) {
            Integer option = menuController.showPrincipalMenu(loggedUser);
            executeOption(option);
        }
    }
    
    private static void createFirstUser() {
        System.out.println("create the first user");
        createUser();
    }

    private static void createUser() {
        User firstUser = userController.createUser();
        users.put(firstUser.getEmail(), firstUser);
    }
    
    private static User makeLogin() {
        System.out.println("Make login");
        loggedUser = null;
        while(Objects.isNull(loggedUser)) {
            loggedUser = userController.makeLogin(users);
        }
        return loggedUser;
    }
    
    private static void executeOption(Integer option) {
        switch(option) {
            case 1:
                createUser();
                break;
            case 2:
                rideMovie();
                break;
            case 3:
                showRidedMovies();
                break;
            case 4:
                recommendedMovies();
                break;
            case 5:
                loggedUser = makeLogin();
                break;
            default:
                System.out.println("invalid option, try again");
        }
    }
    
    private static void rideMovie() {
        String movieName = menuController.rideMovieMenu(movies);
        ridedMovies.add(
            new Ride(
                loggedUser.getEmail(),
                movieName,
                LocalDateTime.now(),
               LocalDateTime.now().plusMinutes(1)
        ));
        System.out.println("Movie rided successfuly!");
    }
    
    private static void showRidedMovies() {
        System.out.println("Your films rided:");
        ridedMovies.stream()
            .filter(movie -> 
                    movie.getUserEmail().equals(loggedUser.getEmail()))
            .forEach(movie -> 
                    System.out.println(movie.getMovieName() +
                    " " + 
                    movie.getStartRide()));
    }
    
    private static void recommendedMovies(){
        System.out.println("Most rided movies:");
        Map<String, Integer> counter = new HashMap<>();
        ridedMovies.forEach(movie -> {
            if (movie.getEndRide()
                .isAfter(LocalDateTime.now().minusMinutes(5))) {
                
                Integer counterRided = counter.containsKey(movie.getMovieName()) ?
                        counter.get(movie.getMovieName()) + 1 : 1;
                counter.put(movie.getMovieName(), counterRided);
            }
        });

        counter.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(5)
                .forEach((movie) -> System.out.println(movie.getKey()));
    }
}
