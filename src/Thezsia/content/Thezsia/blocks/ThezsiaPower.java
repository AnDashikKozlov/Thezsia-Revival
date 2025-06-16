package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import Thezsia.world.blocks.power.*;
import arc.graphics.Color;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.power.Battery;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;

import javax.swing.plaf.basic.BasicTextAreaUI;

import static Thezsia.content.ThezItems.*;
import static mindustry.type.ItemStack.with;

public class ThezsiaPower {
    public static Block
            //Blocks
            silverCable, capacitor, testFignya;
    public static void load() {
        silverCable = new PowerWire("silver-cable"){{
            requirements(Category.power, with(tantalum, 1, silver, 1));
            health = 12;
        }};
        capacitor = new Battery("capacitor"){{
            requirements(Category.power, with(tantalum, 20, tensorite, 15));
            size = 2; squareSprite = false; health = 90;
            consumePowerBuffered(200);
            drawer = new DrawMulti(new DrawRegion(), new DrawGlowRegion("-glow"){{Color.valueOf("8aede2");}});
        }};
        /*testFignya = new TransferPowerConsumeGenerator("test-fignya"){{
            requirements(Category.power, with(tantalum, 1, silver, 1));
            size = 2;
            health = 12;
            radius = 15 / 8f;
        }};*/
    }
}