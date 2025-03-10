
package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import Thezsia.world.blocks.distribution.ClosedConveyor;
import arc.graphics.Color;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidBridge;
import mindustry.world.blocks.liquid.LiquidJunction;
import mindustry.world.blocks.liquid.LiquidRouter;

import static mindustry.content.Items.beryllium;

public class ThezDistribution{
    public static Block
            //item
            berylliumBelt, berylliumConvJunction, berylliumConvBridge, berylliumConvRouter, berylliumConvSorter, invertedBerylliumConvSorter, berylliumConvSpillwayGate, invertedBerylliumConvSpillwayGate,
            //liquid
            berylliumPipe, infiumPipe, liquidJunction, liquidBridge, liquidHub, liquidBallast;
    public static void load(){
        //item
        berylliumBelt = new ClosedConveyor("beryllium-belt"){{
            requirements(Category.distribution, ItemStack.with(beryllium, 1));
            health = 40;
            speed = 0.04f;
            displayedSpeed = 5.4f;
        }};
        berylliumConvJunction = new Junction("beryllium-conv-junction"){{
            requirements(Category.distribution, ItemStack.with(beryllium, 3));
            size = 1;
            speed = 35;
            capacity = 6;
        }};
        berylliumConvBridge = new ItemBridge("beryllium-conv-bridge"){{
            requirements(Category.distribution, ItemStack.with(beryllium, 8));
            size = 1; health = 80;
            hasPower = false;
            range = 3;
        }};
        ((ClosedConveyor) berylliumBelt).junctionReplacement = berylliumConvJunction;
        berylliumConvRouter = new Router("beryllium-conv-router"){{
            requirements(Category.distribution, ItemStack.with(beryllium, 5));
            size = 1;
        }};
        ((ClosedConveyor) berylliumBelt).bridgeReplacement = berylliumConvBridge;
        berylliumConvSorter = new Sorter("beryllium-conv-sorter"){{
            requirements(Category.distribution, ItemStack.with(beryllium, 5, ThezItems.basaltShard,2));
            health =50;
        }};
        invertedBerylliumConvSorter = new Sorter("inverted-beryllium-conv-sorter"){{
            requirements(Category.distribution, ItemStack.with(beryllium, 5, ThezItems.basaltShard,2));
            health = 50;
            invert = true;
        }};
        berylliumConvSpillwayGate = new OverflowGate("beryllium-conv-spillway-gate"){{
            requirements(Category.distribution, ItemStack.with(beryllium, 5, ThezItems.basaltShard,2));
            health = 50;
            researchCostMultiplier = 0.5f;
        }};
        invertedBerylliumConvSpillwayGate = new OverflowGate("inverted-beryllium-conv-spillway-gate"){{
            requirements(Category.distribution, ItemStack.with(beryllium, 5, ThezItems.basaltShard,2));
            health = 50;
            invert = true;
            researchCostMultiplier = 0.5f;
        }};

        //liquid
        berylliumPipe = new Conduit("beryllium-pipe"){{
            requirements(Category.liquid, ItemStack.with(beryllium, 2));
            size = 1;
            liquidCapacity = 12;
            botColor = Color.valueOf("19181AFF");
        }};
        infiumPipe = new Conduit("infium-pipe"){{
            requirements(Category.liquid, ItemStack.with(ThezItems.infium, 2, ThezItems.sulfur, 1));
            health = 160;
            size = 1;
            liquidCapacity = 25;
            botColor = Color.valueOf("19181AFF");
        }};
        liquidJunction = new LiquidJunction("liquid-junction"){{
            requirements(Category.liquid,ItemStack.with(beryllium, 6));
            health = 50;
            size = 1;
        }};
        ((Conduit) berylliumPipe).junctionReplacement = liquidJunction; ((Conduit) infiumPipe).junctionReplacement = liquidJunction;
        liquidBridge = new LiquidBridge("liquid-bridge"){{
            requirements(Category.liquid, ItemStack.with(beryllium, 10));
            size = 1;
            hasPower = false;
            range = 3;
            arrowSpacing =5;
        }};
        ((Conduit) berylliumPipe).bridgeReplacement = liquidBridge; ((Conduit) infiumPipe).bridgeReplacement = liquidBridge;
        liquidHub = new LiquidRouter("liquid-hub"){{
            requirements(Category.liquid, ItemStack.with(beryllium, 5));
            health = 45;
            size = 1;
            liquidPadding = 1;
        }};
        liquidBallast = new LiquidRouter("liquid-ballast"){{
            requirements(Category.liquid, ItemStack.with(beryllium, 40, ThezItems.infium, 10));
            size = 2;
            liquidPadding = 2;
            squareSprite = false;
        }};
    }
}