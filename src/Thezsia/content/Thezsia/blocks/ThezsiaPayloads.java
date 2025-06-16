package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.units.UnitFactory;

import static Thezsia.content.ThezItems.*;
import static Thezsia.content.Thezsia.ThezUnits.*;
import static mindustry.type.ItemStack.with;

public class ThezsiaPayloads{
    public static Block
            //Blocks
            groundFabricator, massConveyor, massRouter;
    public static void load(){
        groundFabricator = new UnitFactory("ground-fabricator"){{
            requirements(Category.units, ItemStack.with(tantalum,50, tensorite, 30));
            size = 3; health = 600;

            consumePower(3);
            plans.addAll(
                    new UnitPlan(noctis, 600, with(tantalum, 15, silver, 8)),
                    new UnitPlan(ignis, 560, with(tantalum, 20, infium, 12))
            );
        }};

        //payloads
        massConveyor = new PayloadConveyor("mass-conveyor"){{
            requirements(Category.units, ItemStack.with(tantalum, 16, nihilite, 8));
            canOverdrive = false;
            payloadLimit = 3;
        }};
        massRouter = new PayloadConveyor("mass-router"){{
            requirements(Category.units, ItemStack.with(tantalum, 20, nihilite, 10));
            canOverdrive = false;
        }};
    }
}