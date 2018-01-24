package fr.univtln.m2dapm.boardgame;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton
public class JSFModel {
    private Player player;
    private List<Player> playerList;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void putPlayer(){
        em.merge(player);
        refresh();
    }
    public void refresh(){
        String pseudo = this.player.getDisplayedName();
        TypedQuery<Player> q = (TypedQuery<Player>) em.createQuery("SELECT p FROM Player AS p WHERE p.displayedName = :pseudo ", Player.class);
        q.setParameter("pseudo", pseudo);
        playerList = q.getResultList();
    }


    public void deletePlayer(){
        this.em.createQuery("DELETE FROM Player WHERE id = "+Long.toString(this.player.getId())).executeUpdate();
        refresh();
    }
}
