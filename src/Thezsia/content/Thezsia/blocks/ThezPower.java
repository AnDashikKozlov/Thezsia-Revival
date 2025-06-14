package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import Thezsia.world.blocks.power.*;
import mindustry.type.Category;
import mindustry.world.Block;

import static Thezsia.content.ThezItems.*;
import static mindustry.type.ItemStack.with;

public class ThezPower {
    public static Block
            //Blocks
            silverCable, testFignya;
    public static void load() {
        silverCable = new PowerWire("silver-cable"){{
            requirements(Category.power, with(tantalum, 1, silver, 1));
            health = 12;
        }};
        /*testFignya = new TransferPowerConsumeGenerator("test-fignya"){{
            requirements(Category.power, with(tantalum, 1, silver, 1));
            size = 2;
            health = 12;
            radius = 15 / 8f;
        }};*/
    }
}