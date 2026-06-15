package Thezsia.content;

import Thezsia.content.Thezsia.blocks.ThezsiaDistribution;
import Thezsia.content.Thezsia.blocks.ThezsiaEnv;
import Thezsia.content.Thezsia.blocks.ThezsiaStorages;
import Thezsia.core.ThezVars;
import Thezsia.world.generators.*;
import Thezsia.world.meta.ThezEnv;
import arc.func.Cons;
import arc.graphics.Color;
import arc.math.Rand;
import arc.math.geom.Mat3D;
import arc.struct.Seq;
import arc.util.Tmp;
import mindustry.content.Blocks;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.AsteroidGenerator;
import mindustry.type.Planet;
import mindustry.type.Sector;
import mindustry.world.Block;
import mindustry.world.meta.Env;

import static Thezsia.world.meta.ThezTeams.*;

public class ThezPlanets {

    public static Planet

            // Lumi system
            /* systemDoubleLumi, */ starLumiAlpha, starLumiBeta,
            planetThezsia,
            satelliteDeoren, asteroidDime, asteroidChaeris, asteroidSonis;

    public static void load(){
        /*
        systemDoubleLumi = new Planet("double-lumi-system", null, 1f) {{
            iconColor = Color.valueOf("c3bdc7");
            bloom = false;
            lightColor = Color.valueOf("c3bdc7"); //404040
            hasAtmosphere = false;
            //meshLoader = () -> new HexSkyMesh(planetThezsia, 1, 1, 1f, 3, Color.valueOf("4040400").a(0f), 3, 0.5f, 1f, 0.58f);
            meshLoader = () -> new SunMesh(this, 4, 4, 0.4, 1.4, 1.4, 1, 1.4f,
                    Color.valueOf("c3bdc7")
            );
            visible = alwaysUnlocked = false;
            //solarSystem = doubleLumiSystem;
        }};
        */
        starLumiAlpha = new Planet("lumi-alpha", null, 5.7f){{
            iconColor = Color.valueOf("bcc9eb");
            /* orbitRadius = 0; orbitOffset = 0; orbitRadius = 120f * 60f; */ rotateTime = 19f * 60f;

            // orbitRadius = 21; orbitOffset = 0; orbitTime = 72f * 60f;
            // rotateTime =  19f * 60f;
            bloom = true;
            lightColor = Color.valueOf("f5b28c");
            hasAtmosphere = false;

            meshLoader = () -> new SunMesh(this, 6, 8, 0.44, 1.3, 1.7, 2.1, 1.22f,
                    Color.valueOf("f5fffe"), // OUTDATED: eeedf7
                    Color.valueOf("defbff"), // OUTDATED: c9cdf2
                    Color.valueOf("c2effc"), // OUTDATED: a3b6e5
                    Color.valueOf("aad9fa"), // OUTDATED: 7ea4cf
                    Color.valueOf("89b2f0")
            );

            visible = alwaysUnlocked = true; accessible = false;
            // solarSystem = systemDoubleLumi;
        }};
        starLumiBeta = new Planet("lumi-beta", starLumiAlpha, 1.6f){{
            iconColor = Color.valueOf("eb8375");
            // Old orbitRadius was 21
            orbitRadius = 61; orbitOffset = 192; orbitTime = 72f * 60f; rotateTime = 72f * 60f;
            bloom = true;
            lightColor = Color.valueOf("d7daf5");
            hasAtmosphere = false;

            meshLoader = () -> new SunMesh(this, 5, 4, 0.27, 1.8, 1, 1.3, 1.2f,
                    Color.valueOf("f7d1ad"),
                    Color.valueOf("f5b28c"),
                    Color.valueOf("eb8375"),
                    Color.valueOf("d65c64")
            );

            visible = alwaysUnlocked = true; accessible = false;
            solarSystem = starLumiAlpha;
        }};
        planetThezsia = new Planet("thezsia", starLumiBeta, 1f, 3){{
            iconColor = Color.valueOf("9e95ad");
            orbitRadius = 28; /* Old orbitRadius was 72 */ orbitOffset = 32; orbitTime = 34 * 60; orbitSpacing = 27; rotateTime = 34 * 60;
            generator = new ThezsiaPlanetGenerator();
            meshLoader = () -> new HexMesh(planetThezsia, 6);
            // Old colors of clouds: 99a3a2, 8e9699, 8b898f.
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(planetThezsia, 34, 1.21f, 0.13f, 6, Color.valueOf("8f8c82").a(0.72f), 3, 0.5f, 1f, 0.58f),
                    new HexSkyMesh(planetThezsia, 32, -0.71f, 0.14f, 6, Color.valueOf("78656c").a(0.44f), 4, 0.56f, 0.89f, 0.5f),
                    new HexSkyMesh(planetThezsia, 30, 1.33f, 0.15f, 6, Color.valueOf("5c4e49").a(0.27f), 4, 0.6f, 1f, 0.61f)
            );

            allowLaunchToNumbered = allowLaunchSchematics = allowLaunchLoadout = false;
            allowSectorInvasion = allowWaves = true; allowCampaignRules  = true;
            enemyBuildSpeedMultiplier = 0.4f;
            clearSectorOnLose = true;
            startSector = 12;
            sectorSeed = 2218;
            defaultCore = ThezsiaStorages.coreDust;
            defaultEnv = Env.terrestrial | Env.groundOil | Env.oxygen | ThezEnv.darkness;

            // lightColor = Color.valueOf("39383d"); //39383d
            updateLighting = false;
            lightSrcTo = 0.5f;
            lightDstFrom = 0.2f;
            hasAtmosphere = true;
            atmosphereColor = Color.valueOf("4d4143d6"); // OUTDATED: 4d4143d6, 6571787a (underwater).
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            tidalLock = false;

            visible = accessible = alwaysUnlocked = true;
            solarSystem = starLumiAlpha;

            ruleSetter = r -> {
                r.lighting = true;
                r.ambientLight = Color.valueOf("343038c6"); // OUTDATED. Colors —> 1d4a624a, 273b4a5c: 343038 — color for fog of war.
                // r.loadout = ItemStack.list();
                r.fog = false; //Should I make it true?
                r.showSpawns = true;
                r.defaultTeam = vanitser;
                r.waveTeam = precursors; // Absolutely not a Subnautica reference :P
                r.enemyCoreBuildRadius = 250;
                r.coreCapture = false;
                // Weather.WeatherEntry weather = new Weather.WeatherEntry(Weathers.suspendParticles);
                // r.weather.always = true; //there are always weather
                // r.weather.add(weather);
                // r.bannedBlocks.addAll(conveyor);
                r.hideBannedBlocks = true;
            };
            unlockedOnLand.addAll(
                    ThezsiaStorages.coreDust,
                    ThezsiaDistribution.tantalumBelt, ThezsiaDistribution.tantalumJunction, ThezsiaDistribution.tantalumBridge, ThezsiaDistribution.tantalumRouter
            );
        }};
        satelliteDeoren = new Planet("deoren", planetThezsia, 0.45f, 1){{
            iconColor = Color.valueOf("7c7582");
            orbitRadius = 7; orbitOffset = 39; orbitTime = 47f * 60f; rotateTime = 156 * 60;
            generator = new DeorenPlanetGenerator();
            meshLoader = () -> new MultiMesh(
                    new HexMesh(this, 5)
            );

            updateLighting = true;
            hasAtmosphere = false;
            atmosphereColor = Color.valueOf("4d464636");
            atmosphereRadIn = 0f;
            atmosphereRadOut = 0.21f;
            tidalLock = true;

            accessible = false;
            solarSystem = starLumiAlpha;
        }};
        asteroidDime = makeAsteroid("dime", satelliteDeoren, ThezsiaEnv.igneousBasalt, Blocks.basalt, 14, 0.34f, 4, 0.05f, gen -> {
            gen.carbonChance = 0.68f;
            gen.stoneChance = 0.5f;
        });
        asteroidChaeris = makeAsteroid("chaeris", starLumiAlpha, ThezsiaEnv.sulfurFloor, ThezsiaEnv.basalticPatch, 58, 0.6f, 9, 0.53f, gen -> {
            gen.iceChance = 0.42f;
            gen.berylChance = 0.7f;
        });
        asteroidSonis = makeAsteroid("sonis", starLumiAlpha, ThezsiaEnv.peridotite, Blocks.arkyicStone, 421, 0.47f, 16, 1.64f, gen -> {
            gen.stoneChance = 0.62f;
            gen.carbonChance = 0.3f;
            gen.berylChance = 0.85f;
        });
    }
    private static Planet makeAsteroid(String name, Planet parent, Block base, Block tint, int seed, float tintThresh, int pieces, float scale, Cons<AsteroidGenerator> cgen) {
        return new Planet(name, parent, 0.14f) {{
            hasAtmosphere = false;
            updateLighting = false;
            sectors.add(new Sector(this, PlanetGrid.Ptile.empty));
            camRadius = 0.68f * scale;
            minZoom = 0.85f;
            drawOrbit = true; // true only for testing
            accessible = false;
            clipRadius = 2f;
            defaultEnv = Env.space;
            icon = "commandRally";
            generator = new AsteroidGenerator();
            cgen.get((AsteroidGenerator) generator);

            meshLoader = () -> {
                iconColor = tint.mapColor;
                Color tinted = tint.mapColor.cpy().a(1f - tint.mapColor.a);
                Seq<GenericMesh> meshes = new Seq<>();
                Color color = base.mapColor;
                Rand rand = new Rand(id + 2);

                meshes.add(new NoiseMesh(
                        this, seed, 2, radius, 2, 0.55f, 0.45f, 16f,
                        color, tinted, 3, 0.6f, 0.38f, tintThresh
                ));

                for (int j = 0; j < pieces; j++) {
                    meshes.add(new MatMesh(
                            new NoiseMesh(this, seed + j + 1, 1, 0.022f + rand.random(0.065f) * scale, 2, 0.6f, 0.38f, 20f,
                                    color, tinted, 3, 0.6f, 0.38f, tintThresh),
                            new Mat3D().setToTranslation(Tmp.v31.setToRandomDirection(rand).setLength(rand.random(0.44f, 1.5f) * scale)))
                    );
                }

                return new MultiMesh(meshes.toArray(GenericMesh.class));
            };
        }};
    }
}