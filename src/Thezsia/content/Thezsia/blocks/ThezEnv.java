package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import Thezsia.world.blocks.ThezAttribute;
import Thezsia.world.blocks.environment.BiggerVent;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.Attribute;

public class ThezEnv{
    public static Block
            //Blocks
            //environment
            basalticPatch, basalticRock, basalticWall,
            charrokFloor, hardCharrok, charrokPile, hardCharrokPile, charrokWall, hardCharrokWall, largeCharrokPile, largeHardCharrokPile,
            limestone, limestoneDark, limestoneCracked, limestoneBoulder, limestoneDarkBoulder, limestoneWall, limestoneDarkWall, limestoneCrackWall,
            smoothSulfur, sulfurFloor, sulfurVent, sulfurBigVent, sulfurBoulder, sulfurWall, largeSulfurPile,
            peridotite, peridotiteDark, peridotiteCube, peridotiteDarkCube, peridotiteWall, peridotiteDarkWall, tritaniumCluster,
            //ores
            basalticVein, silverLick, tritaniumOre, tritaniumOreWall;
    public static void load(){
        /*
                testBiggerVent = new BiggerVent("test-bigger-vent"){{
                    variants = 2;
                    blendGroup = parent = stone;
                    attributes.set(Attribute.steam, 1f);
                }};
                */
        basalticPatch = new Floor("basaltic-patch"){{
            variants = 3;
        }};
        basalticRock = new Prop("basaltic-rock"){{
            variants = 2;
        }};
        basalticWall = new StaticWall("basaltic-wall"){{
            variants = 2;
            basalticPatch.asFloor().wall = this;
            attributes.set(ThezAttribute.volcanicStone, 0.8f);
        }};
        charrokFloor = new Floor("charrok-floor"){{
            variants = 2;
        }};
        hardCharrok = new Floor("hard-charrok"){{
            variants = 2;
        }};
        charrokPile = new Prop("charrok-pile"){{
            variants = 2;
            charrokFloor.asFloor().decoration = this;
        }};
        hardCharrokPile = new Prop("hard-charrok-pile"){{
            variants = 2;
            hardCharrok.asFloor().decoration = this;
        }};
        charrokWall = new StaticWall("charrok-wall"){{
            variants = 2;
            charrokFloor.asFloor().wall = this;
        }};
        hardCharrokWall = new StaticWall("hard-charrok-wall"){{
            variants = 2;
            hardCharrok.asFloor().wall = this;
        }};
        largeCharrokPile = new TallBlock("large-charrok-pile"){{
            variants = 2;
            shadowAlpha = 0.3f;
        }};
        largeHardCharrokPile = new TallBlock("large-hard-charrok-pile"){{
            variants = 2;
            shadowAlpha = 0.3f;
        }};
        limestone = new Floor("limestone"){{
            variants = 2;
        }};
        limestoneDark = new Floor("limestone-dark"){{
            variants = 2;
        }};
        limestoneCracked = new Floor("limestone-cracked"){{
            variants = 2;
        }};
        limestoneBoulder = new Prop("limestone-boulder"){{
            variants = 2;
            limestone.asFloor().decoration = this;
        }};
        limestoneDarkBoulder = new Prop("limestone-dark-boulder"){{
            variants = 2;
            limestoneDark.asFloor().decoration = this;
        }};
        limestoneWall = new StaticWall("limestone-wall"){{
            variants = 2;
            limestone.asFloor().wall = this;
        }};
        limestoneDarkWall = new StaticWall("limestone-dark-wall"){{
            variants = 2;
            limestoneDark.asFloor().wall = this;
        }};
        limestoneCrackWall = new StaticWall("limestone-crack-wall"){{
            variants = 2;
            limestoneCracked.asFloor().wall = this;
        }};
        smoothSulfur = new Floor("smooth-sulfur"){{
            variants = 4;
        }};
        sulfurFloor = new Floor("sulfur-floor"){{
            variants = 4;
            blendGroup = ThezEnv.smoothSulfur;
        }};
        sulfurVent = new SteamVent("sulfur-vent"){{
            variants = 0;
            blendGroup = parent = sulfurFloor = smoothSulfur;
            attributes.set(Attribute.steam, 1f);
        }};
        sulfurBigVent = new BiggerVent("sulfur-big-vent"){{
            variants = 0;
            blendGroup = parent = sulfurFloor;
            attributes.set(Attribute.steam, 1.6f);
        }};
        sulfurBoulder = new Prop("sulfur-boulder"){{
            variants = 2;
            sulfurFloor.asFloor().decoration = smoothSulfur.asFloor().decoration = this;
        }};
        sulfurWall = new StaticWall("sulfur-wall"){{
            variants = 2;
            sulfurFloor.asFloor().wall = smoothSulfur.asFloor().wall = this;
        }};
        largeSulfurPile = new TallBlock("large-sulfur-pile"){{
            variants = 1;
            shadowAlpha = 0.3f;
        }};
        peridotite = new Floor("peridotite"){{
            variants = 4;
        }};
        peridotiteDark = new Floor("peridotite-dark"){{
            variants = 4;
        }};
        peridotiteCube = new Prop("peridotite-cube"){{
            variants = 2;
            peridotite.asFloor().decoration = this;
        }};
        peridotiteDarkCube = new Prop("peridotite-dark-cube"){{
            variants = 2;
            peridotiteDark.asFloor().decoration = this;
        }};
        peridotiteWall = new StaticWall("peridotite-wall"){{
            variants = 2;
            peridotite.asFloor().wall = this;
        }};
        peridotiteDarkWall = new StaticWall("peridotite-dark-wall"){{
            variants = 2;
            peridotiteDark.asFloor().wall = this;
        }};
        tritaniumCluster = new TallBlock("tritanium-cluster"){{
            variants = 2;
            shadowAlpha = 0.3f;
        }};
        //ores
        /* basalticVein = new OreBlock("basaltic-vein"){{
            variants = 3;
            itemDrop = nihilite;
            wallOre = false;
        }}; */
        silverLick = new OreBlock("silver-lick"){{
            variants = 3;
            itemDrop = ThezItems.silver;
            wallOre = false;
        }};
        tritaniumOre = new OreBlock("tritanium-ore"){{
            variants = 3;
            itemDrop = ThezItems.tritaniumCrystal;
            wallOre = false;
        }};
        tritaniumOreWall = new OreBlock("tritanium-wallore"){{
            variants = 3;
            itemDrop = ThezItems.tritaniumCrystal;
            wallOre = true;
        }};
    }
}