package cs301.power_grid;
import android.view.View;

import game.GameHumanPlayer;
import game.GameMainActivity;
import game.infoMsg.GameInfo;

/**
 * @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 */

//will extend GameHumanPlayer
public class PowerGridHumanPlayer extends GameHumanPlayer {

    public PowerGridHumanPlayer(String name){
        super(name);
    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {

    }

    @Override
    public void setAsGui(GameMainActivity activity) {

    }
}
