package Thezsia;

import Thezsia.content.*;
import Thezsia.content.Thezsia.*;
import Thezsia.content.Thezsia.blocks.ThezsiaBlocks;
import Thezsia.world.blocks.ThezAttribute;
import Thezsia.world.graphics.ThezEnvRenderers;
import Thezsia.world.meta.*;
import Thezsia.ui.*;
import arc.*;
import arc.util.*;
import mindustry.game.EventType;
import mindustry.mod.*;

public class Thezsia extends Mod{

    public Thezsia(){
        Events.on(EventType.ClientLoadEvent.class, e -> {
            UIHandler.init();
        });
    }

    @Override
    public void loadContent(){
        Log.info("Loading some Thezsia content.");
        ThezTeams.load();
        ThezAttribute.load();
        ThezItems.load();
        ThezLiquids.load();
        ThezsiaUnits.load();
        ThezsiaBlocks.load();
        ThezPlanets.load();
        ThezEnvRenderers.init();
    }

}
