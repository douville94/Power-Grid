package cs301.power_grid;

import game.GamePlayer;
import game.actionMsg.GameAction;

/**
 * @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 */


public class SelectPowerPlantAction extends GameAction {

    private Powerplant powerplant;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public SelectPowerPlantAction(GamePlayer player, Powerplant initPowerPlant) {
        super(player);
        powerplant = initPowerPlant;
    }

    public Powerplant getPowerplant() {
        return powerplant;
    }
}