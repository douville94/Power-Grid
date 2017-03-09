package cs301.power_grid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Button;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageButton;

import game.GameMainActivity;
import game.GamePlayer;
import game.LocalGame;
import game.config.GameConfig;
import game.config.GamePlayerType;

public class MainActivity extends GameMainActivity {

    //instance variables
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


    UserResources YourResources = new UserResources(150,2,0,6,0);;
    UserResources OtherResources = new UserResources(80,0,3,0,1);;

    UserPowerPlants YourPowerPlants = new UserPowerPlants(80,"Coal",3,0);
    UserPowerPlants OtherPlayersPowerPlants = new UserPowerPlants(10,"Oil",5,6);

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


    @Override
    public GameConfig createDefaultConfig() {
        return null;
    }

    @Override
    public LocalGame createLocalGame() {
        return null;
    }

//    /**
//     * onCreate
//     *
//     * initializes listeners and registers them
//     *
//     * @param savedInstanceState
//     *///////////********MAKE PROTECTED WHEN MOVE TO HUMAN PLAYER*******////////
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        resourcesSpinner =(Spinner)findViewById(R.id.UserResourcesSpinner);
//        resourcesSpinner.setOnItemSelectedListener(new resourcesSpinListener());
//
//        powerPlantsSpinner =(Spinner)findViewById(R.id.userPowerPlantsSpinner);
//        powerPlantsSpinner.setOnItemSelectedListener(new powerPlantsSpinListener());
//
//        costTextView1 = (TextView)findViewById(R.id.upp1cValue);
//        typeTextView1 = (TextView)findViewById(R.id.upp1tValue);
//        numberTextView1 = (TextView)findViewById(R.id.upp1nValue);
//        housesTextView1 = (TextView)findViewById(R.id.upp1hValue);
//
//        costTextView2 = (TextView)findViewById(R.id.upp2cValue);
//        typeTextView2 = (TextView)findViewById(R.id.upp2tValue);
//        numberTextView2 = (TextView)findViewById(R.id.upp2nValue);
//        housesTextView2 = (TextView)findViewById(R.id.upp2hValue);
//
//        costTextView3 = (TextView)findViewById(R.id.upp3cValue);
//        typeTextView3 = (TextView)findViewById(R.id.upp3tValue);
//        numberTextView3 = (TextView)findViewById(R.id.upp3nValue);
//        housesTextView3 = (TextView)findViewById(R.id.upp3hValue);
//
//        costTextView4 = (TextView)findViewById(R.id.upp4cValue);
//        typeTextView4 = (TextView)findViewById(R.id.upp4tValue);
//        numberTextView4 = (TextView)findViewById(R.id.upp4nValue);
//        housesTextView4 = (TextView)findViewById(R.id.upp4hValue);
//
//        moneyTextView = (TextView)findViewById(R.id.moneyTextView);
//        coalNumView =(TextView)findViewById(R.id.coalNumView);
//        oilNumView =(TextView)findViewById(R.id.oilNumView);
//        trashNumView =(TextView)findViewById(R.id.trashNumView);
//        nuclearNumView=(TextView)findViewById(R.id.nuclearTextView);
//
//        coalButton1 = (ImageButton)findViewById(R.id.coalButton1);
//        coalButton1.setOnClickListener(new CoalButtonListener(moneyTextView, coalNumView));
//
//        denverBut = (Button) findViewById(R.id.button4);
//        denverBut.setOnClickListener(new denverButListener());
//
//        seaBut = (Button) findViewById(R.id.button);
//        seaBut.setOnClickListener(new seaButListener());
//
//        sfBut = (Button) findViewById(R.id.button2);
//        sfBut.setOnClickListener(new sfButListener());
//
//        laBut = (Button) findViewById(R.id.button3);
//        laBut.setOnClickListener(new laButListener());
//
//        missoulaBut = (Button) findViewById(R.id.button21);
//        missoulaBut.setOnClickListener(new missoulaButListener());
//
//        boiseBut = (Button) findViewById(R.id.button20);
//        boiseBut.setOnClickListener(new boiseButListener());
//
//        phxBut = (Button) findViewById(R.id.button7);
//        phxBut.setOnClickListener(new phxButListener());
//
//        omahaBut = (Button) findViewById(R.id.button5);
//        omahaBut.setOnClickListener(new omahaButListener());
//
//        okcBut = (Button) findViewById(R.id.button19);
//        okcBut.setOnClickListener(new okcButListener());
//
//        dallasBut = (Button) findViewById(R.id.button9);
//        dallasBut.setOnClickListener(new dallasButListener());
//
//        houBut = (Button) findViewById(R.id.button8);
//        houBut.setOnClickListener(new houButListener());
//
//        stlouBut = (Button) findViewById(R.id.button10);
//        stlouBut.setOnClickListener(new stlouButListener());
//
//        chiBut = (Button) findViewById(R.id.button6);
//        chiBut.setOnClickListener(new chiButListener());
//
//        memBut = (Button) findViewById(R.id.button12);
//        memBut.setOnClickListener(new memButListener());
//
//        neworlBut = (Button) findViewById(R.id.button11);
//        neworlBut.setOnClickListener(new neworlButListener());
//
//        detBut = (Button) findViewById(R.id.button17);
//        detBut.setOnClickListener(new detButListener());
//
//        atlBut = (Button) findViewById(R.id.button14);
//        atlBut.setOnClickListener(new atlButListener());
//
//        miamiBut = (Button) findViewById(R.id.button15);
//        miamiBut.setOnClickListener(new miamiButListener());
//
//        nycBut = (Button) findViewById(R.id.button16);
//        nycBut.setOnClickListener(new nycButListener());
//
//        bosBut = (Button) findViewById(R.id.button18);
//        bosBut.setOnClickListener(new bosButListener());
//
//
//    }

