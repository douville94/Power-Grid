package cs301.power_grid;

import android.view.View;
import android.widget.Button;

import game.GameComputerPlayer;
import game.infoMsg.GameInfo;

/**
 * @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 */


public class PowerGridDumbComputerPlayer extends GameComputerPlayer {
    PowerState powerState;
    PowerGridHumanPlayer instanceVariables = new PowerGridHumanPlayer("DumbAI");
    View v;
    private Button okayButton;
    private Button passButton;

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public PowerGridDumbComputerPlayer(String name) {
        super(name);
    }

    private class okayButListener implements View.OnClickListener {
        private boolean isClicked;
        @Override
        public void onClick(View view) {
            if(isClicked == true) {

            }
        }
    }

    @Override
    public void receiveInfo(GameInfo info) {
        //check if info is a gameState
        if (info instanceof PowerState) {
            powerState = (PowerState)info;

            //look at what phase game is in then make a move
            int phase = powerState.getGamePhase();
            if (phase == 0) {
                /*First player chooses a power plant.
                * "OK" or "Pass" updates phase.*/
            } else if(phase == 1) {
                /*Bidding on power plant(s).
                * Bidding or "pass" updates phase.*/
                BidAction bid = new BidAction(this, (int)Math.random());
                bid.getBid();
                /*If the "OK" or "Pass" button is tapped, update the game phase*/
//                if(okayButListener.onClick(v)) {
//                    phase = 2;
//                    return;
//                }

            } else if(phase == 2) {
                /*Previous passer chooses a power plant.
                * "OK" or "Pass" updates phase.*/
            } else if(phase == 3) {
                /*Second player chooses resources.
                * "OK" or "Pass" updates phase.*/
            } else if(phase == 4) {
                /*First player chooses resources.
                * "OK" or "Pass" updates phase.*/
            } else if(phase == 5) {
                /*Second player chooses cities.
                * "OK" or "Pass" updates phase.*/
            } else if(phase == 6) {
                /*First player chooses cities.
                * "OK" or "Pass" updates phase.*/
            } else {
                /*Other cases go here.*/
            }
        }
    }
}
