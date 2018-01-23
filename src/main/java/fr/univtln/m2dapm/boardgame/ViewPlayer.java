package fr.univtln.m2dapm.boardgame;


import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import fr.univtln.m2dapm.boardgame.restserver.resources.gameinfos.PlayerEJB;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="playerView")
@ViewScoped
public class ViewPlayer implements Serializable {

    private List<Player> playersView;


    @ManagedProperty("#{playerejb}")
    private PlayerEJB service;

    private String newEmail;
    private String newLogin;
    private String newDisplay;

        @PostConstruct
    public void init() {
        playersView = service.getAllPlayers();

    }

    public List<Player> getPlayersView() {
        return playersView;
    }

    public void refreshPlayer(){
        playersView = service.getAllPlayers();
    }

    public void setService(PlayerEJB service) {
        this.service = service;
    }

    public void addPlayer(){
        Player player = new Player();
        player.setEmail(newEmail);
        player.setLoginName(newLogin);
        player.setDisplayedName(newDisplay);
        this.service.createPlayer(player);
    }

    public void setPlayersView(List<Player> playersView) {
        this.playersView = playersView;
    }

    public PlayerEJB getService() {
        return service;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getNewLogin() {
        return newLogin;
    }

    public void setNewLogin(String newLogin) {
        this.newLogin = newLogin;
    }

    public String getNewDisplay() {
        return newDisplay;
    }

    public void setNewDisplay(String newDisplay) {
        this.newDisplay = newDisplay;
    }
}
