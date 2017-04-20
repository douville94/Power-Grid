package cs301.power_grid;

import android.os.Bundle;
import android.view.KeyEvent;
import game.Game;
import game.GameComputerPlayer;
import game.GameMainActivity;
import game.GamePlayer;
import game.infoMsg.GameInfo;

/**
 * @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 */


public class PowerGridDumbComputerPlayer extends GameComputerPlayer {
    private GameMainActivity activity;
//    PowerState powerState;
    PowerState powerState = new PowerState();
//    PowerState powerState = new PowerState(PowerGridDumbComputerPlayer.this.powerState);
//    PowerGridHumanPlayer instanceVariables = new PowerGridHumanPlayer("DumbAI");
//    private GamePlayer tempPlayer;
    private int selectNum = -1;
    private int bidValue = -1;
    private ResourceStore localStore = new ResourceStore();
//    bidValue = Integer.parseInt(bidVal.getText().toString());
    private Powerplant tempPlant;// = new Powerplant();
    private Powerplant selectedPowerPlant;// = new Powerplant();
    private boolean isClicked = false;
//    private GamePlayer tempPlayer;
    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public PowerGridDumbComputerPlayer(String name) {
        super(name);
    }

    public void receiveInfo(GameInfo info) {
//        Powerplant selectedPowerPlant;// = new Powerplant(selectedPowerPlant.getCost(), selectedPowerPlant.getPtp(), selectedPowerPlant.getHp(), selectedPowerPlant.getKind());
        //check if info is a gameState
        if (info instanceof PowerState) {
            powerState = (PowerState)info;
            //look at what phase game is in then make a move
            int phase = powerState.getGamePhase();
            if (phase == 0) {
                /*First player chooses a power plant.
                * "OK" or "Pass" updates phase.*/

                /*Use a random integer because this is the dumb AI.*/
                int randOKPass = (int)(Math.random() * 2);
                int randPPlantToBidOnIndex = (int)(Math.random() * 42);
//                int rand1 = (int)(Math.random() * 4);

                powerState.initiatePowerPlants();
                selectedPowerPlant = powerState.getAvailPowerplant().get(randPPlantToBidOnIndex);

                isClicked = true;
                if(isClicked == true) {
                    phase = 1;
                    UpdatePhaseAction upa = new UpdatePhaseAction(PowerGridDumbComputerPlayer.this, phase);
                    game.sendAction(upa);
                    return;
                }

            } else if(phase == 1) {
                /*Bidding on power plant(s).
                * Bidding or "pass" updates phase.*/
                BidAction bid;
//                BidAction bid = new BidAction(this, (int)Math.random()*20);
//                bid.getBid();
//                bidVal.setOnKeyListener(new bidEditTextListener());
                int randOKPass = (int)(Math.random()*2);
                isClicked = true;
                /*You could just put this in an else statement after evaluating randOKPass below.*/
                if(isClicked == true) {
                    phase = 2;
                    UpdatePhaseAction upa = new UpdatePhaseAction(PowerGridDumbComputerPlayer.this, phase);
                    game.sendAction(upa);
//                    return;
                }
                if(randOKPass == 1) {
//                    phase = 2;
                    bid = new BidAction(this, (int)Math.random()*20);
                    bid.getBid();
                    game.sendAction(bid);
//                    UpdatePhaseAction upa = new UpdatePhaseAction(PowerGridDumbComputerPlayer.this, phase);
//                    game.sendAction(upa);
                    return;
                }

            } else if(phase == 2) {
                /*Previous passer chooses a power plant.
                * "OK" or "Pass" updates phase.*
                * Same as when phase is 0 b/c same logic.
                * We don't determine who the previous passer was in this if statement.*/
                int randOKPass = (int)(Math.random() * 2);
                int randPPlantToBidOn = (int)(Math.random() * 42);
                selectedPowerPlant.setCost(powerState.getAvailPowerplant().get(randPPlantToBidOn).getCost());
                selectedPowerPlant.setPtP(powerState.getAvailPowerplant().get(randPPlantToBidOn).getPtP());
                selectedPowerPlant.setHp(powerState.getAvailPowerplant().get(randPPlantToBidOn).getHp());
                selectedPowerPlant.setKind(powerState.getAvailPowerplant().get(randPPlantToBidOn).getKind());

                isClicked = true;
                /*You could just put this in an else statement after evaluating randOKPass below.*/
                if(isClicked == true) {
                    phase = 3;
                    UpdatePhaseAction upa = new UpdatePhaseAction(PowerGridDumbComputerPlayer.this, phase);
                    game.sendAction(upa);
//                    return;
                }
                if(randOKPass == 1) {
//                    phase = 3;
                    SelectPowerPlantAction sppa = new SelectPowerPlantAction(PowerGridDumbComputerPlayer.this, selectedPowerPlant);
                    game.sendAction(sppa);
//                    UpdatePhaseAction upa = new UpdatePhaseAction(PowerGridDumbComputerPlayer.this, phase);
//                    game.sendAction(upa);
                    return;
                }
            } else if(phase == 3) {
                /*Second player chooses resources.
                * "OK" or "Pass" updates phase.*/
                int randOKPass = (int)(Math.random() * 2);

                isClicked = true;
                /*You could just put this in an else statement after evaluating randOKPass below.*/
                if (isClicked == true) {
                    phase = 4;
                    UpdatePhaseAction upa = new UpdatePhaseAction(PowerGridDumbComputerPlayer.this, phase);
                    game.sendAction(upa);
//                    return;
                }
                if (randOKPass == 1) {
//                    phase = 4;
//                    SelectPowerPlantAction sppa = new SelectPowerPlantAction(PowerGridDumbComputerPlayer.this, selectedPowerPlant);
//                    game.sendAction(sppa);
//                    UpdatePhaseAction upa = new UpdatePhaseAction(PowerGridDumbComputerPlayer.this, phase);
//                    game.sendAction(upa);
//                    return;
//                }

                    for (int i = 0; i < 15; i++) {
                        //if it's not available in the local store, it must have been bought!
                        if (!localStore.coal[i]) {
                            BuyCoalAction bca = new BuyCoalAction(PowerGridDumbComputerPlayer.this, i);
                            game.sendAction(bca);
                            return;
                        }

                        if (!localStore.trash[i]) {
                            BuyTrashAction bta = new BuyTrashAction(PowerGridDumbComputerPlayer.this, i);
                            game.sendAction(bta);
                            return;
                        }

                        if (i < 5 && !localStore.uranium[i]) {
                            BuyUraniumAction bua = new BuyUraniumAction(PowerGridDumbComputerPlayer.this, i);
                            game.sendAction(bua);
                            return;
                        }

                        if (i < 10 && !localStore.oil[i]) {
                            BuyOilAction boa = new BuyOilAction(PowerGridDumbComputerPlayer.this, i);
                            game.sendAction(boa);
                            return;
                        }
                    }
                }

            } else if(phase == 4) {
                /*First player chooses resources.
                * "OK" or "Pass" updates phase.*/
                int randOKPass = (int)(Math.random() * 2);

                isClicked = true;
                /*You could just put this in an else statement after evaluating randOKPass below.*/
                if (isClicked == true) {
                    phase = 4;
                    UpdatePhaseAction upa = new UpdatePhaseAction(PowerGridDumbComputerPlayer.this, phase);
                    game.sendAction(upa);
//                    return;
                }
                if (randOKPass == 1) {
//                    phase = 4;
//                    SelectPowerPlantAction sppa = new SelectPowerPlantAction(PowerGridDumbComputerPlayer.this, selectedPowerPlant);
//                    game.sendAction(sppa);
//                    UpdatePhaseAction upa = new UpdatePhaseAction(PowerGridDumbComputerPlayer.this, phase);
//                    game.sendAction(upa);
//                    return;

                    for(int i = 0; i < 15; i++) {
                        //if it's not available in the local store, it must have been bought!
                        if (!localStore.coal[i]) {
                            BuyCoalAction bca = new BuyCoalAction(PowerGridDumbComputerPlayer.this, i);
                            game.sendAction(bca);
                        }
                        if (!localStore.trash[i]) {
                            BuyTrashAction bta = new BuyTrashAction(PowerGridDumbComputerPlayer.this, i);
                            game.sendAction(bta);
                        }
                        if (i < 5) {
                            if (!localStore.uranium[i]) {
                                BuyUraniumAction bua = new BuyUraniumAction(PowerGridDumbComputerPlayer.this, i);
                                game.sendAction(bua);
                            }
                        }
                        if (i < 10) {
                            if (!localStore.oil[i]) {
                                BuyOilAction boa = new BuyOilAction(PowerGridDumbComputerPlayer.this, i);
                                game.sendAction(boa);
                            }
                        }
                    }
                }
            } else if(phase == 5) {
                /*Second player chooses cities.
                * "OK" or "Pass" updates phase.*/
                City selectedCity;
                int randCityToBidOnIndex = (int)(Math.random() * 20);
                selectedCity = powerState.getAvailCities().get(randCityToBidOnIndex);
                int randOKPass = (int)(Math.random() * 2);

                isClicked = true;
                if(isClicked == true) {
                    phase = 6;
                    UpdatePhaseAction upa = new UpdatePhaseAction(PowerGridDumbComputerPlayer.this, phase);
                    game.sendAction(upa);
                }
                if(randOKPass == 1) {
                    BuyCityAction bca = new BuyCityAction(PowerGridDumbComputerPlayer.this, selectedCity);
                    game.sendAction(bca);
                    return;
                }

            } else if(phase == 6) {
                /*First player chooses cities.
                * "OK" or "Pass" updates phase.*/
                City selectedCity;
                int randCityToBidOnIndex = (int)(Math.random() * 20);
                selectedCity = powerState.getAvailCities().get(randCityToBidOnIndex);
                int randOKPass = (int)(Math.random() * 2);

                isClicked = true;
                if(isClicked == true) {
                    phase = 6;
                    UpdatePhaseAction upa = new UpdatePhaseAction(PowerGridDumbComputerPlayer.this, phase);
                    game.sendAction(upa);
                }
                if(randOKPass == 1) {
                    BuyCityAction bca = new BuyCityAction(PowerGridDumbComputerPlayer.this, selectedCity);
                    game.sendAction(bca);
                    return;
                }
            } else {
                /*Other cases go here.*/
            }
        }
    }
}

