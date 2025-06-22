package Thezsia.content.Thezsia.blocks;

import Thezsia.world.blocks.storage.GeneratorCore;
import Thezsia.world.meta.ThezEnv;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.meta.Env;

import static Thezsia.content.ThezItems.*;
import static Thezsia.content.Thezsia.ThezsiaUnits.*;

public class ThezsiaStorages{
    public static Block
            //Blocks
            coreDust, coreFog;
    public static void load(){
        coreDust = new GeneratorCore("core-dust"){{
            requirements(Category.effect, ItemStack.with(tantalum, 750, silver, 70));
            size= 4; health = 1950; squareSprite = false;

            hasPower = true;
            conductivePower = true;
            powerProduction = 80 / 60f;
            consumePowerBuffered(180);
            glowMag = 0.78f; glowScl = 9.5f;
            itemCapacity = 5000;
            unitType = Iambient;
            unitCapModifier = 15;
            isFirstTier = true;
            alwaysUnlocked = true;
        }};
        coreFog = new GeneratorCore("core-fog"){{
            requirements(Category.effect, ItemStack.with(tantalum, 1200, silver, 500, infium, 260, tensorite, 180));
            size= 5; health = 3700; squareSprite = false;

            hasPower = true;
            conductivePower = true;
            powerProduction = 250 / 60f;
            consumePowerBuffered(100);
            glowMag = 0.78f; glowScl = 9.5f;
            itemCapacity = 7500;
            unitType = IIambient;
            unitCapModifier = 22;
        }};
    }
}