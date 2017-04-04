package cs301.power_grid;

import game.GameComputerPlayer;
import game.infoMsg.GameInfo;

/**
 * @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 */


public class PowerGridDumbComputerPlayer extends GameComputerPlayer {
    PowerState powerState;

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public PowerGridDumbComputerPlayer(String name) {
        super(name);
    }

    @Override
    public void receiveInfo(GameInfo info) {
        //check if info is a gameState
        if (info instanceof PowerState) {
            powerState = (PowerState) info;

            //look at what phase game is in then make a move
            int phase = powerState.getGamePhase();
            if (phase == 0) {
                //do some shit
            }
        }
    }
}
