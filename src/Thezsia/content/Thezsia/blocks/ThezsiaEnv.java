package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import Thezsia.world.blocks.ThezAttribute;
import Thezsia.world.blocks.environment.BiggerVent;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.world.Block;
import mindustry.world.blocks.Attributes;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.Attribute;

import static Thezsia.content.ThezItems.*;
import static mindustry.content.Fx.none;

public class ThezsiaEnv{
    public static Block
            //Blocks
            //environment
            charrokFloor, hardCharrok, charrokPile, hardCharrokPile, charrokWall, hardCharrokWall, charrokWallLedge, hardCharrokWallLedge, largeCharrokPile, largeHardCharrokPile,
            igneousBasalt, hotRock, igneousRock, magma, hotRockWall, igneousRockWall, igneousBasalticWall, magmaticWall, magmaticWallLedge,
            basalticPatch, basalticRock, basalticWall, basalticWallLedge,
            smoothSulfur, sulfurFloor, sulfurVent, sulfurBigVent, sulfurBoulder, sulfurWall, sulfurWallLedge, largeSulfurPile,
            peridotite, peridotiteDark, peridotiteCube, peridotiteDarkCube, peridotiteWall, peridotiteDarkWall, tritaniumCluster,
            //ores
            tantalumOre, silverLick, nihiliteOre, tritaniumOre, tritaniumOreWall;
    public static void load(){
        /*
                testBiggerVent = new BiggerVent("test-bigger-vent"){{
                    variants = 2;
                    blendGroup = parent = stone;
                    attributes.set(Attribute.steam, 1f);
                }};
                */
        //Charrok
        charrokFloor = new Floor("charrok-floor"){{variants = 5;
        }};
        hardCharrok = new Floor("hard-charrok"){{variants = 5;
        }};
        charrokPile = new Prop("charrok-pile"){{variants = 3;
            charrokFloor.asFloor().decoration = this;
        }};
        hardCharrokPile = new Prop("hard-charrok-pile"){{variants = 3;
            hardCharrok.asFloor().decoration = this;
        }};
        charrokWall = new StaticWall("charrok-wall"){{variants = 6;
            charrokFloor.asFloor().wall = this;
        }};
        hardCharrokWall = new StaticWall("hard-charrok-wall"){{variants = 6;
            hardCharrok.asFloor().wall = this;
        }};
        charrokWallLedge = new TallBlock("charrok-wall-ledge"){{variants = 0;
            shadowAlpha = 0.35f;
        }};
        hardCharrokWallLedge = new TallBlock("hard-charrok-wall-ledge"){{variants = 0;
            shadowAlpha = 0.35f;
        }};
        largeCharrokPile = new TallBlock("large-charrok-pile"){{variants = 3;
            shadowAlpha = 0.8f;
        }};
        largeHardCharrokPile = new TallBlock("large-hard-charrok-pile"){{variants = 3;
            shadowAlpha = 0.8f;
        }};
        //Basaltic
        basalticPatch = new Floor("basaltic-patch"){{variants = 5;
        }};
        basalticRock = new Prop("basaltic-rock"){{variants = 3;
            basalticPatch.asFloor().decoration = this;
        }};
        basalticWall = new StaticWall("basaltic-wall"){{variants = 6;
            basalticPatch.asFloor().wall = this;
            attributes.set(ThezAttribute.volcanicStone, 0.8f);
        }};
        basalticWallLedge = new TallBlock("basaltic-wall-ledge"){{variants = 0;
            shadowAlpha = 0.35f;
        }};
        //Igneous basaltic
        igneousBasalt = new Floor("igneous-basalt"){{variants = 5;
            attributes.set(Attribute.heat, 0.15f);
        }};
        hotRock = new Floor("hot-rock"){{variants = 5;
            emitLight = true; lightColor = Color.valueOf("a12d426a"); lightRadius = 9f * 8f;
            attributes.set(Attribute.heat, 0.4f);
            speedMultiplier = 0.9f;
        }};
        igneousRock = new Floor("igneous-rock"){{variants = 5;
            emitLight = true; lightColor = Color.valueOf("c944448b"); lightRadius = 6 * 8f;
            attributes.set(Attribute.heat, 1.0f);
            speedMultiplier = 0.7f;
        }};
        magma = new Floor("magma"){{variants = 0;
            emitLight = true; lightColor = Color.valueOf("ffad8ae5"); lightRadius = 4f * 8f;
            attributes.set(Attribute.heat, 1.6f);
            speedMultiplier = 0.4f; status = StatusEffects.melting; statusDuration = 4f *60f;
        }};
        igneousBasalticWall = new StaticWall("igneous-basaltic-wall"){{variants = 6;
            igneousBasalt.asFloor().wall = this;
        }};
        hotRockWall = new StaticWall("hot-rock-wall"){{variants = 6;
            emitLight = true; lightColor = Color.valueOf("a12d426a"); lightRadius = 9f * 8f;
            hotRock.asFloor().wall = this;
        }};
        igneousRockWall = new StaticWall("igneous-rock-wall"){{variants = 6;
            emitLight = true; lightColor = Color.valueOf("c944448b"); lightRadius = 6 * 8f;
            igneousRock.asFloor().wall = this;
        }};
        magmaticWall = new StaticWall("magmatic-wall"){{variants = 0;
            emitLight = true; lightColor = Color.valueOf("ffad8ae5"); lightRadius = 4f * 8f;
            customShadow = true;
        }};
        magmaticWallLedge = new TallBlock("magmatic-wall-ledge"){{variants = 0;
            emitLight = true; lightColor = Color.valueOf("ffad8ae5"); lightRadius = 4f * 8f;
            shadowAlpha = 0.35f;
        }};

        //Sulfur biome
        smoothSulfur = new Floor("smooth-sulfur"){{variants = 5;
        }};
        sulfurFloor = new Floor("sulfur-floor"){{variants = 5;
            blendGroup = smoothSulfur;
        }};
        sulfurVent = new SteamVent("sulfur-vent"){{variants = 3;
            effect = Fx.airBubble;
            blendGroup = parent = smoothSulfur;
            attributes.set(Attribute.steam, 1f);
        }};
        sulfurBigVent = new BiggerVent("sulfur-big-vent"){{variants = 2;
            effect = Fx.airBubble;
            blendGroup = parent = smoothSulfur;
            attributes.set(Attribute.steam, 1.6f);
        }};
        sulfurBoulder = new Prop("sulfur-boulder"){{variants = 3;
            sulfurFloor.asFloor().decoration = smoothSulfur.asFloor().decoration = this;
        }};
        sulfurWall = new StaticWall("sulfur-wall"){{variants = 6;
            sulfurFloor.asFloor().wall = smoothSulfur.asFloor().wall = this;
        }};
        sulfurWallLedge = new TallBlock("sulfur-wall-ledge"){{variants = 0;
            shadowAlpha = 0.35f;
        }};
        largeSulfurPile = new TallBlock("large-sulfur-pile"){{variants = 1;
            shadowAlpha = 0.75f;
        }};
        //Peridotite biome
        peridotite = new Floor("peridotite"){{variants = 5;
        }};
        peridotiteDark = new Floor("peridotite-dark"){{variants = 5;
        }};
        peridotiteCube = new Prop("peridotite-cube"){{variants = 3;
            peridotite.asFloor().decoration = this;
        }};
        peridotiteDarkCube = new Prop("peridotite-dark-cube"){{variants = 3;
            peridotiteDark.asFloor().decoration = this;
        }};
        peridotiteWall = new StaticWall("peridotite-wall"){{variants = 6;
            peridotite.asFloor().wall = this;
        }};
        peridotiteDarkWall = new StaticWall("peridotite-dark-wall"){{variants = 6;
            peridotiteDark.asFloor().wall = this;
        }};
        tritaniumCluster = new TallBlock("tritanium-cluster"){{variants = 4;
            shadowAlpha = 0.3f;
        }};
        //ores
        tantalumOre = new OreBlock("tantalum-ore"){{variants = 4;
            itemDrop = tantalum;
            wallOre = false;
        }};
        nihiliteOre = new OreBlock("nihilite-ore"){{variants = 4;
            itemDrop = nihilite;
            wallOre = false;
        }};
        silverLick = new OreBlock("silver-lick"){{variants = 4;
            itemDrop = silver;
            wallOre = false;
        }};
        tritaniumOre = new OreBlock("tritanium-ore"){{variants = 4;
            itemDrop = tritaniumCrystal;
            wallOre = false;
        }};
        tritaniumOreWall = new OreBlock("tritanium-wallore"){{variants = 4;
            itemDrop = tritaniumCrystal;
            wallOre = true;
        }};
    }
}