
package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import Thezsia.world.blocks.distribution.ClosedConveyor;
import Thezsia.world.meta.ThezEnv;
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
import mindustry.world.meta.Env;

import static Thezsia.content.ThezItems.*;

public class ThezsiaDistribution{
    public static Block
            //item
            tantalumBelt, tantalumJunction, tantalumBridge, tantalumRouter, tantalumSorter, invertedTantalumSorter, tantalumSpillwayGate, invertedTantalumSpillwayGate,
            //liquid
            tantalumPipe, infiumPipe, liquidJunction, liquidBridge, liquidHub, liquidBallast;
    public static void load(){
        //item
        tantalumBelt = new ClosedConveyor("tantalum-belt"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.distribution, ItemStack.with(tantalum, 1));
            health = 40;
            speed = 0.04f;
            displayedSpeed = 5.4f;
        }};
        tantalumJunction = new Junction("tantalum-junction"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.distribution, ItemStack.with(tantalum, 3));
            size = 1;
            speed = 35;
            capacity = 6;
        }};
        tantalumBridge = new ItemBridge("tantalum-bridge"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.distribution, ItemStack.with(tantalum, 8));
            size = 1; health = 80;
            hasPower = false;
            range = 4;
        }};
        //((ClosedConveyor) tantalumBelt).junctionReplacement = tantalumJunction;
        tantalumRouter = new Router("tantalum-router"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.distribution, ItemStack.with(tantalum, 5));
            size = 1;
        }};
        ((ClosedConveyor) tantalumBelt).bridgeReplacement = tantalumBridge;
        tantalumSorter = new Sorter("tantalum-sorter"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.distribution, ItemStack.with(tantalum, 5, nihilite,2));
            health =50;
        }};
        invertedTantalumSorter = new Sorter("inverted-tantalum-sorter"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.distribution, ItemStack.with(tantalum, 5, nihilite,2));
            health = 50;
            invert = true;
        }};
        tantalumSpillwayGate = new OverflowGate("tantalum-spillway-gate"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.distribution, ItemStack.with(tantalum, 5, nihilite,2));
            health = 50;
            researchCostMultiplier = 0.5f;
        }};
        invertedTantalumSpillwayGate = new OverflowGate("inverted-tantalum-spillway-gate"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.distribution, ItemStack.with(tantalum, 5, nihilite,2));
            health = 50;
            invert = true;
            researchCostMultiplier = 0.5f;
        }};

        //liquid
        tantalumPipe = new Conduit("tantalum-pipe"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.liquid, ItemStack.with(tantalum, 2));
            size = 1;
            liquidCapacity = 12;
            botColor = Color.valueOf("19181AFF");
            leaks = false;
        }};
        /*infiumPipe = new Conduit("infium-pipe"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.liquid, ItemStack.with(infium, 2, sulfur, 1));
            health = 160;
            size = 1;
            liquidCapacity = 25;
            botColor = Color.valueOf("19181AFF");
        }};*/
        liquidJunction = new LiquidJunction("liquid-junction"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.liquid,ItemStack.with(tantalum, 6));
            health = 50;
            size = 1;
        }};
        ((Conduit) tantalumPipe).junctionReplacement = liquidJunction; //((Conduit) infiumPipe).junctionReplacement = liquidJunction;
        liquidBridge = new LiquidBridge("liquid-bridge"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.liquid, ItemStack.with(tantalum, 10));
            size = 1;
            hasPower = false;
            range = 4;
            arrowSpacing =5;
        }};
        ((Conduit) tantalumPipe).bridgeReplacement = liquidBridge; //((Conduit) infiumPipe).bridgeReplacement = liquidBridge;
        liquidHub = new LiquidRouter("liquid-hub"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.liquid, ItemStack.with(tantalum, 5));
            health = 45;
            size = 1;
            liquidPadding = 1;
        }};
        liquidBallast = new LiquidRouter("liquid-ballast"){{
            envEnabled = Env.underwater | ThezEnv.underwaterWarm | Env.oxygen;
            requirements(Category.liquid, ItemStack.with(tantalum, 40, infium, 10));
            size = 2;
            liquidPadding = 2;
            squareSprite = false;
        }};
    }
}