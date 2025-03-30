package Thezsia.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class ThezItems {
    public static Item
            tantalum, silver, nihilite, infium, tensorite, sulfur, tritaniumCrystal, tritanium /*, bebebe, bro wtf*/ ;
    public static final Seq<Item> thezsiaItems = new Seq<>();
    public static void load(){
        tantalum = new Item("tantalum", Color.valueOf("979faa")){{
            cost = 1;
            hardness = 1;
        }};
        silver = new Item("silver", Color.valueOf("d8eded")){{
            hardness = 2;
            cost = 1.24f;
        }};
        nihilite = new Item("nihilite", Color.valueOf("778d88")){{
            hardness = 1;
            cost = 1;
            charge = 0.1f;
        }};
        infium = new Item("infium", Color.valueOf("C99200FF")){{
            hardness = 4;
            cost = 1.3f;
        }};
        tensorite = new Item("tensorite", Color.valueOf("3976A7FF")){{
            hardness = 5;
            cost = 1.62f;
            charge = 0.75f;
        }};
        sulfur = new Item("sulfur", Color.valueOf("BDA511FF")){{
            hardness = 3;
            cost = 1.2f;
            flammability = 1.32f;
        }};
        tritaniumCrystal = new Item("tritanium-crystal", Color.valueOf("CBD97FFF")){{
            hardness = 4;
            cost = 1.35f;
            charge = 0.08f;
            radioactivity = 0.72f;
        }};
        tritanium = new Item("tritanium", Color.valueOf("2CDC78FF")){{
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
