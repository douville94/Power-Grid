package cs301.power_grid;
import android.os.Bundle;
import android.view.View;

import game.GameHumanPlayer;
import game.GameMainActivity;
import game.infoMsg.GameInfo;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 */


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
