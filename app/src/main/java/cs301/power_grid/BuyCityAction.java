package cs301.power_grid;

import game.GamePlayer;
import game.actionMsg.GameAction;
/**
 * @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 */


public class BuyCityAction extends GameAction {

    private City city;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BuyCityAction(GamePlayer player,City initCity) {
        super(player);
        city = initCity;
    }
    public City getCity(){return city;}
}
