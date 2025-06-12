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
        //Basaltic, charrok biome
        basalticPatch = new Floor("basaltic-patch"){{
            variants = 5;
        }};
        basalticRock = new Prop("basaltic-rock"){{
            variants = 3;
        }};
        basalticWall = new StaticWall("basaltic-wall"){{
            variants = 4;
            basalticPatch.asFloor().wall = this;
            attributes.set(ThezAttribute.volcanicStone, 0.8f);
        }};
        charrokFloor = new Floor("charrok-floor"){{
            variants = 5;
        }};
        hardCharrok = new Floor("hard-charrok"){{
            variants = 5;
        }};
        charrokPile = new Prop("charrok-pile"){{
            variants = 3;
            charrokFloor.asFloor().decoration = this;
        }};
        hardCharrokPile = new Prop("hard-charrok-pile"){{
            variants = 3;
            hardCharrok.asFloor().decoration = this;
        }};
        charrokWall = new StaticWall("charrok-wall"){{
            variants = 4;
            charrokFloor.asFloor().wall = this;
        }};
        hardCharrokWall = new StaticWall("hard-charrok-wall"){{
            variants = 4;
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
        //Sulfur Biome
        smoothSulfur = new Floor("smooth-sulfur"){{
            variants = 4;
        }};
        sulfurFloor = new Floor("sulfur-floor"){{
            variants = 5;
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
            variants = 3;
            sulfurFloor.asFloor().decoration = smoothSulfur.asFloor().decoration = this;
        }};
        sulfurWall = new StaticWall("sulfur-wall"){{
            variants = 4;
            sulfurFloor.asFloor().wall = smoothSulfur.asFloor().wall = this;
        }};
        largeSulfurPile = new TallBlock("large-sulfur-pile"){{
            variants = 1;
            shadowAlpha = 0.3f;
        }};
        //Peridotite biome
        peridotite = new Floor("peridotite"){{
            variants = 5;
        }};
        peridotiteDark = new Floor("peridotite-dark"){{
            variants = 5;
        }};
        peridotiteCube = new Prop("peridotite-cube"){{
            variants = 3;
            peridotite.asFloor().decoration = this;
        }};
        peridotiteDarkCube = new Prop("peridotite-dark-cube"){{
            variants = 3;
            peridotiteDark.asFloor().decoration = this;
        }};
        peridotiteWall = new StaticWall("peridotite-wall"){{
            variants = 4;
            peridotite.asFloor().wall = this;
        }};
        peridotiteDarkWall = new StaticWall("peridotite-dark-wall"){{
            variants = 4;
            peridotiteDark.asFloor().wall = this;
        }};
        tritaniumCluster = new TallBlock("tritanium-cluster"){{
            variants = 4;
            shadowAlpha = 0.3f;
        }};
        //ores
        /* basalticVein = new OreBlock("basaltic-vein"){{
            variants = 3;
            itemDrop = nihilite;
            wallOre = false;
        }}; */
        silverLick = new OreBlock("silver-lick"){{
            variants = 4;
            itemDrop = ThezItems.silver;
            wallOre = false;
        }};
        tritaniumOre = new OreBlock("tritanium-ore"){{
            variants = 4;
            itemDrop = ThezItems.tritaniumCrystal;
            wallOre = false;
        }};
        tritaniumOreWall = new OreBlock("tritanium-wallore"){{
            variants = 4;
            itemDrop = ThezItems.tritaniumCrystal;
            wallOre = true;
        }};
    }
}