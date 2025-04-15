package Thezsia.content;

import Thezsia.Thezworld.ColorPassage;
import Thezsia.Thezworld.HeightPassage;
import Thezsia.world.generators.ThezsiaPlanetGenerator;
import arc.graphics.*;
import arc.math.Interp;
import arc.math.Mathf;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.type.*;
import mindustry.world.meta.*;

import static Thezsia.content.Thezsia.blocks.ThezEnv.*;
import static Thezsia.content.Thezsia.blocks.ThezStorages.*;
import static Thezsia.world.meta.ThezTeams.*;

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
            generator = new ThezsiaPlanetGenerator(){{
                baseHeight = 0;
                baseColor = basalticPatch.mapColor;

                heights.add(new HeightPassage.NoiseHeight(){{
                    offset.set(1050, 0, 0);
                    octaves = 16f;
                    persistence = 0.6f;
                    magnitude = 1.25f;
                    heightOffset = -0.5f;
                }});

                Mathf.rand.setSeed(2);
                Seq<HeightPassage>
                mountains = new Seq<>();
                for(int i = 0; i < 20; i++){
                    mountains.add(new HeightPassage.DotHeight(){{
                        dir.setToRandomDirection().y = Mathf.random(2f, 5f);
                        min = 0.99f;
                        magnitude = Math.max(0.7f, dir.nor().y) * 0.3f;
                        interp = Interp.exp10In;
                    }});
                }
                heights.add(new HeightPassage.MultiHeight(mountains, HeightPassage.MultiHeight.MixType.max, HeightPassage.MultiHeight.Operation.add));

                mountains = new Seq<>();
                for(int i = 0; i < 20; i++){
                    mountains.add(new HeightPassage.DotHeight(){{
                        dir.setToRandomDirection().y = Mathf.random(-2f, -5f);
                        min = 0.99f;
                        magnitude = Math.max(0.7f, dir.nor().y) * 0.3f;
                        interp = Interp.exp10In;
                    }});
                }
                heights.add(new HeightPassage.MultiHeight(mountains, HeightPassage.MultiHeight.MixType.max, HeightPassage.MultiHeight.Operation.add));
                colors.addAll(
                        new ColorPassage.NoiseColorPass(){{
                            scale = 1.5;
                            persistence = 0.5;
                            octaves = 3;
                            magnitude = 1.2f;
                            min = 0.3f;
                            max = 0.6f;
                            out = limestone.mapColor;
                            offset.set(1500f, 300f, -500f);
                        }});
            }};
            meshLoader = () -> new HexMesh(this, 5);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 33, 0.891f, 0.11f, 6, Color.valueOf("4d4c4baf").a(0.42f), 3, 0.5f, 1f, 0.58f),
                    new HexSkyMesh(this, 32, 1.21f, 0.178f, 6, Color.valueOf("42423f40").a(0.65f), 3, 0.56f, 0.89f, 0.5f),
                    new HexSkyMesh(this, 31, 1.13f, 0.26f, 6, Color.valueOf("31323638").a(0.58f), 3, 0.4f, 1f, 0.61f)
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
            defaultCore = coreDust;
            defaultEnv = Env.oxygen | Env.terrestrial | Env.groundOil;

            updateLighting = false;
            hasAtmosphere = true;
            atmosphereColor = Color.valueOf("666362d9");
            atmosphereRadIn = 0.9f;
            atmosphereRadOut = 1;
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
                r.defaultTeam = vanitser;
                r.waveTeam = precursors;
                r.enemyCoreBuildRadius = 250;
                r.coreCapture = false;
                Weather.WeatherEntry weather = new Weather.WeatherEntry(Weathers.fog);
                weather.always = true; //always fogy
                r.weather.add(weather);
                //r.bannedBlocks.addAll(conveyor);
                r.hideBannedBlocks = true;
            };
            unlockedOnLand.add(coreDust);
        }};
    }
}
