package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezFx;
import Thezsia.content.ThezItems;
import Thezsia.world.blocks.ThezAttribute;
import Thezsia.world.blocks.environment.BiggerVent;
import Thezsia.world.blocks.environment.EffectFloor;
import arc.graphics.Color;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.world.Block;
import mindustry.world.blocks.Attributes;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.Attribute;

import static Thezsia.content.ThezItems.*;
import static mindustry.Vars.tilesize;
import static mindustry.content.Fx.none;

public class ThezsiaEnv{
    public static Block
            /* Environment */
            // Charrok
            charrokFloor, hardCharrok, charrokPile, hardCharrokPile, charrokWall, hardCharrokWall, charrokWallLedge, hardCharrokWallLedge, largeCharrokPile, largeHardCharrokPile,
            // Basaltic
            basalticPatch, roughBasalticPatch, basalticCrater, basalticRock, basalticWall, basalticWallLedge, coalyDeadTree,
            // Igneous basaltic
            igneousBasalt, hotRock, igneousRock, magma, hotRockWall, igneousRockWall, igneousBasalticWall, magmaticWall, magmaticWallLedge,
            // Sulfur
            smoothSulfur, sulfurFloor, sulfurVent, sulfurBigVent, sulfurBoulder, sulfurWall, sulfurWallLedge, largeSulfurPile,
            // Peridotite
            peridotite, darkPeridotite, peridotiteCube, darkPeridotiteCube, peridotiteWall, darkPeridotiteWall, tritaniumCluster,
            // Nature
            deadYellowCoralFloor, deadYellowCoralFloorAlt, deadYellowcoral, deadYellowcoralAlt,
            // Ores
            tantalumOre, silverLick, nihiliteOre, tritaniumOre, tritaniumOreWall;
    public static void load(){
        /*
                testBiggerVent = new BiggerVent("test-bigger-vent"){{
                    variants = 2;
                    blendGroup = parent = stone;
                    attributes.set(Attribute.steam, 1f);
                }};
                */
        // Charrok
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

        // Basaltic
        basalticPatch = new Floor("basaltic-patch"){{variants = 5;}};
        roughBasalticPatch = new Floor("rough-basaltic-patch"){{variants = 5;}};
        basalticCrater = new EffectFloor("basaltic-crater"){{variants = 5;
            effectChance = 0.0005f; effect = ThezFx.craterSmoke;
        }};
        basalticRock = new Prop("basaltic-rock"){{variants = 3;
            basalticPatch.asFloor().decoration = roughBasalticPatch.asFloor().decoration = basalticCrater.asFloor().decoration =this;
        }};
        basalticWall = new StaticWall("basaltic-wall"){{variants = 6;
            basalticPatch.asFloor().wall = roughBasalticPatch.asFloor().wall = basalticCrater.asFloor().wall = this;
            attributes.set(ThezAttribute.volcanicStone, 0.8f);
        }};
        basalticWallLedge = new TallBlock("basaltic-wall-ledge"){{variants = 0;
            shadowAlpha = 0.35f;
        }};
        coalyDeadTree = new TreeBlock("coaly-dead-tree"){{variants = 2;
            shadowOffset = -1.3f;
            clipSize = 320;
        }};

        // Igneous basaltic
        igneousBasalt = new Floor("igneous-basalt"){{variants = 5;
            attributes.set(Attribute.heat, 0.1f);
        }};
        hotRock = new EffectFloor("hot-rock"){{variants = 5;
            emitLight = true; lightColor = Color.valueOf("a12d426a"); lightRadius = 9f * tilesize;
            attributes.set(Attribute.heat, 0.4f);
            speedMultiplier = 0.8f;
            effectChance = 0.0004f; effect = Fx.fire;
        }};
        igneousRock = new EffectFloor("igneous-rock"){{variants = 5;
            emitLight = true; lightColor = Color.valueOf("c944448b"); lightRadius = 6 * tilesize;
            attributes.set(Attribute.heat, 0.6f);
            speedMultiplier = 0.6f;
            effectChance = 0.0007f; effect = Fx.fire;
        }};
        magma = new EffectFloor("magma"){{variants = 0;
            emitLight = true; lightColor = Color.valueOf("ffad8ae5"); lightRadius = 4f * tilesize;
            attributes.set(Attribute.heat, 1.0f);
            speedMultiplier = 0.3f; status = StatusEffects.melting; statusDuration = 4f * 60f;
            effectChance = 0.001f; effect = Fx.fire;
        }};
        igneousBasalticWall = new StaticWall("igneous-basaltic-wall"){{variants = 8;
            igneousBasalt.asFloor().wall = this;
        }};
        hotRockWall = new StaticWall("hot-rock-wall"){{variants = 6;
            emitLight = true; lightColor = Color.valueOf("a12d426a"); lightRadius = 9f * tilesize;
            hotRock.asFloor().wall = this;
        }};
        igneousRockWall = new StaticWall("igneous-rock-wall"){{variants = 6;
            emitLight = true; lightColor = Color.valueOf("c944448b"); lightRadius = 6 * tilesize;
            igneousRock.asFloor().wall = this;
        }};
        magmaticWall = new StaticWall("magmatic-wall"){{variants = 0;
            emitLight = true; lightColor = Color.valueOf("ffad8ae5"); lightRadius = 4f * tilesize;
            customShadow = true;
        }};
        magmaticWallLedge = new TallBlock("magmatic-wall-ledge"){{variants = 0;
            emitLight = true; lightColor = Color.valueOf("ffad8ae5"); lightRadius = 4f * tilesize;
            shadowAlpha = 0.35f;
        }};

        // Sulfur biome
        smoothSulfur = new Floor("smooth-sulfur"){{variants = 5;
        }};
        sulfurFloor = new Floor("sulfur-floor"){{variants = 5;
            blendGroup = smoothSulfur;
        }};
        sulfurVent = new SteamVent("sulfur-vent"){{variants = 3;
            // TODO make effect look... Just make copy of Purples Vents from Subnautica Below Zero
            effect = ThezFx.craterSmoke;
            blendGroup = parent = smoothSulfur;
            attributes.set(Attribute.steam, 1f);
        }};
        sulfurBigVent = new BiggerVent("sulfur-big-vent"){{variants = 2;
            // TODO make effect look... Just make copy of Purples Vents from Subnautica Below Zero
            effect = ThezFx.craterSmoke;
            blendGroup = parent = smoothSulfur;
            attributes.set(Attribute.steam, 1.6f);
        }};
        sulfurBoulder = new Prop("sulfur-boulder"){{variants = 3;
            smoothSulfur.asFloor().decoration = sulfurFloor.asFloor().decoration = this;
        }};
        sulfurWall = new StaticWall("sulfur-wall"){{variants = 6;
            smoothSulfur.asFloor().wall = sulfurFloor.asFloor().decoration = this;
        }};
        sulfurWallLedge = new TallBlock("sulfur-wall-ledge"){{variants = 0;
            shadowAlpha = 0.35f;
        }};
        largeSulfurPile = new TallBlock("large-sulfur-pile"){{variants = 1;
            shadowAlpha = 0.75f;
        }};

        // Peridotite biome
        peridotite = new Floor("peridotite"){{variants = 5;
        }};
        darkPeridotite = new Floor("peridotite-dark"){{variants = 5;
        }};
        peridotiteCube = new Prop("peridotite-cube"){{variants = 3;
            peridotite.asFloor().decoration = this;
        }};
        darkPeridotiteCube = new Prop("peridotite-dark-cube"){{variants = 3;
            darkPeridotite.asFloor().decoration = this;
        }};
        peridotiteWall = new StaticWall("peridotite-wall"){{variants = 6;
            peridotite.asFloor().wall = this;
        }};
        darkPeridotiteWall = new StaticWall("peridotite-dark-wall"){{variants = 6;
            darkPeridotite.asFloor().wall = this;
        }};
        tritaniumCluster = new TallBlock("tritanium-cluster"){{variants = 4;
            shadowAlpha = 0.3f;
        }};

        // Nature
        deadYellowCoralFloor = new Floor("dead-yellow-coral-floor"){{variants = 5;}};
        deadYellowcoral = new SeaBush("dead-yellowcoral"){{
            lobesMin = 2; lobesMax = 3;
            magMin = 2f; magMax = 8f;
            origin = 0.3f;
            spread = 40f;
            sclMin = 60f; sclMax = 100f;
        }};
        deadYellowcoralAlt = new SeaBush("dead-yellowcoral-alt"){{
            lobesMin = 2; lobesMax = 3;
            magMin = 1.5f; magMax = 5f;
            origin = 0.2f;
            spread = 40f;
            sclMin = 40f; sclMax = 80f;
        }};

        // Ores
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