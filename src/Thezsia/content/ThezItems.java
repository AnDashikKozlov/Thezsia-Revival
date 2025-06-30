package Thezsia.content;

import Thezsia.world.graphics.ThezPal;
import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

//import static Thezsia.world.graphics.ThezPal.*;

public class ThezItems {
    public static Item
            tantalum, silver, nihilite, infium, tensorite, sulfur, tritaniumCrystal, tritanium /*, bebebe, bro wtf*/ ;
    public static final Seq<Item> thezsiaItems = new Seq<>();
    public static void load(){
        tantalum = new Item("tantalum", ThezPal.itemTantalum){{
            cost = 1;
            hardness = 1;
        }};
        silver = new Item("silver", ThezPal.itemSilver){{
            hardness = 2;
            cost = 1.24f;
        }};
        nihilite = new Item("nihilite", ThezPal.itemNihilite){{
            hardness = 1;
            cost = 1;
            charge = 0.1f;
        }};
        infium = new Item("infium", ThezPal.itemInfium){{
            hardness = 4;
            cost = 1.3f;
        }};
        tensorite = new Item("tensorite", ThezPal.itemTensprite){{
            hardness = 5;
            cost = 1.62f;
            charge = 0.75f;
        }};
        sulfur = new Item("sulfur", ThezPal.itemSulfur){{
            hardness = 3;
            cost = 1.2f;
            flammability = 1.32f;
        }};
        tritaniumCrystal = new Item("tritanium-crystal", ThezPal.itemTritaniumcrystal){{
            hardness = 4;
            cost = 1.35f;
            charge = 0.08f;
            radioactivity = 0.72f;
        }};
        tritanium = new Item("tritanium", ThezPal.itemTritanium){{
            hardness = 5;
            cost = 1.8f;
            charge = 0.15f;
            radioactivity = 0.45f;
        }};

        thezsiaItems.addAll(
                tantalum, silver, nihilite, infium, sulfur, tensorite, tritaniumCrystal, tritanium
        );
    }
}
