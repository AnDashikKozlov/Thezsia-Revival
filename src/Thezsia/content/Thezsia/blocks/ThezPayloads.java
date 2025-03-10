package Thezsia.content.Thezsia.blocks;

import Thezsia.content.ThezItems;
import Thezsia.content.Thezsia.ThezUnits;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.units.UnitFactory;

import static mindustry.content.Items.beryllium;
import static mindustry.type.ItemStack.with;

public class ThezPayloads{
    public static Block
            //Blocks
            groundFabricator, massConveyor, massRouter;
    public static void load(){
        groundFabricator = new UnitFactory("ground-fabricator"){{
            requirements(Category.units, ItemStack.with(beryllium,50, ThezItems.tensorite, 30));
            size = 3; health = 600;

            consumePower(3);
            plans.addAll(
                    new UnitPlan(ThezUnits.noctis, 600, with(beryllium, 15, ThezItems.silver, 8)),
                    new UnitPlan(ThezUnits.ignis, 560, with(beryllium, 20, ThezItems.infium, 12))
            );
        }};

        //payloads
        massConveyor = new PayloadConveyor("mass-conveyor"){{
            requirements(Category.units, ItemStack.with(beryllium, 16, ThezItems.basaltShard, 8));
            canOverdrive = false;
            payloadLimit = 3;
        }};
        massRouter = new PayloadConveyor("mass-router"){{
            requirements(Category.units, ItemStack.with(beryllium, 20, ThezItems.basaltShard, 10));
            canOverdrive = false;
        }};
    }
}