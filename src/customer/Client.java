package customer;

import javafx.application.Platform;
import util.LoginDTO;

import java.io.IOException;

public class Client implements Runnable {
    private final Thread thr;
    private final Main main;

    public Client(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getNetworkUtil().read();
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        System.out.println(loginDTO.getUserName());
                        System.out.println(loginDTO.isStatus());
                        System.out.println(loginDTO.getRestaurantManager().getRestaurantsList().size());
                        // the following is necessary to update JavaFX UI components from user created
                        // threads
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if (loginDTO.isStatus()) {
                                    try {
                                        main.showHomePage(loginDTO.getUserName());
                                        main.setFoodList(loginDTO.getfoodList());
                                        main.setResList(loginDTO.getResList());
                                        System.out.println("client er read thread " + loginDTO.getRestaurantManager().getResList().size());
                                        main.setRestaurantManager(loginDTO.getRestaurantManager());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    main.showAlert();
                                }

                            }
                        });
                    }
                   
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                main.getNetworkUtil().closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }






}
