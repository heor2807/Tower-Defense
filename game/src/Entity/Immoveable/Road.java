package Entity.Immoveable;import core.Config;public class Road implements GameTile {    private int[][] roadInfo = new int[Config.MAP_HEIGHT][Config.MAP_WIDTH];    public Road(){}    public Road(int[][] roadTileMap){        setRoadInfo(roadTileMap);    }    public int[][] getRoadInfo() {        return roadInfo;    }    public void setRoadInfo(int[][] roadTileMap) {        for (int i=0; i<Config.MAP_HEIGHT; i++){            for (int j=0; j<Config.MAP_WIDTH; j++){                /**                 * "0" is immovable and "1" is movable                 * "2" is the spawn and "3" is the target                 */                if (roadTileMap[i][j] != 0) roadInfo[i][j] = 1;                else roadInfo[i][j] = 0;            }        }        //hack code (hack target, hack spawn)        roadInfo[6][1] = 2; roadInfo[6][2] = 2;        roadInfo[3][12] = 3; roadInfo[4][12] = 3;    }    public void printTestRoadInfo(){        System.out.println("Road Information");        for (int i=0; i<Config.MAP_HEIGHT; i++){            for (int j=0; j<Config.MAP_WIDTH; j++){                System.out.print(roadInfo[i][j] + " ");            }            System.out.println();        }    }}