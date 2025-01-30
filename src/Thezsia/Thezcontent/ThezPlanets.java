package Thezsia.Thezcontent;

import  static Thezsia.Thezcontent.ThezItems.*;

import Thezsia.Thezworld.meta.ThezTeams;
import arc.graphics.*;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import mindustry.world.meta.*;

import static mindustry.content.Planets.*;

public class ThezPlanets {
    public static Planet
        //Lumi system
        starLumi, planetThezsia;
    public static void  load() {
        starLumi = new Planet("lumi", null, 2.1f){{
            bloom = false;
            lightColor = Color.valueOf("e8f3ff");
            hasAtmosphere = false;
            meshLoader = () -> new SunMesh(this, 5, 5, 0.27, 1.8, 1.3, 1, 1.1f,
                    Color.valueOf("c2edfff9"), Color.valueOf("a8effff9"), Color.valueOf("c2d3fff9"), Color.valueOf("94c6fff9"));
            iconColor = Color.valueOf("c4e0ff");

            //accessible = true;
            visible = true;
            alwaysUnlocked = true;
            //solarSystem = starLumi;
        }};
        planetThezsia = new Planet("thezsia", starLumi, 3.6f, 2){{
            generator = new ErekirPlanetGenerator(); //ThezsiaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 33, 0.891f, 0.092f, 6, Color.valueOf("615d5aaf").a(0.42f), 3, 0.5f, 1f, 0.58f),
                    new HexSkyMesh(this, 32, 1.21f, 0.11f, 6, Color.valueOf("42423f99").a(0.65f), 3, 0.56f, 1f, 0.5f),
                    new HexSkyMesh(this, 31, 1.13f, 0.13f, 6, Color.valueOf("2d2e36aa").a(0.54f), 3, 0.4f, 1f, 0.61f)
            );

            bloom = false;
            lightColor = Color.valueOf("e8f3ff");
            drawOrbit = true;
            orbitTime = 252;
            orbitSpacing = 27;
            orbitRadius = 132;
            rotateTime = 14 * 60;
            enemyBuildSpeedMultiplier = 0.4f;

            allowLaunchSchematics = false;
            allowLaunchToNumbered = false;
            allowLaunchLoadout = false;
            allowSectorInvasion = true;
            allowWaveSimulation = false;
            allowWaves = true;
            clearSectorOnLose = true;
            startSector = 12;
            defaultCore = ThezBlocks.coreDust;
            itemWhitelist = thezsiaItems;
            defaultEnv = Env.oxygen | Env.terrestrial | Env.groundOil;

            updateLighting = false;
            hasAtmosphere = true;
            atmosphereColor = Color.valueOf("666362d9");
            atmosphereRadIn = 0.2f;
            atmosphereRadOut = 0.3f;
            //tidalLock = true;
            updateLighting = false;
            sectorSeed = 12;

            accessible = true;
            visible = true;
            alwaysUnlocked = true;
            solarSystem = starLumi;

            ruleSetter = r -> {
                r.lighting = true;
                r.ambientLight = Color.valueOf("111212ce");
                r.loadout = ItemStack.list();
                r.fog = true;
                r.showSpawns = true;
                r.defaultTeam = ThezTeams.vanitser;
                r.waveTeam = ThezTeams.precursors;
                r.enemyCoreBuildRadius = 250;
                r.coreCapture = false;
                Weather.WeatherEntry weather = new Weather.WeatherEntry(Weathers.fog);
                weather.always = true; //always fogy
                r.weather.add(weather);
                //r.bannedBlocks.addAll(conveyor);
                r.hideBannedBlocks = true;
            };

            unlockedOnLand.add(ThezBlocks.coreDust);
        }};

        serpulo.hiddenItems.addAll(thezsiaItems).addAll(thezsiaItems).removeAll(Items.serpuloItems);
        erekir.hiddenItems.addAll(thezsiaItems).addAll(thezsiaItems).removeAll(Items.erekirItems);
    }
}
