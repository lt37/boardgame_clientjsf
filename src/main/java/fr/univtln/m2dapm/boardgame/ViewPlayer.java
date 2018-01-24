package fr.univtln.m2dapm.boardgame;


import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import fr.univtln.m2dapm.boardgame.restserver.resources.gameinfos.PlayerEJB;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.inject.Inject;


@ManagedBean(name="playerView")
@SessionScoped
public class ViewPlayer implements Serializable {

    @EJB
    JSFModel jsfModel;

    Player player;

    private String newEmail;
    private String newLogin;
    private String newDisplay;

        @PostConstruct
    public void init() {
        //playersView = service.getAllPlayers();
        player = new Player();
    }

    public List<Player> getPlayersView() {
        return jsfModel.getPlayerList();
    }

    public void addPlayer(){
        player.setEmail(newEmail);
        player.setLoginName(newLogin);
        player.setDisplayedName(newDisplay);
        jsfModel.setPlayer(player);
        jsfModel.putPlayer();
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
