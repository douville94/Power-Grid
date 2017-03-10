package cs301.power_grid;


import java.util.ArrayList;


/**@author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 * Created by Computerz on 2/24/2017.
 */

public class City {

    private String name;
    private ArrayList<City> neighborhood = new ArrayList<City>(); //contains a list of all the neighbors of cities this city has
    private ArrayList<Integer> costs = new ArrayList<Integer>();

    public City(String myName){
        name = myName;
    }
    public City(String myName, ArrayList<City> community, ArrayList<Integer> prices){

        name = myName;

        for(int i = 0; i < community.size(); i++){
            neighborhood.add(i, community.get(i));
        }
        for(int i = 0; i < prices.size(); i++){
            costs.add(i, prices.get(i));
        }
    }

    public City(){
        name = "Nathan";
    }

    public ArrayList<City> getNeighborhood(){return neighborhood;}
    public String getName(){return name;}
    public ArrayList<Integer> getCosts(){return costs;}

    public void addNeighbor(City n){neighborhood.add(n);} //add neighbors to the list
    public void setName(String n){name = n;} //cities are identified by name
    public void addCost(int n){costs.add(n);}
}

