package Thezsia.content;

import Thezsia.world.generators.*;
import Thezsia.world.meta.ThezEnv;
import arc.graphics.*;
import mindustry.graphics.g3d.*;
import mindustry.type.*;
import mindustry.world.meta.*;

import static Thezsia.content.Thezsia.blocks.ThezsiaStorages.*;
import static Thezsia.world.meta.ThezTeams.*;

public class ThezPlanets {
    public static Planet

            //Lumi system
            starLumiAlpha, starLumiBeta, planetThezsia;

    public static void load() {
        /*doubleLumiSystem = new Planet("lumi-system", null, 1f) {{
            bloom = false;
            lightColor = Color.valueOf("d4aff0"); //404040
            hasAtmosphere = false;
            meshLoader = () -> new HexSkyMesh(planetThezsia, 1, 1, 1f, 5, Color.valueOf("4040400").a(0f), 3, 0.5f, 1f, 0.58f);
            iconColor = Color.valueOf("404040");

            //accessible = true;
            visible = true;
            alwaysUnlocked = false;
            //solarSystem = doubleLumiSystem;
        }};*/
        starLumiAlpha = new Planet("lumi-alpha", null, 5.6f){{
            //orbitRadius = 21; orbitOffset = 0; orbitTime = 72f * 60f;
            //rotateTime =  19f * 60f;
            bloom = true;
            lightColor = Color.valueOf("f5b28c");
            hasAtmosphere = false;

            meshLoader = () -> new SunMesh(this, 4, 5, 0.27, 1.8, 1.3, 1, 1.1f,
                    Color.valueOf("eeedf7"), Color.valueOf("c9cdf2"), Color.valueOf("a3b6e5"), Color.valueOf("7ea4cf"));
            iconColor = Color.valueOf("bcc9eb");

            //accessible = true;
            visible = true;
            alwaysUnlocked = true;
            //solarSystem = starLumiAlpha;
        }};
        starLumiBeta = new Planet("lumi-beta", starLumiAlpha, 1.5f){{
            //Old orbitRadius was 21
            orbitRadius = 42; orbitOffset = 180; orbitTime = 72f * 60f; rotateTime = 72f * 60f;
            bloom = true;
            lightColor = Color.valueOf("d7daf5");
            hasAtmosphere = false;

            meshLoader = () -> new SunMesh(this, 5, 4, 0.27, 1.8, 1, 1.3, 1.2f,
                    Color.valueOf("f7d1ad"), Color.valueOf("f5b28c"), Color.valueOf("eb8375"), Color.valueOf("d65c64"));
            iconColor = Color.valueOf("eb8375");

            //accessible = true;
            visible = true;
            alwaysUnlocked = true;
            solarSystem = starLumiAlpha;
        }};

        planetThezsia = new Planet("thezsia", starLumiBeta, 1.2f, 2){{
            generator = new ThezsiaPlanetGenerator() {{

                meshLoader = () -> new HexMesh(planetThezsia, 6);
                cloudMeshLoader = () -> new MultiMesh(
                        new HexSkyMesh(planetThezsia, 34, 1.21f, 0.08f, 6, Color.valueOf("99a3a2").a(0.42f), 3, 0.5f, 1f, 0.58f),
                        new HexSkyMesh(planetThezsia, 32, -0.71f, 0.12f, 6, Color.valueOf("8e9699").a(0.54f), 4, 0.56f, 0.89f, 0.5f),
                        new HexSkyMesh(planetThezsia, 30, 1.33f, 0.19f, 6, Color.valueOf("8b898f").a(0.27f), 4, 0.6f, 1f, 0.61f)
                );

                //lightColor = Color.valueOf("39383d"); //39383d
                drawOrbit = true;
                orbitRadius = 21; /* Old orbitRadius was 72*/ orbitSpacing = 27; orbitTime = 34 * 60; rotateTime = 34 * 60;
                enemyBuildSpeedMultiplier = 0.4f;

                allowLaunchToNumbered = allowLaunchSchematics = allowLaunchLoadout = false;
                allowSectorInvasion = allowWaves = true; allowWaveSimulation = false;
                clearSectorOnLose = true;
                startSector = 12;
                sectorSeed = 12;
                defaultCore = coreDust;
                defaultEnv = Env.terrestrial | Env.groundOil | ThezEnv.underwaterWarm;

                updateLighting = false;
                hasAtmosphere = true;
                atmosphereColor = Color.valueOf("9e95ad"); //Old — 4d4143d6
                atmosphereRadIn = 0.1f;
                atmosphereRadOut = 0.24f;
                tidalLock = true;
                updateLighting = false;

                accessible = true;
                visible = true;
                alwaysUnlocked = true;
                solarSystem = starLumiAlpha;

                ruleSetter = r -> {
                    r.lighting = true;
                    r.ambientLight = Color.valueOf("1d4a624a");
                    r.loadout = ItemStack.list();
                    r.fog = false; //true
                    r.showSpawns = true;
                    r.defaultTeam = vanitser;
                    r.waveTeam = precursors;
                    r.enemyCoreBuildRadius = 250;
                    r.coreCapture = false;
                    //Weather.WeatherEntry weather = new Weather.WeatherEntry(Weathers.suspendParticles);
                    //weather.always = true; //there are always weather
                    //r.weather.add(weather);
                    //r.bannedBlocks.addAll(conveyor);
                    r.hideBannedBlocks = true;
                };
                unlockedOnLand.add(coreDust);
            }};
        }};
    }
}