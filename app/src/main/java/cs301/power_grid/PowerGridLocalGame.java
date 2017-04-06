package cs301.power_grid;

import java.util.ArrayList;

import game.GamePlayer;
import game.LocalGame;
import game.actionMsg.GameAction;
import game.infoMsg.GameState;

/**
 * @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 *
 * Contains game logic in makeMove class
 */
public class PowerGridLocalGame extends LocalGame{
    //instance variables
    private PowerState powerGameState = new PowerState();
    private int price;
    private int phase = powerGameState.getGamePhase();

    @Override
    //Sends copy of updated state to given player
    protected void sendUpdatedStateTo(GamePlayer p) {
        PowerState newpgs = new PowerState(powerGameState);
        p.sendInfo((GameState)newpgs);
    }

    @Override
    //determines if a player can move
    protected boolean canMove(int playerIdx) {

        if (playerIdx == powerGameState.getPlayerId()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    //checks to see if the game is over
    protected String checkIfGameOver() {
        return null;
    }

    /**
     * Make Move
     *
     * Contains all Game Logic
     *
     * receives an action:
     * BidAction, BuyCityAction, BuyCoalAction, BuyOilAction, BuyTrashAction,
     * BuyUraniumAction, DiscardPowerPlantAction, PassAction,
     * or SelectPowerStateAction
     * and performs necessary steps for action
     *
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //playerId, 0 = human player, 1 = computer/network player
        int playerID = powerGameState.getPlayerId();

        //BidAction
        if (action instanceof BidAction && playerID == 0){
            powerGameState.setCurrentBid(((BidAction) action).getBid());
            //change player
            powerGameState.setPlayerId(1);
            return true;
        }
        else if (action instanceof BidAction && playerID == 1){
            powerGameState.setCurrentBid(((BidAction) action).getBid());
            //change player
            powerGameState.setPlayerId(0);
            return true;
        }

        //BuyCityAction
        else if (action instanceof BuyCityAction && playerID == 0) {
            boolean didithappen = powerGameState.getGameInventories().get(0).addMyCity(((BuyCityAction) action).getCity());
            if(!didithappen){} //vibrate screen
            return true;
        }
        else if (action instanceof BuyCityAction && playerID == 1) {
            boolean didithappen = powerGameState.getGameInventories().get(1).addMyCity(((BuyCityAction) action).getCity());
            if(!didithappen){} //vibrate screen
            return true;
        }

        //BuyCoalAction
        else if(action instanceof BuyCoalAction && playerID == 0) {
            //determine price of coal
            price = (((BuyCoalAction) action).getCoal()/3+1);
            if (powerGameState.getAvailableResources().coal[((BuyCoalAction) action).getCoal()] && powerGameState.getGameInventories().get(0).getMoney() >= price) {
                //make that resource unavailable for further purchase
                powerGameState.getAvailableResources().coal[((BuyCoalAction) action).getCoal()] = false;
                //take money from user
                powerGameState.getGameInventories().get(0).setMoney(powerGameState.getGameInventories().get(0).getMoney() - price);
                //add oil to inventory
                powerGameState.getGameInventories().get(0).setOil(powerGameState.getGameInventories().get(0).getCoal() + 1);
            }
                return true;
        }
        else if(action instanceof BuyCoalAction && playerID == 1) {
            price = (((BuyCoalAction) action).getCoal()/3+1);
            if (powerGameState.getAvailableResources().coal[((BuyCoalAction) action).getCoal()] && powerGameState.getGameInventories().get(1).getMoney() >= price) {
                //make that resource unavailable for further purchase
                powerGameState.getAvailableResources().coal[((BuyCoalAction) action).getCoal()] = false;
                //take money from user
                powerGameState.getGameInventories().get(1).setMoney(powerGameState.getGameInventories().get(1).getMoney() - price);
                //add oil to inventory
                powerGameState.getGameInventories().get(1).setOil(powerGameState.getGameInventories().get(1).getCoal() + 1);
            }
                    return true;
        }

        //BuyOilAction
        else if(action instanceof BuyOilAction && playerID == 0) {
            price = (((BuyOilAction) action).getOil()/3+1);
            if (powerGameState.getAvailableResources().oil[((BuyOilAction) action).getOil()] && powerGameState.getGameInventories().get(0).getMoney() >= price) {
                //make that resource unavailable for further purchase
                powerGameState.getAvailableResources().oil[((BuyOilAction) action).getOil()] = false;
                //take money from user
                powerGameState.getGameInventories().get(0).setMoney(powerGameState.getGameInventories().get(0).getMoney() - price);
                //add oil to inventory
                powerGameState.getGameInventories().get(0).setOil(powerGameState.getGameInventories().get(0).getOil() + 1);
            }
            return true;
        }
        else if(action instanceof BuyOilAction && playerID == 1) {
            price = (((BuyOilAction) action).getOil()/3+1);
            if (powerGameState.getAvailableResources().oil[((BuyOilAction) action).getOil()] && powerGameState.getGameInventories().get(1).getMoney() >= price) {
                //make that resource unavailable for further purchase
                powerGameState.getAvailableResources().oil[((BuyOilAction) action).getOil()] = false;
                //take money from user
                powerGameState.getGameInventories().get(1).setMoney(powerGameState.getGameInventories().get(1).getMoney() - price);
                //add oil to inventory
                powerGameState.getGameInventories().get(1).setOil(powerGameState.getGameInventories().get(1).getOil() + 1);
            }
            return true;
        }

        //BuyTrashAction
        else if(action instanceof BuyTrashAction && playerID == 0) {
            price = (((BuyTrashAction) action).getTrash()/3+1);
            if (powerGameState.getAvailableResources().trash[((BuyTrashAction) action).getTrash()] && powerGameState.getGameInventories().get(0).getMoney() >= price) {
                //make that resource unavailable for further purchase
                powerGameState.getAvailableResources().trash[((BuyTrashAction) action).getTrash()] = false;
                //take money from user
                powerGameState.getGameInventories().get(0).setMoney(powerGameState.getGameInventories().get(0).getMoney() - price);
                //add oil to inventory
                powerGameState.getGameInventories().get(0).setTrash(powerGameState.getGameInventories().get(0).getTrash() + 1);
            }
            return true;
        }
        else if(action instanceof BuyTrashAction && playerID == 1) {
            price = (((BuyTrashAction) action).getTrash()/3+1);
            if (powerGameState.getAvailableResources().trash[((BuyTrashAction) action).getTrash()] && powerGameState.getGameInventories().get(1).getMoney() >= price) {
                //make that resource unavailable for further purchase
                powerGameState.getAvailableResources().trash[((BuyTrashAction) action).getTrash()] = false;
                //take money from user
                powerGameState.getGameInventories().get(1).setMoney(powerGameState.getGameInventories().get(1).getMoney() - price);
                //add oil to inventory
                powerGameState.getGameInventories().get(1).setTrash(powerGameState.getGameInventories().get(1).getTrash() + 1);
            }
            return true;
        }

        //BuyUraniumAction
        else if(action instanceof BuyUraniumAction && playerID == 0) {
            price = (((BuyUraniumAction) action).getUranium()/3+1);
            if (powerGameState.getAvailableResources().uranium[((BuyUraniumAction) action).getUranium()] && powerGameState.getGameInventories().get(0).getMoney() >= price) {
                //make that resource unavailable for further purchase
                powerGameState.getAvailableResources().uranium[((BuyUraniumAction) action).getUranium()] = false;
                //take money from user
                powerGameState.getGameInventories().get(0).setMoney(powerGameState.getGameInventories().get(0).getMoney() - price);
                //add oil to inventory
                powerGameState.getGameInventories().get(0).setTrash(powerGameState.getGameInventories().get(0).getUranium() + 1);
            }
            return true;
        }
        else if(action instanceof BuyUraniumAction && playerID == 1) {
            price = (((BuyUraniumAction) action).getUranium()/3+1);
            if (powerGameState.getAvailableResources().uranium[((BuyUraniumAction) action).getUranium()] && powerGameState.getGameInventories().get(1).getMoney() >= price) {
                //make that resource unavailable for further purchase
                powerGameState.getAvailableResources().uranium[((BuyUraniumAction) action).getUranium()] = false;
                //take money from user
                powerGameState.getGameInventories().get(1).setMoney(powerGameState.getGameInventories().get(1).getMoney() - price);
                //add oil to inventory
                powerGameState.getGameInventories().get(1).setTrash(powerGameState.getGameInventories().get(1).getUranium() + 1);
            }
            return true;
        }

        //DiscardPowerPlantAction
        else if(action instanceof DiscardPowerPlantAction && playerID == 0) {
            //find index of powerplant to be discarded
            Powerplant discard = ((DiscardPowerPlantAction) action).getPowerplant();
            int ppIndex = powerGameState.getGameInventories().get(0).getMyPlants().indexOf(discard);
            //remove indicated powerplant
            powerGameState.getGameInventories().get(0).getMyPlants().remove(ppIndex);
            return true;
        }
        else if(action instanceof DiscardPowerPlantAction && playerID == 1) {
            //find index of powerplant to be discarded
            Powerplant discard = ((DiscardPowerPlantAction) action).getPowerplant();
            int ppIndex = powerGameState.getGameInventories().get(1).getMyPlants().indexOf(discard);
            //remove indicated powerplant
            powerGameState.getGameInventories().get(1).getMyPlants().remove(ppIndex);
            return true;
        }

        //PassAction
        else if(action instanceof PassAction && playerID == 0) {
            //if user0 passes on a bid, user1 gets the selected power plant
            Powerplant passedOn = ((PassAction) action).getPowerplant();
            powerGameState.getGameInventories().get(1).addMyPlants(passedOn);
            //change player
            powerGameState.setPlayerId(1);
            return true;
        }

        else if(action instanceof PassAction && playerID == 1) {
            //if user1 passes on a bid, user0 gets the selected power plant
            Powerplant passedOn = ((PassAction) action).getPowerplant();
            powerGameState.getGameInventories().get(0).addMyPlants(passedOn);
            //change player
            powerGameState.setPlayerId(0);
            return true;
        }

        //SelectPowerPlantAction
        else if(action instanceof SelectPowerPlantAction && playerID == 0) {
            //user0 selects a powerplant and presses confirm which will start the bidding process with user1
            //highlight on GUI for humanplayer
            //change player
            powerGameState.setPlayerId(1);
            return true;
        }
        else if(action instanceof SelectPowerPlantAction && playerID == 1) {
            //user1 selects a powerplant and presses confirm which will start the bidding process with user0
            //change player
            powerGameState.setPlayerId(0);
            return true;
        }
        else{
            return false;
        }


    }//makeMove
}
