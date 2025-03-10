package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import Thezsia.content.Thezsia.ThezUnits;
import Thezsia.world.blocks.storage.GeneratorCore;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;

import static mindustry.content.Items.*;

public class ThezStorages{
    public static Block
            //Blocks
            coreDust, coreFog;
    public static void load(){
        coreDust = new GeneratorCore("core-dust"){{
            requirements(Category.effect, ItemStack.with(beryllium, 750, ThezItems.silver, 70));
            size= 4; health = 1950; squareSprite = false;

            hasPower = true;
            conductivePower = true;
            powerProduction = 180 / 60f;
            consumePowerBuffered(180);
            //glowColors = new Color[]{Color.valueOf("ade7ec79")};
            //glowMag = 0.78f; glowScl = 9.5f;
            itemCapacity = 5000;
            unitType = ThezUnits.Iambient;
            unitCapModifier = 15;
            isFirstTier = true;
            alwaysUnlocked = true;
        }};
        coreFog = new GeneratorCore("core-fog"){{
            requirements(Category.effect, ItemStack.with(beryllium, 1200, ThezItems.silver, 500, ThezItems.infium, 260, ThezItems.tensorite, 180));
            size= 5; health = 3700; squareSprite = false;

            hasPower = true;
            conductivePower = true;
            powerProduction = 600 / 60f;
            consumePowerBuffered(100);
            //glowColors = new Color[]{Color.valueOf("ade7ec79")};
            //glowMag = 0.78f; glowScl = 9.5f;
            itemCapacity = 7500;
            unitType = ThezUnits.IIambient;
            unitCapModifier = 22;
        }};
    }
}