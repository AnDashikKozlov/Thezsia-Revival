package Thezsia.world.blocks.production;

import arc.Core;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.blocks.production.Drill;
import Thezsia.world.meta.ThezStats;

//Code by ItzCraft. This shit is not working :/ Or just... I'm stupid
public class AccelDrill extends Drill {
    // The acceleration time
    public int accelTime;
    // the limit of multiplier (drillTime * limit)
    public int accelLimit;
    //the multiplier of acceleration
    public float drillAccelMultiplier;
    public float powerRequirement;

    public final float oldDrillTime = drillTime;
    public final float oldRotateSpeed =  rotateSpeed;
    public final float oldPowerRequirement = powerRequirement;

    public AccelDrill(String name){
        super(name);
        hasPower = true;
    }

    @Override
    public void setStats(){
        super.setStats();

        stats.add(ThezStats.accelTime, accelTime*60);
        stats.add(ThezStats.accelLimit, accelLimit*drillTime);
        stats.add(ThezStats.drillAccelMultiplier, drillAccelMultiplier);
        stats.add(ThezStats.powerRequirement, powerRequirement*60);
    }

    @Override
    public void setBars() {
        super.setBars();
        addBar("Acceleration", (AccelDrillBuild) ->
                new Bar(() ->
                        Core.bundle.format("bar.accel", drillTime*drillAccelMultiplier),
                        () -> Pal.lighterOrange,
                        () -> drillTime*drillAccelMultiplier
                )
        );
    }

    public class AccelDrillBuild extends DrillBuild {
        @Override
        public void updateTile(){
            if(efficiency > 0){
                if(drillTime < oldDrillTime*accelLimit ) {
                    drillTime = drillTime*1;
                }
                else {
                    drillTime = drillTime * drillAccelMultiplier;
                    rotateSpeed = rotateSpeed * drillAccelMultiplier;
                    powerRequirement = powerRequirement*drillAccelMultiplier;
                }
            }
            else{
                drillTime = oldDrillTime;
                rotateSpeed = oldRotateSpeed;
                powerRequirement = oldPowerRequirement;
            }
            consumePower(powerRequirement);
            super.updateTile();
        }
    }
}