package Entity.Immoveable.TowerExtend;

import Entity.Immoveable.Tower;
import Entity.Moveable.Bullet.Bullet;
import Entity.Moveable.Bullet.RocketBullet;
import Entity.Moveable.Enemy.Enemy;
import core.Config;
import core.GameField;
import core.GameStage;

public class RocketTower extends Tower {

    public RocketTower() {
        super(Config.ROCKET_TOWER_SPEED, Config.ROCKET_TOWER_RANGE, Config.ROCKET_BULLET_UPDATE_COST);
        //TODO: find the imageSheet index for machine gun
        setImg(GameField.getImageSheet().imageSheet.get(8*23 + 21), GameField.getImageSheet().imageSheet.get(7*23 + 20));
        setCost(Config.ROCKET_TOWER_COST);
        GameStage.buy((int)getCost());
    }

    protected long tickDown = 0;

    @Override
    public void shoot(Enemy enemy) {
        if (tickDown-- > 0) return;
        if (shootingEnemy != null) {
            tickDown = (int) getSpeed();
            Bullet bullet = new RocketBullet(getPosX(),getPosY(),0,0);
            bullet.setEnemy(enemy);
            GameField.addBullet(bullet);
        }
    }

    @Override
    public void updateTower() {
        super.updateTower();
        GameStage.buy((int)Config.MACHINE_GUN_BULLET_UPDATE_COST);
        setImg(GameField.getImageSheet().imageSheet.get(8*23 + 20), GameField.getImageSheet().imageSheet.get(7*23 + 20));
        setUpdated(true);
    }
}