    private class resourcesSpinListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //String currVal = resourcesSpinner.getSelectedItem().toString();
           switch (position){
               case 0:
                   setResources(YourResources);
                   break;
               case 1:
                   setResources(OtherResources);
                   break;
           }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            //do nothing
        }
    }

    private void setResources(UserResources rsc){
        moneyTextView.setText(""+ rsc.money);
        coalNumView.setText(""+ rsc.coal);
        oilNumView.setText("" + rsc.oil);
        trashNumView.setText("" + rsc.trash);
        nuclearNumView.setText("" + rsc.nuclear);
    }

    private void setPowerPlants(UserPowerPlants upp)
    {
        costTextView1.setText(""+upp.cost);
        typeTextView1.setText(""+upp.type);
        numberTextView1.setText(""+upp.number);
        housesTextView1.setText(""+upp.houses);

        costTextView2.setText(""+upp.cost);
        typeTextView2.setText(""+upp.type);
        numberTextView2.setText(""+upp.number);
        housesTextView2.setText(""+upp.houses);

        costTextView3.setText(""+upp.cost);
        typeTextView3.setText(""+upp.type);
        numberTextView3.setText(""+upp.number);
        housesTextView3.setText(""+upp.houses);

        costTextView4.setText(""+upp.cost);
        typeTextView4.setText(""+upp.type);
        numberTextView4.setText(""+upp.number);
        housesTextView4.setText(""+upp.houses);
    }

    private class powerPlantsSpinListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //String currVal = resourcesSpinner.getSelectedItem().toString();
            switch (position){
                case 0:
                    setPowerPlants(YourPowerPlants);
                    break;
                case 1:
                    setPowerPlants(OtherPlayersPowerPlants);
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

    //COULD GET RID OF USERRESOURCES AND USERPOWERPLANTS AND REPLACE WITH INVENTORY AND POWERPLANT
    //USED IN SPINNERS
    public class UserResources//(int one, int two, int three, int four, int five)
    {
        int coal;
        int oil;
        int nuclear;
        int money;
        int trash;

        public UserResources(int constructCoal, int constructOil, int constructNuclear, int constructMoney, int constructTrash)
        {
            coal = constructCoal;
            oil = constructOil;
            nuclear = constructNuclear;
            money = constructMoney;
            trash = constructTrash;
        }
    }

    public class UserPowerPlants
    {
        int cost;
        String type;
        int number;
        int houses;

        public UserPowerPlants(int constructCost, String constructType, int constructNumber, int constructHouses)
        {
            cost = constructCost;
            type = constructType;
            number = constructNumber;
            houses = constructHouses;
        }
    }
}