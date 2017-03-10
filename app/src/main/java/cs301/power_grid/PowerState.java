package cs301.power_grid;

import java.util.ArrayList;

import game.GamePlayer;
import game.infoMsg.GameState;

/** @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 * Created by Computerz on 2/24/2017.
 */

public class PowerState extends GameState {

    private int currentBid;
    private int phase;
    private int turn;
    private ArrayList<City> cities = new ArrayList<City>();
    private ArrayList<Powerplant> salePlants = new ArrayList<Powerplant>();
    private ArrayList<Inventory> gameInventories = new ArrayList<Inventory>(); //making an array list because we want to leave the option open for more than 2 players for later code
    private ResourceStore availableResources;



    //Regular Constructor
    public PowerState(int initPhase, ArrayList<City> initCities, ArrayList<Powerplant> initSalePlants,ArrayList<Inventory> initGameInventories, ResourceStore initAvailableResources ){
        phase = initPhase;
        cities = initCities;
        salePlants = initSalePlants;
        gameInventories = initGameInventories;
        availableResources = initAvailableResources;
    }

    //Copy Constructor
    public PowerState(PowerState original){

        int i, j, k, m, n;

        //get the cities up and running
        for(i = 0; i < original.cities.size(); i++){
            //copies the city over and goes to the trouble of saving each city name
            cities.add(original.cities.get(i));
            cities.get(i).setName(original.cities.get(i).getName());

            //one by one copies all of the neighbors over to the new copy city
            for(j = 0; j < original.cities.get(i).getNeighborhood().size(); j++) {
                cities.get(i).addNeighbor(original.cities.get(i).getNeighborhood().get(j));
            }
        }

        //get the powerplants up and running
        for(k = 0; k< original.salePlants.size(); k++){
            salePlants.add(original.salePlants.get(k));
            salePlants.get(k).setCost(original.salePlants.get(k).getCost());
            salePlants.get(k).setPtP(original.salePlants.get(k).getPtP());
            salePlants.get(k).setHp(original.salePlants.get(k).getHp());
            salePlants.get(k).setKind(original.salePlants.get(k).getKind());
        }

        //lets save all the player data
        for(m = 0; m < original.gameInventories.size(); m++){
            gameInventories.add(original.gameInventories.get(m));
            gameInventories.get(m).setCoal(original.gameInventories.get(m).getCoal());
            gameInventories.get(m).setMoney(original.gameInventories.get(m).getMoney());
            gameInventories.get(m).setUranium(original.gameInventories.get(m).getUranium());
            gameInventories.get(m).setOil(original.gameInventories.get(m).getOil());
            gameInventories.get(m).setTrash(original.gameInventories.get(m).getTrash());

            for(n = 0; n < original.gameInventories.get(m).getMyPlants().size(); n++)
            gameInventories.get(m).addMyPlants(original.gameInventories.get(m).getMyPlants().get(n));
            gameInventories.get(m).addMyCity(original.gameInventories.get(m).getMyCities().get(n));
        }
    }
    public void performBidding(BidAction bA){
        currentBid = bA.getBid();
    }

    public void performBuyCity(GamePlayer player, BuyCityAction bCA){
        boolean didithappen = player.inventory.addMyCity(bCA.getCity());
        if(!didithappen){} //vibrate screen
    }

    public void performBuyOil(GamePlayer player, BuyOilAction bOA, int index){
        int price = (index/3+1);
        if (availableResources.coal[index] && player.inventory.getMoney() >= price){
            availableResources.coal[index] = false;
            player.inventory.setMoney(player.inventory.getMoney()-price);
            player.inventory.setOil(player.inventory.getOil()+1);

        }
    }

    //getters
    public int getGamePhase(){return phase;}
    public ArrayList<City> getAvailCities(){return cities;}
    public ArrayList<Powerplant> getAvailPowerplant(){return salePlants;}
    public ArrayList<Inventory> getGameInventories(){return gameInventories;}
    public ResourceStore getAvailableResources(){return availableResources;}

    //setters
    public void setGamePhase(int refresh){phase = refresh;}
    public void setAvailCities(ArrayList<City> newCit){cities = newCit;}
    public void setSalePlants(ArrayList<Powerplant> newPlant){salePlants = newPlant;}
    public void setGameInventories(ArrayList<Inventory> newInventory){gameInventories = newInventory;}
    public void setAvailableResources(ResourceStore newResources){availableResources = newResources;}



}
