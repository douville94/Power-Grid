package cs301.power_grid;


import java.util.ArrayList;


/**@author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 * Created by Computerz on 2/24/2017.
 */

public class City {

    private String name;
    private ArrayList<City> neighborhood = new ArrayList<City>(); //contains a list of all the neighbors of cities this city has

    public City(String myName, ArrayList<City> community){

        name = myName;

        for(int i = 0; i < community.size(); i++){
            neighborhood.set(i, community.get(i));
        }

    }

    public ArrayList<City> getNeighborhood(){return neighborhood;}
    public String getName(){return name;}

    public void addNeighbor(City n){neighborhood.add(n);} //add neighbors to the list
    public void setName(String n){name = n;} //cities are identified by name

}
