package Thezsia.content.Thezsia.blocks;

import Thezsia.world.blocks.power.*;
import Thezsia.world.graphics.ThezPal;
import Thezsia.world.meta.ThezEnv;
import arc.graphics.Color;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.BeamNode;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.Env;

import static Thezsia.content.ThezItems.*;
import static Thezsia.world.graphics.ThezPal.*;
import static mindustry.type.ItemStack.with;

public class ThezsiaPower {
    public static Block
            //Blocks
            /*silverCable,*/ transmittingNode, capacitor; /*testFignya;*/
    public static void load() {
        /*silverCable = new PowerWire("silver-cable"){{
            requirements(Category.power, with(tantalum, 1, silver, 1));
            health = 12;
            emitLight = true; lightColor = powerColorA; lightRadius = 10;
        }};*/
        capacitor = new Battery("capacitor"){{
            requirements(Category.power, with(tantalum, 20, tensorite, 15));
            size = 2; squareSprite = false; health = 90;
            //lightColor = Color.valueOf("8aede2"); lightRadius = 1.2f * 8;
            emptyLightColor = powerColorA; fullLightColor = powerColorB;
            consumePowerBuffered(200);
            ambientSound = Sounds.electricHum; ambientSoundVolume = 0.31f;
            drawer = new DrawMulti(new DrawRegion(), new DrawGlowRegion("-glow"){{color = powerColorC;}});
        }};
        transmittingNode = new BeamNode("transmitting-node"){{
            requirements(Category.power, with(tantalum, 20, silver, 8));
            consumesPower = outputsPower = true;
            consumePowerBuffered(750f);
            health = 120;
            range = 14;
            laserColor1 = powerColorB;
            laserColor2 = powerColorA;
            fogRadius = 1;
            // researchCost = with(tantalum, 5);
            // buildCostMultiplier = 2.5f;
        }};
    }
}