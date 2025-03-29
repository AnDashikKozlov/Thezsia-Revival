package Thezsia.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.content.Items;
import mindustry.type.*;

import static mindustry.content.Items.*;
import static mindustry.content.Planets.*;

public class ThezItems {
    public static Item
            silver, basaltShard, infium, tensorite, sulfur, tritaniumCrystal, Tritanium, bebebe, nihilite, tantalum;
    public static final Seq<Item> thezsiaItems = new Seq<>();
    public static void load(){
        Items.scrap.buildable = true;
        silver = new Item("silver", Color.valueOf("d8eded")){{
            hardness = 2;
            cost = 1.24f;
        }};
        basaltShard = new Item("basalt-shard", Color.valueOf("5e5f6b")){{
            hardness = 2;
            cost = 1;
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

        nihilite = new Item("nihilite", Color.valueOf("778d88"){{
            hardness = 0.4f;
            cost = 1;
            charge = 0.1f;
        }};
        tantalum = new Item("tantalum", Color.valueOf("979faa")){{
            cost = 1;
            hardness = 0.6f;
        }};

        thezsiaItems.addAll(
                basaltShard, silver, infium, sulfur, tensorite, tritaniumCrystal, Tritanium, nihilite, tantalum
        );
    }
            }
