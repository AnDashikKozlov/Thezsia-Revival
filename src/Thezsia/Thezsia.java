package Thezsia;

import Thezsia.content.*;
import Thezsia.content.Thezsia.*;
import Thezsia.content.Thezsia.blocks.ThezsiaBlocks;
import Thezsia.core.ThezVars;
import Thezsia.world.blocks.ThezAttribute;
import Thezsia.world.graphics.ThezEnvRenderers;
import Thezsia.world.meta.*;
import Thezsia.ui.*;
import arc.*;
import arc.util.*;
import mindustry.game.EventType;
import mindustry.gen.Icon;
import mindustry.mod.*;
import mindustry.ui.dialogs.PlanetDialog;

import static arc.Core.bundle;
import static mindustry.Vars.ui;

public class Thezsia extends Mod{

    public Thezsia(){
        Events.on(EventType.ClientLoadEvent.class, e -> {
            loadSettings();
            UIHandler.init();
        });
    }

    @Override
    public void loadContent(){
        Log.info("Loading some Thezsia content.");
        ThezTeams.load();
        ThezAttribute.load();
        ThezSounds.load();
        ThezItems.load();
        ThezLiquids.load();
        ThezsiaUnits.load();
        ThezsiaBlocks.load();
        ThezPlanets.load();
        ThezsiaTechTreePlayer.load();
        ThezEnvRenderers.init();
    }

    @Override
    public void init(){
        if(ThezVars.settingsDebug){
            PlanetDialog.debugSelect = true;
        };
    };

    private void loadSettings(){
        ui.settings.addCategory(bundle.get("settings.thezsia-title"), Icon.book, t -> {
            t.checkPref("@settings.lowdetail", false);
            t.checkPref("@settings.debug", false);
        });
    }
}
