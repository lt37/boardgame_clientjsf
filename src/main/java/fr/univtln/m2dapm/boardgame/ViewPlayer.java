package fr.univtln.m2dapm.boardgame;


import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="playerView")
@ViewScoped
public class ViewPlayer implements Serializable {

    private List<Player> players;

    @ManagedProperty("#{playerService}")
    private PlayerEJB service;

    @PostConstruct
    public void init() {
        players = service.createCars(10);
    }

    public List<Player> getCars() {
        return players;
    }

    public void setService(PlayerEJB service) {
        this.service = service;
    }
}
