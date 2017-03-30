package cs301.power_grid;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import game.GameHumanPlayer;
import game.GameMainActivity;
import game.infoMsg.GameInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * @author Luchini Guilian, Tibbetts Nathan, Douville Luke, Hoang Paul
 */


public class PowerGridHumanPlayer extends GameHumanPlayer {


    //instance variables
    //Do we get rid of these and make an instance of the Game state here
    private Inventory HumanPlayer = new Inventory();
    private Inventory OpponentPlayer = new Inventory();

    //instance of android activity we are running
    private GameMainActivity myActivity;

    //instance of the game state
    private PowerState powerState;


    //GUI features
    private Spinner resourcesSpinner;
    private Spinner powerPlantsSpinner;

    private TextView moneyTextView;
    private TextView coalNumView;
    private TextView oilNumView;
    private TextView trashNumView;
    private TextView nuclearNumView;
    private TextView costTextView1;
    private TextView typeTextView1;
    private TextView numberTextView1;
    private TextView housesTextView1;
    private TextView costTextView2;
    private TextView typeTextView2;
    private TextView numberTextView2;
    private TextView housesTextView2;
    private TextView costTextView3;
    private TextView typeTextView3;
    private TextView numberTextView3;
    private TextView housesTextView3;
    private TextView costTextView4;
    private TextView typeTextView4;
    private TextView numberTextView4;
    private TextView housesTextView4;

    private int basicGray = Color.rgb(214,215,215);
    private int prettyBlue = Color.rgb(0, 221, 255);

    private Button denverBut;
    private boolean denverOn = false;

    private Button seaBut;
    private boolean seaOn = false;

    private Button sfBut;
    private boolean sfOn = false;

    private Button laBut;
    private boolean laOn = false;

    private Button missoulaBut;
    private boolean missoulaOn = false;

    private Button boiseBut;
    private boolean boiseOn = false;

    private Button phxBut;
    private boolean phxOn = false;

    private Button omahaBut;
    private boolean omahaOn = false;

    private Button okcBut;
    private boolean okcOn = false;

    private Button dallasBut;
    private boolean dallasOn = false;

    private Button houBut;
    private boolean houOn = false;

    private Button stlouBut;
    private boolean stlouOn = false;

    private Button chiBut;
    private boolean chiOn = false;

    private Button memBut;
    private boolean memOn = false;

    private Button neworlBut;
    private boolean neworlOn = false;

    private Button detBut;
    private boolean detOn = false;

    private Button atlBut;
    private boolean atlOn = false;

    private Button miamiBut;
    private boolean miamiOn = false;

    private Button bosBut;
    private boolean bosOn = false;

    private Button nycBut;
    private boolean nycOn = false;

    private ImageButton coalButton1;

    //Constructor
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

        // remember the activity
        myActivity = activity;

