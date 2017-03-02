package cs301.power_grid;

import java.util.ArrayList;

/** @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 * Created by Computerz on 2/24/2017.
 */


public class PowerState {

    private int phase;
    private int coal;
    private int oil;
    private int uranium;
    private int trash;
    private ArrayList<City> copyCity = new ArrayList<City>();
    private ArrayList<Powerplant> copyPlants = new ArrayList<Powerplant>();
    private ArrayList<Inventory> gameInventories = new ArrayList<Inventory>(); //making an array list because we want to leave the option open for more than 2 players for later code

    public PowerState(int pha, int co, int oi, int ur, int tra, ArrayList<City> avCit, ArrayList<Powerplant> avPlan, ArrayList<Inventory> inventoryList){

        int i, j, k, m, n;
        phase = pha;
        coal = co;
        oil = oi;
        uranium = ur;
        trash = tra;

        //get the cities up and running
        for(i = 0; i < avCit.size(); i++){

            //copies the city over and goes to the trouble of saving each city name
            copyCity.add(avCit.get(i));
            copyCity.get(i).setName(avCit.get(i).getName());

            //one by one copies all of the neighbors over to the new copy city
            for(j = 0; j < avCit.get(i).getNeighborhood().size(); j++) {
                copyCity.get(i).addNeighbor(avCit.get(i).getNeighborhood().get(j));
            }
        }

        //get the powerplants up and running
        for(k = 0; k< avPlan.size(); k++){

            copyPlants.add(avPlan.get(k));
            copyPlants.get(k).setCost(avPlan.get(k).getCost());
            copyPlants.get(k).setPtP(avPlan.get(k).getPtP());
            copyPlants.get(k).setHp(avPlan.get(k).getHp());
            copyPlants.get(k).setKind(avPlan.get(k).getKind());
        }

        //lets save all the player data
        for(m = 0; m < inventoryList.size(); m++){

            gameInventories.add(inventoryList.get(m));
            gameInventories.get(m).setCoal(inventoryList.get(m).getCoal());
            gameInventories.get(m).setMoney(inventoryList.get(m).getMoney());
            gameInventories.get(m).setUranium(inventoryList.get(m).getUranium());
            gameInventories.get(m).setOil(inventoryList.get(m).getOil());
            gameInventories.get(m).setTrash(inventoryList.get(m).getTrash());

            for(n = 0; n < inventoryList.get(m).getMyPlants().size(); n++)
            gameInventories.get(m).addMyPlants(inventoryList.get(m).getMyPlants().get(n));
            gameInventories.get(m).addMyCity(inventoryList.get(m).getMyCities().get(n));
        }



    }

    public int getGameCoal(){return coal;}
    public int getGameOil(){return oil;}
    public int getGameUranium(){return uranium;}
    public int getGameTrash(){return trash;}
    public int getGamePhase(){return phase;}
    public ArrayList<City> getAvailCities(){return copyCity;}
    public ArrayList<Powerplant> getAvailPowerplant(){return copyPlants;}
    public ArrayList<Inventory> getGameInventories(){return gameInventories;}

    public void setGameCoal(int refresh){coal = refresh;}
    public void setGameOil(int refresh){oil = refresh;}
    public void setGameUranium(int refresh){uranium = refresh;}
    public void setGameTrash(int refresh){trash = refresh;}
    public void setGamePhase(int refresh){phase = refresh;}
    public void setAvailCities(ArrayList<City> newCit){copyCity = newCit;}
    public void setAvailPowerplant(ArrayList<Powerplant> newPlant){copyPlants = newPlant;}
    public void setGameInventories(ArrayList<Inventory> newInventory){gameInventories = newInventory;}
}
