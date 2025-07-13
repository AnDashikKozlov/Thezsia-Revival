package Thezsia.world.blocks.storage;

import arc.Core;
import arc.func.Func;
import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.util.Strings;
import arc.util.Time;
import mindustry.core.UI;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.blocks.storage.CoreBlock;

public class GeneratorCore extends CoreBlock{

    public TextureRegion glow;
    public float glowMag = 0.5f;
    public float glowScl = 10f;

    public float passiveEnergyOut = 60 / 60f;

    public GeneratorCore(String name){
        super(name);
        hasPower = true;
        conductivePower= true;
        outputsPower = true;
        consumesPower = false;
    }

    @Override
    public void load(){
        super.load();
        glow = Core.atlas.find(name + "-glow");
        uiIcon = fullIcon = editorIcon = Core.atlas.find(name + "-full");
    }

    @Override
    public void setBars(){
        super.setBars();
        addBar("poweroutput", (GeneratorCoreBuild entity) ->
                new Bar(
                        () -> Core.bundle.format("bar.poweroutput", Strings.fixed(passiveEnergyOut * 60, 1)),
                        () -> Pal.powerBar,
                        () -> 1f
                )
        );
    }

    public static Func<Building, Bar> makePowerBalance(){
        return entity -> new Bar(() ->
                Core.bundle.format("bar.powerbalance",
                        ((entity.power.graph.getPowerBalance() >= 0 ? "+" : "") + UI.formatAmount((long)(entity.power.graph.getPowerBalance() * 60 + 0.0001f)))),
                () -> Pal.powerBar,
                () -> Mathf.clamp(entity.power.graph.getLastPowerProduced() / entity.power.graph.getLastPowerNeeded())
        );
    }

    public class GeneratorCoreBuild extends CoreBuild{
        @Override
        public void draw(){
            super.draw();
            Drawf.additive(glow, team.color, 0.8f - glowMag + Mathf.absin(Time.time, glowScl, glowMag), x, y, 0f, Layer.blockAdditive);
        }

        @Override
        public void onProximityUpdate(){
            super.onProximityUpdate();
            if(!allowUpdate()){
                enabled = false;
            }
        }

        @Override
        public float getPowerProduction(){
            return enabled ? passiveEnergyOut : 0f;
        }
    }
}