        // Load the layout resource for our GUI
        activity.setContentView(R.layout.activity_main);
    }

    /**************************
     * onCreate
     *
     * initializes buttons and registers them to listeners
     *
     * @param savedInstanceState
     *************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resourcesSpinner =(Spinner)findViewById(R.id.UserResourcesSpinner);
        resourcesSpinner.setOnItemSelectedListener(new resourcesSpinListener());

        powerPlantsSpinner =(Spinner)findViewById(R.id.userPowerPlantsSpinner);
        powerPlantsSpinner.setOnItemSelectedListener(new powerPlantsSpinListener());

        costTextView1 = (TextView)findViewById(R.id.upp1cValue);
        typeTextView1 = (TextView)findViewById(R.id.upp1tValue);
        numberTextView1 = (TextView)findViewById(R.id.upp1nValue);
        housesTextView1 = (TextView)findViewById(R.id.upp1hValue);

        costTextView2 = (TextView)findViewById(R.id.upp2cValue);
        typeTextView2 = (TextView)findViewById(R.id.upp2tValue);
        numberTextView2 = (TextView)findViewById(R.id.upp2nValue);
        housesTextView2 = (TextView)findViewById(R.id.upp2hValue);

        costTextView3 = (TextView)findViewById(R.id.upp3cValue);
        typeTextView3 = (TextView)findViewById(R.id.upp3tValue);
        numberTextView3 = (TextView)findViewById(R.id.upp3nValue);
        housesTextView3 = (TextView)findViewById(R.id.upp3hValue);

        costTextView4 = (TextView)findViewById(R.id.upp4cValue);
        typeTextView4 = (TextView)findViewById(R.id.upp4tValue);
        numberTextView4 = (TextView)findViewById(R.id.upp4nValue);
        housesTextView4 = (TextView)findViewById(R.id.upp4hValue);

        moneyTextView = (TextView)findViewById(R.id.moneyTextView);
        coalNumView =(TextView)findViewById(R.id.coalNumView);
        oilNumView =(TextView)findViewById(R.id.oilNumView);
        trashNumView =(TextView)findViewById(R.id.trashNumView);
        nuclearNumView=(TextView)findViewById(R.id.nuclearTextView);

        coalButton1 = (ImageButton)findViewById(R.id.cb1s1);
        coalButton1.setOnClickListener(new CoalButtonListener(moneyTextView, coalNumView));

        denverBut = (Button) findViewById(R.id.button4);
        denverBut.setOnClickListener(new denverButListener());

        seaBut = (Button) findViewById(R.id.button);
        seaBut.setOnClickListener(new seaButListener());

        sfBut = (Button) findViewById(R.id.button2);
        sfBut.setOnClickListener(new sfButListener());

        laBut = (Button) findViewById(R.id.button3);
        laBut.setOnClickListener(new laButListener());

        missoulaBut = (Button) findViewById(R.id.button21);
        missoulaBut.setOnClickListener(new missoulaButListener());

        boiseBut = (Button) findViewById(R.id.button20);
        boiseBut.setOnClickListener(new boiseButListener());

        phxBut = (Button) findViewById(R.id.button7);
        phxBut.setOnClickListener(new phxButListener());

        omahaBut = (Button) findViewById(R.id.button5);
        omahaBut.setOnClickListener(new omahaButListener());

        okcBut = (Button) findViewById(R.id.button19);
        okcBut.setOnClickListener(new okcButListener());

        dallasBut = (Button) findViewById(R.id.button9);
        dallasBut.setOnClickListener(new dallasButListener());

        houBut = (Button) findViewById(R.id.button8);
        houBut.setOnClickListener(new houButListener());

        stlouBut = (Button) findViewById(R.id.button10);
        stlouBut.setOnClickListener(new stlouButListener());

        chiBut = (Button) findViewById(R.id.button6);
        chiBut.setOnClickListener(new chiButListener());

        memBut = (Button) findViewById(R.id.button12);
        memBut.setOnClickListener(new memButListener());

        neworlBut = (Button) findViewById(R.id.button11);
        neworlBut.setOnClickListener(new neworlButListener());

        detBut = (Button) findViewById(R.id.button17);
        detBut.setOnClickListener(new detButListener());

        atlBut = (Button) findViewById(R.id.button14);
        atlBut.setOnClickListener(new atlButListener());

        miamiBut = (Button) findViewById(R.id.button15);
        miamiBut.setOnClickListener(new miamiButListener());

        nycBut = (Button) findViewById(R.id.button16);
        nycBut.setOnClickListener(new nycButListener());

        bosBut = (Button) findViewById(R.id.button18);
        bosBut.setOnClickListener(new bosButListener());
    }

    /**
     * setResources
     *
     * to be used in the spinners methods, sets resources text on GUI
     *
     * @param rsc //resource
     */
    private void setResources(Inventory rsc){
        moneyTextView.setText(""+ rsc.getMoney());
        coalNumView.setText(""+ rsc.getCoal());
        oilNumView.setText("" + rsc.getOil());
        trashNumView.setText("" + rsc.getTrash());
        nuclearNumView.setText("" + rsc.getUranium());
    }

    /**
     * setPowerPlants
     *
     * to be used in the spinners methods, sets power plants text on GUI
     *
     * @param upp //userPowerPlant
     */
    private void setPowerPlants(Inventory upp) {
        costTextView1.setText("");
        typeTextView1.setText("");
        numberTextView1.setText("");
        housesTextView1.setText("");

        costTextView2.setText("");
        typeTextView2.setText("");
        numberTextView2.setText("");
        housesTextView2.setText("");

        costTextView3.setText("");
        typeTextView3.setText("");
        numberTextView3.setText("");
        housesTextView3.setText("");

        costTextView4.setText("");
        typeTextView4.setText("");
        numberTextView4.setText("");
        housesTextView4.setText("");

        if (upp.getMyPlants().size() > 0) {
            costTextView1.setText("" + upp.getMyPlants().get(0).getCost());
            typeTextView1.setText("" + upp.getMyPlants().get(0).getKind());
            numberTextView1.setText("" + upp.getMyPlants().get(0).getPtP());
            housesTextView1.setText("" + upp.getMyPlants().get(0).getHp());
        }
        if (upp.getMyPlants().size() > 1) {
            costTextView2.setText("" + upp.getMyPlants().get(1).getCost());
            typeTextView2.setText("" + upp.getMyPlants().get(1).getKind());
            numberTextView2.setText("" + upp.getMyPlants().get(1).getPtP());
            housesTextView2.setText("" + upp.getMyPlants().get(1).getHp());
        }
        if (upp.getMyPlants().size() > 2) {
            costTextView3.setText("" + upp.getMyPlants().get(2).getCost());
            typeTextView3.setText("" + upp.getMyPlants().get(2).getKind());
            numberTextView3.setText("" + upp.getMyPlants().get(2).getPtP());
            housesTextView3.setText("" + upp.getMyPlants().get(2).getHp());
        }
        if (upp.getMyPlants().size() > 3) {
            costTextView4.setText("" + upp.getMyPlants().get(3).getCost());
            typeTextView4.setText("" + upp.getMyPlants().get(3).getKind());
            numberTextView4.setText("" + upp.getMyPlants().get(3).getPtP());
            housesTextView4.setText("" + upp.getMyPlants().get(3).getHp());
        }
    }

    /**
     * resourceSpinListener
     *
     * configures the spinner in the upper left of the GUI to display
     * either Humanplayers resources or opponent
     */
    private class resourcesSpinListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //String currVal = resourcesSpinner.getSelectedItem().toString();
            switch (position){
                case 0:
                    setResources(HumanPlayer);
                    break;
                case 1:
                    setResources(OpponentPlayer);
                    break;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            //do nothing
        }
    }

    /**
     * powerPlantsSpinListener
     *
     * configures the spinner on the map to display
     * either Human Opponent's powerplants
     */
    private class powerPlantsSpinListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //String currVal = resourcesSpinner.getSelectedItem().toString();
            switch (position){
                case 0:
                    setPowerPlants(HumanPlayer);
                    break;
                case 1:
                    setPowerPlants(OpponentPlayer);
                    break;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            //do nothing
        }
    }


    private class denverButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (denverOn) {


                denverBut.setBackgroundColor(basicGray);

                denverOn = false;
            } else {

                denverBut.setBackgroundColor(prettyBlue);
                denverOn = true;
            }
        }
    }

    private class seaButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (seaOn) {


                seaBut.setBackgroundColor(basicGray);

                seaOn = false;
            } else {

                seaBut.setBackgroundColor(prettyBlue);
                seaOn = true;
            }
        }
    }

    private class bosButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (bosOn) {


                bosBut.setBackgroundColor(basicGray);

                bosOn = false;
            } else {

                bosBut.setBackgroundColor(prettyBlue);
                bosOn = true;
            }
        }
    }

    private class nycButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (nycOn) {


                nycBut.setBackgroundColor(basicGray);

                nycOn = false;
            } else {

                nycBut.setBackgroundColor(prettyBlue);
                nycOn = true;
            }
        }
    }

    private class miamiButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (miamiOn) {


                miamiBut.setBackgroundColor(basicGray);

                miamiOn = false;
            } else {

                miamiBut.setBackgroundColor(prettyBlue);
                miamiOn = true;
            }
        }
    }

    private class atlButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (atlOn) {


                atlBut.setBackgroundColor(basicGray);

                atlOn = false;
            } else {

                atlBut.setBackgroundColor(prettyBlue);
                atlOn = true;
            }
        }
    }

    private class detButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (detOn) {


                detBut.setBackgroundColor(basicGray);

                detOn = false;
            } else {

                detBut.setBackgroundColor(prettyBlue);
                detOn = true;
            }
        }
    }

    private class chiButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (chiOn) {


                chiBut.setBackgroundColor(basicGray);

                chiOn = false;
            } else {

                chiBut.setBackgroundColor(prettyBlue);
                chiOn = true;
            }
        }
    }

    private class neworlButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (neworlOn) {


                neworlBut.setBackgroundColor(basicGray);

                neworlOn = false;
            } else {

                neworlBut.setBackgroundColor(prettyBlue);
                neworlOn = true;
            }
        }
    }

    private class memButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (memOn) {


                memBut.setBackgroundColor(basicGray);

                memOn = false;
            } else {

                memBut.setBackgroundColor(prettyBlue);
                memOn = true;
            }
        }
    }

    private class stlouButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (stlouOn) {


                stlouBut.setBackgroundColor(basicGray);

                stlouOn = false;
            } else {

                stlouBut.setBackgroundColor(prettyBlue);
                stlouOn = true;
            }
        }
    }

    private class houButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (houOn) {


                houBut.setBackgroundColor(basicGray);

                houOn = false;
            } else {

                houBut.setBackgroundColor(prettyBlue);
                houOn = true;
            }
        }
    }

    private class dallasButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (dallasOn) {


                dallasBut.setBackgroundColor(basicGray);

                dallasOn = false;
            } else {

                dallasBut.setBackgroundColor(prettyBlue);
                dallasOn = true;
            }
        }
    }

    private class okcButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (okcOn) {


                okcBut.setBackgroundColor(basicGray);

                okcOn = false;
            } else {

                okcBut.setBackgroundColor(prettyBlue);
                okcOn = true;
            }
        }
    }

    private class omahaButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (omahaOn) {


                omahaBut.setBackgroundColor(basicGray);

                omahaOn = false;
            } else {

                omahaBut.setBackgroundColor(prettyBlue);
                omahaOn = true;
            }
        }
    }

    private class phxButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (phxOn) {


                phxBut.setBackgroundColor(basicGray);

                phxOn = false;
            } else {

                phxBut.setBackgroundColor(prettyBlue);
                phxOn = true;
            }
        }
    }

    private class boiseButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (boiseOn) {


                boiseBut.setBackgroundColor(basicGray);

                boiseOn = false;
            } else {

                boiseBut.setBackgroundColor(prettyBlue);
                boiseOn = true;
            }
        }
    }

    private class missoulaButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (missoulaOn) {


                missoulaBut.setBackgroundColor(basicGray);

                missoulaOn = false;
            } else {

                missoulaBut.setBackgroundColor(prettyBlue);
                missoulaOn = true;
            }
        }
    }

    private class laButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (laOn) {


                laBut.setBackgroundColor(basicGray);

                laOn = false;
            } else {

                laBut.setBackgroundColor(prettyBlue);
                laOn = true;
            }
        }
    }

    private class sfButListener implements View.OnClickListener {
        public void onClick(View v) {
            if (sfOn) {


                sfBut.setBackgroundColor(basicGray);

                sfOn = false;
            } else {

                sfBut.setBackgroundColor(prettyBlue);
                sfOn = true;
            }
        }
    }

    //implements the coal buttons
    public class CoalButtonListener implements View.OnClickListener {

        public CoalButtonListener(TextView initTextView, TextView initCoalNumView) {
            moneyTextView = initTextView;
            coalNumView = initCoalNumView;

        }

        @Override
        public void onClick(View view) {
            int viewId = view.getId();
            int currMoneyVal = Integer.parseInt(moneyTextView.getText().toString());
            int currCoalVal = Integer.parseInt(coalNumView.getText().toString());
            int newMoneyVal = currMoneyVal - 1;
            int newCoalVal = currCoalVal + 1;

            if (viewId == R.id.cb1s1) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }


            if (viewId == R.id.cb2s1) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb3s1) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb1s2) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb2s2) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb3s2) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb1s3) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb2s3) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb3s3) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb1s4) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb2s4) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb3s4) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb1s5) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb2s5) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

            if (viewId == R.id.cb3s5) {
                moneyTextView.setText("" + newMoneyVal);
                coalNumView.setText("" + newCoalVal);
            } else {
                return;
            }

        }
    }

    //implements the oil buttons
    public class OilButtonListener implements View.OnClickListener {

        public OilButtonListener(TextView initTextView, TextView initOilNumView) {
            moneyTextView = initTextView;
            oilNumView = initOilNumView;

        }

        @Override
        public void onClick(View view) {
            int viewId = view.getId();
            int currMoneyVal = Integer.parseInt(moneyTextView.getText().toString());
            int currOilVal = Integer.parseInt(oilNumView.getText().toString());
            int newMoneyVal = currMoneyVal - 3;
            int newOilVal = currOilVal + 1;

            if (viewId == R.id.ob1s2) {
                moneyTextView.setText("" + newMoneyVal);
                oilNumView.setText("" + newOilVal);
            } else {
                return;
            }

            if (viewId == R.id.ob2s2) {
                moneyTextView.setText("" + newMoneyVal);
                oilNumView.setText("" + newOilVal);
            } else {
                return;
            }

            if (viewId == R.id.ob1s3) {
                moneyTextView.setText("" + newMoneyVal);
                oilNumView.setText("" + newOilVal);
            } else {
                return;
            }

            if (viewId == R.id.ob2s3) {
                moneyTextView.setText("" + newMoneyVal);
                oilNumView.setText("" + newOilVal);
            } else {
                return;
            }

            if (viewId == R.id.ob1s4) {
                moneyTextView.setText("" + newMoneyVal);
                oilNumView.setText("" + newOilVal);
            } else {
                return;
            }

            if (viewId == R.id.ob2s4) {
                moneyTextView.setText("" + newMoneyVal);
                oilNumView.setText("" + newOilVal);
            } else {
                return;
            }

            if (viewId == R.id.ob1s5) {
                moneyTextView.setText("" + newMoneyVal);
                oilNumView.setText("" + newOilVal);
            } else {
                return;
            }

            if (viewId == R.id.ob2s5) {
                moneyTextView.setText("" + newMoneyVal);
                oilNumView.setText("" + newOilVal);
            } else {
                return;
            }
        }
    }

    //implements the trash buttons
    public class TrashButtonListener implements View.OnClickListener {

        public TrashButtonListener(TextView initTextView, TextView initTrashNumView) {
            moneyTextView = initTextView;
            trashNumView = initTrashNumView;

        }

        @Override
        public void onClick(View view) {
            int viewId = view.getId();
            int currMoneyVal = Integer.parseInt(moneyTextView.getText().toString());
            int currTrashVal = Integer.parseInt(trashNumView.getText().toString());
            int newMoneyVal = currMoneyVal - 7;
            int newTrashVal = currTrashVal + 1;

            if (viewId == R.id.gb1s2) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }

            if (viewId == R.id.gb2s2) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }
            if (viewId == R.id.gb3s2) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }

            if (viewId == R.id.gb1s3) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }

            if (viewId == R.id.gb2s3) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }

            if (viewId == R.id.gb3s3) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }

            if (viewId == R.id.gb1s4) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }

            if (viewId == R.id.gb2s4) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }

            if (viewId == R.id.gb3s4) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }

            if (viewId == R.id.gb1s5) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }

            if (viewId == R.id.gb2s5) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }

            if (viewId == R.id.gb3s5) {
                moneyTextView.setText("" + newMoneyVal);
                trashNumView.setText("" + newTrashVal);
            } else {
                return;
            }
        }
    }

    //implements the nuclear buttons
    public class NuclearButtonListener implements View.OnClickListener {

        public NuclearButtonListener(TextView initTextView, TextView initNuclearNumView) {
            moneyTextView = initTextView;
            nuclearNumView = initNuclearNumView;

        }

        @Override
        public void onClick(View view) {
            int viewId = view.getId();
            int currMoneyVal = Integer.parseInt(moneyTextView.getText().toString());
            int currNuclearVal = Integer.parseInt(nuclearNumView.getText().toString());
            int newMoneyVal = currMoneyVal - 14;
            int newNucelarVal = currNuclearVal + 1;

            if (viewId == R.id.ub1s2) {
                moneyTextView.setText("" + newMoneyVal);
                nuclearNumView.setText("" + newNucelarVal);
            } else {
                return;
            }

            if (viewId == R.id.ub1s3) {
                moneyTextView.setText("" + newMoneyVal);
                nuclearNumView.setText("" + newNucelarVal);
            } else {
                return;
            }

            if (viewId == R.id.ub1s4) {
                moneyTextView.setText("" + newMoneyVal);
                nuclearNumView.setText("" + newNucelarVal);
            } else {
                return;
            }

            if (viewId == R.id.ub1s5) {
                moneyTextView.setText("" + newMoneyVal);
                nuclearNumView.setText("" + newNucelarVal);
            } else {
                return;
            }
        }
    }


}
