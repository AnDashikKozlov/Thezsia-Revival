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
        /*
        Events.on(EventType.ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Thanks for playing!");
                dialog.cont.add("cool").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("thezsia1-text-logo")).pad(20f).row();
                dialog.cont.button("Thezsia is the best!", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
        */
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
