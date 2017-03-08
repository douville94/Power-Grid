package cs301.power_grid;
import game.Game;
import game.GamePlayer;
import game.actionMsg.GameAction;
/**
 * @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 */

//will extend GameAction
public class PassAction extends GameAction{
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PassAction(GamePlayer player) {
        super(player);
    }
}
