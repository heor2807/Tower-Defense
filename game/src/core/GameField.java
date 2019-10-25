package core;/*|===================================================||   This class manages every object in the field    ||===================================================| */import Graphic.ImageSheet;import Graphic.TileMap;public class GameField {    private static TileMap background = new TileMap(); //first layer    private static TileMap road = new TileMap();       //second layer    private static TileMap rockTree = new TileMap();   //third layer    private static TileMap spawn = new TileMap();      //final layer    private static ImageSheet imageSheet = new ImageSheet(); //load tiled sheet    public static void loadMap(){        //input layer data        background.readFile("Map/background.txt");        road.readFile("Map/road.txt");        rockTree.readFile("Map/rockTree.txt");        spawn.readFile("Map/spawn.txt");        //print to check        background.printMapData();        road.printMapData();        rockTree.printMapData();        spawn.printMapData();        //load tiled sheet        imageSheet.loadImageViewSheet("Graphic/towerDefense_tilesheet.png");    }    public static void loadGameplay(){    }}